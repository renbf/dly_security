package com.project.web.mapper;

import com.project.web.domian.TCarInsurance;
import java.util.List;	
import org.springframework.stereotype.Repository;
/**
 * 车辆保险情况 数据层
 * 
 * @author rbf
 * @date 2019-04-23
 */
 @Repository("tCarInsuranceMapper")
public interface TCarInsuranceMapper 
{
	/**
     * 查询车辆保险情况信息
     * 
     * @param id 车辆保险情况ID
     * @return 车辆保险情况信息
     */
	public TCarInsurance selectTCarInsuranceById(String id);
	
	/**
     * 查询车辆保险情况列表
     * 
     * @param tCarInsurance 车辆保险情况信息
     * @return 车辆保险情况集合
     */
	public List<TCarInsurance> selectTCarInsuranceList(TCarInsurance tCarInsurance);
	
	/**
     * 新增车辆保险情况
     * 
     * @param tCarInsurance 车辆保险情况信息
     * @return 结果
     */
	public int insertTCarInsurance(TCarInsurance tCarInsurance);
	
	/**
     * 修改车辆保险情况
     * 
     * @param tCarInsurance 车辆保险情况信息
     * @return 结果
     */
	public int updateTCarInsurance(TCarInsurance tCarInsurance);
	
	/**
     * 删除车辆保险情况
     * 
     * @param id 车辆保险情况ID
     * @return 结果
     */
	public int deleteTCarInsuranceById(String id);
	
	/**
     * 批量删除车辆保险情况
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTCarInsuranceByIds(String[] ids);
	//以上自动生成的尽量别动
}