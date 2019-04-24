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
import com.project.web.domian.TDriverMiddleLog;
import com.project.web.service.ITDriverMiddleLogService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 行车中检查事项 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tDriverMiddleLog")
public class TDriverMiddleLogController extends BaseController
{
    private String prefix = "web/tDriverMiddleLog";
	
	@Autowired
	private ITDriverMiddleLogService tDriverMiddleLogService;
	
	@RequiresPermissions("web:tDriverMiddleLog:view")
	@GetMapping()
	public String tDriverMiddleLog()
	{
	    return prefix + "/tDriverMiddleLog";
	}
	
	/**
	 * 查询行车中检查事项列表
	 */
	@RequiresPermissions("web:tDriverMiddleLog:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TDriverMiddleLog tDriverMiddleLog)
	{
		startPage();
        List<TDriverMiddleLog> list = tDriverMiddleLogService.selectTDriverMiddleLogList(tDriverMiddleLog);
		return getDataTable(list);
	}
	
	/**
	 * 新增行车中检查事项
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存行车中检查事项
	 */
	@RequiresPermissions("web:tDriverMiddleLog:add")
	@Log(title = "行车中检查事项", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TDriverMiddleLog tDriverMiddleLog)
	{		
		return toAjax(tDriverMiddleLogService.insertTDriverMiddleLog(tDriverMiddleLog));
	}

	/**
	 * 修改行车中检查事项
	 */
	@GetMapping("/edit/{driverLogId}")
	public String edit(@PathVariable("driverLogId") String driverLogId, ModelMap mmap)
	{
		TDriverMiddleLog tDriverMiddleLog = tDriverMiddleLogService.selectTDriverMiddleLogById(driverLogId);
		mmap.put("tDriverMiddleLog", tDriverMiddleLog);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存行车中检查事项
	 */
	@RequiresPermissions("web:tDriverMiddleLog:edit")
	@Log(title = "行车中检查事项", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TDriverMiddleLog tDriverMiddleLog)
	{		
		return toAjax(tDriverMiddleLogService.updateTDriverMiddleLog(tDriverMiddleLog));
	}
	
	/**
	 * 删除行车中检查事项
	 */
	@RequiresPermissions("web:tDriverMiddleLog:remove")
	@Log(title = "行车中检查事项", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tDriverMiddleLogService.deleteTDriverMiddleLogByIds(ids));
	}
	
}
