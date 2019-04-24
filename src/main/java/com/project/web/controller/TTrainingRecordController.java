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
import com.project.web.domian.TTrainingRecord;
import com.project.web.service.ITTrainingRecordService;

/**
 * 培训记录 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/system/tTrainingRecord")
public class TTrainingRecordController extends BaseController
{
    private String prefix = "system/tTrainingRecord";
	
	@Autowired
	private ITTrainingRecordService tTrainingRecordService;
	
	@RequiresPermissions("system:tTrainingRecord:view")
	@GetMapping()
	public String tTrainingRecord()
	{
	    return prefix + "/tTrainingRecord";
	}
	
	/**
	 * 查询培训记录列表
	 */
	@RequiresPermissions("system:tTrainingRecord:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TTrainingRecord tTrainingRecord)
	{
		startPage();
        List<TTrainingRecord> list = tTrainingRecordService.selectTTrainingRecordList(tTrainingRecord);
		return getDataTable(list);
	}
	
	/**
	 * 新增培训记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存培训记录
	 */
	@RequiresPermissions("system:tTrainingRecord:add")
	@Log(title = "培训记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TTrainingRecord tTrainingRecord)
	{		
		return toAjax(tTrainingRecordService.insertTTrainingRecord(tTrainingRecord));
	}

	/**
	 * 修改培训记录
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TTrainingRecord tTrainingRecord = tTrainingRecordService.selectTTrainingRecordById(id);
		mmap.put("tTrainingRecord", tTrainingRecord);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存培训记录
	 */
	@RequiresPermissions("system:tTrainingRecord:edit")
	@Log(title = "培训记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TTrainingRecord tTrainingRecord)
	{		
		return toAjax(tTrainingRecordService.updateTTrainingRecord(tTrainingRecord));
	}
	
	/**
	 * 删除培训记录
	 */
	@RequiresPermissions("system:tTrainingRecord:remove")
	@Log(title = "培训记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tTrainingRecordService.deleteTTrainingRecordByIds(ids));
	}
	
}
