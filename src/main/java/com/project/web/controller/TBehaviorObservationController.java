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
import com.project.web.domian.TBehaviorObservation;
import com.project.web.service.ITBehaviorObservationService;

/**
 * 行为观察 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Controller
@RequestMapping("/system/tBehaviorObservation")
public class TBehaviorObservationController extends BaseController
{
    private String prefix = "system/tBehaviorObservation";
	
	@Autowired
	private ITBehaviorObservationService tBehaviorObservationService;
	
	@RequiresPermissions("system:tBehaviorObservation:view")
	@GetMapping()
	public String tBehaviorObservation()
	{
	    return prefix + "/tBehaviorObservation";
	}
	
	/**
	 * 查询行为观察列表
	 */
//	@RequiresPermissions("system:tBehaviorObservation:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TBehaviorObservation tBehaviorObservation)
	{
		startPage();
        List<TBehaviorObservation> list = tBehaviorObservationService.selectTBehaviorObservationList(tBehaviorObservation);
		return getDataTable(list);
	}
	
	/**
	 * 新增行为观察
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存行为观察
	 */
//	@RequiresPermissions("system:tBehaviorObservation:add")
	@Log(title = "行为观察", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TBehaviorObservation tBehaviorObservation)
	{		
		return toAjax(tBehaviorObservationService.insertTBehaviorObservation(tBehaviorObservation));
	}

	/**
	 * 修改行为观察
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TBehaviorObservation tBehaviorObservation = tBehaviorObservationService.selectTBehaviorObservationById(id);
		mmap.put("tBehaviorObservation", tBehaviorObservation);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存行为观察
	 */
//	@RequiresPermissions("system:tBehaviorObservation:edit")
	@Log(title = "行为观察", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TBehaviorObservation tBehaviorObservation)
	{		
		return toAjax(tBehaviorObservationService.updateTBehaviorObservation(tBehaviorObservation));
	}
	
	/**
	 * 删除行为观察
	 */
	@RequiresPermissions("system:tBehaviorObservation:remove")
	@Log(title = "行为观察", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tBehaviorObservationService.deleteTBehaviorObservationByIds(ids));
	}
	
}
