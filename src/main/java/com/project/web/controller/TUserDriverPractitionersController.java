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
import com.project.web.domian.TUserDriverPractitioners;
import com.project.web.service.ITUserDriverPractitionersService;

/**
 * 驾驶员从业资格证 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Controller
@RequestMapping("/system/tUserDriverPractitioners")
public class TUserDriverPractitionersController extends BaseController
{
    private String prefix = "system/tUserDriverPractitioners";
	
	@Autowired
	private ITUserDriverPractitionersService tUserDriverPractitionersService;
	
	@RequiresPermissions("system:tUserDriverPractitioners:view")
	@GetMapping()
	public String tUserDriverPractitioners()
	{
	    return prefix + "/tUserDriverPractitioners";
	}
	
	/**
	 * 查询驾驶员从业资格证列表
	 */
	@RequiresPermissions("system:tUserDriverPractitioners:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TUserDriverPractitioners tUserDriverPractitioners)
	{
		startPage();
        List<TUserDriverPractitioners> list = tUserDriverPractitionersService.selectTUserDriverPractitionersList(tUserDriverPractitioners);
		return getDataTable(list);
	}
	
	/**
	 * 新增驾驶员从业资格证
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存驾驶员从业资格证
	 */
	@RequiresPermissions("system:tUserDriverPractitioners:add")
	@Log(title = "驾驶员从业资格证", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TUserDriverPractitioners tUserDriverPractitioners)
	{		
		return toAjax(tUserDriverPractitionersService.insertTUserDriverPractitioners(tUserDriverPractitioners));
	}

	/**
	 * 修改驾驶员从业资格证
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TUserDriverPractitioners tUserDriverPractitioners = tUserDriverPractitionersService.selectTUserDriverPractitionersById(id);
		mmap.put("tUserDriverPractitioners", tUserDriverPractitioners);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存驾驶员从业资格证
	 */
	@RequiresPermissions("system:tUserDriverPractitioners:edit")
	@Log(title = "驾驶员从业资格证", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TUserDriverPractitioners tUserDriverPractitioners)
	{		
		return toAjax(tUserDriverPractitionersService.updateTUserDriverPractitioners(tUserDriverPractitioners));
	}
	
	/**
	 * 删除驾驶员从业资格证
	 */
	@RequiresPermissions("system:tUserDriverPractitioners:remove")
	@Log(title = "驾驶员从业资格证", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tUserDriverPractitionersService.deleteTUserDriverPractitionersByIds(ids));
	}
	
}
