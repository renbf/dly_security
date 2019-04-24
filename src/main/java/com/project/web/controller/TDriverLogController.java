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
import com.project.web.domian.TDriverLog;
import com.project.web.service.ITDriverLogService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 行车日志基础 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tDriverLog")
public class TDriverLogController extends BaseController
{
    private String prefix = "web/tDriverLog";
	
	@Autowired
	private ITDriverLogService tDriverLogService;
	
	@RequiresPermissions("web:tDriverLog:view")
	@GetMapping()
	public String tDriverLog()
	{
	    return prefix + "/tDriverLog";
	}
	
	/**
	 * 查询行车日志基础列表
	 */
	@RequiresPermissions("web:tDriverLog:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TDriverLog tDriverLog)
	{
		startPage();
        List<TDriverLog> list = tDriverLogService.selectTDriverLogList(tDriverLog);
		return getDataTable(list);
	}
	
	/**
	 * 新增行车日志基础
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存行车日志基础
	 */
	@RequiresPermissions("web:tDriverLog:add")
	@Log(title = "行车日志基础", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TDriverLog tDriverLog)
	{		
		return toAjax(tDriverLogService.insertTDriverLog(tDriverLog));
	}

	/**
	 * 修改行车日志基础
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TDriverLog tDriverLog = tDriverLogService.selectTDriverLogById(id);
		mmap.put("tDriverLog", tDriverLog);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存行车日志基础
	 */
	@RequiresPermissions("web:tDriverLog:edit")
	@Log(title = "行车日志基础", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TDriverLog tDriverLog)
	{		
		return toAjax(tDriverLogService.updateTDriverLog(tDriverLog));
	}
	
	/**
	 * 删除行车日志基础
	 */
	@RequiresPermissions("web:tDriverLog:remove")
	@Log(title = "行车日志基础", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tDriverLogService.deleteTDriverLogByIds(ids));
	}
	
}
