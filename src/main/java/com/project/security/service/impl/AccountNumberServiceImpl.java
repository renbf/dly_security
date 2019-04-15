package com.project.security.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.common.result.DataResult;
import com.project.common.result.Result;
import com.project.security.domain.TBanner;
import com.project.security.domain.TMessage;
import com.project.security.domain.TNotice;
import com.project.security.mapper.TBannerMapper;
import com.project.security.mapper.TMessageMapper;
import com.project.security.mapper.TNoticeMapper;
import com.project.security.service.IAccountNumberService;

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
	@Override
	public DataResult bannerAndNotice(String userId) {
		DataResult result = new DataResult();
		try {
			List<TBanner> bannerList = bannerMapper.selectTBannerList(null);
			List<TNotice> noticeList = noticeMapper.selectTNoticeList(null);
			TMessage tMessage = new TMessage();
			tMessage.setUserId(userId);
			tMessage.setIsRead("0");
			List<TMessage> messageList = messageMapper.selectTMessageList(tMessage);
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
			log.error("上传认证接口异常",e);
			throw new RuntimeException("上传认证接口异常");
		}
	}
	
	
}
