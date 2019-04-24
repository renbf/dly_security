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
import com.project.web.domian.TOperatingProcedures;
import com.project.web.service.ITOperatingProceduresService;

/**
 * 操作规程 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Controller
@RequestMapping("/system/tOperatingProcedures")
public class TOperatingProceduresController extends BaseController
{
    private String prefix = "system/tOperatingProcedures";
	
	@Autowired
	private ITOperatingProceduresService tOperatingProceduresService;
	
	@RequiresPermissions("system:tOperatingProcedures:view")
	@GetMapping()
	public String tOperatingProcedures()
	{
	    return prefix + "/tOperatingProcedures";
	}
	
	/**
	 * 查询操作规程列表
	 */
	@RequiresPermissions("system:tOperatingProcedures:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TOperatingProcedures tOperatingProcedures)
	{
		startPage();
        List<TOperatingProcedures> list = tOperatingProceduresService.selectTOperatingProceduresList(tOperatingProcedures);
		return getDataTable(list);
	}
	
	/**
	 * 新增操作规程
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存操作规程
	 */
	@RequiresPermissions("system:tOperatingProcedures:add")
	@Log(title = "操作规程", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TOperatingProcedures tOperatingProcedures)
	{		
		return toAjax(tOperatingProceduresService.insertTOperatingProcedures(tOperatingProcedures));
	}

	/**
	 * 修改操作规程
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TOperatingProcedures tOperatingProcedures = tOperatingProceduresService.selectTOperatingProceduresById(id);
		mmap.put("tOperatingProcedures", tOperatingProcedures);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存操作规程
	 */
	@RequiresPermissions("system:tOperatingProcedures:edit")
	@Log(title = "操作规程", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TOperatingProcedures tOperatingProcedures)
	{		
		return toAjax(tOperatingProceduresService.updateTOperatingProcedures(tOperatingProcedures));
	}
	
	/**
	 * 删除操作规程
	 */
	@RequiresPermissions("system:tOperatingProcedures:remove")
	@Log(title = "操作规程", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tOperatingProceduresService.deleteTOperatingProceduresByIds(ids));
	}
	
}
