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
import com.project.web.domian.TIndustryDynamics;
import com.project.web.service.ITIndustryDynamicsService;

/**
 * 行业动态 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/system/tIndustryDynamics")
public class TIndustryDynamicsController extends BaseController
{
    private String prefix = "system/tIndustryDynamics";
	
	@Autowired
	private ITIndustryDynamicsService tIndustryDynamicsService;
	
	@RequiresPermissions("system:tIndustryDynamics:view")
	@GetMapping()
	public String tIndustryDynamics()
	{
	    return prefix + "/tIndustryDynamics";
	}
	
	/**
	 * 查询行业动态列表
	 */
	@RequiresPermissions("system:tIndustryDynamics:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TIndustryDynamics tIndustryDynamics)
	{
		startPage();
        List<TIndustryDynamics> list = tIndustryDynamicsService.selectTIndustryDynamicsList(tIndustryDynamics);
		return getDataTable(list);
	}
	
	/**
	 * 新增行业动态
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存行业动态
	 */
	@RequiresPermissions("system:tIndustryDynamics:add")
	@Log(title = "行业动态", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TIndustryDynamics tIndustryDynamics)
	{		
		return toAjax(tIndustryDynamicsService.insertTIndustryDynamics(tIndustryDynamics));
	}

	/**
	 * 修改行业动态
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TIndustryDynamics tIndustryDynamics = tIndustryDynamicsService.selectTIndustryDynamicsById(id);
		mmap.put("tIndustryDynamics", tIndustryDynamics);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存行业动态
	 */
	@RequiresPermissions("system:tIndustryDynamics:edit")
	@Log(title = "行业动态", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TIndustryDynamics tIndustryDynamics)
	{		
		return toAjax(tIndustryDynamicsService.updateTIndustryDynamics(tIndustryDynamics));
	}
	
	/**
	 * 删除行业动态
	 */
	@RequiresPermissions("system:tIndustryDynamics:remove")
	@Log(title = "行业动态", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tIndustryDynamicsService.deleteTIndustryDynamicsByIds(ids));
	}
	
}
