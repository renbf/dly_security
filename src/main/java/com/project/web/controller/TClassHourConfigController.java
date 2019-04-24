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
import com.project.web.domian.TClassHourConfig;
import com.project.web.service.ITClassHourConfigService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 课时配置 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tClassHourConfig")
public class TClassHourConfigController extends BaseController
{
    private String prefix = "web/tClassHourConfig";
	
	@Autowired
	private ITClassHourConfigService tClassHourConfigService;
	
	//@RequiresPermissions("web:tClassHourConfig:view")
	@GetMapping()
	public String tClassHourConfig()
	{
	    return prefix + "/tClassHourConfig";
	}
	
	/**
	 * 查询课时配置列表
	 */
	//@RequiresPermissions("web:tClassHourConfig:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TClassHourConfig tClassHourConfig)
	{
		startPage();
        List<TClassHourConfig> list = tClassHourConfigService.selectTClassHourConfigList(tClassHourConfig);
		return getDataTable(list);
	}
	
	/**
	 * 新增课时配置
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存课时配置
	 */
	//@RequiresPermissions("web:tClassHourConfig:add")
	@Log(title = "课时配置", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TClassHourConfig tClassHourConfig)
	{		
		return toAjax(tClassHourConfigService.insertTClassHourConfig(tClassHourConfig));
	}

	/**
	 * 修改课时配置
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TClassHourConfig tClassHourConfig = tClassHourConfigService.selectTClassHourConfigById(id);
		mmap.put("tClassHourConfig", tClassHourConfig);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存课时配置
	 */
	//@RequiresPermissions("web:tClassHourConfig:edit")
	@Log(title = "课时配置", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TClassHourConfig tClassHourConfig)
	{		
		return toAjax(tClassHourConfigService.updateTClassHourConfig(tClassHourConfig));
	}
	
	/**
	 * 删除课时配置
	 */
	//@RequiresPermissions("web:tClassHourConfig:remove")
	@Log(title = "课时配置", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tClassHourConfigService.deleteTClassHourConfigByIds(ids));
	}
	
}
