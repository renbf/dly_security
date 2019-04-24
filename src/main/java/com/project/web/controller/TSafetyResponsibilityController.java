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
import com.project.web.domian.TSafetyResponsibility;
import com.project.web.service.ITSafetyResponsibilityService;

/**
 * 安全责任 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/system/tSafetyResponsibility")
public class TSafetyResponsibilityController extends BaseController
{
    private String prefix = "system/tSafetyResponsibility";
	
	@Autowired
	private ITSafetyResponsibilityService tSafetyResponsibilityService;
	
	@RequiresPermissions("system:tSafetyResponsibility:view")
	@GetMapping()
	public String tSafetyResponsibility()
	{
	    return prefix + "/tSafetyResponsibility";
	}
	
	/**
	 * 查询安全责任列表
	 */
	@RequiresPermissions("system:tSafetyResponsibility:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TSafetyResponsibility tSafetyResponsibility)
	{
		startPage();
        List<TSafetyResponsibility> list = tSafetyResponsibilityService.selectTSafetyResponsibilityList(tSafetyResponsibility);
		return getDataTable(list);
	}
	
	/**
	 * 新增安全责任
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存安全责任
	 */
	@RequiresPermissions("system:tSafetyResponsibility:add")
	@Log(title = "安全责任", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TSafetyResponsibility tSafetyResponsibility)
	{		
		return toAjax(tSafetyResponsibilityService.insertTSafetyResponsibility(tSafetyResponsibility));
	}

	/**
	 * 修改安全责任
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TSafetyResponsibility tSafetyResponsibility = tSafetyResponsibilityService.selectTSafetyResponsibilityById(id);
		mmap.put("tSafetyResponsibility", tSafetyResponsibility);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存安全责任
	 */
	@RequiresPermissions("system:tSafetyResponsibility:edit")
	@Log(title = "安全责任", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TSafetyResponsibility tSafetyResponsibility)
	{		
		return toAjax(tSafetyResponsibilityService.updateTSafetyResponsibility(tSafetyResponsibility));
	}
	
	/**
	 * 删除安全责任
	 */
	@RequiresPermissions("system:tSafetyResponsibility:remove")
	@Log(title = "安全责任", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tSafetyResponsibilityService.deleteTSafetyResponsibilityByIds(ids));
	}
	
}
