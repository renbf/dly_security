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
import com.project.web.domian.TSubject;
import com.project.web.service.ITSubjectService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 题库 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tSubject")
public class TSubjectController extends BaseController
{
    private String prefix = "web/tSubject";
	
	@Autowired
	private ITSubjectService tSubjectService;
	
	@RequiresPermissions("web:tSubject:view")
	@GetMapping()
	public String tSubject()
	{
	    return prefix + "/tSubject";
	}
	
	/**
	 * 查询题库列表  选项为一条拼接字段
	 */
//	@RequiresPermissions("web:tSubject:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TSubject tSubject)
	{
		startPage();
        List<TSubject> list = tSubjectService.selectTSubjectListByOneData(tSubject);
		return getDataTable(list);
	}
	
	/**
	 * 根据ID查询 具体某一条数据
	 */
//	@RequiresPermissions("web:tSubject:list")
	@PostMapping("/listById")
	@ResponseBody
	public AjaxResult listById(TSubject tSubject)
	{	AjaxResult aj =AjaxResult.success();
		String id= tSubject.getId();
		aj.put("data", tSubjectService.selectTSubjectById(id));
		return aj;
	}
	
	
	/**
	 * 新增题库
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存题库
	 */
//	@RequiresPermissions("web:tSubject:add")
	@Log(title = "题库", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TSubject tSubject)
	{		
		return tSubjectService.insertTSubject(tSubject);
	}

	/**
	 * 修改题库
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TSubject tSubject = tSubjectService.selectTSubjectById(id);
		mmap.put("tSubject", tSubject);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存题库
	 */
//	@RequiresPermissions("web:tSubject:edit")
	@Log(title = "题库", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TSubject tSubject)
	{		
		return tSubjectService.updateTSubject(tSubject);
	}
	
	/**
	 * 删除题库
	 */
//	@RequiresPermissions("web:tSubject:remove")
	@Log(title = "题库", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tSubjectService.deleteTSubjectByIds(ids));
	}
	
}
