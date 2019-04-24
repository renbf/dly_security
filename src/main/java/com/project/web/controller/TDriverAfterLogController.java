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
import com.project.web.domian.TDriverAfterLog;
import com.project.web.service.ITDriverAfterLogService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 行车后检查事项 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tDriverAfterLog")
public class TDriverAfterLogController extends BaseController
{
    private String prefix = "web/tDriverAfterLog";
	
	@Autowired
	private ITDriverAfterLogService tDriverAfterLogService;
	
	@RequiresPermissions("web:tDriverAfterLog:view")
	@GetMapping()
	public String tDriverAfterLog()
	{
	    return prefix + "/tDriverAfterLog";
	}
	
	/**
	 * 查询行车后检查事项列表
	 */
	@RequiresPermissions("web:tDriverAfterLog:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TDriverAfterLog tDriverAfterLog)
	{
		startPage();
        List<TDriverAfterLog> list = tDriverAfterLogService.selectTDriverAfterLogList(tDriverAfterLog);
		return getDataTable(list);
	}
	
	/**
	 * 新增行车后检查事项
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存行车后检查事项
	 */
	@RequiresPermissions("web:tDriverAfterLog:add")
	@Log(title = "行车后检查事项", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TDriverAfterLog tDriverAfterLog)
	{		
		return toAjax(tDriverAfterLogService.insertTDriverAfterLog(tDriverAfterLog));
	}

	/**
	 * 修改行车后检查事项
	 */
	@GetMapping("/edit/{driverLogId}")
	public String edit(@PathVariable("driverLogId") String driverLogId, ModelMap mmap)
	{
		TDriverAfterLog tDriverAfterLog = tDriverAfterLogService.selectTDriverAfterLogById(driverLogId);
		mmap.put("tDriverAfterLog", tDriverAfterLog);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存行车后检查事项
	 */
	@RequiresPermissions("web:tDriverAfterLog:edit")
	@Log(title = "行车后检查事项", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TDriverAfterLog tDriverAfterLog)
	{		
		return toAjax(tDriverAfterLogService.updateTDriverAfterLog(tDriverAfterLog));
	}
	
	/**
	 * 删除行车后检查事项
	 */
	@RequiresPermissions("web:tDriverAfterLog:remove")
	@Log(title = "行车后检查事项", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tDriverAfterLogService.deleteTDriverAfterLogByIds(ids));
	}
	
}
