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
import com.project.web.domian.TUserSubject;
import com.project.web.service.ITUserSubjectService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 用户答题记录 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tUserSubject")
public class TUserSubjectController extends BaseController
{
    private String prefix = "web/tUserSubject";
	
	@Autowired
	private ITUserSubjectService tUserSubjectService;
	
	@RequiresPermissions("web:tUserSubject:view")
	@GetMapping()
	public String tUserSubject()
	{
	    return prefix + "/tUserSubject";
	}
	
	/**
	 * 查询用户答题记录列表
	 */
	@RequiresPermissions("web:tUserSubject:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TUserSubject tUserSubject)
	{
		startPage();
        List<TUserSubject> list = tUserSubjectService.selectTUserSubjectList(tUserSubject);
		return getDataTable(list);
	}
	
	/**
	 * 新增用户答题记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户答题记录
	 */
	@RequiresPermissions("web:tUserSubject:add")
	@Log(title = "用户答题记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TUserSubject tUserSubject)
	{		
		return toAjax(tUserSubjectService.insertTUserSubject(tUserSubject));
	}

	/**
	 * 修改用户答题记录
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TUserSubject tUserSubject = tUserSubjectService.selectTUserSubjectById(id);
		mmap.put("tUserSubject", tUserSubject);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户答题记录
	 */
	@RequiresPermissions("web:tUserSubject:edit")
	@Log(title = "用户答题记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TUserSubject tUserSubject)
	{		
		return toAjax(tUserSubjectService.updateTUserSubject(tUserSubject));
	}
	
	/**
	 * 删除用户答题记录
	 */
	@RequiresPermissions("web:tUserSubject:remove")
	@Log(title = "用户答题记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tUserSubjectService.deleteTUserSubjectByIds(ids));
	}
	
}
