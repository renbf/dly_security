package com.project.web.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.web.domian.TFacilitiesEquipment;

/**
 * 设施设备 服务层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface ITFacilitiesEquipmentService 
{
	/**
     * 查询设施设备信息
     * 
     * @param id 设施设备ID
     * @return 设施设备信息
     */
	public TFacilitiesEquipment selectTFacilitiesEquipmentById(String id);
	
	/**
     * 查询设施设备列表
     * 
     * @param tFacilitiesEquipment 设施设备信息
     * @return 设施设备集合
     */
	public List<TFacilitiesEquipment> selectTFacilitiesEquipmentList(TFacilitiesEquipment tFacilitiesEquipment);
	
	/**
     * 新增设施设备
     * 
     * @param tFacilitiesEquipment 设施设备信息
     * @return 结果
     */
	public int insertTFacilitiesEquipment(TFacilitiesEquipment tFacilitiesEquipment,MultipartFile facilitiesFile);
	
	/**
     * 修改设施设备
     * 
     * @param tFacilitiesEquipment 设施设备信息
     * @return 结果
     */
	public int updateTFacilitiesEquipment(TFacilitiesEquipment tFacilitiesEquipment,MultipartFile facilitiesFile);
		
	/**
     * 删除设施设备信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTFacilitiesEquipmentByIds(String ids);
	
}
