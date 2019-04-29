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
import com.project.web.domian.TLabourGoodsDetail;
import com.project.web.service.ITLabourGoodsDetailService;

/**
 * 劳动防护物品明细 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/security/tLabourGoodsDetail")
public class TLabourGoodsDetailController extends BaseController
{
    private String prefix = "security/tLabourGoodsDetail";
	
	@Autowired
	private ITLabourGoodsDetailService tLabourGoodsDetailService;
	
	@RequiresPermissions("security:tLabourGoodsDetail:view")
	@GetMapping()
	public String tLabourGoodsDetail()
	{
	    return prefix + "/tLabourGoodsDetail";
	}
	
	/**
	 * 查询劳动防护物品明细列表
	 */
	@RequiresPermissions("security:tLabourGoodsDetail:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TLabourGoodsDetail tLabourGoodsDetail)
	{
		startPage();
        List<TLabourGoodsDetail> list = tLabourGoodsDetailService.selectTLabourGoodsDetailList(tLabourGoodsDetail);
		return getDataTable(list);
	}
	
	/**
	 * 新增劳动防护物品明细
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存劳动防护物品明细
	 */
	@RequiresPermissions("security:tLabourGoodsDetail:add")
	@Log(title = "劳动防护物品明细", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TLabourGoodsDetail tLabourGoodsDetail)
	{		
		return toAjax(tLabourGoodsDetailService.insertTLabourGoodsDetail(tLabourGoodsDetail));
	}

	/**
	 * 修改劳动防护物品明细
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TLabourGoodsDetail tLabourGoodsDetail = tLabourGoodsDetailService.selectTLabourGoodsDetailById(id);
		mmap.put("tLabourGoodsDetail", tLabourGoodsDetail);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存劳动防护物品明细
	 */
	@RequiresPermissions("security:tLabourGoodsDetail:edit")
	@Log(title = "劳动防护物品明细", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TLabourGoodsDetail tLabourGoodsDetail)
	{		
		return toAjax(tLabourGoodsDetailService.updateTLabourGoodsDetail(tLabourGoodsDetail));
	}
	
	/**
	 * 删除劳动防护物品明细
	 */
	@RequiresPermissions("security:tLabourGoodsDetail:remove")
	@Log(title = "劳动防护物品明细", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tLabourGoodsDetailService.deleteTLabourGoodsDetailByIds(ids));
	}
	
}
