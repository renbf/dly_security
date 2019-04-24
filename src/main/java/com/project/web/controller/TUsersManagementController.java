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
import org.springframework.web.bind.annotation.ResponseBody;
import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TUsersManagement;
import com.project.web.service.ITUsersManagementService;

/**
 * 人员台账 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Controller
@RequestMapping("/system/tUsersManagement")
public class TUsersManagementController extends BaseController
{
    private String prefix = "system/tUsersManagement";
	
	@Autowired
	private ITUsersManagementService tUsersManagementService;
	
	@RequiresPermissions("system:tUsersManagement:view")
	@GetMapping()
	public String tUsersManagement()
	{
	    return prefix + "/tUsersManagement";
	}
	
	/**
	 * 查询人员台账列表
	 */
	@RequiresPermissions("system:tUsersManagement:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TUsersManagement tUsersManagement)
	{
		startPage();
        List<TUsersManagement> list = tUsersManagementService.selectTUsersManagementList(tUsersManagement);
		return getDataTable(list);
	}
	
	/**
	 * 新增人员台账
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存人员台账
	 */
	@RequiresPermissions("system:tUsersManagement:add")
	@Log(title = "人员台账", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TUsersManagement tUsersManagement)
	{		
		return toAjax(tUsersManagementService.insertTUsersManagement(tUsersManagement));
	}

	/**
	 * 修改人员台账
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TUsersManagement tUsersManagement = tUsersManagementService.selectTUsersManagementById(id);
		mmap.put("tUsersManagement", tUsersManagement);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存人员台账
	 */
	@RequiresPermissions("system:tUsersManagement:edit")
	@Log(title = "人员台账", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TUsersManagement tUsersManagement)
	{		
		return toAjax(tUsersManagementService.updateTUsersManagement(tUsersManagement));
	}
	
	/**
	 * 删除人员台账
	 */
	@RequiresPermissions("system:tUsersManagement:remove")
	@Log(title = "人员台账", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tUsersManagementService.deleteTUsersManagementByIds(ids));
	}
	
}
