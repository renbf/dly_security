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
import com.project.web.domian.TPhysicalExaminationDetail;
import com.project.web.service.ITPhysicalExaminationDetailService;

/**
 * 体检记录明细 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Controller
@RequestMapping("/system/tPhysicalExaminationDetail")
public class TPhysicalExaminationDetailController extends BaseController
{
    private String prefix = "system/tPhysicalExaminationDetail";
	
	@Autowired
	private ITPhysicalExaminationDetailService tPhysicalExaminationDetailService;
	
	@RequiresPermissions("system:tPhysicalExaminationDetail:view")
	@GetMapping()
	public String tPhysicalExaminationDetail()
	{
	    return prefix + "/tPhysicalExaminationDetail";
	}
	
	/**
	 * 查询体检记录明细列表
	 */
//	@RequiresPermissions("system:tPhysicalExaminationDetail:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TPhysicalExaminationDetail tPhysicalExaminationDetail)
	{
		startPage();
        List<TPhysicalExaminationDetail> list = tPhysicalExaminationDetailService.selectTPhysicalExaminationDetailList(tPhysicalExaminationDetail);
		return getDataTable(list);
	}

	/**
	 * 新增体检记录明细
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存体检记录明细
	 */
	@RequiresPermissions("system:tPhysicalExaminationDetail:add")
	@Log(title = "体检记录明细", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TPhysicalExaminationDetail tPhysicalExaminationDetail)
	{		
		return toAjax(tPhysicalExaminationDetailService.insertTPhysicalExaminationDetail(tPhysicalExaminationDetail));
	}

	/**
	 * 修改体检记录明细
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TPhysicalExaminationDetail tPhysicalExaminationDetail = tPhysicalExaminationDetailService.selectTPhysicalExaminationDetailById(id);
		mmap.put("tPhysicalExaminationDetail", tPhysicalExaminationDetail);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存体检记录明细
	 */
	@RequiresPermissions("system:tPhysicalExaminationDetail:edit")
	@Log(title = "体检记录明细", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TPhysicalExaminationDetail tPhysicalExaminationDetail)
	{		
		return toAjax(tPhysicalExaminationDetailService.updateTPhysicalExaminationDetail(tPhysicalExaminationDetail));
	}
	
	/**
	 * 删除体检记录明细
	 */
	@RequiresPermissions("system:tPhysicalExaminationDetail:remove")
	@Log(title = "体检记录明细", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tPhysicalExaminationDetailService.deleteTPhysicalExaminationDetailByIds(ids));
	}
	
}
