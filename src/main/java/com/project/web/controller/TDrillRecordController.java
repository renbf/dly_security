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
import com.project.web.domian.TDrillRecord;
import com.project.web.service.ITDrillRecordService;

/**
 * 演练记录 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/system/tDrillRecord")
public class TDrillRecordController extends BaseController
{
    private String prefix = "system/tDrillRecord";
	
	@Autowired
	private ITDrillRecordService tDrillRecordService;
	
	@RequiresPermissions("system:tDrillRecord:view")
	@GetMapping()
	public String tDrillRecord()
	{
	    return prefix + "/tDrillRecord";
	}
	
	/**
	 * 查询演练记录列表
	 */
	@RequiresPermissions("system:tDrillRecord:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TDrillRecord tDrillRecord)
	{
		startPage();
        List<TDrillRecord> list = tDrillRecordService.selectTDrillRecordList(tDrillRecord);
		return getDataTable(list);
	}
	
	/**
	 * 新增演练记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存演练记录
	 */
	@RequiresPermissions("system:tDrillRecord:add")
	@Log(title = "演练记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TDrillRecord tDrillRecord)
	{		
		return toAjax(tDrillRecordService.insertTDrillRecord(tDrillRecord));
	}

	/**
	 * 修改演练记录
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TDrillRecord tDrillRecord = tDrillRecordService.selectTDrillRecordById(id);
		mmap.put("tDrillRecord", tDrillRecord);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存演练记录
	 */
	@RequiresPermissions("system:tDrillRecord:edit")
	@Log(title = "演练记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TDrillRecord tDrillRecord)
	{		
		return toAjax(tDrillRecordService.updateTDrillRecord(tDrillRecord));
	}
	
	/**
	 * 删除演练记录
	 */
	@RequiresPermissions("system:tDrillRecord:remove")
	@Log(title = "演练记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tDrillRecordService.deleteTDrillRecordByIds(ids));
	}
	
}
