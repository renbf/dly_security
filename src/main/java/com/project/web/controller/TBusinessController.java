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
import com.project.web.domian.TBusiness;
import com.project.web.service.ITBusinessService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 企业管理 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tBusiness")
public class TBusinessController extends BaseController
{
    private String prefix = "web/tBusiness";
	
	@Autowired
	private ITBusinessService tBusinessService;
	
	@RequiresPermissions("web:tBusiness:view")
	@GetMapping()
	public String tBusiness()
	{
	    return prefix + "/tBusiness";
	}
	
	/**
	 * 查询企业管理列表
	 */
	@RequiresPermissions("web:tBusiness:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TBusiness tBusiness)
	{
		startPage();
        List<TBusiness> list = tBusinessService.selectTBusinessList(tBusiness);
		return getDataTable(list);
	}
	
	/**
	 * 新增企业管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存企业管理
	 */
	@RequiresPermissions("web:tBusiness:add")
	@Log(title = "企业管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TBusiness tBusiness)
	{		
		return toAjax(tBusinessService.insertTBusiness(tBusiness));
	}

	/**
	 * 修改企业管理
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TBusiness tBusiness = tBusinessService.selectTBusinessById(id);
		mmap.put("tBusiness", tBusiness);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存企业管理
	 */
	@RequiresPermissions("web:tBusiness:edit")
	@Log(title = "企业管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TBusiness tBusiness)
	{		
		return toAjax(tBusinessService.updateTBusiness(tBusiness));
	}
	
	/**
	 * 删除企业管理
	 */
	@RequiresPermissions("web:tBusiness:remove")
	@Log(title = "企业管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tBusinessService.deleteTBusinessByIds(ids));
	}
	
}
