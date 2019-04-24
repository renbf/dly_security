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
import com.project.web.domian.TUserDriverOthers;
import com.project.web.service.ITUserDriverOthersService;

/**
 * 驾驶员其他 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Controller
@RequestMapping("/system/tUserDriverOthers")
public class TUserDriverOthersController extends BaseController
{
    private String prefix = "system/tUserDriverOthers";
	
	@Autowired
	private ITUserDriverOthersService tUserDriverOthersService;
	
	@RequiresPermissions("system:tUserDriverOthers:view")
	@GetMapping()
	public String tUserDriverOthers()
	{
	    return prefix + "/tUserDriverOthers";
	}
	
	/**
	 * 查询驾驶员其他列表
	 */
	@RequiresPermissions("system:tUserDriverOthers:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TUserDriverOthers tUserDriverOthers)
	{
		startPage();
        List<TUserDriverOthers> list = tUserDriverOthersService.selectTUserDriverOthersList(tUserDriverOthers);
		return getDataTable(list);
	}
	
	/**
	 * 新增驾驶员其他
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存驾驶员其他
	 */
	@RequiresPermissions("system:tUserDriverOthers:add")
	@Log(title = "驾驶员其他", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TUserDriverOthers tUserDriverOthers)
	{		
		return toAjax(tUserDriverOthersService.insertTUserDriverOthers(tUserDriverOthers));
	}

	/**
	 * 修改驾驶员其他
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TUserDriverOthers tUserDriverOthers = tUserDriverOthersService.selectTUserDriverOthersById(id);
		mmap.put("tUserDriverOthers", tUserDriverOthers);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存驾驶员其他
	 */
	@RequiresPermissions("system:tUserDriverOthers:edit")
	@Log(title = "驾驶员其他", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TUserDriverOthers tUserDriverOthers)
	{		
		return toAjax(tUserDriverOthersService.updateTUserDriverOthers(tUserDriverOthers));
	}
	
	/**
	 * 删除驾驶员其他
	 */
	@RequiresPermissions("system:tUserDriverOthers:remove")
	@Log(title = "驾驶员其他", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tUserDriverOthersService.deleteTUserDriverOthersByIds(ids));
	}
	
}
