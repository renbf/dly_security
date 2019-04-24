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
import com.project.web.domian.TCheckPlan;
import com.project.web.service.ITCheckPlanService;

/**
 * 检查计划 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/system/tCheckPlan")
public class TCheckPlanController extends BaseController
{
    private String prefix = "system/tCheckPlan";
	
	@Autowired
	private ITCheckPlanService tCheckPlanService;
	
	@RequiresPermissions("system:tCheckPlan:view")
	@GetMapping()
	public String tCheckPlan()
	{
	    return prefix + "/tCheckPlan";
	}
	
	/**
	 * 查询检查计划列表
	 */
	@RequiresPermissions("system:tCheckPlan:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TCheckPlan tCheckPlan)
	{
		startPage();
        List<TCheckPlan> list = tCheckPlanService.selectTCheckPlanList(tCheckPlan);
		return getDataTable(list);
	}
	
	/**
	 * 新增检查计划
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存检查计划
	 */
	@RequiresPermissions("system:tCheckPlan:add")
	@Log(title = "检查计划", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TCheckPlan tCheckPlan)
	{		
		return toAjax(tCheckPlanService.insertTCheckPlan(tCheckPlan));
	}

	/**
	 * 修改检查计划
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TCheckPlan tCheckPlan = tCheckPlanService.selectTCheckPlanById(id);
		mmap.put("tCheckPlan", tCheckPlan);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存检查计划
	 */
	@RequiresPermissions("system:tCheckPlan:edit")
	@Log(title = "检查计划", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TCheckPlan tCheckPlan)
	{		
		return toAjax(tCheckPlanService.updateTCheckPlan(tCheckPlan));
	}
	
	/**
	 * 删除检查计划
	 */
	@RequiresPermissions("system:tCheckPlan:remove")
	@Log(title = "检查计划", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tCheckPlanService.deleteTCheckPlanByIds(ids));
	}
	
}
