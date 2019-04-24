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
import com.project.web.domian.TDepartureCheck;
import com.project.web.service.ITDepartureCheckService;


/**
 * 出站例检 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Controller
@RequestMapping("/system/tDepartureCheck")
public class TDepartureCheckController extends BaseController
{
    private String prefix = "system/tDepartureCheck";
	
	@Autowired
	private ITDepartureCheckService tDepartureCheckService;
	
	@RequiresPermissions("system:tDepartureCheck:view")
	@GetMapping()
	public String tDepartureCheck()
	{
	    return prefix + "/tDepartureCheck";
	}
	
	/**
	 * 查询出站例检列表
	 */
	@RequiresPermissions("system:tDepartureCheck:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TDepartureCheck tDepartureCheck)
	{
		startPage();
        List<TDepartureCheck> list = tDepartureCheckService.selectTDepartureCheckList(tDepartureCheck);
		return getDataTable(list);
	}
	
	/**
	 * 新增出站例检
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存出站例检
	 */
	@RequiresPermissions("system:tDepartureCheck:add")
	@Log(title = "出站例检", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TDepartureCheck tDepartureCheck)
	{		
		return toAjax(tDepartureCheckService.insertTDepartureCheck(tDepartureCheck));
	}

	/**
	 * 修改出站例检
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		TDepartureCheck tDepartureCheck = tDepartureCheckService.selectTDepartureCheckById(id);
		mmap.put("tDepartureCheck", tDepartureCheck);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存出站例检
	 */
	@RequiresPermissions("system:tDepartureCheck:edit")
	@Log(title = "出站例检", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TDepartureCheck tDepartureCheck)
	{		
		return toAjax(tDepartureCheckService.updateTDepartureCheck(tDepartureCheck));
	}
	
	/**
	 * 删除出站例检
	 */
	@RequiresPermissions("system:tDepartureCheck:remove")
	@Log(title = "出站例检", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tDepartureCheckService.deleteTDepartureCheckByIds(ids));
	}
	
}
