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
import com.project.web.domian.TSafetyDuty;
import com.project.web.service.ITSafetyDutyService;

/**
 * 安全值班 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Controller
@RequestMapping("/system/tSafetyDuty")
public class TSafetyDutyController extends BaseController
{
    private String prefix = "system/tSafetyDuty";
	
	@Autowired
	private ITSafetyDutyService tSafetyDutyService;
	
	@RequiresPermissions("system:tSafetyDuty:view")
	@GetMapping()
	public String tSafetyDuty()
	{
	    return prefix + "/tSafetyDuty";
	}
	
	/**
	 * 查询安全值班列表
	 */
	@RequiresPermissions("system:tSafetyDuty:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TSafetyDuty tSafetyDuty)
	{
		startPage();
        List<TSafetyDuty> list = tSafetyDutyService.selectTSafetyDutyList(tSafetyDuty);
		return getDataTable(list);
	}
	
	/**
	 * 新增安全值班
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存安全值班
	 */
	@RequiresPermissions("system:tSafetyDuty:add")
	@Log(title = "安全值班", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TSafetyDuty tSafetyDuty)
	{		
		return toAjax(tSafetyDutyService.insertTSafetyDuty(tSafetyDuty));
	}

	/**
	 * 修改安全值班
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TSafetyDuty tSafetyDuty = tSafetyDutyService.selectTSafetyDutyById(id);
		mmap.put("tSafetyDuty", tSafetyDuty);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存安全值班
	 */
	@RequiresPermissions("system:tSafetyDuty:edit")
	@Log(title = "安全值班", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TSafetyDuty tSafetyDuty)
	{		
		return toAjax(tSafetyDutyService.updateTSafetyDuty(tSafetyDuty));
	}
	
	/**
	 * 删除安全值班
	 */
	@RequiresPermissions("system:tSafetyDuty:remove")
	@Log(title = "安全值班", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tSafetyDutyService.deleteTSafetyDutyByIds(ids));
	}
	
}
