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
import com.project.web.domian.TCarCarrier;
import com.project.web.service.ITCarCarrierService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 承运人责任险 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tCarCarrier")
public class TCarCarrierController extends BaseController
{
    private String prefix = "web/tCarCarrier";
	
	@Autowired
	private ITCarCarrierService tCarCarrierService;
	
	@RequiresPermissions("web:tCarCarrier:view")
	@GetMapping()
	public String tCarCarrier()
	{
	    return prefix + "/tCarCarrier";
	}
	
	/**
	 * 查询承运人责任险列表
	 */
	@RequiresPermissions("web:tCarCarrier:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TCarCarrier tCarCarrier)
	{
		startPage();
        List<TCarCarrier> list = tCarCarrierService.selectTCarCarrierList(tCarCarrier);
		return getDataTable(list);
	}
	
	/**
	 * 新增承运人责任险
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存承运人责任险
	 */
	@RequiresPermissions("web:tCarCarrier:add")
	@Log(title = "承运人责任险", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TCarCarrier tCarCarrier)
	{		
		return toAjax(tCarCarrierService.insertTCarCarrier(tCarCarrier));
	}

	/**
	 * 修改承运人责任险
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TCarCarrier tCarCarrier = tCarCarrierService.selectTCarCarrierById(id);
		mmap.put("tCarCarrier", tCarCarrier);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存承运人责任险
	 */
	@RequiresPermissions("web:tCarCarrier:edit")
	@Log(title = "承运人责任险", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TCarCarrier tCarCarrier)
	{		
		return toAjax(tCarCarrierService.updateTCarCarrier(tCarCarrier));
	}
	
	/**
	 * 删除承运人责任险
	 */
	@RequiresPermissions("web:tCarCarrier:remove")
	@Log(title = "承运人责任险", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tCarCarrierService.deleteTCarCarrierByIds(ids));
	}
	
}
