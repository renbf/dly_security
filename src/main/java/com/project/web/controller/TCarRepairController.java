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
import com.project.web.domian.TCarRepair;
import com.project.web.service.ITCarRepairService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 车辆维护和修理登记 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tCarRepair")
public class TCarRepairController extends BaseController
{
    private String prefix = "web/tCarRepair";
	
	@Autowired
	private ITCarRepairService tCarRepairService;
	
	@RequiresPermissions("web:tCarRepair:view")
	@GetMapping()
	public String tCarRepair()
	{
	    return prefix + "/tCarRepair";
	}
	
	/**
	 * 查询车辆维护和修理登记列表
	 */
	@RequiresPermissions("web:tCarRepair:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TCarRepair tCarRepair)
	{
		startPage();
        List<TCarRepair> list = tCarRepairService.selectTCarRepairList(tCarRepair);
		return getDataTable(list);
	}
	
	/**
	 * 新增车辆维护和修理登记
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存车辆维护和修理登记
	 */
	@RequiresPermissions("web:tCarRepair:add")
	@Log(title = "车辆维护和修理登记", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TCarRepair tCarRepair)
	{		
		return toAjax(tCarRepairService.insertTCarRepair(tCarRepair));
	}

	/**
	 * 修改车辆维护和修理登记
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TCarRepair tCarRepair = tCarRepairService.selectTCarRepairById(id);
		mmap.put("tCarRepair", tCarRepair);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存车辆维护和修理登记
	 */
	@RequiresPermissions("web:tCarRepair:edit")
	@Log(title = "车辆维护和修理登记", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TCarRepair tCarRepair)
	{		
		return toAjax(tCarRepairService.updateTCarRepair(tCarRepair));
	}
	
	/**
	 * 删除车辆维护和修理登记
	 */
	@RequiresPermissions("web:tCarRepair:remove")
	@Log(title = "车辆维护和修理登记", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tCarRepairService.deleteTCarRepairByIds(ids));
	}
	
}
