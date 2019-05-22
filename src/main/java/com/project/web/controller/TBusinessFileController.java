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
import com.project.web.domian.TBusinessFile;
import com.project.web.service.ITBusinessFileService;

/**
 * 企业文件 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Controller
@RequestMapping("/system/tBusinessFile")
public class TBusinessFileController extends BaseController
{
    private String prefix = "system/tBusinessFile";
	
	@Autowired
	private ITBusinessFileService tBusinessFileService;
	
	@RequiresPermissions("system:tBusinessFile:view")
	@GetMapping()
	public String tBusinessFile()
	{
	    return prefix + "/tBusinessFile";
	}
	
	/**
	 * 查询企业文件列表
	 */
//	@RequiresPermissions("system:tBusinessFile:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TBusinessFile tBusinessFile)
	{
		startPage();
        List<TBusinessFile> list = tBusinessFileService.selectTBusinessFileList(tBusinessFile);
		return getDataTable(list);
	}
	
	/**
	 * 新增企业文件
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存企业文件
	 */
//	@RequiresPermissions("system:tBusinessFile:add")
	@Log(title = "企业文件", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TBusinessFile tBusinessFile,@RequestParam(name = "businessFile",required = false) MultipartFile businessFile)
	{		
		return toAjax(tBusinessFileService.insertTBusinessFile(tBusinessFile,businessFile));
	}

	/**
	 * 修改企业文件
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TBusinessFile tBusinessFile = tBusinessFileService.selectTBusinessFileById(id);
		mmap.put("tBusinessFile", tBusinessFile);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存企业文件
	 */
//	@RequiresPermissions("system:tBusinessFile:edit")
	@Log(title = "企业文件", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TBusinessFile tBusinessFile,@RequestParam(name = "businessFile",required = false) MultipartFile businessFile)
	{		
		return toAjax(tBusinessFileService.updateTBusinessFile(tBusinessFile,businessFile));
	}
	
	/**
	 * 删除企业文件
	 */
//	@RequiresPermissions("system:tBusinessFile:remove")
	@Log(title = "企业文件", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tBusinessFileService.deleteTBusinessFileByIds(ids));
	}
	
}
