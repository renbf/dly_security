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
import com.project.web.domian.TUserSubjectCollect;
import com.project.web.service.ITUserSubjectCollectService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 用户收藏记录 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tUserSubjectCollect")
public class TUserSubjectCollectController extends BaseController
{
    private String prefix = "web/tUserSubjectCollect";
	
	@Autowired
	private ITUserSubjectCollectService tUserSubjectCollectService;
	
	@RequiresPermissions("web:tUserSubjectCollect:view")
	@GetMapping()
	public String tUserSubjectCollect()
	{
	    return prefix + "/tUserSubjectCollect";
	}
	
	/**
	 * 查询用户收藏记录列表
	 */
	@RequiresPermissions("web:tUserSubjectCollect:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TUserSubjectCollect tUserSubjectCollect)
	{
		startPage();
        List<TUserSubjectCollect> list = tUserSubjectCollectService.selectTUserSubjectCollectList(tUserSubjectCollect);
		return getDataTable(list);
	}
	
	/**
	 * 新增用户收藏记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户收藏记录
	 */
	@RequiresPermissions("web:tUserSubjectCollect:add")
	@Log(title = "用户收藏记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TUserSubjectCollect tUserSubjectCollect)
	{		
		return toAjax(tUserSubjectCollectService.insertTUserSubjectCollect(tUserSubjectCollect));
	}

	/**
	 * 修改用户收藏记录
	 */
	@GetMapping("/edit/{userId}")
	public String edit(@PathVariable("userId") String userId, ModelMap mmap)
	{
		TUserSubjectCollect tUserSubjectCollect = tUserSubjectCollectService.selectTUserSubjectCollectById(userId);
		mmap.put("tUserSubjectCollect", tUserSubjectCollect);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户收藏记录
	 */
	@RequiresPermissions("web:tUserSubjectCollect:edit")
	@Log(title = "用户收藏记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TUserSubjectCollect tUserSubjectCollect)
	{		
		return toAjax(tUserSubjectCollectService.updateTUserSubjectCollect(tUserSubjectCollect));
	}
	
	/**
	 * 删除用户收藏记录
	 */
	@RequiresPermissions("web:tUserSubjectCollect:remove")
	@Log(title = "用户收藏记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tUserSubjectCollectService.deleteTUserSubjectCollectByIds(ids));
	}
	
}
