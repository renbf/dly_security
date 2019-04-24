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
import com.project.web.domian.TGoodsNameType;
import com.project.web.service.ITGoodsNameTypeService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 货物名称类项关系 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tGoodsNameType")
public class TGoodsNameTypeController extends BaseController
{
    private String prefix = "web/tGoodsNameType";
	
	@Autowired
	private ITGoodsNameTypeService tGoodsNameTypeService;
	
	@RequiresPermissions("web:tGoodsNameType:view")
	@GetMapping()
	public String tGoodsNameType()
	{
	    return prefix + "/tGoodsNameType";
	}
	
	/**
	 * 查询货物名称类项关系列表
	 */
	@RequiresPermissions("web:tGoodsNameType:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TGoodsNameType tGoodsNameType)
	{
		startPage();
        List<TGoodsNameType> list = tGoodsNameTypeService.selectTGoodsNameTypeList(tGoodsNameType);
		return getDataTable(list);
	}
	
	/**
	 * 新增货物名称类项关系
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存货物名称类项关系
	 */
	@RequiresPermissions("web:tGoodsNameType:add")
	@Log(title = "货物名称类项关系", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TGoodsNameType tGoodsNameType)
	{		
		return toAjax(tGoodsNameTypeService.insertTGoodsNameType(tGoodsNameType));
	}

	/**
	 * 修改货物名称类项关系
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TGoodsNameType tGoodsNameType = tGoodsNameTypeService.selectTGoodsNameTypeById(id);
		mmap.put("tGoodsNameType", tGoodsNameType);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存货物名称类项关系
	 */
	@RequiresPermissions("web:tGoodsNameType:edit")
	@Log(title = "货物名称类项关系", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TGoodsNameType tGoodsNameType)
	{		
		return toAjax(tGoodsNameTypeService.updateTGoodsNameType(tGoodsNameType));
	}
	
	/**
	 * 删除货物名称类项关系
	 */
	@RequiresPermissions("web:tGoodsNameType:remove")
	@Log(title = "货物名称类项关系", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tGoodsNameTypeService.deleteTGoodsNameTypeByIds(ids));
	}
	
}
