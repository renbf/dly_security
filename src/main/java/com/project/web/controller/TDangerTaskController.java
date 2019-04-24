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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TDangerTask;
import com.project.web.service.ITDangerTaskService;


/**
 * 危险作业 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Controller
@RequestMapping("/system/tDangerTask")
public class TDangerTaskController extends BaseController
{
    private String prefix = "system/tDangerTask";
	
	@Autowired
	private ITDangerTaskService tDangerTaskService;
	
	@RequiresPermissions("system:tDangerTask:view")
	@GetMapping()
	public String tDangerTask()
	{
	    return prefix + "/tDangerTask";
	}
	
	/**
	 * 查询危险作业列表
	 */
//	@RequiresPermissions("system:tDangerTask:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TDangerTask tDangerTask)
	{
		startPage();
        List<TDangerTask> list = tDangerTaskService.selectTDangerTaskList(tDangerTask);
		return getDataTable(list);
	}
	
	/**
	 * 新增危险作业
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存危险作业
	 */
//	@RequiresPermissions("system:tDangerTask:add")
	@Log(title = "危险作业", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TDangerTask tDangerTask,@RequestParam(name = "technologyFile",required = false) MultipartFile technologyFile,@RequestParam(name = "licenceFile",required = false) MultipartFile licenceFile)
	{		
		return toAjax(tDangerTaskService.insertTDangerTask(tDangerTask,technologyFile,licenceFile));
	}

	/**
	 * 修改危险作业
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		TDangerTask tDangerTask = tDangerTaskService.selectTDangerTaskById(id);
		mmap.put("tDangerTask", tDangerTask);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存危险作业
	 */
//	@RequiresPermissions("system:tDangerTask:edit")
	@Log(title = "危险作业", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TDangerTask tDangerTask,@RequestParam(name = "technologyFile",required = false) MultipartFile technologyFile,@RequestParam(name = "licenceFile",required = false) MultipartFile licenceFile)
	{		
		return toAjax(tDangerTaskService.updateTDangerTask(tDangerTask,technologyFile,licenceFile));
	}
	
	/**
	 * 删除危险作业
	 */
//	@RequiresPermissions("system:tDangerTask:remove")
	@Log(title = "危险作业", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tDangerTaskService.deleteTDangerTaskByIds(ids));
	}
	
}
