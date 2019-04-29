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
import com.project.web.domian.TLegalProvisions;
import com.project.web.service.ITLegalProvisionsService;

/**
 * 法律法规 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Controller
@RequestMapping("/system/tLegalProvisions")
public class TLegalProvisionsController extends BaseController
{
    private String prefix = "system/tLegalProvisions";
	
	@Autowired
	private ITLegalProvisionsService tLegalProvisionsService;
	
	@RequiresPermissions("system:tLegalProvisions:view")
	@GetMapping()
	public String tLegalProvisions()
	{
	    return prefix + "/tLegalProvisions";
	}
	
	/**
	 * 查询法律法规列表
	 */
	@RequiresPermissions("system:tLegalProvisions:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TLegalProvisions tLegalProvisions)
	{
		startPage();
        List<TLegalProvisions> list = tLegalProvisionsService.selectTLegalProvisionsList(tLegalProvisions);
		return getDataTable(list);
	}
	
	/**
	 * 新增法律法规
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存法律法规
	 */
	@RequiresPermissions("system:tLegalProvisions:add")
	@Log(title = "法律法规", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TLegalProvisions tLegalProvisions,@RequestParam(name = "legalFile",required = false) MultipartFile legalFile)
	{		
		return tLegalProvisionsService.insertTLegalProvisions(tLegalProvisions,legalFile);
	}

	/**
	 * 修改法律法规
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TLegalProvisions tLegalProvisions = tLegalProvisionsService.selectTLegalProvisionsById(id);
		mmap.put("tLegalProvisions", tLegalProvisions);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存法律法规
	 */
	@RequiresPermissions("system:tLegalProvisions:edit")
	@Log(title = "法律法规", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TLegalProvisions tLegalProvisions,@RequestParam(name = "legalFile",required = false) MultipartFile legalFile)
	{		
		return tLegalProvisionsService.updateTLegalProvisions(tLegalProvisions,legalFile);
	}
	
	/**
	 * 删除法律法规
	 */
	@RequiresPermissions("system:tLegalProvisions:remove")
	@Log(title = "法律法规", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tLegalProvisionsService.deleteTLegalProvisionsByIds(ids));
	}
	
}
