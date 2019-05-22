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
import com.project.web.domian.TEarlyWarningReport;
import com.project.web.service.ITEarlyWarningReportService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 预警统计 信息操作处理
 * 
 * @author rbf
 * @date 2019-05-14
 */
@Controller
@RequestMapping("/web/tEarlyWarningReport")
public class TEarlyWarningReportController extends BaseController
{
    private String prefix = "web/tEarlyWarningReport";
	
	@Autowired
	private ITEarlyWarningReportService tEarlyWarningReportService;
	
	//@RequiresPermissions("web:tEarlyWarningReport:view")
	@GetMapping()
	public String tEarlyWarningReport()
	{
	    return prefix + "/tEarlyWarningReport";
	}
	
	/**
	 * 查询预警统计列表
	 */
	//@RequiresPermissions("web:tEarlyWarningReport:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TEarlyWarningReport tEarlyWarningReport)
	{
		startPage();
        List<TEarlyWarningReport> list = tEarlyWarningReportService.selectTEarlyWarningReportList(tEarlyWarningReport);
		return getDataTable(list);
	}
	
	/**
	 * 新增预警统计
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存预警统计
	 */
	//@RequiresPermissions("web:tEarlyWarningReport:add")
	@Log(title = "预警统计", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TEarlyWarningReport tEarlyWarningReport)
	{		
		return toAjax(tEarlyWarningReportService.insertTEarlyWarningReport(tEarlyWarningReport));
	}

	/**
	 * 修改预警统计
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TEarlyWarningReport tEarlyWarningReport = tEarlyWarningReportService.selectTEarlyWarningReportById(id);
		mmap.put("tEarlyWarningReport", tEarlyWarningReport);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存预警统计
	 */
	//@RequiresPermissions("web:tEarlyWarningReport:edit")
	@Log(title = "预警统计", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TEarlyWarningReport tEarlyWarningReport)
	{		
		return toAjax(tEarlyWarningReportService.updateTEarlyWarningReport(tEarlyWarningReport));
	}
	
	/**
	 * 删除预警统计
	 */
	//@RequiresPermissions("web:tEarlyWarningReport:remove")
	@Log(title = "预警统计", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tEarlyWarningReportService.deleteTEarlyWarningReportByIds(ids));
	}



	@PostMapping( "/warningReport")
	@ResponseBody
	public AjaxResult warningReport(TEarlyWarningReport tEarlyWarningReport) {
		return this.tEarlyWarningReportService.selectDangerWarningSum(tEarlyWarningReport);
	}


}
