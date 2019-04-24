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
import com.project.web.domian.TLabourGoods;
import com.project.web.service.ITLabourGoodsService;


/**
 * 劳动防护物品 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Controller
@RequestMapping("/system/tLabourGoods")
public class TLabourGoodsController extends BaseController
{
    private String prefix = "system/tLabourGoods";
	
	@Autowired
	private ITLabourGoodsService tLabourGoodsService;
	
	@RequiresPermissions("system:tLabourGoods:view")
	@GetMapping()
	public String tLabourGoods()
	{
	    return prefix + "/tLabourGoods";
	}
	
	/**
	 * 查询劳动防护物品列表
	 */
	@RequiresPermissions("system:tLabourGoods:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TLabourGoods tLabourGoods)
	{
		startPage();
        List<TLabourGoods> list = tLabourGoodsService.selectTLabourGoodsList(tLabourGoods);
		return getDataTable(list);
	}
	
	/**
	 * 新增劳动防护物品
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存劳动防护物品
	 */
	@RequiresPermissions("system:tLabourGoods:add")
	@Log(title = "劳动防护物品", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TLabourGoods tLabourGoods)
	{		
		return toAjax(tLabourGoodsService.insertTLabourGoods(tLabourGoods));
	}

	/**
	 * 修改劳动防护物品
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		TLabourGoods tLabourGoods = tLabourGoodsService.selectTLabourGoodsById(id);
		mmap.put("tLabourGoods", tLabourGoods);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存劳动防护物品
	 */
	@RequiresPermissions("system:tLabourGoods:edit")
	@Log(title = "劳动防护物品", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TLabourGoods tLabourGoods)
	{		
		return toAjax(tLabourGoodsService.updateTLabourGoods(tLabourGoods));
	}
	
	/**
	 * 删除劳动防护物品
	 */
	@RequiresPermissions("system:tLabourGoods:remove")
	@Log(title = "劳动防护物品", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tLabourGoodsService.deleteTLabourGoodsByIds(ids));
	}
	
}
