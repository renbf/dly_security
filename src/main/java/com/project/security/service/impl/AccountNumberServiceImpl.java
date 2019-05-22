package com.project.security.service.impl;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.project.common.result.DataResult;
import com.project.common.result.Result;
import com.project.framework.config.ServerConfig;
import com.project.security.domain.TBanner;
import com.project.security.domain.TIndustryDynamics;
import com.project.security.domain.TNotice;
import com.project.security.domain.TUserMessage;
import com.project.security.domain.vo.TCourseVo;
import com.project.security.domain.vo.TSubjectVo;
import com.project.security.domain.vo.TUserMessageVo;
import com.project.security.domain.vo.TUserPaperVo;
import com.project.security.domain.vo.UserVo;
import com.project.security.mapper.TBannerMapper;
import com.project.security.mapper.TCourseMapper;
import com.project.security.mapper.TDictMapper;
import com.project.security.mapper.TIndustryDynamicsMapper;
import com.project.security.mapper.TNoticeMapper;
import com.project.security.mapper.TSubjectMapper;
import com.project.security.mapper.TUserMessageMapper;
import com.project.security.mapper.TUserPaperMapper;
import com.project.security.mapper.UserMapper;
import com.project.security.service.IAccountNumberService;
import com.project.security.utils.page.PageInfoUtil;
import com.project.security.utils.page.TableDataView;
import com.project.system.domain.SysUser;

/**
 * 
 * @author rbf
 *
 */
@Service
public class AccountNumberServiceImpl implements IAccountNumberService{
	private static final Logger log = LoggerFactory.getLogger(AccountNumberServiceImpl.class);

	@Autowired
	@Qualifier("bannerMapper")
	private TBannerMapper bannerMapper;
	@Autowired
	@Qualifier("noticeMapper")
	private TNoticeMapper noticeMapper;
	@Autowired
	@Qualifier("userMessageMapper")
	private TUserMessageMapper userMessageMapper;
	@Autowired
	@Qualifier("industryDynamicsMapper")
	private TIndustryDynamicsMapper industryDynamicsMapper;
	@Autowired
	@Qualifier("courseMapper")
	private TCourseMapper courseMapper;
	@Autowired
	@Qualifier("userPaperMapper")
	private TUserPaperMapper userPaperMapper;
	
	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;
	@Autowired
	private ServerConfig serverConfig;
	@Autowired
	@Qualifier("subjectMapper")
	private TSubjectMapper subjectMapper;
	@Autowired
	@Qualifier("dictMapper")
	private TDictMapper dictMapper;
	
	@Override
	public DataResult bannerAndNotice() {
		DataResult result = new DataResult();
		try {
			List<TBanner> bannerList = bannerMapper.selectTBannerList(null);
			if(CollectionUtils.isNotEmpty(bannerList)) {
    			String serverUrl = serverConfig.getUrl();
    			for(TBanner banner :bannerList) {
    				banner.setWebUrl(serverUrl+"/safety/train/industryDynamicsWebUrl/"+banner.getId());
    			}
    		}
			List<TNotice> noticeList = noticeMapper.selectTNoticeList(null);
			Map<String, Object> mapResult = new HashMap<>();
			mapResult.put("bannerList", bannerList);
			mapResult.put("noticeList", noticeList);
			result.setResult(mapResult);
			result.setMessage("查询轮播图和公告以及消息接口成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("查询轮播图和公告以及消息接口异常",e);
			throw new RuntimeException("查询轮播图和公告以及消息接口异常");
		}
	}
	
	
	@Override
	public DataResult checkIsHaveMsg(String userId) {
		DataResult result = new DataResult();
		try {
			TUserMessage tUserMessage = new TUserMessage();
			tUserMessage.setUserId(userId);
			tUserMessage.setIsRead("0");
			List<TUserMessageVo> messageList = userMessageMapper.selectTUserMessageVos(tUserMessage);
			Map<String, Object> mapResult = new HashMap<>();
			if(CollectionUtils.isNotEmpty(messageList)) {
				mapResult.put("isHaveMsg", "1");
			}else {
				mapResult.put("isHaveMsg", "0");
			}
			result.setResult(mapResult);
			result.setMessage("是否有新消息成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("查询是否有新消息接口异常",e);
			throw new RuntimeException("查询是否有新消息接口异常");
		}
	}


	@Override
	public DataResult industryDynamic(Integer pageNumber,Long total) {
		DataResult result = new DataResult();
        try {
        	DataResult pageResult = PageInfoUtil.startPage(pageNumber, total,null);
        	if(Result.SUCCESS.equals(pageResult.getStatus())) {
    			return pageResult;
        	}
            List<TIndustryDynamics> list = industryDynamicsMapper.selectTIndustryDynamicsList(null);
            if(CollectionUtils.isNotEmpty(list)) {
    			String serverUrl = serverConfig.getUrl();
    			for(TIndustryDynamics industryDynamics :list) {
    				industryDynamics.setWebUrl(serverUrl+"/safety/train/industryDynamicsWebUrl/"+industryDynamics.getId());
    			}
    		}
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
	public DataResult littleKnowledge(Integer pageNumber,Long total,String userId) {
		DataResult result = new DataResult();
        try {
        	DataResult pageResult = PageInfoUtil.startPage(pageNumber, total,null);
        	if(Result.SUCCESS.equals(pageResult.getStatus())) {
    			return pageResult;
        	}
    		List<TCourseVo> courseList = courseMapper.littleKnowledge("12");
    		if(CollectionUtils.isNotEmpty(courseList)) {
    			String serverUrl = serverConfig.getUrl();
    			for(TCourseVo courseVo :courseList) {
    				courseVo.setWebUrl(serverUrl+"/safety/train/introductionUrl/"+courseVo.getId());
    			}
    		}
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
	public DataResult userMessage(Integer pageNumber,Long total,String userId) {
		DataResult result = new DataResult();
        try {
        	DataResult pageResult = PageInfoUtil.startPage(pageNumber, total,null);
        	if(Result.SUCCESS.equals(pageResult.getStatus())) {
    			return pageResult;
        	}
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
	public DataResult myExam(Integer pageNumber,Long total, String userId) {
		DataResult result = new DataResult();
        try {
        	DataResult pageResult = PageInfoUtil.startPage(pageNumber, total,null);
        	if(Result.SUCCESS.equals(pageResult.getStatus())) {
    			return pageResult;
        	}
        	Map<String,Object> param = new HashMap<String, Object>();
        	param.put("status", "2");
        	param.put("userId", userId);
    		List<TUserPaperVo> list = userPaperMapper.selectTUserPapersByWhere(param);
    		TableDataView<TUserPaperVo> tableDataView = PageInfoUtil.addPageInfo(list);
			result.setResult(tableDataView);
			result.setMessage("查询我的考卷成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("查询我的考卷接口异常",e);
			throw new RuntimeException("查询我的考卷接口异常");
		}
	}
	
	@Override
	public DataResult courseCollection(Integer pageNumber,Long total, String userId) {
		DataResult result = new DataResult();
        try {
        	DataResult pageResult = PageInfoUtil.startPage(pageNumber, total,null);
        	if(Result.SUCCESS.equals(pageResult.getStatus())) {
    			return pageResult;
        	}
        	Map<String,Object> param = new HashMap<String, Object>();
        	param.put("isCollect", "1");
        	param.put("userId", userId);
    		List<TCourseVo> courseList = courseMapper.courseCollection(param);
    		TableDataView<TCourseVo> tableDataView = PageInfoUtil.addPageInfo(courseList);
			result.setResult(tableDataView);
			result.setMessage("查询我的课程收藏成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("查询我的课程收藏接口异常",e);
			throw new RuntimeException("查询我的课程收藏接口异常");
		}
	}
	
	@Override
	public DataResult examCollection(Integer pageNumber,Long total, String userId) {
		DataResult result = new DataResult();
        try {
        	DataResult pageResult = PageInfoUtil.startPage(pageNumber, total,null);
        	if(Result.SUCCESS.equals(pageResult.getStatus())) {
    			return pageResult;
        	}
    		List<TSubjectVo> list = subjectMapper.examCollection(userId);
    		List<TSubjectVo> listNew = new ArrayList<TSubjectVo>();
        	if(CollectionUtils.isNotEmpty(list)) {
        		Set<String> distinctSet = new HashSet<String>();
        		for(TSubjectVo bean:list) {
        			String subjectId = bean.getId();
        			if(!distinctSet.contains(subjectId)) {
        				List<Map<String,Object>> optionContents = new ArrayList<Map<String,Object>>();
        				Map<String,Object> map = new HashMap<String, Object>();
        				map.put("optionValue", bean.getOptionValue());
        				map.put("content", bean.getContent());
        				map.put("optionSort", bean.getOptionSort());
        				optionContents.add(map);
        				bean.setOptionContents(optionContents);
        				bean.setOptionValue(null);
        				bean.setContent(null);
        				bean.setOptionSort(null);
        				listNew.add(bean);
        				distinctSet.add(subjectId);
        			}else {
        				TSubjectVo bean2 = listNew.get(listNew.size() -1);
        				List<Map<String,Object>> optionContents = bean2.getOptionContents();
        				Map<String,Object> map = new HashMap<String, Object>();
        				map.put("optionValue", bean.getOptionValue());
        				map.put("content", bean.getContent());
        				map.put("optionSort", bean.getOptionSort());
        				optionContents.add(map);
        			}
        		}
        	}
    		TableDataView<TSubjectVo> tableDataView = PageInfoUtil.addPageInfo(listNew);
			result.setResult(tableDataView);
			result.setMessage("查询我的考题收藏成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("查询我的考题收藏接口异常",e);
			throw new RuntimeException("查询我的考题收藏接口异常");
		}
	}
	
	@Override
	public DataResult myCourse(Integer pageNumber,Long total, String userId) {
		DataResult result = new DataResult();
        try {
        	DataResult pageResult = PageInfoUtil.startPage(pageNumber, total,null);
        	if(Result.SUCCESS.equals(pageResult.getStatus())) {
    			return pageResult;
        	}
        	Map<String,Object> param = new HashMap<String, Object>();
        	param.put("status", "2");
        	param.put("userId", userId);
    		List<TCourseVo> courseList = courseMapper.courseCollection(param);
    		if(CollectionUtils.isNotEmpty(courseList)) {
    			String serverUrl = serverConfig.getUrl();
    			for(TCourseVo courseVo :courseList) {
    				courseVo.setWebUrl(serverUrl+"/safety/train/introductionUrl/"+courseVo.getId());
    			}
    		}
    		TableDataView<TCourseVo> tableDataView = PageInfoUtil.addPageInfo(courseList);
			result.setResult(tableDataView);
			result.setMessage("查询我的课程成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("查询我的课程接口异常",e);
			throw new RuntimeException("查询我的课程接口异常");
		}
	}
	
	@Override
	public DataResult getUserInfo(String userId) {
		DataResult result = new DataResult();
        try {
        	UserVo userVo = userMapper.selectUserByUserId(Long.valueOf(userId));
        	result.setResult(userVo);
			result.setMessage("查询个人信息成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("查询个人信息接口异常",e);
			throw new RuntimeException("查询个人信息接口异常");
		}
	}


	@Override
	public DataResult searchCource(Integer pageNumber,Long total,String userId,String searchKey) {
		DataResult result = new DataResult();
        try {
        	DataResult pageResult = PageInfoUtil.startPage(pageNumber, total,null);
        	if(Result.SUCCESS.equals(pageResult.getStatus())) {
    			return pageResult;
        	}
    		List<TCourseVo> courseList = courseMapper.searchCource(userId,searchKey);
    		if(CollectionUtils.isNotEmpty(courseList)) {
    			String serverUrl = serverConfig.getUrl();
    			for(TCourseVo courseVo :courseList) {
    				courseVo.setWebUrl(serverUrl+"/safety/train/introductionUrl/"+courseVo.getId());
    			}
    		}
    		TableDataView<TCourseVo> tableDataView = PageInfoUtil.addPageInfo(courseList);
			result.setResult(tableDataView);
			result.setMessage("搜索课程成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("搜索课程接口异常",e);
			throw new RuntimeException("搜索课程接口异常");
		}
	}

}
