package com.project.web.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TTaskManagement;
import com.project.web.mapper.TTaskManagementMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITTaskManagementService;

/**
 * 作业管理 服务层实现
 * 
 * @author rbf
 * @date 2019-04-15
 */
@Service
public class TTaskManagementServiceImpl implements ITTaskManagementService 
{
	@Autowired
	private TTaskManagementMapper tTaskManagementMapper;
	@Autowired
	private IFileService fileService;

	/**
     * 查询作业管理信息
     * 
     * @param id 作业管理ID
     * @return 作业管理信息
     */
    @Override
	public TTaskManagement selectTTaskManagementById(Long id)
	{
	    return tTaskManagementMapper.selectTTaskManagementById(id);
	}
	
	/**
     * 查询作业管理列表
     * 
     * @param tTaskManagement 作业管理信息
     * @return 作业管理集合
     */
	@Override
	public List<TTaskManagement> selectTTaskManagementList(TTaskManagement tTaskManagement)
	{
	    return tTaskManagementMapper.selectTTaskManagementList(tTaskManagement);
	}
	
    /**
     * 新增作业管理
     * 
     * @param tTaskManagement 作业管理信息
     * @return 结果
     */
	@Override
	public AjaxResult insertTTaskManagement(TTaskManagement tTaskManagement,MultipartFile tasklFile)
	{
		if(checkObjParam(tTaskManagement) || checkObjParam(tTaskManagement.getEventName())){
			return AjaxResult.error(2, "事件名称不能为空");
		}
		if(checkObjParam(tTaskManagement.getRegulationsDate())){
			return AjaxResult.error(2, "违规日期不能为空");
		}
		if(checkObjParam(tTaskManagement.getIsLearn())){
			return AjaxResult.error(2, "是否学习不能为空");
		}
		if(checkObjParam(tTaskManagement.getDeptId())){
			return AjaxResult.error(2, "所属部门不能为空");
		}
		if(checkObjParam(tTaskManagement.getIllegalInfo())){
			return AjaxResult.error(2, "违规描述不能为空");
		}

		try {
			String uuid = UUIDUtil.getUUID();		
			tTaskManagement.setId(uuid);
			tTaskManagement.setCreateTime(new Date());
			//若文件不为空   则进行上传文件
			if(Objects.nonNull(tasklFile)&&StringUtils.isNotEmpty(tasklFile.getOriginalFilename())){
				String Str = fileService.upolad("weifaweizhang",uuid,"违法违章附件",tasklFile,0);
				tTaskManagement.setFilePath(Str);				
			}		

	
										
		} catch (IOException e) {
			e.printStackTrace();
		}
		int i= tTaskManagementMapper.insertTTaskManagement(tTaskManagement);
		if(i==1) {
			return AjaxResult.success();
		}else {
			return AjaxResult.error();
		}
	}
	
	/**
     * 修改作业管理
     * 
     * @param tTaskManagement 作业管理信息
     * @return 结果
     */
	@Override
	public AjaxResult updateTTaskManagement(TTaskManagement tTaskManagement,MultipartFile tasklFile)
	{
		try {
			if(checkObjParam(tTaskManagement) || checkObjParam(tTaskManagement.getEventName())){
				return AjaxResult.error(2, "事件名称不能为空");
			}
			if(checkObjParam(tTaskManagement.getRegulationsDate())){
				return AjaxResult.error(2, "违规日期不能为空");
			}
			if(checkObjParam(tTaskManagement.getIsLearn())){
				return AjaxResult.error(2, "是否学习不能为空");
			}
			if(checkObjParam(tTaskManagement.getDeptId())){
				return AjaxResult.error(2, "所属部门不能为空");
			}
			if(checkObjParam(tTaskManagement.getIllegalInfo())){
				return AjaxResult.error(2, "违规描述不能为空");
			}
			//若文件不为空   则进行上传文件
			if(Objects.nonNull(tasklFile)&&StringUtils.isNotEmpty(tasklFile.getOriginalFilename())){
				String Str = fileService.upolad("weifaweizhang",tTaskManagement.getId(),"违法违章附件",tasklFile,0);
				tTaskManagement.setFilePath(Str);				
			}		
			tTaskManagement.setUpdateTime(new Date());
			tTaskManagement.setUpdateUserId(ShiroUtils.getUserId());
										
		} catch (IOException e) {
			e.printStackTrace();
		}
		int i = tTaskManagementMapper.updateTTaskManagement(tTaskManagement);
		if(i==1) {
			return AjaxResult.success();
		}else {
			return AjaxResult.error();
		}
	}

	/**
     * 删除作业管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTTaskManagementByIds(String ids)
	{
		return tTaskManagementMapper.deleteTTaskManagementByIds(Convert.toStrArray(ids));
	}
	
	private boolean checkObjParam(Object obj) {
		if(obj ==null || "".equals(obj)) {
			return true;
		}
		return false;
	}
}
