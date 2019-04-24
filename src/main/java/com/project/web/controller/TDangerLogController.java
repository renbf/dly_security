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
import com.project.web.domian.TDangerLog;
import com.project.web.service.ITDangerLogService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 隐患日志 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tDangerLog")
public class TDangerLogController extends BaseController
{
    private String prefix = "web/tDangerLog";
	
	@Autowired
	private ITDangerLogService tDangerLogService;
	
	@RequiresPermissions("web:tDangerLog:view")
	@GetMapping()
	public String tDangerLog()
	{
	    return prefix + "/tDangerLog";
	}
	
	/**
	 * 查询隐患日志列表
	 */
	@RequiresPermissions("web:tDangerLog:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TDangerLog tDangerLog)
	{
		startPage();
        List<TDangerLog> list = tDangerLogService.selectTDangerLogList(tDangerLog);
		return getDataTable(list);
	}
	
	/**
	 * 新增隐患日志
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存隐患日志
	 */
	@RequiresPermissions("web:tDangerLog:add")
	@Log(title = "隐患日志", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TDangerLog tDangerLog)
	{		
		return toAjax(tDangerLogService.insertTDangerLog(tDangerLog));
	}

	/**
	 * 修改隐患日志
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TDangerLog tDangerLog = tDangerLogService.selectTDangerLogById(id);
		mmap.put("tDangerLog", tDangerLog);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存隐患日志
	 */
	@RequiresPermissions("web:tDangerLog:edit")
	@Log(title = "隐患日志", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TDangerLog tDangerLog)
	{		
		return toAjax(tDangerLogService.updateTDangerLog(tDangerLog));
	}
	
	/**
	 * 删除隐患日志
	 */
	@RequiresPermissions("web:tDangerLog:remove")
	@Log(title = "隐患日志", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tDangerLogService.deleteTDangerLogByIds(ids));
	}
	
}
