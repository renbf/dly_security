package com.project.web.service;

import com.project.web.domian.TBusiness;
import java.util.List;

/**
 * 企业管理 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITBusinessService 
{
	/**
     * 查询企业管理信息
     * 
     * @param id 企业管理ID
     * @return 企业管理信息
     */
	public TBusiness selectTBusinessById(String id);
	
	/**
     * 查询企业管理列表
     * 
     * @param tBusiness 企业管理信息
     * @return 企业管理集合
     */
	public List<TBusiness> selectTBusinessList(TBusiness tBusiness);
	
	/**
     * 新增企业管理
     * 
     * @param tBusiness 企业管理信息
     * @return 结果
     */
	public int insertTBusiness(TBusiness tBusiness);
	
	/**
     * 修改企业管理
     * 
     * @param tBusiness 企业管理信息
     * @return 结果
     */
	public int updateTBusiness(TBusiness tBusiness);
		
	/**
     * 删除企业管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTBusinessByIds(String ids);
	//以上自动生成的尽量别动
}
