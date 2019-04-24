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
import com.project.web.domian.TSafetyTarget;
import com.project.web.service.ITSafetyTargetService;

/**
 * 安全目标 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/system/tSafetyTarget")
public class TSafetyTargetController extends BaseController
{
    private String prefix = "system/tSafetyTarget";
	
	@Autowired
	private ITSafetyTargetService tSafetyTargetService;
	
	@RequiresPermissions("system:tSafetyTarget:view")
	@GetMapping()
	public String tSafetyTarget()
	{
	    return prefix + "/tSafetyTarget";
	}
	
	/**
	 * 查询安全目标列表
	 */
	@RequiresPermissions("system:tSafetyTarget:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TSafetyTarget tSafetyTarget)
	{
		startPage();
        List<TSafetyTarget> list = tSafetyTargetService.selectTSafetyTargetList(tSafetyTarget);
		return getDataTable(list);
	}
	
	/**
	 * 新增安全目标
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存安全目标
	 */
	@RequiresPermissions("system:tSafetyTarget:add")
	@Log(title = "安全目标", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TSafetyTarget tSafetyTarget)
	{		
		return toAjax(tSafetyTargetService.insertTSafetyTarget(tSafetyTarget));
	}

	/**
	 * 修改安全目标
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TSafetyTarget tSafetyTarget = tSafetyTargetService.selectTSafetyTargetById(id);
		mmap.put("tSafetyTarget", tSafetyTarget);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存安全目标
	 */
	@RequiresPermissions("system:tSafetyTarget:edit")
	@Log(title = "安全目标", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TSafetyTarget tSafetyTarget)
	{		
		return toAjax(tSafetyTargetService.updateTSafetyTarget(tSafetyTarget));
	}
	
	/**
	 * 删除安全目标
	 */
	@RequiresPermissions("system:tSafetyTarget:remove")
	@Log(title = "安全目标", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tSafetyTargetService.deleteTSafetyTargetByIds(ids));
	}
	
}
