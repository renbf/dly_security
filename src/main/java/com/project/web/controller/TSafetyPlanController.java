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
import com.project.web.domian.TSafetyPlan;
import com.project.web.service.ITSafetyPlanService;

/**
 * 安全计划 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/system/tSafetyPlan")
public class TSafetyPlanController extends BaseController
{
    private String prefix = "system/tSafetyPlan";
	
	@Autowired
	private ITSafetyPlanService tSafetyPlanService;
	
	@RequiresPermissions("system:tSafetyPlan:view")
	@GetMapping()
	public String tSafetyPlan()
	{
	    return prefix + "/tSafetyPlan";
	}
	
	/**
	 * 查询安全计划列表
	 */
	@RequiresPermissions("system:tSafetyPlan:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TSafetyPlan tSafetyPlan)
	{
		startPage();
        List<TSafetyPlan> list = tSafetyPlanService.selectTSafetyPlanList(tSafetyPlan);
		return getDataTable(list);
	}
	
	/**
	 * 新增安全计划
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存安全计划
	 */
	@RequiresPermissions("system:tSafetyPlan:add")
	@Log(title = "安全计划", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TSafetyPlan tSafetyPlan)
	{		
		return toAjax(tSafetyPlanService.insertTSafetyPlan(tSafetyPlan));
	}

	/**
	 * 修改安全计划
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TSafetyPlan tSafetyPlan = tSafetyPlanService.selectTSafetyPlanById(id);
		mmap.put("tSafetyPlan", tSafetyPlan);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存安全计划
	 */
	@RequiresPermissions("system:tSafetyPlan:edit")
	@Log(title = "安全计划", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TSafetyPlan tSafetyPlan)
	{		
		return toAjax(tSafetyPlanService.updateTSafetyPlan(tSafetyPlan));
	}
	
	/**
	 * 删除安全计划
	 */
	@RequiresPermissions("system:tSafetyPlan:remove")
	@Log(title = "安全计划", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tSafetyPlanService.deleteTSafetyPlanByIds(ids));
	}
	
}
