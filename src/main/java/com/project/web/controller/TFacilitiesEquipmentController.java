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
import com.project.web.domian.TFacilitiesEquipment;
import com.project.web.service.ITFacilitiesEquipmentService;

/**
 * 设施设备 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Controller
@RequestMapping("/system/tFacilitiesEquipment")
public class TFacilitiesEquipmentController extends BaseController
{
    private String prefix = "system/tFacilitiesEquipment";
	
	@Autowired
	private ITFacilitiesEquipmentService tFacilitiesEquipmentService;
	
	@RequiresPermissions("system:tFacilitiesEquipment:view")
	@GetMapping()
	public String tFacilitiesEquipment()
	{
	    return prefix + "/tFacilitiesEquipment";
	}
	
	/**
	 * 查询设施设备列表
	 */
//	@RequiresPermissions("system:tFacilitiesEquipment:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TFacilitiesEquipment tFacilitiesEquipment)
	{
		startPage();
        List<TFacilitiesEquipment> list = tFacilitiesEquipmentService.selectTFacilitiesEquipmentList(tFacilitiesEquipment);
		return getDataTable(list);
	}
	
	/**
	 * 新增设施设备
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存设施设备
	 */
//	@RequiresPermissions("system:tFacilitiesEquipment:add")
	@Log(title = "设施设备", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TFacilitiesEquipment tFacilitiesEquipment,@RequestParam(name = "facilitiesFile",required = false) MultipartFile facilitiesFile)
	{		
		return toAjax(tFacilitiesEquipmentService.insertTFacilitiesEquipment(tFacilitiesEquipment,facilitiesFile));
	}

	/**
	 * 修改设施设备
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TFacilitiesEquipment tFacilitiesEquipment = tFacilitiesEquipmentService.selectTFacilitiesEquipmentById(id);
		mmap.put("tFacilitiesEquipment", tFacilitiesEquipment);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存设施设备
	 */
//	@RequiresPermissions("system:tFacilitiesEquipment:edit")
	@Log(title = "设施设备", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TFacilitiesEquipment tFacilitiesEquipment,@RequestParam(name = "facilitiesFile",required = false) MultipartFile facilitiesFile)
	{		
		return toAjax(tFacilitiesEquipmentService.updateTFacilitiesEquipment(tFacilitiesEquipment,facilitiesFile));
	}
	
	/**
	 * 删除设施设备
	 */
//	@RequiresPermissions("system:tFacilitiesEquipment:remove")
	@Log(title = "设施设备", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tFacilitiesEquipmentService.deleteTFacilitiesEquipmentByIds(ids));
	}
	
}
