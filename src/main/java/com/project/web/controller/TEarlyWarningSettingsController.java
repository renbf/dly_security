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
import com.project.web.domian.TEarlyWarningSettings;
import com.project.web.service.ITEarlyWarningSettingsService;

/**
 * 预警设置 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/system/tEarlyWarningSettings")
public class TEarlyWarningSettingsController extends BaseController
{
    private String prefix = "system/tEarlyWarningSettings";
	
	@Autowired
	private ITEarlyWarningSettingsService tEarlyWarningSettingsService;
	
	@RequiresPermissions("system:tEarlyWarningSettings:view")
	@GetMapping()
	public String tEarlyWarningSettings()
	{
	    return prefix + "/tEarlyWarningSettings";
	}
	
	/**
	 * 查询预警设置列表
	 */
	@RequiresPermissions("system:tEarlyWarningSettings:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TEarlyWarningSettings tEarlyWarningSettings)
	{
		startPage();
        List<TEarlyWarningSettings> list = tEarlyWarningSettingsService.selectTEarlyWarningSettingsList(tEarlyWarningSettings);
		return getDataTable(list);
	}
	
	/**
	 * 新增预警设置
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存预警设置
	 */
	@RequiresPermissions("system:tEarlyWarningSettings:add")
	@Log(title = "预警设置", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TEarlyWarningSettings tEarlyWarningSettings)
	{		
		return toAjax(tEarlyWarningSettingsService.insertTEarlyWarningSettings(tEarlyWarningSettings));
	}

	/**
	 * 修改预警设置
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TEarlyWarningSettings tEarlyWarningSettings = tEarlyWarningSettingsService.selectTEarlyWarningSettingsById(id);
		mmap.put("tEarlyWarningSettings", tEarlyWarningSettings);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存预警设置
	 */
	@RequiresPermissions("system:tEarlyWarningSettings:edit")
	@Log(title = "预警设置", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TEarlyWarningSettings tEarlyWarningSettings)
	{		
		return toAjax(tEarlyWarningSettingsService.updateTEarlyWarningSettings(tEarlyWarningSettings));
	}
	
	/**
	 * 删除预警设置
	 */
	@RequiresPermissions("system:tEarlyWarningSettings:remove")
	@Log(title = "预警设置", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tEarlyWarningSettingsService.deleteTEarlyWarningSettingsByIds(ids));
	}
	
}
