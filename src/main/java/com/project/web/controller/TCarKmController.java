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
import com.project.web.domian.TCarKm;
import com.project.web.service.ITCarKmService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 车辆行驶里程登记 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tCarKm")
public class TCarKmController extends BaseController
{
    private String prefix = "web/tCarKm";
	
	@Autowired
	private ITCarKmService tCarKmService;
	
	@RequiresPermissions("web:tCarKm:view")
	@GetMapping()
	public String tCarKm()
	{
	    return prefix + "/tCarKm";
	}
	
	/**
	 * 查询车辆行驶里程登记列表
	 */
	@RequiresPermissions("web:tCarKm:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TCarKm tCarKm)
	{
		startPage();
        List<TCarKm> list = tCarKmService.selectTCarKmList(tCarKm);
		return getDataTable(list);
	}
	
	/**
	 * 新增车辆行驶里程登记
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存车辆行驶里程登记
	 */
	@RequiresPermissions("web:tCarKm:add")
	@Log(title = "车辆行驶里程登记", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TCarKm tCarKm)
	{		
		return toAjax(tCarKmService.insertTCarKm(tCarKm));
	}

	/**
	 * 修改车辆行驶里程登记
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TCarKm tCarKm = tCarKmService.selectTCarKmById(id);
		mmap.put("tCarKm", tCarKm);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存车辆行驶里程登记
	 */
	@RequiresPermissions("web:tCarKm:edit")
	@Log(title = "车辆行驶里程登记", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TCarKm tCarKm)
	{		
		return toAjax(tCarKmService.updateTCarKm(tCarKm));
	}
	
	/**
	 * 删除车辆行驶里程登记
	 */
	@RequiresPermissions("web:tCarKm:remove")
	@Log(title = "车辆行驶里程登记", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tCarKmService.deleteTCarKmByIds(ids));
	}
	
}
