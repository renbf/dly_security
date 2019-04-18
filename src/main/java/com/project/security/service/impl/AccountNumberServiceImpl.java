package com.project.security.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.project.common.constant.Constants;
import com.project.common.result.DataResult;
import com.project.common.result.Result;
import com.project.security.domain.Dept;
import com.project.security.domain.TBanner;
import com.project.security.domain.TDanger;
import com.project.security.domain.TDict;
import com.project.security.domain.TDriverAfterLog;
import com.project.security.domain.TDriverBeforeLog;
import com.project.security.domain.TDriverLog;
import com.project.security.domain.TDriverMiddleLog;
import com.project.security.domain.TGoodsNameType;
import com.project.security.domain.TIndustryDynamics;
import com.project.security.domain.TInspectPlan;
import com.project.security.domain.TInspectRecord;
import com.project.security.domain.TInspectTeamProject;
import com.project.security.domain.TNotice;
import com.project.security.domain.TUserCourse;
import com.project.security.domain.TUserMessage;
import com.project.security.domain.TUserPaper;
import com.project.security.domain.TUserSubject;
import com.project.security.domain.TUserSubjectCollect;
import com.project.security.domain.vo.TCourseVo;
import com.project.security.domain.vo.TDangerVo;
import com.project.security.domain.vo.TDictView;
import com.project.security.domain.vo.TDriverBeforeLogVo;
import com.project.security.domain.vo.TInspectPlanVo;
import com.project.security.domain.vo.TInspectTeamProjectVo;
import com.project.security.domain.vo.TUserCourseVo;
import com.project.security.domain.vo.TUserMessageVo;
import com.project.security.domain.vo.TUserPaperVo;
import com.project.security.domain.vo.UserPaperDetailVo;
import com.project.security.mapper.DeptMapper;
import com.project.security.mapper.TBannerMapper;
import com.project.security.mapper.TCourseMapper;
import com.project.security.mapper.TDangerMapper;
import com.project.security.mapper.TDictMapper;
import com.project.security.mapper.TDriverAfterLogMapper;
import com.project.security.mapper.TDriverBeforeLogMapper;
import com.project.security.mapper.TDriverLogMapper;
import com.project.security.mapper.TDriverMiddleLogMapper;
import com.project.security.mapper.TGoodsNameTypeMapper;
import com.project.security.mapper.TIndustryDynamicsMapper;
import com.project.security.mapper.TInspectPlanMapper;
import com.project.security.mapper.TInspectRecordMapper;
import com.project.security.mapper.TInspectTeamProjectMapper;
import com.project.security.mapper.TMessageMapper;
import com.project.security.mapper.TNoticeMapper;
import com.project.security.mapper.TUserCourseMapper;
import com.project.security.mapper.TUserMessageMapper;
import com.project.security.mapper.TUserPaperMapper;
import com.project.security.mapper.TUserSubjectCollectMapper;
import com.project.security.mapper.TUserSubjectMapper;
import com.project.security.mapper.UserMapper;
import com.project.security.service.IAccountNumberService;
import com.project.security.service.IFileSystemService;
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
public class AccountNumberServiceImpl implements IAccountNumberService{
	private static final Logger log = LoggerFactory.getLogger(AccountNumberServiceImpl.class);

	@Autowired
	private TBannerMapper bannerMapper;
	@Autowired
	private TNoticeMapper noticeMapper;
	@Autowired
	private TMessageMapper messageMapper;
	@Autowired
	private TUserMessageMapper userMessageMapper;
	@Autowired
	private IFileSystemService fileSystemService;
	@Autowired
	private TIndustryDynamicsMapper industryDynamicsMapper;
	@Autowired
	private TCourseMapper courseMapper;
	@Autowired
	private TUserCourseMapper userCourseMapper;
	@Autowired
	private TUserPaperMapper userPaperMapper;
	@Autowired
	private TUserSubjectMapper userSubjectMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private TUserSubjectCollectMapper userSubjectCollectMapper;
	@Autowired
	private TInspectPlanMapper inspectPlanMapper;
	@Autowired
	private TInspectTeamProjectMapper inspectTeamProjectMapper;
	@Autowired
	private DeptMapper deptMapper;
	@Autowired
	private TInspectRecordMapper inspectRecordMapper;
	@Autowired
	private TDangerMapper dangerMapper;
	@Autowired
	private TGoodsNameTypeMapper goodsNameTypeMapper;
	@Autowired
	private TDriverLogMapper driverLogMapper;
	@Autowired
	private TDriverBeforeLogMapper driverBeforeLogMapper;
	@Autowired
	private TDriverMiddleLogMapper driverMiddleLogMapper;
	@Autowired
	private TDriverAfterLogMapper driverAfterLogMapper;
	@Autowired
	private TDictMapper dictMapper;
	
	@Override
	public DataResult bannerAndNotice(String userId) {
		DataResult result = new DataResult();
		try {
			List<TBanner> bannerList = bannerMapper.selectTBannerList(null);
			List<TNotice> noticeList = noticeMapper.selectTNoticeList(null);
			TUserMessage tUserMessage = new TUserMessage();
			tUserMessage.setUserId(userId);
			tUserMessage.setIsRead("0");
			List<TUserMessageVo> messageList = userMessageMapper.selectTUserMessageVos(tUserMessage);
			Map<String, Object> mapResult = new HashMap<>();
			mapResult.put("bannerList", bannerList);
			mapResult.put("noticeList", noticeList);
			if(CollectionUtils.isNotEmpty(messageList)) {
				mapResult.put("isHaveMsg", "1");
			}else {
				mapResult.put("isHaveMsg", "0");
			}
			result.setResult(mapResult);
			result.setMessage("上传认证成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("查询轮播图和公告以及消息接口异常",e);
			throw new RuntimeException("查询轮播图和公告以及消息接口异常");
		}
	}
	@Override
	public DataResult industryDynamic(Integer pageNumber) {
		DataResult result = new DataResult();
        try {
        	PageHelper.startPage(pageNumber, Constants.PAGE_SIZE_NUMBER);
            List<TIndustryDynamics> list = industryDynamicsMapper.selectTIndustryDynamicsList(null);
            TableDataView<TIndustryDynamics> tableDataView = PageInfoUtil.addPageInfo(list);
			result.setResult(tableDataView);
			result.setMessage("行业动态查询成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("行业动态接口异常",e);
			throw new RuntimeException("行业动态接口异常");
		}
	}
	
	@Override
	public DataResult littleKnowledge(Integer pageNumber,String userId) {
		DataResult result = new DataResult();
        try {
    		PageHelper.startPage(pageNumber, Constants.PAGE_SIZE_NUMBER);
    		List<TCourseVo> courseList = courseMapper.littleKnowledge(userId,"12");
    		TableDataView<TCourseVo> tableDataView = PageInfoUtil.addPageInfo(courseList);
			result.setResult(tableDataView);
			result.setMessage("小知识查询成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("小知识接口异常",e);
			throw new RuntimeException("小知识接口异常");
		}
	}
	
	@Override
	public DataResult userMessage(Integer pageNumber,String userId) {
		DataResult result = new DataResult();
        try {
    		PageHelper.startPage(pageNumber, Constants.PAGE_SIZE_NUMBER);
    		TUserMessage tUserMessage = new TUserMessage();
			tUserMessage.setUserId(userId);
			List<TUserMessageVo> messageList = userMessageMapper.selectTUserMessageVos(tUserMessage);
    		TableDataView<TUserMessageVo> tableDataView = PageInfoUtil.addPageInfo(messageList);
			result.setResult(tableDataView);
			result.setMessage("消息查询成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("消息查询接口异常",e);
			throw new RuntimeException("消息查询接口异常");
		}
	}
	@Override
	public DataResult readMessage(String messageId, String userId) {
		DataResult result = new DataResult();
        try {
        	if(StringUtils.isEmpty(messageId) || StringUtils.isEmpty(userId)) {
        		result.setMessage("参数不能为空");
    			result.setStatus(Result.FAILED);
    			return result;
        	}
        	TUserMessage tUserMessage = new TUserMessage();
			tUserMessage.setUserId(userId);
			tUserMessage.setMessageId(messageId);
			tUserMessage.setIsRead("1");
        	userMessageMapper.updateTUserMessageByWhere(tUserMessage);
			result.setMessage("消息已读成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("消息已读接口异常",e);
			throw new RuntimeException("消息已读接口异常");
		}
	}
	
	@Override
	public DataResult readAllMessage(String userId) {
		DataResult result = new DataResult();
        try {
        	if(StringUtils.isEmpty(userId)) {
        		result.setMessage("参数不能为空");
    			result.setStatus(Result.FAILED);
    			return result;
        	}
        	TUserMessage tUserMessage = new TUserMessage();
			tUserMessage.setUserId(userId);
			tUserMessage.setIsRead("1");
        	userMessageMapper.updateTUserMessageByWhere(tUserMessage);
			result.setMessage("消息全部已读成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("消息全部已读接口异常",e);
			throw new RuntimeException("消息全部已读接口异常");
		}
	}
	
	@Override
	public DataResult courseArrange(Integer pageNumber,String userId) {
		DataResult result = new DataResult();
        try {
        	if(StringUtils.isEmpty(userId)) {
        		result.setMessage("参数不能为空");
    			result.setStatus(Result.FAILED);
    			return result;
        	}
        	PageHelper.startPage(pageNumber, Constants.PAGE_SIZE_NUMBER);
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
	public DataResult examPaper(Integer pageNumber, String userId) {
		DataResult result = new DataResult();
        try {
        	PageHelper.startPage(pageNumber, Constants.PAGE_SIZE_NUMBER);
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
        	TUserPaper userPaper = userPaperMapper.selectTUserPaperById(userPaperId);
        	if(userPaper == null) {
        		result.setMessage("没有查到试卷");
    			result.setStatus(Result.FAILED);
    			return result;
        	}
        	if(userPaper.getStartDate() == null) {
        		userPaper.setStartDate(new Date());
        		userPaper.setStatus("1");
        		userPaperMapper.updateTUserPaper(userPaper);
        	}
    		List<UserPaperDetailVo> userPaperDetailVos = userPaperMapper.examPaperDetail(userPaperId);
			result.setResult(userPaperDetailVos);
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
			result.setMessage("考试试卷详情成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("考试试卷详情接口异常",e);
			throw new RuntimeException("考试试卷详情接口异常");
		}
	}
	
	@Override
	public DataResult videoCollection(String userId, String courseId) {
		DataResult result = new DataResult();
        try {
        	TUserCourse tUserCourse = new TUserCourse();
        	tUserCourse.setUserId(userId);
        	tUserCourse.setCourseId(courseId);
        	tUserCourse.setIsCollect("1");
        	userCourseMapper.updateTUserCourse(tUserCourse);
			result.setMessage("收藏视频成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("收藏视频接口异常",e);
			throw new RuntimeException("收藏视频接口异常");
		}
	}
	
	@Override
	public DataResult subjectCollection(String userId, String subjectId) {
		DataResult result = new DataResult();
        try {
        	TUserSubjectCollect tUserSubjectCollect = new TUserSubjectCollect();
        	tUserSubjectCollect.setUserId(userId);
        	tUserSubjectCollect.setSubjectId(subjectId);
        	tUserSubjectCollect.setIsCollect("1");
        	userSubjectCollectMapper.insertTUserSubjectCollect(tUserSubjectCollect);
			result.setMessage("收藏题目成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("收藏题目接口异常",e);
			throw new RuntimeException("收藏题目接口异常");
		}
	}
	@Override
	public DataResult checkPlan(String userId,Integer pageNumber) {
		DataResult result = new DataResult();
        try {
        	PageHelper.startPage(pageNumber, Constants.PAGE_SIZE_NUMBER);
        	List<TInspectPlanVo> inspectPlanList = inspectPlanMapper.selectTInspectPlanListByUserId(userId);
        	if(CollectionUtils.isNotEmpty(inspectPlanList)) {
        		for(TInspectPlanVo inspectPlanVo:inspectPlanList) {
        			List<Map<String,Object>> checkProjects = new ArrayList<Map<String,Object>>();
        			String checkName = inspectPlanVo.getCheckName();
        			if(StringUtils.isNotEmpty(checkName)) {
        				Map<String,Object> map = new HashMap<String,Object>();
        				//checkName = id:name,id2:name2
        				String[] str = checkName.split(",");
        				for(String checkItem:str) {
        					String[] dictArr = checkItem.split(":");
        					map.put(dictArr[0], dictArr[1]);
        				}
        				checkProjects.add(map);
        			}
        			inspectPlanVo.setCheckProjects(checkProjects);
        		}
        	}
    		TableDataView<TInspectPlanVo> tableDataView = PageInfoUtil.addPageInfo(inspectPlanList);
			result.setResult(tableDataView);
			result.setMessage("检查计划成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("检查计划接口异常",e);
			throw new RuntimeException("检查计划接口异常");
		}
	}
	
	@Override
	public DataResult queryCheckProject(String inspectPlanId, String projectId) {
		DataResult result = new DataResult();
        try {
        	List<TInspectTeamProjectVo> inspectTeamProjects = inspectTeamProjectMapper.selectTInspectTeamProjects(inspectPlanId,projectId);
        	result.setResult(inspectTeamProjects);
			result.setMessage("查询检查项成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("查询检查项接口异常",e);
			throw new RuntimeException("查询检查项接口异常");
		}
	}
	
	
	@Override
	@Transactional
	public DataResult saveCheckProject(String inspectTeamProjectJson) {
		DataResult result = new DataResult();
        try {
        	List<TInspectTeamProject> tInspectTeamProjects = JSONArray.parseArray(inspectTeamProjectJson, TInspectTeamProject.class);
        	if(CollectionUtils.isNotEmpty(tInspectTeamProjects)) {
        		String inspectPlanId = tInspectTeamProjects.get(0).getInspectPlanId();
        		String checkTeamId = tInspectTeamProjects.get(0).getCheckTeamId();
        		inspectTeamProjectMapper.deleteTInspectTeamProjectByTeamId(inspectPlanId, checkTeamId);
        		inspectTeamProjectMapper.addBatchTInspectTeamProjects(tInspectTeamProjects);
        	}
			result.setMessage("保存检查项成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("保存检查项接口异常",e);
			throw new RuntimeException("保存检查项接口异常");
		}
	}
	
	
	@Override
	@Transactional
	public DataResult completeCheck(String inspectRecordJson,MultipartFile file) {
		DataResult result = new DataResult();
        try {
        	TInspectRecord tInspectRecord = JSON.parseObject(inspectRecordJson, TInspectRecord.class);
        	if(tInspectRecord == null) {
        		result.setMessage("完成检查计划参数错误");
    			result.setStatus(Result.FAILED);
    			return result;
        	}
        	TInspectPlan tInspectPlan = new TInspectPlan();
        	tInspectPlan.setId(tInspectRecord.getInspectPlanId());
        	tInspectPlan.setCheckStatus("1");
        	inspectPlanMapper.updateTInspectPlan(tInspectPlan);
        	inspectRecordMapper.insertTInspectRecord(tInspectRecord);
			result.setMessage("完成检查计划成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("完成检查计划接口异常",e);
			throw new RuntimeException("完成检查计划接口异常");
		}
	}
	
	
	@Override
	public DataResult queryHiddenDanger(String businessId) {
		DataResult result = new DataResult();
        try {
        	//部门
        	Dept dept = new Dept();
        	dept.setBusinessId(businessId);
        	List<Dept> deptList = deptMapper.selectDeptList(dept);
        	
        	//检查类型
        	TDict tDict = new TDict();
        	tDict.setParentId("");
        	tDict.setBusinessId(businessId);
        	List<TDict> checkTypePid = dictMapper.selectTDictList(tDict);
        	if(CollectionUtils.isEmpty(checkTypePid) || checkTypePid.size() != 1) {
        		result.setMessage("上传隐患——查询部门等接口失败");
    			result.setStatus(Result.FAILED);
    			return result;
        	}
        	TDict checkTypeDict = new TDict();
        	checkTypeDict.setParentId(checkTypePid.get(0).getId());
        	checkTypeDict.setBusinessId(businessId);
        	List<TDict> checkTypes = dictMapper.selectTDictList(checkTypeDict);
        	//隐患类型
        	TDict dangerTypeDict = new TDict();
        	dangerTypeDict.setParentId("");
        	dangerTypeDict.setBusinessId(businessId);
        	List<TDict> dangerTypes = dictMapper.selectTDictList(dangerTypeDict);
        	//隐患等级
        	TDict dangerLevelDict = new TDict();
        	dangerLevelDict.setParentId("");
        	dangerLevelDict.setBusinessId(businessId);
        	List<TDict> dangerLevels = dictMapper.selectTDictList(dangerLevelDict);
        	//可能后果
        	TDict maybeResultDict = new TDict();
        	maybeResultDict.setParentId("");
        	maybeResultDict.setBusinessId(businessId);
        	List<TDict> maybeResults = dictMapper.selectTDictList(maybeResultDict);
        	
        	Map<String, Object> mapResult = new HashMap<>();
			mapResult.put("deptList", deptList);
			mapResult.put("checkTypes", checkTypes);
			mapResult.put("dangerTypes", dangerTypes);
			mapResult.put("dangerLevels", dangerLevels);
			mapResult.put("maybeResults", maybeResults);
        	result.setResult(mapResult);
			result.setMessage("上传隐患——查询部门等成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("上传隐患——查询部门等接口异常",e);
			throw new RuntimeException("上传隐患——查询部门等接口异常");
		}
	}
	
	@Override
	public DataResult queryHiddenDangerDetail(String dangerId) {
		DataResult result = new DataResult();
        try {
        	TDangerVo tDangerVo = dangerMapper.selectTDangerVoByDangerId(dangerId);
        	result.setResult(tDangerVo);
			result.setMessage("隐患详情成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("隐患详情接口异常",e);
			throw new RuntimeException("隐患详情接口异常");
		}
	}
	
	@Override
	public DataResult uploadHiddenDanger(String dangerJson, MultipartFile file) {
		DataResult result = new DataResult();
        try {
        	String dangerUrl = fileSystemService.uploadFile("/security"+file.getOriginalFilename(), file);
        	TDanger danger = JSON.parseObject(dangerJson, TDanger.class);
        	danger.setId(UUIDUtil.getUUID());
        	danger.setCreateDate(new Date());
        	danger.setDangerUrl(dangerUrl);
        	danger.setStatus("0");
        	dangerMapper.insertTDanger(danger);
			result.setMessage("上报隐患成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("上报隐患接口异常",e);
			throw new RuntimeException("上报隐患接口异常");
		}
	}
	
	@Override
	public DataResult rectification(Integer pageNumber,String userId) {
		DataResult result = new DataResult();
        try {
        	PageHelper.startPage(pageNumber, Constants.PAGE_SIZE_NUMBER);
        	TDanger tDanger = new TDanger();
        	tDanger.setDochangeUserId(userId);
        	tDanger.setStatus("1");
        	List<TDanger> dangerList = dangerMapper.selectTDangerList(tDanger);
    		TableDataView<TDanger> tableDataView = PageInfoUtil.addPageInfo(dangerList);
			result.setResult(tableDataView);
			result.setMessage("隐患整改成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("隐患整改接口异常",e);
			throw new RuntimeException("隐患整改接口异常");
		}
	}
	
	@Override
	public DataResult rectificationDetail(String dangerJson, MultipartFile file) {
		DataResult result = new DataResult();
        try {
        	String dochangePicture = fileSystemService.uploadFile("/security"+file.getOriginalFilename(), file);
        	TDanger danger = JSON.parseObject(dangerJson, TDanger.class);
        	danger.setStatus("2");
        	danger.setDochangePicture(dochangePicture);
        	dangerMapper.updateTDanger(danger);
			result.setMessage("隐患整改提交成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("隐患整改提交接口异常",e);
			throw new RuntimeException("隐患整改提交接口异常");
		}
	}
	
	@Override
	public DataResult refuseDochange(String dangerId, String refuseText) {
		DataResult result = new DataResult();
        try {
        	TDanger danger = new TDanger();
        	danger.setId(dangerId);
        	danger.setStatus("0");
        	danger.setRefuseText(refuseText);
        	dangerMapper.updateTDanger(danger);
			result.setMessage("拒绝整改成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("拒绝整改接口异常",e);
			throw new RuntimeException("拒绝整改接口异常");
		}
	}
	
	@Override
	public DataResult rectificationCheck(Integer pageNumber, String userId) {
		DataResult result = new DataResult();
        try {
        	PageHelper.startPage(pageNumber, Constants.PAGE_SIZE_NUMBER);
        	TDanger tDanger = new TDanger();
        	tDanger.setCheckAcceptUserId(userId);
        	tDanger.setStatus("2");
        	List<TDanger> dangerList = dangerMapper.selectTDangerList(tDanger);
    		TableDataView<TDanger> tableDataView = PageInfoUtil.addPageInfo(dangerList);
			result.setResult(tableDataView);
			result.setMessage("隐患验收成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("隐患验收接口异常",e);
			throw new RuntimeException("隐患验收接口异常");
		}
	}
	
	@Override
	public DataResult rectificationClose(String dangerJson, MultipartFile file) {
		DataResult result = new DataResult();
        try {
        	String checkAcceptUrl = fileSystemService.uploadFile("/security"+file.getOriginalFilename(), file);
        	TDanger danger = JSON.parseObject(dangerJson, TDanger.class);
        	danger.setStatus("3");
        	danger.setCheckAcceptUrl(checkAcceptUrl);
        	dangerMapper.updateTDanger(danger);
			result.setMessage("提交隐患验收成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("提交隐患验收接口异常",e);
			throw new RuntimeException("提交隐患验收接口异常");
		}
	}
	
	@Override
	public DataResult queryLogParamBefore(String businessId) {
		DataResult result = new DataResult();
        try {
        	//货物名称
        	TGoodsNameType tGoodsNameType = new TGoodsNameType();
        	tGoodsNameType.setBusinessId(businessId);
        	List<TGoodsNameType> goodsNameTypeList = goodsNameTypeMapper.selectTGoodsNameTypeList(tGoodsNameType);
        	//货物类项
        	List<TDictView> type = dictMapper.selectTDictsByGoodsType("");
        	//驾驶员
        	List<SysUser> drivers = userMapper.selectUserByDriver(businessId);
        	//天气
        	List<TDictView> weather = dictMapper.selectTDictListByParentId("");
        	//行车前事项
        	List<TDictView> carCheckProject = dictMapper.selectTDictListByParentId("");
        	//确认结论
        	List<TDictView> sureComment = dictMapper.selectTDictListByParentId("");
        	Map<String, Object> mapResult = new HashMap<>();
			mapResult.put("goodsNameTypeList", goodsNameTypeList);
			mapResult.put("type", type);
			mapResult.put("drivers", drivers);
			mapResult.put("weather", weather);
			mapResult.put("carCheckProject", carCheckProject);
			mapResult.put("sureComment", sureComment);
        	result.setResult(mapResult);
			result.setMessage("查询行车前需要日志参数成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("查询行车前需要日志参数接口异常",e);
			throw new RuntimeException("查询行车前需要日志参数接口异常");
		}
	}
	
	@Override
	public DataResult queryLogParamMiddle(String businessId) {
		DataResult result = new DataResult();
        try {
        	//行车中事项
        	List<TDictView> carCheckProject = dictMapper.selectTDictListByParentId("");
        	Map<String, Object> mapResult = new HashMap<>();
			mapResult.put("carCheckProject", carCheckProject);
        	result.setResult(mapResult);
			result.setMessage("查询行车中需要日志参数成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("查询行车中需要日志参数接口异常",e);
			throw new RuntimeException("查询行车中需要日志参数接口异常");
		}
	}
	
	@Override
	public DataResult queryLogParamAfter(String businessId) {
		DataResult result = new DataResult();
        try {
        	//行车后事项
        	List<TDictView> carCheckProject = dictMapper.selectTDictListByParentId("");
        	Map<String, Object> mapResult = new HashMap<>();
			mapResult.put("carCheckProject", carCheckProject);
        	result.setResult(mapResult);
			result.setMessage("查询行车后需要日志参数成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("查询行车后需要日志参数接口异常",e);
			throw new RuntimeException("查询行车后需要日志参数接口异常");
		}
	}
	
	@Override
	public DataResult addBeforeLog(String driverLogJson, MultipartFile file) {
		DataResult result = new DataResult();
        try {
        	String checkAcceptUrl = fileSystemService.uploadFile("/security"+file.getOriginalFilename(), file);
        	TDriverBeforeLogVo driverLog = JSON.parseObject(driverLogJson, TDriverBeforeLogVo.class);
        	TDriverLog tDriverLog = new TDriverLog();
        	TDriverBeforeLog tDriverBeforeLog = new TDriverBeforeLog();
        	BeanUtils.copyProperties(tDriverLog, driverLog);
        	BeanUtils.copyProperties(tDriverBeforeLog, driverLog);
        	List<TDictView> carCheckProjectList = driverLog.getCarCheckProjectList();
        	tDriverBeforeLog.setCarCheckProject(JSON.toJSONString(carCheckProjectList));
        	driverLogMapper.insertTDriverLog(tDriverLog);
        	driverBeforeLogMapper.insertTDriverBeforeLog(tDriverBeforeLog);
			result.setMessage("添加行车前日志成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("添加行车前日志接口异常",e);
			throw new RuntimeException("添加行车前日志接口异常");
		}
	}
	
	@Override
	public DataResult addMiddleLog(String driverLogJson, MultipartFile file) {
		DataResult result = new DataResult();
        try {
        	String checkAcceptUrl = fileSystemService.uploadFile("/security"+file.getOriginalFilename(), file);
        	TDriverMiddleLog tDriverMiddleLog = JSON.parseObject(driverLogJson, TDriverMiddleLog.class);
        	driverMiddleLogMapper.insertTDriverMiddleLog(tDriverMiddleLog);
			result.setMessage("添加行车中日志成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("添加行车中日志接口异常",e);
			throw new RuntimeException("添加行车中日志接口异常");
		}
	}
	
	@Override
	public DataResult addAfterLog(String driverLogJson, MultipartFile file) {
		DataResult result = new DataResult();
        try {
        	TDriverAfterLog tDriverAfterLog = JSON.parseObject(driverLogJson, TDriverAfterLog.class);
        	driverAfterLogMapper.insertTDriverAfterLog(tDriverAfterLog);
			result.setMessage("添加行车后日志成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("添加行车后日志接口异常",e);
			throw new RuntimeException("添加行车后日志接口异常");
		}
	}
}
