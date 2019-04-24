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
import com.project.web.domian.TEmergencyPlanRelease;
import com.project.web.service.ITEmergencyPlanReleaseService;

/**
 * 应急预案发布 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/system/tEmergencyPlanRelease")
public class TEmergencyPlanReleaseController extends BaseController
{
    private String prefix = "system/tEmergencyPlanRelease";
	
	@Autowired
	private ITEmergencyPlanReleaseService tEmergencyPlanReleaseService;
	
	@RequiresPermissions("system:tEmergencyPlanRelease:view")
	@GetMapping()
	public String tEmergencyPlanRelease()
	{
	    return prefix + "/tEmergencyPlanRelease";
	}
	
	/**
	 * 查询应急预案发布列表
	 */
	@RequiresPermissions("system:tEmergencyPlanRelease:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TEmergencyPlanRelease tEmergencyPlanRelease)
	{
		startPage();
        List<TEmergencyPlanRelease> list = tEmergencyPlanReleaseService.selectTEmergencyPlanReleaseList(tEmergencyPlanRelease);
		return getDataTable(list);
	}
	
	/**
	 * 新增应急预案发布
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存应急预案发布
	 */
	@RequiresPermissions("system:tEmergencyPlanRelease:add")
	@Log(title = "应急预案发布", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TEmergencyPlanRelease tEmergencyPlanRelease)
	{		
		return toAjax(tEmergencyPlanReleaseService.insertTEmergencyPlanRelease(tEmergencyPlanRelease));
	}

	/**
	 * 修改应急预案发布
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TEmergencyPlanRelease tEmergencyPlanRelease = tEmergencyPlanReleaseService.selectTEmergencyPlanReleaseById(id);
		mmap.put("tEmergencyPlanRelease", tEmergencyPlanRelease);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存应急预案发布
	 */
	@RequiresPermissions("system:tEmergencyPlanRelease:edit")
	@Log(title = "应急预案发布", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TEmergencyPlanRelease tEmergencyPlanRelease)
	{		
		return toAjax(tEmergencyPlanReleaseService.updateTEmergencyPlanRelease(tEmergencyPlanRelease));
	}
	
	/**
	 * 删除应急预案发布
	 */
	@RequiresPermissions("system:tEmergencyPlanRelease:remove")
	@Log(title = "应急预案发布", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tEmergencyPlanReleaseService.deleteTEmergencyPlanReleaseByIds(ids));
	}
	
}
