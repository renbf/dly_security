package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.ValidationUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.THiddenTroubleInvestigation;
import com.project.web.domian.TRiskLevelControl;
import com.project.web.mapper.THiddenTroubleInvestigationMapper;
import com.project.web.service.ITHiddenTroubleInvestigationService;

/**
 * 隐患排查 服务层实现
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class THiddenTroubleInvestigationServiceImpl implements ITHiddenTroubleInvestigationService 
{
	@Autowired
	private THiddenTroubleInvestigationMapper tHiddenTroubleInvestigationMapper;

	/**
     * 查询隐患排查信息
     * 
     * @param id 隐患排查ID
     * @return 隐患排查信息
     */
    @Override
	public THiddenTroubleInvestigation selectTHiddenTroubleInvestigationById(String id)
	{
	    return tHiddenTroubleInvestigationMapper.selectTHiddenTroubleInvestigationById(id);
	}
	
	/**
     * 查询隐患排查列表
     * 
     * @param tHiddenTroubleInvestigation 隐患排查信息
     * @return 隐患排查集合
     */
	@Override
	public List<THiddenTroubleInvestigation> selectTHiddenTroubleInvestigationList(THiddenTroubleInvestigation tHiddenTroubleInvestigation)
	{
	    return tHiddenTroubleInvestigationMapper.selectTHiddenTroubleInvestigationList(tHiddenTroubleInvestigation);
	}
	
    /**
     * 新增隐患排查
     * 
     * @param tHiddenTroubleInvestigation 隐患排查信息
     * @return 结果
     */
	@Override
	public AjaxResult insertTHiddenTroubleInvestigation(THiddenTroubleInvestigation tHiddenTroubleInvestigation)
	{
		AjaxResult aj= insertValidation(tHiddenTroubleInvestigation);
		if(aj!=null) {
			return aj;
		}
		tHiddenTroubleInvestigation.setId(UUIDUtil.getUUID());
		tHiddenTroubleInvestigation.setCreateTime(new Date());
		tHiddenTroubleInvestigation.setUserId(ShiroUtils.getUserId());
		int i = tHiddenTroubleInvestigationMapper.insertTHiddenTroubleInvestigation(tHiddenTroubleInvestigation);
		if(i==0) {
			return AjaxResult.error();
		}
		return AjaxResult.success();
	}
	
	/**
     * 修改隐患排查
     * 
     * @param tHiddenTroubleInvestigation 隐患排查信息
     * @return 结果
     */
	@Override
	public AjaxResult updateTHiddenTroubleInvestigation(THiddenTroubleInvestigation tHiddenTroubleInvestigation)
	{
		AjaxResult aj= insertValidation(tHiddenTroubleInvestigation);
		if(aj!=null) {
			return aj;
		}
		tHiddenTroubleInvestigation.setUpdateTime(new Date());
		tHiddenTroubleInvestigation.setUpdateUserId(ShiroUtils.getUserId());
		int i = tHiddenTroubleInvestigationMapper.updateTHiddenTroubleInvestigation(tHiddenTroubleInvestigation);
		if(i==0) {
			return AjaxResult.error();
		}
		return AjaxResult.success();
	}

	/**
     * 删除隐患排查对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTHiddenTroubleInvestigationByIds(String ids)
	{
		return tHiddenTroubleInvestigationMapper.deleteTHiddenTroubleInvestigationByIds(Convert.toStrArray(ids));
	}
	
	private AjaxResult insertValidation(THiddenTroubleInvestigation obj) {
        if (ValidationUtils.objIsNull(obj.getRiskPosition())) {
            return AjaxResult.error(2, "风险部位不能为空");
        }
        if (ValidationUtils.objIsNull(obj.getRiskName())) {
            return AjaxResult.error(2, "风险名称不能为空");
        }
        if (ValidationUtils.objIsNull(obj.getRiskLevel())) {
            return AjaxResult.error(2, "风险分级不能为空");
        }
        if (ValidationUtils.objIsNull(obj.getDerelictionDeptId())) {
            return AjaxResult.error(2, "失职部门不能为空");
        }
        if (ValidationUtils.objIsNull(obj.getDerelictionPer())) {
            return AjaxResult.error(2, "失职人员不能为空");
        }
        if (ValidationUtils.objIsNull(obj.getTroubleshootDeptId())) {
            return AjaxResult.error(2, "排查部门不能为空");
        }
        if (ValidationUtils.objIsNull(obj.getDeptId())) {
            return AjaxResult.error(2, "部门不能为空");
        }
        if (ValidationUtils.objIsNull(obj.getTroubleshootStatus())) {
            return AjaxResult.error(2, "状态不能为空");
        }
        return null;
    }
}
