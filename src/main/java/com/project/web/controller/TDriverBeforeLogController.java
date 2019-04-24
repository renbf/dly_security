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
import com.project.web.domian.TDriverBeforeLog;
import com.project.web.service.ITDriverBeforeLogService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 行车前检查事项 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tDriverBeforeLog")
public class TDriverBeforeLogController extends BaseController
{
    private String prefix = "web/tDriverBeforeLog";
	
	@Autowired
	private ITDriverBeforeLogService tDriverBeforeLogService;
	
	@RequiresPermissions("web:tDriverBeforeLog:view")
	@GetMapping()
	public String tDriverBeforeLog()
	{
	    return prefix + "/tDriverBeforeLog";
	}
	
	/**
	 * 查询行车前检查事项列表
	 */
	@RequiresPermissions("web:tDriverBeforeLog:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TDriverBeforeLog tDriverBeforeLog)
	{
		startPage();
        List<TDriverBeforeLog> list = tDriverBeforeLogService.selectTDriverBeforeLogList(tDriverBeforeLog);
		return getDataTable(list);
	}
	
	/**
	 * 新增行车前检查事项
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存行车前检查事项
	 */
	@RequiresPermissions("web:tDriverBeforeLog:add")
	@Log(title = "行车前检查事项", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TDriverBeforeLog tDriverBeforeLog)
	{		
		return toAjax(tDriverBeforeLogService.insertTDriverBeforeLog(tDriverBeforeLog));
	}

	/**
	 * 修改行车前检查事项
	 */
	@GetMapping("/edit/{driverLogId}")
	public String edit(@PathVariable("driverLogId") String driverLogId, ModelMap mmap)
	{
		TDriverBeforeLog tDriverBeforeLog = tDriverBeforeLogService.selectTDriverBeforeLogById(driverLogId);
		mmap.put("tDriverBeforeLog", tDriverBeforeLog);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存行车前检查事项
	 */
	@RequiresPermissions("web:tDriverBeforeLog:edit")
	@Log(title = "行车前检查事项", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TDriverBeforeLog tDriverBeforeLog)
	{		
		return toAjax(tDriverBeforeLogService.updateTDriverBeforeLog(tDriverBeforeLog));
	}
	
	/**
	 * 删除行车前检查事项
	 */
	@RequiresPermissions("web:tDriverBeforeLog:remove")
	@Log(title = "行车前检查事项", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tDriverBeforeLogService.deleteTDriverBeforeLogByIds(ids));
	}
	
}
