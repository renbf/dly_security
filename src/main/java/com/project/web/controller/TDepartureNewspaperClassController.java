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
import com.project.web.domian.TDepartureNewspaperClass;
import com.project.web.service.ITDepartureNewspaperClassService;


/**
 * 车辆报班 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Controller
@RequestMapping("/web/tDepartureNewspaperClass")
public class TDepartureNewspaperClassController extends BaseController
{
	private String prefix = "web/tDepartureNewspaperClass";

	@Autowired
	private ITDepartureNewspaperClassService tDepartureNewspaperClassService;

	@RequiresPermissions("web:tDepartureNewspaperClass:view")
	@GetMapping()
	public String tDepartureNewspaperClass()
	{
		return prefix + "/tDepartureNewspaperClass";
	}

	/**
	 * 查询车辆报班列表
	 */
	//@RequiresPermissions("web:tDepartureNewspaperClass:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TDepartureNewspaperClass tDepartureNewspaperClass)
	{
		startPage();
		List<TDepartureNewspaperClass> list = tDepartureNewspaperClassService.selectTDepartureNewspaperClassList(tDepartureNewspaperClass);
		return getDataTable(list);
	}

	/**
	 * 新增车辆报班
	 */
	@GetMapping("/add")
	public String add()
	{
		return prefix + "/add";
	}

	/**
	 * 新增保存车辆报班
	 */
	//@RequiresPermissions("web:tDepartureNewspaperClass:add")
	@Log(title = "车辆报班", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TDepartureNewspaperClass tDepartureNewspaperClass)
	{
		return tDepartureNewspaperClassService.insertTDepartureNewspaperClass(tDepartureNewspaperClass);
	}

	/**
	 * 修改车辆报班
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TDepartureNewspaperClass tDepartureNewspaperClass = tDepartureNewspaperClassService.selectTDepartureNewspaperClassById(id);
		mmap.put("tDepartureNewspaperClass", tDepartureNewspaperClass);
		return prefix + "/edit";
	}

	/**
	 * 修改保存车辆报班
	 */
	//@RequiresPermissions("web:tDepartureNewspaperClass:edit")
	@Log(title = "车辆报班", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TDepartureNewspaperClass tDepartureNewspaperClass)
	{
		return tDepartureNewspaperClassService.updateTDepartureNewspaperClass(tDepartureNewspaperClass);
	}

	/**
	 * 删除车辆报班
	 */
	//@RequiresPermissions("web:tDepartureNewspaperClass:remove")
	@Log(title = "车辆报班", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		return toAjax(tDepartureNewspaperClassService.deleteTDepartureNewspaperClassByIds(ids));
	}

}
