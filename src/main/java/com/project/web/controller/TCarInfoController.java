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
import com.project.web.domian.TCarInfo;
import com.project.web.service.ITCarInfoService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 车辆 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tCarInfo")
public class TCarInfoController extends BaseController
{
    private String prefix = "web/tCarInfo";
	
	@Autowired
	private ITCarInfoService tCarInfoService;
	
	@RequiresPermissions("web:tCarInfo:view")
	@GetMapping()
	public String tCarInfo()
	{
	    return prefix + "/tCarInfo";
	}
	
	/**
	 * 查询车辆列表
	 */
	@RequiresPermissions("web:tCarInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TCarInfo tCarInfo)
	{
		startPage();
        List<TCarInfo> list = tCarInfoService.selectTCarInfoList(tCarInfo);
		return getDataTable(list);
	}
	
	/**
	 * 新增车辆
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存车辆
	 */
	@RequiresPermissions("web:tCarInfo:add")
	@Log(title = "车辆", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TCarInfo tCarInfo)
	{		
		return toAjax(tCarInfoService.insertTCarInfo(tCarInfo));
	}

	/**
	 * 修改车辆
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TCarInfo tCarInfo = tCarInfoService.selectTCarInfoById(id);
		mmap.put("tCarInfo", tCarInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存车辆
	 */
	@RequiresPermissions("web:tCarInfo:edit")
	@Log(title = "车辆", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TCarInfo tCarInfo)
	{		
		return toAjax(tCarInfoService.updateTCarInfo(tCarInfo));
	}
	
	/**
	 * 删除车辆
	 */
	@RequiresPermissions("web:tCarInfo:remove")
	@Log(title = "车辆", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tCarInfoService.deleteTCarInfoByIds(ids));
	}
	
}
