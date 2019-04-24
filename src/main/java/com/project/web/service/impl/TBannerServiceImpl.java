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
import com.project.web.mapper.TBannerMapper;
import com.project.web.domian.TBanner;
import com.project.web.service.ITBannerService;
import com.project.common.support.Convert;

/**
 * 轮播图 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TBannerServiceImpl implements ITBannerService 
{
	private static final Logger log = LoggerFactory.getLogger(TBannerServiceImpl.class);
	@Autowired
	@Qualifier("tBannerMapper")
	private TBannerMapper tBannerMapper;

	/**
     * 查询轮播图信息
     * 
     * @param id 轮播图ID
     * @return 轮播图信息
     */
    @Override
	public TBanner selectTBannerById(String id)
	{
	    return tBannerMapper.selectTBannerById(id);
	}
	
	/**
     * 查询轮播图列表
     * 
     * @param tBanner 轮播图信息
     * @return 轮播图集合
     */
	@Override
	public List<TBanner> selectTBannerList(TBanner tBanner)
	{
	    return tBannerMapper.selectTBannerList(tBanner);
	}
	
    /**
     * 新增轮播图
     * 
     * @param tBanner 轮播图信息
     * @return 结果
     */
	@Override
	public int insertTBanner(TBanner tBanner)
	{
		tBanner.setId(UUIDUtil.getUUID());
		tBanner.setCreateDate(new Date());
		tBanner.setAddUserId(ShiroUtils.getUserId().toString());
	    return tBannerMapper.insertTBanner(tBanner);
	}
	
	/**
     * 修改轮播图
     * 
     * @param tBanner 轮播图信息
     * @return 结果
     */
	@Override
	public int updateTBanner(TBanner tBanner)
	{
	    return tBannerMapper.updateTBanner(tBanner);
	}

	/**
     * 删除轮播图对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTBannerByIds(String ids)
	{
		return tBannerMapper.deleteTBannerByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
