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
import com.project.web.domian.THiddenTroubleInvestigation;
import com.project.web.service.ITHiddenTroubleInvestigationService;

/**
 * 隐患排查 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/system/tHiddenTroubleInvestigation")
public class THiddenTroubleInvestigationController extends BaseController
{
    private String prefix = "system/tHiddenTroubleInvestigation";
	
	@Autowired
	private ITHiddenTroubleInvestigationService tHiddenTroubleInvestigationService;
	
	@RequiresPermissions("system:tHiddenTroubleInvestigation:view")
	@GetMapping()
	public String tHiddenTroubleInvestigation()
	{
	    return prefix + "/tHiddenTroubleInvestigation";
	}
	
	/**
	 * 查询隐患排查列表
	 */
//	@RequiresPermissions("system:tHiddenTroubleInvestigation:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(THiddenTroubleInvestigation tHiddenTroubleInvestigation)
	{
		startPage();
        List<THiddenTroubleInvestigation> list = tHiddenTroubleInvestigationService.selectTHiddenTroubleInvestigationList(tHiddenTroubleInvestigation);
		return getDataTable(list);
	}
	
	/**
	 * 新增隐患排查
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存隐患排查
	 */
//	@RequiresPermissions("system:tHiddenTroubleInvestigation:add")
	@Log(title = "隐患排查", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(THiddenTroubleInvestigation tHiddenTroubleInvestigation)
	{		
		return tHiddenTroubleInvestigationService.insertTHiddenTroubleInvestigation(tHiddenTroubleInvestigation);
	}

	/**
	 * 修改隐患排查
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		THiddenTroubleInvestigation tHiddenTroubleInvestigation = tHiddenTroubleInvestigationService.selectTHiddenTroubleInvestigationById(id);
		mmap.put("tHiddenTroubleInvestigation", tHiddenTroubleInvestigation);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存隐患排查
	 */
	@RequiresPermissions("system:tHiddenTroubleInvestigation:edit")
	@Log(title = "隐患排查", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(THiddenTroubleInvestigation tHiddenTroubleInvestigation)
	{		
		return tHiddenTroubleInvestigationService.updateTHiddenTroubleInvestigation(tHiddenTroubleInvestigation);
	}
	
	/**
	 * 删除隐患排查
	 */
//	@RequiresPermissions("system:tHiddenTroubleInvestigation:remove")
	@Log(title = "隐患排查", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tHiddenTroubleInvestigationService.deleteTHiddenTroubleInvestigationByIds(ids));
	}
	
}
