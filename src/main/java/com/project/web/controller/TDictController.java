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
import com.project.web.domian.TDict;
import com.project.web.service.ITDictService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 字典 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tDict")
public class TDictController extends BaseController
{
    private String prefix = "web/tDict";
	
	@Autowired
	private ITDictService tDictService;
	
	@RequiresPermissions("web:tDict:view")
	@GetMapping()
	public String tDict()
	{
	    return prefix + "/tDict";
	}
	
	/**
	 * 查询字典列表
	 */
	@RequiresPermissions("web:tDict:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TDict tDict)
	{
		startPage();
        List<TDict> list = tDictService.selectTDictList(tDict);
		return getDataTable(list);
	}
	
	/**
	 * 新增字典
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存字典
	 */
	@RequiresPermissions("web:tDict:add")
	@Log(title = "字典", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TDict tDict)
	{		
		return toAjax(tDictService.insertTDict(tDict));
	}

	/**
	 * 修改字典
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TDict tDict = tDictService.selectTDictById(id);
		mmap.put("tDict", tDict);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存字典
	 */
	@RequiresPermissions("web:tDict:edit")
	@Log(title = "字典", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TDict tDict)
	{		
		return toAjax(tDictService.updateTDict(tDict));
	}
	
	/**
	 * 删除字典
	 */
	@RequiresPermissions("web:tDict:remove")
	@Log(title = "字典", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tDictService.deleteTDictByIds(ids));
	}
	
}
