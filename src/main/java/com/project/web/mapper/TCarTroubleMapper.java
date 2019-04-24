package com.project.web.mapper;

import com.project.web.domian.TCarTrouble;
import java.util.List;	
import org.springframework.stereotype.Repository;
/**
 * 车辆机损事故登记 数据层
 * 
 * @author rbf
 * @date 2019-04-23
 */
 @Repository("tCarTroubleMapper")
public interface TCarTroubleMapper 
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
	public int insertTCarTrouble(TCarTrouble tCarTrouble);
	
	/**
     * 修改车辆机损事故登记
     * 
     * @param tCarTrouble 车辆机损事故登记信息
     * @return 结果
     */
	public int updateTCarTrouble(TCarTrouble tCarTrouble);
	
	/**
     * 删除车辆机损事故登记
     * 
     * @param id 车辆机损事故登记ID
     * @return 结果
     */
	public int deleteTCarTroubleById(String id);
	
	/**
     * 批量删除车辆机损事故登记
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTCarTroubleByIds(String[] ids);
	//以上自动生成的尽量别动
}