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
import com.project.web.domian.TRoadTransportLog;
import com.project.web.service.ITRoadTransportLogService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 道路运输证变更 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tRoadTransportLog")
public class TRoadTransportLogController extends BaseController
{
    private String prefix = "web/tRoadTransportLog";
	
	@Autowired
	private ITRoadTransportLogService tRoadTransportLogService;
	
	@RequiresPermissions("web:tRoadTransportLog:view")
	@GetMapping()
	public String tRoadTransportLog()
	{
	    return prefix + "/tRoadTransportLog";
	}
	
	/**
	 * 查询道路运输证变更列表
	 */
	@RequiresPermissions("web:tRoadTransportLog:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TRoadTransportLog tRoadTransportLog)
	{
		startPage();
        List<TRoadTransportLog> list = tRoadTransportLogService.selectTRoadTransportLogList(tRoadTransportLog);
		return getDataTable(list);
	}
	
	/**
	 * 新增道路运输证变更
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存道路运输证变更
	 */
	@RequiresPermissions("web:tRoadTransportLog:add")
	@Log(title = "道路运输证变更", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TRoadTransportLog tRoadTransportLog)
	{		
		return toAjax(tRoadTransportLogService.insertTRoadTransportLog(tRoadTransportLog));
	}

	/**
	 * 修改道路运输证变更
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TRoadTransportLog tRoadTransportLog = tRoadTransportLogService.selectTRoadTransportLogById(id);
		mmap.put("tRoadTransportLog", tRoadTransportLog);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存道路运输证变更
	 */
	@RequiresPermissions("web:tRoadTransportLog:edit")
	@Log(title = "道路运输证变更", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TRoadTransportLog tRoadTransportLog)
	{		
		return toAjax(tRoadTransportLogService.updateTRoadTransportLog(tRoadTransportLog));
	}
	
	/**
	 * 删除道路运输证变更
	 */
	@RequiresPermissions("web:tRoadTransportLog:remove")
	@Log(title = "道路运输证变更", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tRoadTransportLogService.deleteTRoadTransportLogByIds(ids));
	}
	
}
