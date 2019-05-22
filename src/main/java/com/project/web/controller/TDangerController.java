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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project.common.annotation.Log;
import com.project.common.enums.BusinessType;
import com.project.web.domian.TDanger;
import com.project.web.service.ITDangerService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 隐患 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tDanger")
public class TDangerController extends BaseController
{
    private String prefix = "web/tDanger";
	
	@Autowired
	private ITDangerService tDangerService;
	
	@RequiresPermissions("web:tDanger:view")
	@GetMapping()
	public String tDanger()
	{
	    return prefix + "/tDanger";
	}
	
	/**
	 * 查询隐患列表
	 */
//	@RequiresPermissions("web:tDanger:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TDanger tDanger)
	{
		startPage();
        List<TDanger> list = tDangerService.selectTDangerList(tDanger);
		return getDataTable(list);
	}
	
	/**
	 * 根据隐患整改人查询隐患列表
	 */
//	@RequiresPermissions("web:tDanger:list")
	@PostMapping("/listByUser")
	@ResponseBody
	public TableDataInfo listByUser(TDanger tDanger)
	{
		startPage();
        List<TDanger> list = tDangerService.selectTDangerListByUser(tDanger);
		return getDataTable(list);
	}
	
	/**
	 * 新增隐患
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存隐患
	 */
//	@RequiresPermissions("web:tDanger:add")
	@Log(title = "隐患", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TDanger tDanger)
	{		
		return toAjax(tDangerService.insertTDanger(tDanger));
	}

	/**
	 * 修改隐患
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TDanger tDanger = tDangerService.selectTDangerById(id);
		mmap.put("tDanger", tDanger);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存隐患
	 */
//	@RequiresPermissions("web:tDanger:edit")
	@Log(title = "隐患", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TDanger tDanger,@RequestParam(name = "dochangePicture",required = false) MultipartFile dochangePicture)
	{		
		return toAjax(tDangerService.updateTDanger(tDanger,dochangePicture));
	}
	
	/**
	 * 删除隐患
	 */
//	@RequiresPermissions("web:tDanger:remove")
	@Log(title = "隐患", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tDangerService.deleteTDangerByIds(ids));
	}
	
}
