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
import com.project.web.domian.TCarPartsChange;
import com.project.web.service.ITCarPartsChangeService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 车辆主要部件更换登记 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tCarPartsChange")
public class TCarPartsChangeController extends BaseController
{
    private String prefix = "web/tCarPartsChange";
	
	@Autowired
	private ITCarPartsChangeService tCarPartsChangeService;
	
	@RequiresPermissions("web:tCarPartsChange:view")
	@GetMapping()
	public String tCarPartsChange()
	{
	    return prefix + "/tCarPartsChange";
	}
	
	/**
	 * 查询车辆主要部件更换登记列表
	 */
	@RequiresPermissions("web:tCarPartsChange:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TCarPartsChange tCarPartsChange)
	{
		startPage();
        List<TCarPartsChange> list = tCarPartsChangeService.selectTCarPartsChangeList(tCarPartsChange);
		return getDataTable(list);
	}
	
	/**
	 * 新增车辆主要部件更换登记
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存车辆主要部件更换登记
	 */
	@RequiresPermissions("web:tCarPartsChange:add")
	@Log(title = "车辆主要部件更换登记", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TCarPartsChange tCarPartsChange)
	{		
		return toAjax(tCarPartsChangeService.insertTCarPartsChange(tCarPartsChange));
	}

	/**
	 * 修改车辆主要部件更换登记
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TCarPartsChange tCarPartsChange = tCarPartsChangeService.selectTCarPartsChangeById(id);
		mmap.put("tCarPartsChange", tCarPartsChange);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存车辆主要部件更换登记
	 */
	@RequiresPermissions("web:tCarPartsChange:edit")
	@Log(title = "车辆主要部件更换登记", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TCarPartsChange tCarPartsChange)
	{		
		return toAjax(tCarPartsChangeService.updateTCarPartsChange(tCarPartsChange));
	}
	
	/**
	 * 删除车辆主要部件更换登记
	 */
	@RequiresPermissions("web:tCarPartsChange:remove")
	@Log(title = "车辆主要部件更换登记", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tCarPartsChangeService.deleteTCarPartsChangeByIds(ids));
	}
	
}
