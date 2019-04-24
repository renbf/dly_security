package com.project.web.service;

import com.project.web.domian.TCarRepair;
import java.util.List;

/**
 * 车辆维护和修理登记 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITCarRepairService 
{
	/**
     * 查询车辆维护和修理登记信息
     * 
     * @param id 车辆维护和修理登记ID
     * @return 车辆维护和修理登记信息
     */
	public TCarRepair selectTCarRepairById(String id);
	
	/**
     * 查询车辆维护和修理登记列表
     * 
     * @param tCarRepair 车辆维护和修理登记信息
     * @return 车辆维护和修理登记集合
     */
	public List<TCarRepair> selectTCarRepairList(TCarRepair tCarRepair);
	
	/**
     * 新增车辆维护和修理登记
     * 
     * @param tCarRepair 车辆维护和修理登记信息
     * @return 结果
     */
	public int insertTCarRepair(TCarRepair tCarRepair);
	
	/**
     * 修改车辆维护和修理登记
     * 
     * @param tCarRepair 车辆维护和修理登记信息
     * @return 结果
     */
	public int updateTCarRepair(TCarRepair tCarRepair);
		
	/**
     * 删除车辆维护和修理登记信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTCarRepairByIds(String ids);
	//以上自动生成的尽量别动
}
