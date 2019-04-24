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
import com.project.web.domian.TCarSatellitePosition;
import com.project.web.service.ITCarSatellitePositionService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 卫星定位 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tCarSatellitePosition")
public class TCarSatellitePositionController extends BaseController
{
    private String prefix = "web/tCarSatellitePosition";
	
	@Autowired
	private ITCarSatellitePositionService tCarSatellitePositionService;
	
	@RequiresPermissions("web:tCarSatellitePosition:view")
	@GetMapping()
	public String tCarSatellitePosition()
	{
	    return prefix + "/tCarSatellitePosition";
	}
	
	/**
	 * 查询卫星定位列表
	 */
	@RequiresPermissions("web:tCarSatellitePosition:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TCarSatellitePosition tCarSatellitePosition)
	{
		startPage();
        List<TCarSatellitePosition> list = tCarSatellitePositionService.selectTCarSatellitePositionList(tCarSatellitePosition);
		return getDataTable(list);
	}
	
	/**
	 * 新增卫星定位
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存卫星定位
	 */
	@RequiresPermissions("web:tCarSatellitePosition:add")
	@Log(title = "卫星定位", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TCarSatellitePosition tCarSatellitePosition)
	{		
		return toAjax(tCarSatellitePositionService.insertTCarSatellitePosition(tCarSatellitePosition));
	}

	/**
	 * 修改卫星定位
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TCarSatellitePosition tCarSatellitePosition = tCarSatellitePositionService.selectTCarSatellitePositionById(id);
		mmap.put("tCarSatellitePosition", tCarSatellitePosition);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存卫星定位
	 */
	@RequiresPermissions("web:tCarSatellitePosition:edit")
	@Log(title = "卫星定位", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TCarSatellitePosition tCarSatellitePosition)
	{		
		return toAjax(tCarSatellitePositionService.updateTCarSatellitePosition(tCarSatellitePosition));
	}
	
	/**
	 * 删除卫星定位
	 */
	@RequiresPermissions("web:tCarSatellitePosition:remove")
	@Log(title = "卫星定位", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tCarSatellitePositionService.deleteTCarSatellitePositionByIds(ids));
	}
	
}
