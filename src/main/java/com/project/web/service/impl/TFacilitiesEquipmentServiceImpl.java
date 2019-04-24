package com.project.web.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TFacilitiesEquipment;
import com.project.web.mapper.TFacilitiesEquipmentMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITFacilitiesEquipmentService;

/**
 * 设施设备 服务层实现
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TFacilitiesEquipmentServiceImpl implements ITFacilitiesEquipmentService 
{
	@Autowired
	private TFacilitiesEquipmentMapper tFacilitiesEquipmentMapper;
	@Autowired
	private IFileService fileService;

	/**
     * 查询设施设备信息
     * 
     * @param id 设施设备ID
     * @return 设施设备信息
     */
    @Override
	public TFacilitiesEquipment selectTFacilitiesEquipmentById(String id)
	{
	    return tFacilitiesEquipmentMapper.selectTFacilitiesEquipmentById(id);
	}
	
	/**
     * 查询设施设备列表
     * 
     * @param tFacilitiesEquipment 设施设备信息
     * @return 设施设备集合
     */
	@Override
	public List<TFacilitiesEquipment> selectTFacilitiesEquipmentList(TFacilitiesEquipment tFacilitiesEquipment)
	{
	    return tFacilitiesEquipmentMapper.selectTFacilitiesEquipmentList(tFacilitiesEquipment);
	}
	
    /**
     * 新增设施设备
     * 
     * @param tFacilitiesEquipment 设施设备信息
     * @return 结果
     */
	@Override
	public int insertTFacilitiesEquipment(TFacilitiesEquipment tFacilitiesEquipment,MultipartFile facilitiesFile)
	{
		String uuid = UUIDUtil.getUUID();
		tFacilitiesEquipment.setId(uuid);
		tFacilitiesEquipment.setCreateTime(new Date());
		tFacilitiesEquipment.setUserId(ShiroUtils.getUserId());
		try {
			if(Objects.nonNull(facilitiesFile)&&StringUtils.isNotEmpty(facilitiesFile.getOriginalFilename())){
				String Str = fileService.upolad("sheshishebei",uuid,"设施设备使用等级附件",facilitiesFile,0);
				tFacilitiesEquipment.setFilePath(Str);
				
			}				
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	    return tFacilitiesEquipmentMapper.insertTFacilitiesEquipment(tFacilitiesEquipment);
	}
	
	/**
     * 修改设施设备
     * 
     * @param tFacilitiesEquipment 设施设备信息
     * @return 结果
     */
	@Override
	public int updateTFacilitiesEquipment(TFacilitiesEquipment tFacilitiesEquipment,MultipartFile facilitiesFile)
	{
		try {
			if(Objects.nonNull(facilitiesFile)&&StringUtils.isNotEmpty(facilitiesFile.getOriginalFilename())){
				String Str = fileService.upolad("sheshishebei",tFacilitiesEquipment.getId(),"设施设备使用等级附件",facilitiesFile,0);
				tFacilitiesEquipment.setFilePath(Str);
				
			}				
		} catch (IOException e) {
			e.printStackTrace();
		}
		tFacilitiesEquipment.setUpdateTime(new Date());
		tFacilitiesEquipment.setUpdateUserId(ShiroUtils.getUserId());
	    return tFacilitiesEquipmentMapper.updateTFacilitiesEquipment(tFacilitiesEquipment);
	}

	/**
     * 删除设施设备对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTFacilitiesEquipmentByIds(String ids)
	{
		return tFacilitiesEquipmentMapper.deleteTFacilitiesEquipmentByIds(Convert.toStrArray(ids));
	}
	
}
