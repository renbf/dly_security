package com.project.security.service.impl;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.project.common.result.DataResult;
import com.project.common.result.Result;
import com.project.framework.config.ServerConfig;
import com.project.framework.util.SpringUtils;
import com.project.security.domain.TBusiness;
import com.project.security.domain.TCourse;
import com.project.security.domain.TSubject;
import com.project.security.domain.TSubjectPaper;
import com.project.security.domain.TUserCourse;
import com.project.security.domain.TUserPaper;
import com.project.security.domain.TUserSubject;
import com.project.security.domain.TUserSubjectCollect;
import com.project.security.domain.vo.TCourseVo;
import com.project.security.domain.vo.TUserCourseVo;
import com.project.security.domain.vo.TUserPaperVo;
import com.project.security.domain.vo.UserPaperDetailVo;
import com.project.security.domain.vo.UserVo;
import com.project.security.mapper.TBusinessMapper;
import com.project.security.mapper.TCourseMapper;
import com.project.security.mapper.TDictMapper;
import com.project.security.mapper.TSubjectMapper;
import com.project.security.mapper.TSubjectPaperMapper;
import com.project.security.mapper.TUserCourseMapper;
import com.project.security.mapper.TUserPaperMapper;
import com.project.security.mapper.TUserSubjectCollectMapper;
import com.project.security.mapper.TUserSubjectMapper;
import com.project.security.mapper.UserMapper;
import com.project.security.service.ITrainService;
import com.project.security.utils.page.PageInfoUtil;
import com.project.security.utils.page.TableDataView;
import com.project.system.domain.SysUser;
import com.project.util.UUIDUtil;
import com.project.util.aliyun.AESDecode;
import com.project.util.aliyun.FaceVerifyParam;
import com.project.util.aliyun.FaceVerifyResponse;
/**
 * 
 * @author rbf
 *
 */
@Service
public class TrainServiceImpl implements ITrainService {
	private static final Logger log = LoggerFactory.getLogger(TrainServiceImpl.class);
	@Autowired
	@Qualifier("dictMapper")
	private TDictMapper dictMapper;
	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;
	
	@Autowired
	@Qualifier("courseMapper")
	private TCourseMapper courseMapper;
	@Autowired
	@Qualifier("userCourseMapper")
	private TUserCourseMapper userCourseMapper;
	@Autowired
	@Qualifier("userPaperMapper")
	private TUserPaperMapper userPaperMapper;
	@Autowired
	@Qualifier("userSubjectMapper")
	private TUserSubjectMapper userSubjectMapper;
	@Autowired
	@Qualifier("userSubjectCollectMapper")
	private TUserSubjectCollectMapper userSubjectCollectMapper;
	@Autowired
	@Qualifier("subjectMapper")
	private TSubjectMapper subjectMapper;
	@Autowired
	@Qualifier("subjectPaperMapper")
	private TSubjectPaperMapper subjectPaperMapper;
	@Autowired
	private ServerConfig serverConfig;
	@Autowired
	@Qualifier("businessMapper")
	private TBusinessMapper businessMapper;
	@Override
	public DataResult courseArrange(Integer pageNumber,Long total,String userId) {
		DataResult result = new DataResult();
        try {
        	if(StringUtils.isEmpty(userId)) {
        		result.setMessage("参数不能为空");
    			result.setStatus(Result.FAILED);
    			return result;
        	}
        	DataResult pageResult = PageInfoUtil.startPage(pageNumber, total,null);
        	if(Result.SUCCESS.equals(pageResult.getStatus())) {
    			return pageResult;
        	}
    		List<TCourseVo> courseList = courseMapper.courseArrange(userId);
    		if(CollectionUtils.isNotEmpty(courseList)) {
    			String serverUrl = serverConfig.getUrl();
    			for(TCourseVo courseVo :courseList) {
    				courseVo.setWebUrl(serverUrl+"/safety/train/introductionUrl/"+courseVo.getId());
    			}
    		}
    		TableDataView<TCourseVo> tableDataView = PageInfoUtil.addPageInfo(courseList);
			result.setResult(tableDataView);
			result.setMessage("课程安排成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("课程安排接口异常",e);
			throw new RuntimeException("课程安排接口异常");
		}
	}
	
	@Override
	public DataResult uploadVideoProgress(String userCourseId,Long progress) {
		DataResult result = new DataResult();
        try {
        	TUserCourse userCourse = userCourseMapper.selectTUserCourseById(userCourseId);
        	TCourse course = courseMapper.selectTCourseById(userCourse.getCourseId());
        	Long totalTimes = course.getTotalTimes();
        	if(totalTimes == null) {
        		result.setMessage("视频总时长为空");
    			result.setStatus(Result.FAILED);
    			return result;
        	}
        	String status = userCourse.getStatus();
        	if(!"2".equals(status)) {
        		TUserCourse tUserCourse = new TUserCourse();
        		if("0".equals(status)) {
        			tUserCourse.setStatus("1");
        		}
            	tUserCourse.setId(userCourseId);
            	tUserCourse.setProgress(progress);
            	if(progress != null && progress.longValue() >= (totalTimes.longValue() -2000)) {
            		tUserCourse.setStatus("2");
            	}
            	userCourseMapper.updateTUserCourse(tUserCourse);
        	}
        	result.setMessage("上传视频进度成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("上传视频进度接口异常",e);
			throw new RuntimeException("上传视频进度接口异常");
		}
	}
	
	@Override
	public DataResult examPaper(Integer pageNumber,Long total, String userId) {
		DataResult result = new DataResult();
        try {
        	DataResult pageResult = PageInfoUtil.startPage(pageNumber, total,null);
        	if(Result.SUCCESS.equals(pageResult.getStatus())) {
    			return pageResult;
        	}
    		List<TUserPaperVo> courseList = userPaperMapper.selectTUserPapersByUserId(userId);
    		TableDataView<TUserPaperVo> tableDataView = PageInfoUtil.addPageInfo(courseList);
			result.setResult(tableDataView);
			result.setMessage("考试试卷成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("考试试卷接口异常",e);
			throw new RuntimeException("考试试卷接口异常");
		}
	}
	
	@Override
	public DataResult examPaperDetail(String userPaperId) {
		DataResult result = new DataResult();
        try {
        	TUserPaperVo userPaper = userPaperMapper.selectTUserPaperByUserPaperId(userPaperId);
        	if(userPaper == null) {
        		result.setMessage("没有查到试卷");
    			result.setStatus(Result.FAILED);
    			return result;
        	}
        	if(userPaper.getStartDate() == null) {
        		TUserPaper tUserPaper = new TUserPaper();
        		tUserPaper.setStartDate(new Date());
        		tUserPaper.setStatus("1");
        		tUserPaper.setId(userPaperId);
        		userPaperMapper.updateTUserPaper(tUserPaper);
        		Long remainingTime = Long.valueOf(userPaper.getPaperTimes());
        		userPaper.setRemainingTime(remainingTime);
        		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        		executor.schedule(autoSsubmitPaper(userPaperId), remainingTime, TimeUnit.SECONDS);
        	}else {
        		if(userPaper.getRemainingTime().longValue() <= 0) {
            		if(userPaper.getCommitDate() == null) {
            			TUserPaper tUserPaper = new TUserPaper();
                		tUserPaper.setCommitDate(new Date());
                		tUserPaper.setId(userPaperId);
                		userPaper.setStatus("2");
                		userPaperMapper.updateTUserPaper(tUserPaper);
            		}
            		result.setMessage("考试时间已到");
        			result.setStatus(Result.FAILED);
        			return result;
            	}
        	}
    		List<UserPaperDetailVo> userPaperDetailVoList = userPaperMapper.examPaperDetail(userPaperId);
    		Set<String> distinctSet = new HashSet<String>();
    		List<UserPaperDetailVo> examQuestions = new ArrayList<UserPaperDetailVo>();
    		for(UserPaperDetailVo userPaperDetailVo:userPaperDetailVoList) {
    			String subjectId = userPaperDetailVo.getSubjectId();
    			if(!distinctSet.contains(subjectId)) {
    				List<Map<String,Object>> optionContents = new ArrayList<Map<String,Object>>();
    				Map<String,Object> optionMap = new HashMap<String, Object>();
    				optionMap.put("optionValue", userPaperDetailVo.getOptionValue());
    				optionMap.put("content", userPaperDetailVo.getContent());
    				optionMap.put("optionSort", userPaperDetailVo.getOptionSort());
    				optionContents.add(optionMap);
    				userPaperDetailVo.setOptionContents(optionContents);
    				userPaperDetailVo.setOptionValue(null);
    				userPaperDetailVo.setContent(null);
    				userPaperDetailVo.setOptionSort(null);
    				examQuestions.add(userPaperDetailVo);
    				distinctSet.add(subjectId);
    			}else {
    				UserPaperDetailVo userPaperDetailVo2 = examQuestions.get(examQuestions.size() -1);
    				List<Map<String,Object>> optionContents = userPaperDetailVo2.getOptionContents();
    				Map<String,Object> optionMap = new HashMap<String, Object>();
    				optionMap.put("optionValue", userPaperDetailVo.getOptionValue());
    				optionMap.put("content", userPaperDetailVo.getContent());
    				optionMap.put("optionSort", userPaperDetailVo.getOptionSort());
    				optionContents.add(optionMap);
    			}
    		}
    		userPaper.setExamQuestions(examQuestions);
			result.setResult(userPaper);
			result.setMessage("考试试卷详情成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("考试试卷详情接口异常",e);
			throw new RuntimeException("考试试卷详情接口异常");
		}
	}
	
	@Override
	public DataResult queryExamPaperDetail(String userPaperId) {
		DataResult result = new DataResult();
        try {
        	TUserPaperVo userPaper = userPaperMapper.selectTUserPaperByUserPaperId(userPaperId);
        	if(userPaper == null) {
        		result.setMessage("没有查到试卷");
    			result.setStatus(Result.FAILED);
    			return result;
        	}
    		List<UserPaperDetailVo> userPaperDetailVoList = userPaperMapper.examPaperDetail(userPaperId);
    		Set<String> distinctSet = new HashSet<String>();
    		List<UserPaperDetailVo> examQuestions = new ArrayList<UserPaperDetailVo>();
    		for(UserPaperDetailVo userPaperDetailVo:userPaperDetailVoList) {
    			String subjectId = userPaperDetailVo.getSubjectId();
    			if(!distinctSet.contains(subjectId)) {
    				List<Map<String,Object>> optionContents = new ArrayList<Map<String,Object>>();
    				Map<String,Object> optionMap = new HashMap<String, Object>();
    				optionMap.put("optionValue", userPaperDetailVo.getOptionValue());
    				optionMap.put("content", userPaperDetailVo.getContent());
    				optionMap.put("optionSort", userPaperDetailVo.getOptionSort());
    				optionContents.add(optionMap);
    				userPaperDetailVo.setOptionContents(optionContents);
    				userPaperDetailVo.setOptionValue(null);
    				userPaperDetailVo.setContent(null);
    				userPaperDetailVo.setOptionSort(null);
    				examQuestions.add(userPaperDetailVo);
    				distinctSet.add(subjectId);
    			}else {
    				UserPaperDetailVo userPaperDetailVo2 = examQuestions.get(examQuestions.size() -1);
    				List<Map<String,Object>> optionContents = userPaperDetailVo2.getOptionContents();
    				Map<String,Object> optionMap = new HashMap<String, Object>();
    				optionMap.put("optionValue", userPaperDetailVo.getOptionValue());
    				optionMap.put("content", userPaperDetailVo.getContent());
    				optionMap.put("optionSort", userPaperDetailVo.getOptionSort());
    				optionContents.add(optionMap);
    			}
    		}
    		userPaper.setExamQuestions(examQuestions);
			result.setResult(userPaper);
			result.setMessage("考试试卷详情成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("考试试卷详情接口异常",e);
			throw new RuntimeException("考试试卷详情接口异常");
		}
	}
	
	@Override
	@Transactional
	public DataResult submitSubject(String userSubjectJson) {
		DataResult result = new DataResult();
        try {
        	TUserSubject userSubject = JSON.parseObject(userSubjectJson, TUserSubject.class);
        	TSubject subject = subjectMapper.selectTSubjectById(userSubject.getSubjectId());
        	TUserPaper userPaper = userPaperMapper.selectTUserPaperById(userSubject.getUserPaperId());
        	TSubjectPaper subjectPaper = subjectPaperMapper.selectTSubjectPaperByKey(userPaper.getPaperId(),userSubject.getSubjectId());
        	//正确答案
        	String trueAnswer = subject.getTrueAnswer();
        	//用户答案
        	String userAnswer = userSubject.getUserAnswer();
        	//用户题目id
        	String userSubjectId = userSubject.getId();
        	//答案是否正确
        	String isTrue = "0";
        	if(StringUtils.isNotEmpty(userAnswer) && trueAnswer.equals(userAnswer)) {
        		isTrue = "1";
        		userSubject.setIsTrue(isTrue);
        		Integer paperScore = userPaper.getPaperScore();
            	if(paperScore == null) {
            		paperScore = 0;
            	}
            	TUserPaper tUserPaper = new TUserPaper();
            	tUserPaper.setId(userSubject.getUserPaperId());
            	tUserPaper.setPaperScore(paperScore.intValue()+subjectPaper.getSubjectScore().intValue());
            	userPaperMapper.updateTUserPaper(tUserPaper);
        	}else {
        		userSubject.setIsTrue(isTrue);
        	}
        	if(StringUtils.isEmpty(userSubjectId)) {
        		TUserSubject tUserSubject = new TUserSubject();
        		tUserSubject.setSubjectId(userSubject.getSubjectId());
        		tUserSubject.setUserPaperId(userSubject.getUserPaperId());
        		List<TUserSubject> userSubjectList = userSubjectMapper.selectTUserSubjectList(tUserSubject);
        		if(CollectionUtils.isNotEmpty(userSubjectList)) {
        			userSubjectId = userSubjectList.get(0).getId();
        			userSubject.setId(userSubjectId);
        			userSubjectMapper.updateTUserSubject(userSubject);
        		}else {
        			String id = UUIDUtil.getUUID();
            		userSubject.setId(id);
            		userSubjectMapper.insertTUserSubject(userSubject);
            		userSubjectId = id;
        		}
        	}else {
        		userSubjectMapper.updateTUserSubject(userSubject);
        	}
        	Map<String, Object> mapResult = new HashMap<>();
			mapResult.put("userSubjectId", userSubjectId);
    		result.setResult(mapResult);
			result.setMessage("提交题目成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("提交题目接口异常",e);
			throw new RuntimeException("提交题目接口异常");
		}
	}
	
	
	@Override
	public DataResult submitPaper(String userPaperId) {
		DataResult result = new DataResult();
        try {
        	TUserPaper tUserPaper = userPaperMapper.selectTUserPaperById(userPaperId);
        	TUserPaper userPaper = new TUserPaper();
        	userPaper.setId(userPaperId);
        	userPaper.setCommitDate(new Date());
        	userPaper.setStatus("2");
        	userPaperMapper.updateTUserPaper(userPaper);
        	Map<String, Object> mapResult = new HashMap<>();
			mapResult.put("paperScore", tUserPaper.getPaperScore());
    		result.setResult(mapResult);
			result.setMessage("提交考卷成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("提交考卷接口异常",e);
			throw new RuntimeException("提交考卷接口异常");
		}
	}
	
	@Override
	public DataResult courseRanking(String userId) {
		DataResult result = new DataResult();
        try {
        	SysUser sysUser = userMapper.selectUserById(Long.valueOf(userId));
    		List<TUserCourseVo> userCourseVos = userCourseMapper.courseRanking(userId);
    		TUserCourseVo userCourseVo = userCourseMapper.courseRankingByUserId(userId, sysUser.getBusinessId());
    		Map<String, Object> mapResult = new HashMap<>();
			mapResult.put("userCourseVos", userCourseVos);
			mapResult.put("userCourseVo", userCourseVo);
			result.setResult(mapResult);
			result.setMessage("课时排名成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("课时排名接口异常",e);
			throw new RuntimeException("课时排名接口异常");
		}
	}
	
	@Override
	public DataResult videoCollection(String userCourseId,String isCollect) {
		DataResult result = new DataResult();
        try {
        	TUserCourse tUserCourse = new TUserCourse();
        	tUserCourse.setId(userCourseId);
        	tUserCourse.setIsCollect(isCollect);
        	userCourseMapper.updateTUserCourse(tUserCourse);
        	if("1".equals(isCollect)) {
        		result.setMessage("收藏视频成功");
        	}else {
        		result.setMessage("取消收藏视频成功");
        	}
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("收藏视频接口异常",e);
			throw new RuntimeException("收藏视频接口异常");
		}
	}
	
	@Override
	public DataResult subjectCollection(String userId, String subjectId,String isCollect) {
		DataResult result = new DataResult();
        try {
        	if("1".equals(isCollect)) {
        		TUserSubjectCollect tUserSubjectCollect = new TUserSubjectCollect();
            	tUserSubjectCollect.setUserId(userId);
            	tUserSubjectCollect.setSubjectId(subjectId);
            	tUserSubjectCollect.setIsCollect("1");
            	userSubjectCollectMapper.insertTUserSubjectCollect(tUserSubjectCollect);
            	result.setMessage("收藏题目成功");
        	}else {
        		userSubjectCollectMapper.deleteTUserSubjectCollectByKey(userId,subjectId);
        		result.setMessage("取消收藏题目成功");
        	}
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("收藏题目接口异常",e);
			throw new RuntimeException("收藏题目接口异常");
		}
	}
	
	
	@Override
	public DataResult imgAuthentication(String userId, MultipartFile file) {
		DataResult result = new DataResult();
        try {
        	HttpURLConnection conn = null;
        	UserVo userVo = userMapper.selectUserByUserId(Long.valueOf(userId));
        	String authUrl = userVo.getAuthUrl();
        	URL url = new URL(authUrl);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(20 * 1000);
            String content_1 = AESDecode.encodeImageToBase64(conn.getInputStream());
            content_1 = content_1.replaceAll("[\\s*\t\n\r]", "");
            String content_2 = AESDecode.encodeImageToBase64(file.getInputStream());
            content_2 = content_2.replaceAll("[\\s*\t\n\r]", "");
            FaceVerifyParam faceVerifyParam = new FaceVerifyParam();
            faceVerifyParam.setType("1");
            faceVerifyParam.setContent_1(content_1);
            faceVerifyParam.setContent_2(content_2);
            FaceVerifyResponse faceVerifyResponse = AESDecode.sendPost(faceVerifyParam);
            if(faceVerifyResponse != null && faceVerifyResponse.getErrno() == 0) {
            	if(faceVerifyResponse.getConfidence() > 8.0) {
            		result.setMessage("图片认证成功");
        			result.setStatus(Result.SUCCESS);
        			return result;
            	}
            }
            result.setMessage("图片认证失败");
			result.setStatus(Result.FAILED);
			return result;
		} catch (Exception e) {
			log.error("图片认证接口异常",e);
			throw new RuntimeException("图片认证接口异常");
		}
	}

	@Override
	public DataResult queryIsVerifyOn(String businessId) {
		DataResult result = new DataResult();
        try {
        	TBusiness business = businessMapper.selectTBusinessById(businessId);
        	String isVerify = "";
        	if(business != null) {
        		if("1".equals(business.getIsVerify())) {
        			isVerify = "1";
        		}else {
        			isVerify = "0";
        		}
        	}else {
        		result.setMessage("公司不存在");
    			result.setStatus(Result.FAILED);
    			return result;
        	}
        	Map<String,Object> map = new HashMap<String, Object>();
        	map.put("isVerify", isVerify);
        	result.setResult(map);
        	result.setMessage("查询是否开启认证成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("查询是否开启认证接口异常",e);
			throw new RuntimeException("查询是否开启认证接口异常");
		}
	}

	@Override
	public String introductionUrl(String courseId) {
		TCourse tCourse = courseMapper.selectTCourseById(courseId);
		if(Objects.nonNull(tCourse)) {
			return tCourse.getIntroduction();
		}
		return null;
	}

	/**
     * 记录响应时间
     *
     * @param costTime 消耗时间
     * @return 任务task
     */
    private TimerTask autoSsubmitPaper(final String userPaperId) {
        return new TimerTask() {
            @Override
            public void run() {
                // 远程查询操作地点
                SpringUtils.getBean(TrainServiceImpl.class).submitPaper(userPaperId);
            }
        };
    }
}
