package com.project.security.mapper;

import com.project.security.domain.TBanner;
import java.util.List;

import org.springframework.stereotype.Repository;	

/**
 * 轮播图 数据层
 * 
 * @author rbf
 * @date 2019-04-15
 */
@Repository("bannerMapper")
public interface TBannerMapper 
{
	/**
     * 查询轮播图信息
     * 
     * @param id 轮播图ID
     * @return 轮播图信息
     */
	public TBanner selectTBannerById(String id);
	
	/**
     * 查询轮播图列表
     * 
     * @param tBanner 轮播图信息
     * @return 轮播图集合
     */
	public List<TBanner> selectTBannerList(TBanner tBanner);
	
	/**
     * 新增轮播图
     * 
     * @param tBanner 轮播图信息
     * @return 结果
     */
	public int insertTBanner(TBanner tBanner);
	
	/**
     * 修改轮播图
     * 
     * @param tBanner 轮播图信息
     * @return 结果
     */
	public int updateTBanner(TBanner tBanner);
	
	/**
     * 删除轮播图
     * 
     * @param id 轮播图ID
     * @return 结果
     */
	public int deleteTBannerById(String id);
	
	/**
     * 批量删除轮播图
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTBannerByIds(String[] ids);
	//以上自动生成的尽量别动
	
}