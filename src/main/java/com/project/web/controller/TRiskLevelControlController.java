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
import com.project.web.domian.TRiskLevelControl;
import com.project.web.service.ITRiskLevelControlService;

/**
 * 风险分级管控 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/system/tRiskLevelControl")
public class TRiskLevelControlController extends BaseController
{
    private String prefix = "system/tRiskLevelControl";
	
	@Autowired
	private ITRiskLevelControlService tRiskLevelControlService;
	
	@RequiresPermissions("system:tRiskLevelControl:view")
	@GetMapping()
	public String tRiskLevelControl()
	{
	    return prefix + "/tRiskLevelControl";
	}
	
	/**
	 * 查询风险分级管控列表
	 */
//	@RequiresPermissions("system:tRiskLevelControl:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TRiskLevelControl tRiskLevelControl)
	{
		startPage();
        List<TRiskLevelControl> list = tRiskLevelControlService.selectTRiskLevelControlList(tRiskLevelControl);
		return getDataTable(list);
	}
	
	/**
	 * 新增风险分级管控
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存风险分级管控
	 */
//	@RequiresPermissions("system:tRiskLevelControl:add")
	@Log(title = "风险分级管控", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TRiskLevelControl tRiskLevelControl,@RequestParam(name = "riskLevelFile",required = false) MultipartFile riskLevelFile)
	{		
		return tRiskLevelControlService.insertTRiskLevelControl(tRiskLevelControl,riskLevelFile);
	}

	/**
	 * 修改风险分级管控
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TRiskLevelControl tRiskLevelControl = tRiskLevelControlService.selectTRiskLevelControlById(id);
		mmap.put("tRiskLevelControl", tRiskLevelControl);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存风险分级管控
	 */
//	@RequiresPermissions("system:tRiskLevelControl:edit")
	@Log(title = "风险分级管控", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TRiskLevelControl tRiskLevelControl,@RequestParam(name = "riskLevelFile",required = false) MultipartFile riskLevelFile)
	{		
		return tRiskLevelControlService.updateTRiskLevelControl(tRiskLevelControl,riskLevelFile);
	}
	
	/**
	 * 删除风险分级管控
	 */
//	@RequiresPermissions("system:tRiskLevelControl:remove")
	@Log(title = "风险分级管控", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tRiskLevelControlService.deleteTRiskLevelControlByIds(ids));
	}
	
}
