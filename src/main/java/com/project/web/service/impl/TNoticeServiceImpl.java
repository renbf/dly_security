package com.project.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Date;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.project.web.mapper.TNoticeMapper;
import com.project.web.domian.TNotice;
import com.project.web.service.ITNoticeService;
import com.project.common.support.Convert;

/**
 * 公告管理 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TNoticeServiceImpl implements ITNoticeService 
{
	private static final Logger log = LoggerFactory.getLogger(TNoticeServiceImpl.class);
	@Autowired
	@Qualifier("tNoticeMapper")
	private TNoticeMapper tNoticeMapper;

	/**
     * 查询公告管理信息
     * 
     * @param id 公告管理ID
     * @return 公告管理信息
     */
    @Override
	public TNotice selectTNoticeById(String id)
	{
	    return tNoticeMapper.selectTNoticeById(id);
	}
	
	/**
     * 查询公告管理列表
     * 
     * @param tNotice 公告管理信息
     * @return 公告管理集合
     */
	@Override
	public List<TNotice> selectTNoticeList(TNotice tNotice)
	{
	    return tNoticeMapper.selectTNoticeList(tNotice);
	}
	
    /**
     * 新增公告管理
     * 
     * @param tNotice 公告管理信息
     * @return 结果
     */
	@Override
	public int insertTNotice(TNotice tNotice)
	{
		tNotice.setId(UUIDUtil.getUUID());
		tNotice.setCreateDate(new Date());
		tNotice.setAddUserId(ShiroUtils.getUserId().toString());
	    return tNoticeMapper.insertTNotice(tNotice);
	}
	
	/**
     * 修改公告管理
     * 
     * @param tNotice 公告管理信息
     * @return 结果
     */
	@Override
	public int updateTNotice(TNotice tNotice)
	{
	    return tNoticeMapper.updateTNotice(tNotice);
	}

	/**
     * 删除公告管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTNoticeByIds(String ids)
	{
		return tNoticeMapper.deleteTNoticeByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
