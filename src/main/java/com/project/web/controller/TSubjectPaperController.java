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
import com.project.web.domian.TSubjectPaper;
import com.project.web.service.ITSubjectPaperService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 考卷题目关系 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tSubjectPaper")
public class TSubjectPaperController extends BaseController
{
    private String prefix = "web/tSubjectPaper";
	
	@Autowired
	private ITSubjectPaperService tSubjectPaperService;
	
	@RequiresPermissions("web:tSubjectPaper:view")
	@GetMapping()
	public String tSubjectPaper()
	{
	    return prefix + "/tSubjectPaper";
	}
	
	/**
	 * 查询考卷题目关系列表
	 */
	@RequiresPermissions("web:tSubjectPaper:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TSubjectPaper tSubjectPaper)
	{
		startPage();
        List<TSubjectPaper> list = tSubjectPaperService.selectTSubjectPaperList(tSubjectPaper);
		return getDataTable(list);
	}
	
	/**
	 * 新增考卷题目关系
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存考卷题目关系
	 */
	@RequiresPermissions("web:tSubjectPaper:add")
	@Log(title = "考卷题目关系", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TSubjectPaper tSubjectPaper)
	{		
		return toAjax(tSubjectPaperService.insertTSubjectPaper(tSubjectPaper));
	}

	/**
	 * 修改考卷题目关系
	 */
	@GetMapping("/edit/{paperId}")
	public String edit(@PathVariable("paperId") String paperId, ModelMap mmap)
	{
		TSubjectPaper tSubjectPaper = tSubjectPaperService.selectTSubjectPaperById(paperId);
		mmap.put("tSubjectPaper", tSubjectPaper);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存考卷题目关系
	 */
	@RequiresPermissions("web:tSubjectPaper:edit")
	@Log(title = "考卷题目关系", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TSubjectPaper tSubjectPaper)
	{		
		return toAjax(tSubjectPaperService.updateTSubjectPaper(tSubjectPaper));
	}
	
	/**
	 * 删除考卷题目关系
	 */
	@RequiresPermissions("web:tSubjectPaper:remove")
	@Log(title = "考卷题目关系", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tSubjectPaperService.deleteTSubjectPaperByIds(ids));
	}
	
}
