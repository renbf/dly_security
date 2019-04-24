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
import com.project.web.domian.TSubjectOption;
import com.project.web.service.ITSubjectOptionService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 题库选项关系 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tSubjectOption")
public class TSubjectOptionController extends BaseController
{
    private String prefix = "web/tSubjectOption";
	
	@Autowired
	private ITSubjectOptionService tSubjectOptionService;
	
	@RequiresPermissions("web:tSubjectOption:view")
	@GetMapping()
	public String tSubjectOption()
	{
	    return prefix + "/tSubjectOption";
	}
	
	/**
	 * 查询题库选项关系列表
	 */
	@RequiresPermissions("web:tSubjectOption:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TSubjectOption tSubjectOption)
	{
		startPage();
        List<TSubjectOption> list = tSubjectOptionService.selectTSubjectOptionList(tSubjectOption);
		return getDataTable(list);
	}
	
	/**
	 * 新增题库选项关系
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存题库选项关系
	 */
	@RequiresPermissions("web:tSubjectOption:add")
	@Log(title = "题库选项关系", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TSubjectOption tSubjectOption)
	{		
		return toAjax(tSubjectOptionService.insertTSubjectOption(tSubjectOption));
	}

	/**
	 * 修改题库选项关系
	 */
	@GetMapping("/edit/{subjectId}")
	public String edit(@PathVariable("subjectId") String subjectId, ModelMap mmap)
	{
		TSubjectOption tSubjectOption = tSubjectOptionService.selectTSubjectOptionById(subjectId);
		mmap.put("tSubjectOption", tSubjectOption);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存题库选项关系
	 */
	@RequiresPermissions("web:tSubjectOption:edit")
	@Log(title = "题库选项关系", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TSubjectOption tSubjectOption)
	{		
		return toAjax(tSubjectOptionService.updateTSubjectOption(tSubjectOption));
	}
	
	/**
	 * 删除题库选项关系
	 */
	@RequiresPermissions("web:tSubjectOption:remove")
	@Log(title = "题库选项关系", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tSubjectOptionService.deleteTSubjectOptionByIds(ids));
	}
	
}
