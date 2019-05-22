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
import com.project.web.domian.TCarInsurance;
import com.project.web.service.ITCarInsuranceService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 车辆保险情况 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tCarInsurance")
public class TCarInsuranceController extends BaseController
{
    private String prefix = "web/tCarInsurance";
	
	@Autowired
	private ITCarInsuranceService tCarInsuranceService;
	
	@RequiresPermissions("web:tCarInsurance:view")
	@GetMapping()
	public String tCarInsurance()
	{
	    return prefix + "/tCarInsurance";
	}
	
	/**
	 * 查询车辆保险情况列表
	 */
	//@RequiresPermissions("web:tCarInsurance:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TCarInsurance tCarInsurance)
	{
		startPage();
        List<TCarInsurance> list = tCarInsuranceService.selectTCarInsuranceList(tCarInsurance);
		return getDataTable(list);
	}
	
	/**
	 * 新增车辆保险情况
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存车辆保险情况
	 */
	//@RequiresPermissions("web:tCarInsurance:add")
	@Log(title = "车辆保险情况", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TCarInsurance tCarInsurance)
	{		
		return tCarInsuranceService.insertTCarInsurance(tCarInsurance);
	}

	/**
	 * 修改车辆保险情况
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TCarInsurance tCarInsurance = tCarInsuranceService.selectTCarInsuranceById(id);
		mmap.put("tCarInsurance", tCarInsurance);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存车辆保险情况
	 */
	//@RequiresPermissions("web:tCarInsurance:edit")
	@Log(title = "车辆保险情况", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TCarInsurance tCarInsurance)
	{		
		return tCarInsuranceService.updateTCarInsurance(tCarInsurance);
	}
	
	/**
	 * 删除车辆保险情况
	 */
	//@RequiresPermissions("web:tCarInsurance:remove")
	@Log(title = "车辆保险情况", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tCarInsuranceService.deleteTCarInsuranceByIds(ids));
	}
	
}
