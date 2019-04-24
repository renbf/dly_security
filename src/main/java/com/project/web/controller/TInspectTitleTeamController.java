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
import com.project.web.domian.TInspectTitleTeam;
import com.project.web.service.ITInspectTitleTeamService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 标题和检查项目关系 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tInspectTitleTeam")
public class TInspectTitleTeamController extends BaseController
{
    private String prefix = "web/tInspectTitleTeam";
	
	@Autowired
	private ITInspectTitleTeamService tInspectTitleTeamService;
	
	@RequiresPermissions("web:tInspectTitleTeam:view")
	@GetMapping()
	public String tInspectTitleTeam()
	{
	    return prefix + "/tInspectTitleTeam";
	}
	
	/**
	 * 查询标题和检查项目关系列表
	 */
	@RequiresPermissions("web:tInspectTitleTeam:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TInspectTitleTeam tInspectTitleTeam)
	{
		startPage();
        List<TInspectTitleTeam> list = tInspectTitleTeamService.selectTInspectTitleTeamList(tInspectTitleTeam);
		return getDataTable(list);
	}
	
	/**
	 * 新增标题和检查项目关系
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存标题和检查项目关系
	 */
	@RequiresPermissions("web:tInspectTitleTeam:add")
	@Log(title = "标题和检查项目关系", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TInspectTitleTeam tInspectTitleTeam)
	{		
		return toAjax(tInspectTitleTeamService.insertTInspectTitleTeam(tInspectTitleTeam));
	}

	/**
	 * 修改标题和检查项目关系
	 */
	@GetMapping("/edit/{titleId}")
	public String edit(@PathVariable("titleId") String titleId, ModelMap mmap)
	{
		TInspectTitleTeam tInspectTitleTeam = tInspectTitleTeamService.selectTInspectTitleTeamById(titleId);
		mmap.put("tInspectTitleTeam", tInspectTitleTeam);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存标题和检查项目关系
	 */
	@RequiresPermissions("web:tInspectTitleTeam:edit")
	@Log(title = "标题和检查项目关系", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TInspectTitleTeam tInspectTitleTeam)
	{		
		return toAjax(tInspectTitleTeamService.updateTInspectTitleTeam(tInspectTitleTeam));
	}
	
	/**
	 * 删除标题和检查项目关系
	 */
	@RequiresPermissions("web:tInspectTitleTeam:remove")
	@Log(title = "标题和检查项目关系", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tInspectTitleTeamService.deleteTInspectTitleTeamByIds(ids));
	}
	
}
