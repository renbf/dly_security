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
import com.project.web.domian.TUserDriverInfo;
import com.project.web.service.ITUserDriverInfoService;

/**
 * 驾驶员驾驶 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Controller
@RequestMapping("/system/tUserDriverInfo")
public class TUserDriverInfoController extends BaseController
{
    private String prefix = "system/tUserDriverInfo";
	
	@Autowired
	private ITUserDriverInfoService tUserDriverInfoService;
	
	@RequiresPermissions("system:tUserDriverInfo:view")
	@GetMapping()
	public String tUserDriverInfo()
	{
	    return prefix + "/tUserDriverInfo";
	}
	
	/**
	 * 查询驾驶员驾驶列表
	 */
	@RequiresPermissions("system:tUserDriverInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TUserDriverInfo tUserDriverInfo)
	{
		startPage();
        List<TUserDriverInfo> list = tUserDriverInfoService.selectTUserDriverInfoList(tUserDriverInfo);
		return getDataTable(list);
	}
	
	/**
	 * 新增驾驶员驾驶
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存驾驶员驾驶
	 */
	@RequiresPermissions("system:tUserDriverInfo:add")
	@Log(title = "驾驶员驾驶", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TUserDriverInfo tUserDriverInfo)
	{		
		return toAjax(tUserDriverInfoService.insertTUserDriverInfo(tUserDriverInfo));
	}

	/**
	 * 修改驾驶员驾驶
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TUserDriverInfo tUserDriverInfo = tUserDriverInfoService.selectTUserDriverInfoById(id);
		mmap.put("tUserDriverInfo", tUserDriverInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存驾驶员驾驶
	 */
	@RequiresPermissions("system:tUserDriverInfo:edit")
	@Log(title = "驾驶员驾驶", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TUserDriverInfo tUserDriverInfo)
	{		
		return toAjax(tUserDriverInfoService.updateTUserDriverInfo(tUserDriverInfo));
	}
	
	/**
	 * 删除驾驶员驾驶
	 */
	@RequiresPermissions("system:tUserDriverInfo:remove")
	@Log(title = "驾驶员驾驶", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tUserDriverInfoService.deleteTUserDriverInfoByIds(ids));
	}
	
}
