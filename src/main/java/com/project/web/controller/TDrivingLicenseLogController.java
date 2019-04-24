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
import com.project.web.domian.TDrivingLicenseLog;
import com.project.web.service.ITDrivingLicenseLogService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 行驶证变更 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tDrivingLicenseLog")
public class TDrivingLicenseLogController extends BaseController
{
    private String prefix = "web/tDrivingLicenseLog";
	
	@Autowired
	private ITDrivingLicenseLogService tDrivingLicenseLogService;
	
	@RequiresPermissions("web:tDrivingLicenseLog:view")
	@GetMapping()
	public String tDrivingLicenseLog()
	{
	    return prefix + "/tDrivingLicenseLog";
	}
	
	/**
	 * 查询行驶证变更列表
	 */
	@RequiresPermissions("web:tDrivingLicenseLog:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TDrivingLicenseLog tDrivingLicenseLog)
	{
		startPage();
        List<TDrivingLicenseLog> list = tDrivingLicenseLogService.selectTDrivingLicenseLogList(tDrivingLicenseLog);
		return getDataTable(list);
	}
	
	/**
	 * 新增行驶证变更
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存行驶证变更
	 */
	@RequiresPermissions("web:tDrivingLicenseLog:add")
	@Log(title = "行驶证变更", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TDrivingLicenseLog tDrivingLicenseLog)
	{		
		return toAjax(tDrivingLicenseLogService.insertTDrivingLicenseLog(tDrivingLicenseLog));
	}

	/**
	 * 修改行驶证变更
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TDrivingLicenseLog tDrivingLicenseLog = tDrivingLicenseLogService.selectTDrivingLicenseLogById(id);
		mmap.put("tDrivingLicenseLog", tDrivingLicenseLog);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存行驶证变更
	 */
	@RequiresPermissions("web:tDrivingLicenseLog:edit")
	@Log(title = "行驶证变更", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TDrivingLicenseLog tDrivingLicenseLog)
	{		
		return toAjax(tDrivingLicenseLogService.updateTDrivingLicenseLog(tDrivingLicenseLog));
	}
	
	/**
	 * 删除行驶证变更
	 */
	@RequiresPermissions("web:tDrivingLicenseLog:remove")
	@Log(title = "行驶证变更", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tDrivingLicenseLogService.deleteTDrivingLicenseLogByIds(ids));
	}
	
}
