package com.project.web.service;

import com.project.web.domian.TBanner;
import java.util.List;

/**
 * 轮播图 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITBannerService 
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
     * 删除轮播图信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTBannerByIds(String ids);
	//以上自动生成的尽量别动
}
