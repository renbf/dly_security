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
import com.project.common.enums.BusinessType;
import com.project.web.domian.TCoursePlan;
import com.project.web.service.ITCoursePlanService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 课程计划 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tCoursePlan")
public class TCoursePlanController extends BaseController
{
    private String prefix = "web/tCoursePlan";
	
	@Autowired
	private ITCoursePlanService tCoursePlanService;
	
	@RequiresPermissions("web:tCoursePlan:view")
	@GetMapping()
	public String tCoursePlan()
	{
	    return prefix + "/tCoursePlan";
	}
	
	/**
	 * 查询课程计划列表
	 */
	@RequiresPermissions("web:tCoursePlan:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TCoursePlan tCoursePlan)
	{
		startPage();
        List<TCoursePlan> list = tCoursePlanService.selectTCoursePlanList(tCoursePlan);
		return getDataTable(list);
	}
	
	/**
	 * 新增课程计划
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存课程计划
	 */
	@RequiresPermissions("web:tCoursePlan:add")
	@Log(title = "课程计划", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TCoursePlan tCoursePlan)
	{		
		return toAjax(tCoursePlanService.insertTCoursePlan(tCoursePlan));
	}

	/**
	 * 修改课程计划
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TCoursePlan tCoursePlan = tCoursePlanService.selectTCoursePlanById(id);
		mmap.put("tCoursePlan", tCoursePlan);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存课程计划
	 */
	@RequiresPermissions("web:tCoursePlan:edit")
	@Log(title = "课程计划", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TCoursePlan tCoursePlan)
	{		
		return toAjax(tCoursePlanService.updateTCoursePlan(tCoursePlan));
	}
	
	/**
	 * 删除课程计划
	 */
	@RequiresPermissions("web:tCoursePlan:remove")
	@Log(title = "课程计划", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tCoursePlanService.deleteTCoursePlanByIds(ids));
	}
	
}
