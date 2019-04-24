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
import com.project.web.domian.TUserDriverBasic;
import com.project.web.service.ITUserDriverBasicService;

/**
 * 驾驶员台账基础 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Controller
@RequestMapping("/system/tUserDriverBasic")
public class TUserDriverBasicController extends BaseController
{
    private String prefix = "system/tUserDriverBasic";
	
	@Autowired
	private ITUserDriverBasicService tUserDriverBasicService;
	
	@RequiresPermissions("system:tUserDriverBasic:view")
	@GetMapping()
	public String tUserDriverBasic()
	{
	    return prefix + "/tUserDriverBasic";
	}
	
	/**
	 * 查询驾驶员台账基础列表
	 */
	@RequiresPermissions("system:tUserDriverBasic:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TUserDriverBasic tUserDriverBasic)
	{
		startPage();
        List<TUserDriverBasic> list = tUserDriverBasicService.selectTUserDriverBasicList(tUserDriverBasic);
		return getDataTable(list);
	}
	
	/**
	 * 新增驾驶员台账基础
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存驾驶员台账基础
	 */
	@RequiresPermissions("system:tUserDriverBasic:add")
	@Log(title = "驾驶员台账基础", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TUserDriverBasic tUserDriverBasic)
	{		
		return toAjax(tUserDriverBasicService.insertTUserDriverBasic(tUserDriverBasic));
	}

	/**
	 * 修改驾驶员台账基础
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TUserDriverBasic tUserDriverBasic = tUserDriverBasicService.selectTUserDriverBasicById(id);
		mmap.put("tUserDriverBasic", tUserDriverBasic);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存驾驶员台账基础
	 */
	@RequiresPermissions("system:tUserDriverBasic:edit")
	@Log(title = "驾驶员台账基础", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TUserDriverBasic tUserDriverBasic)
	{		
		return toAjax(tUserDriverBasicService.updateTUserDriverBasic(tUserDriverBasic));
	}
	
	/**
	 * 删除驾驶员台账基础
	 */
	@RequiresPermissions("system:tUserDriverBasic:remove")
	@Log(title = "驾驶员台账基础", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tUserDriverBasicService.deleteTUserDriverBasicByIds(ids));
	}
	
}
