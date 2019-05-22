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
import com.project.web.domian.TAccidentAnalysisTopic;
import com.project.web.domian.TRiskLevelControl;
import com.project.web.mapper.TRiskLevelControlMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITRiskLevelControlService;

/**
 * 风险分级管控 服务层实现
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TRiskLevelControlServiceImpl implements ITRiskLevelControlService 
{
	@Autowired
	private TRiskLevelControlMapper tRiskLevelControlMapper;
    @Autowired
    private IFileService fileService;

	/**
     * 查询风险分级管控信息
     * 
     * @param id 风险分级管控ID
     * @return 风险分级管控信息
     */
    @Override
	public TRiskLevelControl selectTRiskLevelControlById(String id)
	{
	    return tRiskLevelControlMapper.selectTRiskLevelControlById(id);
	}
	
	/**
     * 查询风险分级管控列表
     * 
     * @param tRiskLevelControl 风险分级管控信息
     * @return 风险分级管控集合
     */
	@Override
	public List<TRiskLevelControl> selectTRiskLevelControlList(TRiskLevelControl tRiskLevelControl)
	{
	    return tRiskLevelControlMapper.selectTRiskLevelControlList(tRiskLevelControl);
	}
	
    /**
     * 新增风险分级管控
     * 
     * @param tRiskLevelControl 风险分级管控信息
     * @return 结果
     */
	@Override
	public AjaxResult insertTRiskLevelControl(TRiskLevelControl tRiskLevelControl,MultipartFile riskLevelFile)
	{
		try {
			AjaxResult aj = insertValidation(tRiskLevelControl);
			if(aj!=null) {
				return aj;
			}
			String uuid= UUIDUtil.getUUID();
			 if (Objects.nonNull(riskLevelFile) && StringUtils.isNotEmpty(riskLevelFile.getOriginalFilename())) {
	                String upolad = this.fileService.upolad("fengxianfenjiguankong", uuid, "风险分级管控附件文件", riskLevelFile, 0,tRiskLevelControl.getBusinessId());
	                tRiskLevelControl.setFilePath(upolad);
	            }
				tRiskLevelControl.setId(uuid);
				tRiskLevelControl.setCreateTime(new Date());
				tRiskLevelControl.setUserId(ShiroUtils.getUserId());
				int i = tRiskLevelControlMapper.insertTRiskLevelControl(tRiskLevelControl);
				if(i==0) {
					return AjaxResult.error();
				}
		} catch (Exception e) {
			e.getStackTrace();
		}

		return AjaxResult.success();
	}
	
	/**
     * 修改风险分级管控
     * 
     * @param tRiskLevelControl 风险分级管控信息
     * @return 结果
     */
	@Override
	public AjaxResult updateTRiskLevelControl(TRiskLevelControl tRiskLevelControl,MultipartFile riskLevelFile)
	{
		try {
			AjaxResult aj = insertValidation(tRiskLevelControl);
			if(aj!=null) {
				return aj;
			}
			 if (Objects.nonNull(riskLevelFile) && StringUtils.isNotEmpty(riskLevelFile.getOriginalFilename())) {
	                String upolad = this.fileService.upolad("fengxianfenjiguankong", tRiskLevelControl.getId(), "风险分级管控附件文件", riskLevelFile, 0,tRiskLevelControl.getBusinessId());
	                tRiskLevelControl.setFilePath(upolad);
	            }
				tRiskLevelControl.setUpdateTime(new Date());
				tRiskLevelControl.setUpdateUserId(ShiroUtils.getUserId());
				int i = tRiskLevelControlMapper.updateTRiskLevelControl(tRiskLevelControl);
				if(i==0) {
					return AjaxResult.error();
				}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return AjaxResult.success();
	}

	/**
     * 删除风险分级管控对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTRiskLevelControlByIds(String ids)
	{
		return tRiskLevelControlMapper.deleteTRiskLevelControlByIds(Convert.toStrArray(ids));
	}
	

	private AjaxResult insertValidation(TRiskLevelControl obj) {
	        if (ValidationUtils.objIsNull(obj.getRiskPosition())) {
	            return AjaxResult.error(2, "风险部位不能为空");
	        }
	        if (ValidationUtils.objIsNull(obj.getRiskName())) {
	            return AjaxResult.error(2, "风险名称不能为空");
	        }
	        if (ValidationUtils.objIsNull(obj.getRiskLevel())) {
	            return AjaxResult.error(2, "风险分级不能为空");
	        }
	        if (ValidationUtils.objIsNull(obj.getPreventiveMeasures())) {
	            return AjaxResult.error(2, "防范措施不能为空");
	        }
	        if (ValidationUtils.objIsNull(obj.getAccidentType())) {
	            return AjaxResult.error(2, "事故类型不能为空");
	        }
	        if (ValidationUtils.objIsNull(obj.getIdentificationDate())) {
	            return AjaxResult.error(2, "辨识日期不能为空");
	        }
	        if (ValidationUtils.objIsNull(obj.getDeptId())) {
	            return AjaxResult.error(2, "部门不能为空");
	        }
	        return null;
	    }

}
