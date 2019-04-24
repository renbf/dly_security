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
import com.project.web.domian.TCourse;
import com.project.web.service.ITCourseService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 课程 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tCourse")
public class TCourseController extends BaseController
{
    private String prefix = "web/tCourse";
	
	@Autowired
	private ITCourseService tCourseService;
	
	@RequiresPermissions("web:tCourse:view")
	@GetMapping()
	public String tCourse()
	{
	    return prefix + "/tCourse";
	}
	
	/**
	 * 查询课程列表
	 */
	@RequiresPermissions("web:tCourse:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TCourse tCourse)
	{
		startPage();
        List<TCourse> list = tCourseService.selectTCourseList(tCourse);
		return getDataTable(list);
	}
	
	/**
	 * 新增课程
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存课程
	 */
	@RequiresPermissions("web:tCourse:add")
	@Log(title = "课程", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TCourse tCourse)
	{		
		return toAjax(tCourseService.insertTCourse(tCourse));
	}

	/**
	 * 修改课程
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TCourse tCourse = tCourseService.selectTCourseById(id);
		mmap.put("tCourse", tCourse);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存课程
	 */
	@RequiresPermissions("web:tCourse:edit")
	@Log(title = "课程", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TCourse tCourse)
	{		
		return toAjax(tCourseService.updateTCourse(tCourse));
	}
	
	/**
	 * 删除课程
	 */
	@RequiresPermissions("web:tCourse:remove")
	@Log(title = "课程", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tCourseService.deleteTCourseByIds(ids));
	}
	
}
