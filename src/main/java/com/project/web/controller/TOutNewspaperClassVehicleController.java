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
import com.project.web.domian.TOutNewspaperClassVehicle;
import com.project.web.service.ITOutNewspaperClassVehicleService;


/**
 * 未报班车辆 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Controller
@RequestMapping("/system/tOutNewspaperClassVehicle")
public class TOutNewspaperClassVehicleController extends BaseController
{
    private String prefix = "system/tOutNewspaperClassVehicle";
	
	@Autowired
	private ITOutNewspaperClassVehicleService tOutNewspaperClassVehicleService;
	
	@RequiresPermissions("system:tOutNewspaperClassVehicle:view")
	@GetMapping()
	public String tOutNewspaperClassVehicle()
	{
	    return prefix + "/tOutNewspaperClassVehicle";
	}
	
	/**
	 * 查询未报班车辆列表
	 */
	@RequiresPermissions("system:tOutNewspaperClassVehicle:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TOutNewspaperClassVehicle tOutNewspaperClassVehicle)
	{
		startPage();
        List<TOutNewspaperClassVehicle> list = tOutNewspaperClassVehicleService.selectTOutNewspaperClassVehicleList(tOutNewspaperClassVehicle);
		return getDataTable(list);
	}
	
	/**
	 * 新增未报班车辆
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存未报班车辆
	 */
	@RequiresPermissions("system:tOutNewspaperClassVehicle:add")
	@Log(title = "未报班车辆", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TOutNewspaperClassVehicle tOutNewspaperClassVehicle)
	{		
		return toAjax(tOutNewspaperClassVehicleService.insertTOutNewspaperClassVehicle(tOutNewspaperClassVehicle));
	}

	/**
	 * 修改未报班车辆
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		TOutNewspaperClassVehicle tOutNewspaperClassVehicle = tOutNewspaperClassVehicleService.selectTOutNewspaperClassVehicleById(id);
		mmap.put("tOutNewspaperClassVehicle", tOutNewspaperClassVehicle);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存未报班车辆
	 */
	@RequiresPermissions("system:tOutNewspaperClassVehicle:edit")
	@Log(title = "未报班车辆", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TOutNewspaperClassVehicle tOutNewspaperClassVehicle)
	{		
		return toAjax(tOutNewspaperClassVehicleService.updateTOutNewspaperClassVehicle(tOutNewspaperClassVehicle));
	}
	
	/**
	 * 删除未报班车辆
	 */
	@RequiresPermissions("system:tOutNewspaperClassVehicle:remove")
	@Log(title = "未报班车辆", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tOutNewspaperClassVehicleService.deleteTOutNewspaperClassVehicleByIds(ids));
	}
	
}
