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
import com.project.web.domian.TPaper;
import com.project.web.service.ITPaperService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 考卷 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tPaper")
public class TPaperController extends BaseController
{
    private String prefix = "web/tPaper";
	
	@Autowired
	private ITPaperService tPaperService;
	
	@RequiresPermissions("web:tPaper:view")
	@GetMapping()
	public String tPaper()
	{
	    return prefix + "/tPaper";
	}
	
	/**
	 * 查询考卷列表
	 */
	@RequiresPermissions("web:tPaper:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TPaper tPaper)
	{
		startPage();
        List<TPaper> list = tPaperService.selectTPaperList(tPaper);
		return getDataTable(list);
	}
	
	/**
	 * 新增考卷
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存考卷
	 */
	@RequiresPermissions("web:tPaper:add")
	@Log(title = "考卷", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TPaper tPaper)
	{		
		return toAjax(tPaperService.insertTPaper(tPaper));
	}

	/**
	 * 修改考卷
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TPaper tPaper = tPaperService.selectTPaperById(id);
		mmap.put("tPaper", tPaper);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存考卷
	 */
	@RequiresPermissions("web:tPaper:edit")
	@Log(title = "考卷", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TPaper tPaper)
	{		
		return toAjax(tPaperService.updateTPaper(tPaper));
	}
	
	/**
	 * 删除考卷
	 */
	@RequiresPermissions("web:tPaper:remove")
	@Log(title = "考卷", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tPaperService.deleteTPaperByIds(ids));
	}
	
}
