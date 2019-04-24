package com.project.security.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.project.common.result.DataResult;
import com.project.common.result.Result;
import com.project.security.domain.TUserCourse;
import com.project.security.domain.TUserPaper;
import com.project.security.domain.TUserSubject;
import com.project.security.domain.TUserSubjectCollect;
import com.project.security.domain.vo.TCourseVo;
import com.project.security.domain.vo.TUserCourseVo;
import com.project.security.domain.vo.TUserPaperVo;
import com.project.security.domain.vo.UserPaperDetailVo;
import com.project.security.mapper.TCourseMapper;
import com.project.security.mapper.TDictMapper;
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
	public DataResult uploadVideoProgress(String courseId, String userId,Long progress) {
		DataResult result = new DataResult();
        try {
        	TUserCourse tUserCourse = new TUserCourse();
        	tUserCourse.setUserId(userId);
        	tUserCourse.setCourseId(courseId);
        	tUserCourse.setProgress(progress);
        	userCourseMapper.updateTUserCourseByUser(tUserCourse);
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
        		userPaper.setRemainingTime(Long.valueOf(userPaper.getPaperTimes()));
        	}else {
        		if(userPaper.getRemainingTime().longValue() <= 0) {
            		if(userPaper.getCommitDate() == null) {
            			TUserPaper tUserPaper = new TUserPaper();
                		tUserPaper.setCommitDate(new Date());
                		tUserPaper.setId(userPaperId);
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
	public DataResult submitSubject(String userSubjectJson) {
		DataResult result = new DataResult();
        try {
        	TUserSubject userSubject = JSON.parseObject(userSubjectJson, TUserSubject.class);
        	if(StringUtils.isEmpty(userSubject.getId())) {
        		userSubject.setId(UUIDUtil.getUUID());
        		userSubjectMapper.insertTUserSubject(userSubject);
        	}else {
        		userSubjectMapper.updateTUserSubject(userSubject);
        	}
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
        	TUserPaper userPaper = new TUserPaper();
        	userPaper.setId(userPaperId);
        	userPaper.setCommitDate(new Date());
        	userPaperMapper.updateTUserPaper(userPaper);
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
	public DataResult videoCollection(String userId, String courseId,String isCollect) {
		DataResult result = new DataResult();
        try {
        	TUserCourse tUserCourse = new TUserCourse();
        	tUserCourse.setUserId(userId);
        	tUserCourse.setCourseId(courseId);
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
}
