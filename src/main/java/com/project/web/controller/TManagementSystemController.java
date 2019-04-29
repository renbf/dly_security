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
import com.project.web.domian.TManagementSystem;
import com.project.web.service.ITManagementSystemService;

/**
 * 管理制度 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Controller
@RequestMapping("/system/tManagementSystem")
public class TManagementSystemController extends BaseController
{
    private String prefix = "system/tManagementSystem";
	
	@Autowired
	private ITManagementSystemService tManagementSystemService;
	
	@RequiresPermissions("system:tManagementSystem:view")
	@GetMapping()
	public String tManagementSystem()
	{
	    return prefix + "/tManagementSystem";
	}
	
	/**
	 * 查询管理制度列表
	 */
	@RequiresPermissions("system:tManagementSystem:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TManagementSystem tManagementSystem)
	{
		startPage();
        List<TManagementSystem> list = tManagementSystemService.selectTManagementSystemList(tManagementSystem);
		return getDataTable(list);
	}
	
	/**
	 * 新增管理制度
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存管理制度
	 */
//	@RequiresPermissions("system:tManagementSystem:add")
	@Log(title = "管理制度", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TManagementSystem tManagementSystem,@RequestParam(name = "managementFile",required = false) MultipartFile managementFile)
	{		
		return toAjax(tManagementSystemService.insertTManagementSystem(tManagementSystem,managementFile));
	}

	/**
	 * 修改管理制度
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TManagementSystem tManagementSystem = tManagementSystemService.selectTManagementSystemById(id);
		mmap.put("tManagementSystem", tManagementSystem);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存管理制度
	 */
	@RequiresPermissions("system:tManagementSystem:edit")
	@Log(title = "管理制度", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TManagementSystem tManagementSystem,@RequestParam(name = "managementFile",required = false) MultipartFile managementFile)
	{		
		return toAjax(tManagementSystemService.updateTManagementSystem(tManagementSystem,managementFile));
	}
	
	/**
	 * 删除管理制度
	 */
	@RequiresPermissions("system:tManagementSystem:remove")
	@Log(title = "管理制度", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tManagementSystemService.deleteTManagementSystemByIds(ids));
	}
	
}
