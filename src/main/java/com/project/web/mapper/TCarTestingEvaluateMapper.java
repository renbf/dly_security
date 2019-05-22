package com.project.web.mapper;

import com.project.web.domian.TCarTestingEvaluate;
import java.util.List;	
import org.springframework.stereotype.Repository;
/**
 * 车辆检测和评定登记 数据层
 * 
 * @author rbf
 * @date 2019-04-23
 */
 @Repository("tCarTestingEvaluateMapper")
public interface TCarTestingEvaluateMapper 
{
	/**
     * 查询车辆检测和评定登记信息
     * 
     * @param id 车辆检测和评定登记ID
     * @return 车辆检测和评定登记信息
     */
	public TCarTestingEvaluate selectTCarTestingEvaluateById(String id);
	
	/**
     * 查询车辆检测和评定登记列表
     * 
     * @param tCarTestingEvaluate 车辆检测和评定登记信息
     * @return 车辆检测和评定登记集合
     */
	public List<TCarTestingEvaluate> selectTCarTestingEvaluateList(TCarTestingEvaluate tCarTestingEvaluate);
	
	/**
     * 新增车辆检测和评定登记
     * 
     * @param tCarTestingEvaluate 车辆检测和评定登记信息
     * @return 结果
     */
	public int insertTCarTestingEvaluate(TCarTestingEvaluate tCarTestingEvaluate);
	
	/**
     * 修改车辆检测和评定登记
     * 
     * @param tCarTestingEvaluate 车辆检测和评定登记信息
     * @return 结果
     */
	public int updateTCarTestingEvaluate(TCarTestingEvaluate tCarTestingEvaluate);
	
	/**
     * 删除车辆检测和评定登记
     * 
     * @param id 车辆检测和评定登记ID
     * @return 结果
     */
	public int deleteTCarTestingEvaluateById(String id);
	
	/**
     * 批量删除车辆检测和评定登记
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTCarTestingEvaluateByIds(String[] ids);
	//以上自动生成的尽量别动


	/**
	 * 批量删除  根据车辆信息id
	 * @param ids
	 * @return
	 */
	public int deleteByCarInfoId(String[] ids);
}