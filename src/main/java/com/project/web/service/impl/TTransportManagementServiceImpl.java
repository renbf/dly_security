package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.common.utils.ValidationUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TThreeProducts;
import com.project.web.domian.TTransportManagement;
import com.project.web.mapper.TTransportManagementMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITTransportManagementService;

/**
 * 客运管理 服务层实现
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Service
public class TTransportManagementServiceImpl implements ITTransportManagementService 
{
	@Autowired
	private TTransportManagementMapper tTransportManagementMapper;
    @Autowired
    private IFileService fileService;

	/**
     * 查询客运管理信息
     * 
     * @param id 客运管理ID
     * @return 客运管理信息
     */
    @Override
	public TTransportManagement selectTTransportManagementById(Long id)
	{
	    return tTransportManagementMapper.selectTTransportManagementById(id);
	}
	
	/**
     * 查询客运管理列表
     * 
     * @param tTransportManagement 客运管理信息
     * @return 客运管理集合
     */
	@Override
	public List<TTransportManagement> selectTTransportManagementList(TTransportManagement tTransportManagement)
	{
	    return tTransportManagementMapper.selectTTransportManagementList(tTransportManagement);
	}
	
    /**
     * 新增客运管理
     * 
     * @param tTransportManagement 客运管理信息
     * @return 结果
     */
	@Override
	public AjaxResult insertTTransportManagement(TTransportManagement tTransportManagement,MultipartFile transportFile)
	{
		AjaxResult aj=insertValidation(tTransportManagement);
		if(aj!=null) {
			return aj;
		}
		try {
			String uuid= UUIDUtil.getUUID();
			if (Objects.nonNull(transportFile) && StringUtils.isNotEmpty(transportFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("keyunguanli", uuid, "客运管理附件文件", transportFile, 0,tTransportManagement.getBusinessId());
                tTransportManagement.setFilePath(upolad);
            }
    		tTransportManagement.setId(uuid);
    		tTransportManagement.setCreateTime(new Date());
    		tTransportManagement.setUserId(ShiroUtils.getUserId());
			int i =tTransportManagementMapper.insertTTransportManagement(tTransportManagement);
			if(i==0) {
				return AjaxResult.error();
			}
		} catch (Exception e) {
			e.getStackTrace();
		}


		return AjaxResult.success();
				
	}
	
	/**
     * 修改客运管理
     * 
     * @param tTransportManagement 客运管理信息
     * @return 结果
     */
	@Override
	public AjaxResult updateTTransportManagement(TTransportManagement tTransportManagement,MultipartFile transportFile)
	{
		AjaxResult aj=insertValidation(tTransportManagement);
		if(aj!=null) {
			return aj;
		}
		try {
			if (Objects.nonNull(transportFile) && StringUtils.isNotEmpty(transportFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("keyunguanli", tTransportManagement.getId(), "客运管理附件文件", transportFile, 0,tTransportManagement.getBusinessId());
                tTransportManagement.setFilePath(upolad);
            }
    		tTransportManagement.setUpdateTime(new Date());
    		tTransportManagement.setUpdateUserId(ShiroUtils.getUserId());
			int i =tTransportManagementMapper.updateTTransportManagement(tTransportManagement);
			if(i==0) {
				return AjaxResult.error();
			}
		} catch (Exception e) {
			e.getStackTrace();
		}

		return AjaxResult.success();
	}

	/**
     * 删除客运管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTTransportManagementByIds(String ids)
	{
		return tTransportManagementMapper.deleteTTransportManagementByIds(Convert.toStrArray(ids));
	}
	
    /**
     * insert非空字段校验
     * @param tThreeProducts
     * @return
     */
    private AjaxResult insertValidation(TTransportManagement tTransportManagement) {
        if (ValidationUtils.objIsNull(tTransportManagement.getLineName())) {
        	return AjaxResult.error(2, "线路名称不能为空");
        }
        if (ValidationUtils.objIsNull(tTransportManagement.getStartCity())) {
        	return AjaxResult.error(2, "起点城市不能为空");
        }
        if (ValidationUtils.objIsNull(tTransportManagement.getEndCity())) {
        	return AjaxResult.error(2, "终点城市不能为空");
        }
        if (ValidationUtils.objIsNull(tTransportManagement.getLineType())) {
            return AjaxResult.error(2, "线路类别不能为空");
        }
        if (ValidationUtils.objIsNull(tTransportManagement.getLineLevel())) {
            return AjaxResult.error(2, "线路等级不能为空");
        }
        if (ValidationUtils.objIsNull(tTransportManagement.getStatrStation())) {
            return AjaxResult.error(2, "起点站不能为空");
        }
        if (ValidationUtils.objIsNull(tTransportManagement.getEndStation())) {
            return AjaxResult.error(2, "终点站不能为空");
        }
        if (ValidationUtils.objIsNull(tTransportManagement.getDayVehicle())) {
            return AjaxResult.error(2, "日发班次不能为空");
        }
        if (ValidationUtils.objIsNull(tTransportManagement.getDeptId())) {
            return AjaxResult.error(2, "所属部门不能为空");
        }
        if (ValidationUtils.objIsNull(tTransportManagement.getShiftsType())) {
            return AjaxResult.error(2, "班车类型不能为空");
        }
        return null;
    }
	
}
