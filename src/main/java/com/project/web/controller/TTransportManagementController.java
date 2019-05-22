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
import com.project.web.domian.TTransportManagement;
import com.project.web.service.ITTransportManagementService;


/**
 * 客运管理 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Controller
@RequestMapping("/system/tTransportManagement")
public class TTransportManagementController extends BaseController
{
    private String prefix = "system/tTransportManagement";
	
	@Autowired
	private ITTransportManagementService tTransportManagementService;
	
	@RequiresPermissions("system:tTransportManagement:view")
	@GetMapping()
	public String tTransportManagement()
	{
	    return prefix + "/tTransportManagement";
	}
	
	/**
	 * 查询客运管理列表
	 */
//	@RequiresPermissions("system:tTransportManagement:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TTransportManagement tTransportManagement)
	{
		startPage();
        List<TTransportManagement> list = tTransportManagementService.selectTTransportManagementList(tTransportManagement);
		return getDataTable(list);
	}
	
	/**
	 * 新增客运管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存客运管理
	 */
//	@RequiresPermissions("system:tTransportManagement:add")
	@Log(title = "客运管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TTransportManagement tTransportManagement,@RequestParam(name = "transportFile",required = false) MultipartFile transportFile)
	{		
		return tTransportManagementService.insertTTransportManagement(tTransportManagement,transportFile);
	}

	/**
	 * 修改客运管理
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		TTransportManagement tTransportManagement = tTransportManagementService.selectTTransportManagementById(id);
		mmap.put("tTransportManagement", tTransportManagement);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存客运管理
	 */
//	@RequiresPermissions("system:tTransportManagement:edit")
	@Log(title = "客运管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TTransportManagement tTransportManagement,@RequestParam(name = "transportFile",required = false) MultipartFile transportFile)
	{		
		return tTransportManagementService.updateTTransportManagement(tTransportManagement,transportFile);
	}
	
	/**
	 * 删除客运管理
	 */
//	@RequiresPermissions("system:tTransportManagement:remove")
	@Log(title = "客运管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tTransportManagementService.deleteTTransportManagementByIds(ids));
	}
	
}
