package com.project.web.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TTaskManagement;
import com.project.web.service.ITTaskManagementService;

/**
 * 作业管理 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-15
 */
@Controller
@RequestMapping("/system/tTaskManagement")
public class TTaskManagementController extends BaseController
{
    private String prefix = "system/tTaskManagement";
	
	@Autowired
	private ITTaskManagementService tTaskManagementService;
	
	@RequiresPermissions("system:tTaskManagement:view")
	@GetMapping()
	public String tTaskManagement()
	{
	    return prefix + "/tTaskManagement";
	}
	
	/**
	 * 查询作业管理列表
	 */
	@RequiresPermissions("system:tTaskManagement:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TTaskManagement tTaskManagement)
	{
		startPage();
        List<TTaskManagement> list = tTaskManagementService.selectTTaskManagementList(tTaskManagement);
		return getDataTable(list);
	}
	
	/**
	 * 新增作业管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存作业管理
	 */
	@RequiresPermissions("system:tTaskManagement:add")
	@Log(title = "作业管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TTaskManagement tTaskManagement,@RequestParam(name = "taskFile",required = false) MultipartFile taskFile)
	{		
		return tTaskManagementService.insertTTaskManagement(tTaskManagement,taskFile);
	}

	/**
	 * 修改作业管理
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		TTaskManagement tTaskManagement = tTaskManagementService.selectTTaskManagementById(id);
		mmap.put("tTaskManagement", tTaskManagement);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存作业管理
	 */
	@RequiresPermissions("system:tTaskManagement:edit")
	@Log(title = "作业管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TTaskManagement tTaskManagement,@RequestParam(name = "taskFile",required = false) MultipartFile taskFile)
	{		
		return tTaskManagementService.updateTTaskManagement(tTaskManagement,taskFile);
	}
	
	/**
	 * 删除作业管理
	 */
	@RequiresPermissions("system:tTaskManagement:remove")
	@Log(title = "作业管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tTaskManagementService.deleteTTaskManagementByIds(ids));
	}
	
}
