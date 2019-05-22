package com.project.web.service;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TCarTrouble;
import java.util.List;

/**
 * 车辆机损事故登记 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITCarTroubleService 
{
	/**
     * 查询车辆机损事故登记信息
     * 
     * @param id 车辆机损事故登记ID
     * @return 车辆机损事故登记信息
     */
	public TCarTrouble selectTCarTroubleById(String id);
	
	/**
     * 查询车辆机损事故登记列表
     * 
     * @param tCarTrouble 车辆机损事故登记信息
     * @return 车辆机损事故登记集合
     */
	public List<TCarTrouble> selectTCarTroubleList(TCarTrouble tCarTrouble);
	
	/**
     * 新增车辆机损事故登记
     * 
     * @param tCarTrouble 车辆机损事故登记信息
     * @return 结果
     */
	public AjaxResult insertTCarTrouble(TCarTrouble tCarTrouble);
	
	/**
     * 修改车辆机损事故登记
     * 
     * @param tCarTrouble 车辆机损事故登记信息
     * @return 结果
     */
	public AjaxResult updateTCarTrouble(TCarTrouble tCarTrouble);
		
	/**
     * 删除车辆机损事故登记信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTCarTroubleByIds(String ids);
	//以上自动生成的尽量别动
}
