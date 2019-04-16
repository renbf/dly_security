package com.project.security.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.project.common.constant.Constants;
import com.project.common.result.DataResult;
import com.project.common.result.Result;
import com.project.security.domain.TBanner;
import com.project.security.domain.TIndustryDynamics;
import com.project.security.domain.TNotice;
import com.project.security.domain.TUserCourse;
import com.project.security.domain.TUserMessage;
import com.project.security.domain.vo.TCourseVo;
import com.project.security.domain.vo.TUserMessageVo;
import com.project.security.domain.vo.TUserPaperVo;
import com.project.security.mapper.TBannerMapper;
import com.project.security.mapper.TCourseMapper;
import com.project.security.mapper.TDictMapper;
import com.project.security.mapper.TIndustryDynamicsMapper;
import com.project.security.mapper.TMessageMapper;
import com.project.security.mapper.TNoticeMapper;
import com.project.security.mapper.TUserCourseMapper;
import com.project.security.mapper.TUserMessageMapper;
import com.project.security.mapper.TUserPaperMapper;
import com.project.security.mapper.TUserSubjectMapper;
import com.project.security.service.IAccountNumberService;
import com.project.security.utils.page.PageInfoUtil;
import com.project.security.utils.page.TableDataView;

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
	public DataResult examPaperDetail(String userId) {
		DataResult result = new DataResult();
        try {
//    		List<TUserPaperVo> courseList = userSubjectMapper.selectTUserPapersByUserId(userId);
//			result.setResult(tableDataView);
			result.setMessage("考试试卷成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("考试试卷接口异常",e);
			throw new RuntimeException("考试试卷接口异常");
		}
	}
	
	
}
