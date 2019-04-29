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
import com.project.web.domian.Dept;
import com.project.web.service.IDeptService;


/**
 * 部门 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/webSys/dept")
public class WebDeptController extends BaseController
{
    private String prefix = "webSys/dept";
	
	@Autowired
	private IDeptService deptService;
	
//	@RequiresPermissions("security:dept:view")
	@GetMapping()
	public String dept()
	{
	    return prefix + "/dept";
	}
	
	/**
	 * 查询部门列表
	 */
//	@RequiresPermissions("security:dept:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Dept dept)
	{
		startPage();
        List<Dept> list = deptService.selectDeptList(dept);
		return getDataTable(list);
	}
	
	/**
	 * 根据企业查询下面部门
	 */
//	@RequiresPermissions("security:dept:list")
	@PostMapping("/listByBusiness")
	@ResponseBody
	public AjaxResult listByBusiness(Dept dept)
	{
		AjaxResult aj= AjaxResult.success();
        List<Dept> list = deptService.selectDeptList(dept);
        aj.put("data", list);
		return aj;
	}
	
	/**
	 * 新增部门
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存部门
	 */
//	@RequiresPermissions("security:dept:add")
	@Log(title = "部门", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Dept dept)
	{		
		return deptService.insertDept(dept);
	}

	/**
	 * 修改部门
	 */
//	@GetMapping("/edit/{deptId}")
	public String edit(@PathVariable("deptId") Long deptId, ModelMap mmap)
	{
		Dept dept = deptService.selectDeptById(deptId);
		mmap.put("dept", dept);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存部门
	 */
//	@RequiresPermissions("security:dept:edit")
	@Log(title = "部门", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Dept dept)
	{		
		return deptService.updateDept(dept);
	}
	
	/**
	 * 删除部门
	 */
//	@RequiresPermissions("security:dept:remove")
	@Log(title = "部门", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return deptService.deleteDeptByIds(ids);
	}
	
}
