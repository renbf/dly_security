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
import com.project.web.domian.TPhysicalExamination;
import com.project.web.service.ITPhysicalExaminationService;


/**
 * 体检记录 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Controller
@RequestMapping("/system/tPhysicalExamination")
public class TPhysicalExaminationController extends BaseController
{
    private String prefix = "system/tPhysicalExamination";
	
	@Autowired
	private ITPhysicalExaminationService tPhysicalExaminationService;
	
	@RequiresPermissions("system:tPhysicalExamination:view")
	@GetMapping()
	public String tPhysicalExamination()
	{
	    return prefix + "/tPhysicalExamination";
	}
	
	/**
	 * 查询体检记录列表
	 */
//	@RequiresPermissions("system:tPhysicalExamination:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TPhysicalExamination tPhysicalExamination)
	{
		startPage();
        List<TPhysicalExamination> list = tPhysicalExaminationService.selectTPhysicalExaminationList(tPhysicalExamination);
		return getDataTable(list);
	}
	
	/**
	 * 新增体检记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存体检记录
	 */
//	@RequiresPermissions("system:tPhysicalExamination:add")
	@Log(title = "体检记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TPhysicalExamination tPhysicalExamination,@RequestParam(name = "physicalFile",required = false) MultipartFile physicalFile)
	{		
		return tPhysicalExaminationService.insertTPhysicalExamination(tPhysicalExamination,physicalFile);
	}

	/**
	 * 修改体检记录
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		TPhysicalExamination tPhysicalExamination = tPhysicalExaminationService.selectTPhysicalExaminationById(id);
		mmap.put("tPhysicalExamination", tPhysicalExamination);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存体检记录
	 */
//	@RequiresPermissions("system:tPhysicalExamination:edit")
	@Log(title = "体检记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TPhysicalExamination tPhysicalExamination,@RequestParam(name = "physicalFile",required = false) MultipartFile physicalFile)
	{		
		return tPhysicalExaminationService.updateTPhysicalExamination(tPhysicalExamination,physicalFile);
	}
	
	/**
	 * 删除体检记录
	 */
//	@RequiresPermissions("system:tPhysicalExamination:remove")
	@Log(title = "体检记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tPhysicalExaminationService.deleteTPhysicalExaminationByIds(ids));
	}
	
}
