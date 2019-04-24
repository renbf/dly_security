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
import com.project.web.domian.TBanner;
import com.project.web.service.ITBannerService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 轮播图 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tBanner")
public class TBannerController extends BaseController
{
    private String prefix = "web/tBanner";
	
	@Autowired
	private ITBannerService tBannerService;
	
	@RequiresPermissions("web:tBanner:view")
	@GetMapping()
	public String tBanner()
	{
	    return prefix + "/tBanner";
	}
	
	/**
	 * 查询轮播图列表
	 */
	@RequiresPermissions("web:tBanner:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TBanner tBanner)
	{
		startPage();
        List<TBanner> list = tBannerService.selectTBannerList(tBanner);
		return getDataTable(list);
	}
	
	/**
	 * 新增轮播图
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存轮播图
	 */
	@RequiresPermissions("web:tBanner:add")
	@Log(title = "轮播图", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TBanner tBanner)
	{		
		return toAjax(tBannerService.insertTBanner(tBanner));
	}

	/**
	 * 修改轮播图
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TBanner tBanner = tBannerService.selectTBannerById(id);
		mmap.put("tBanner", tBanner);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存轮播图
	 */
	@RequiresPermissions("web:tBanner:edit")
	@Log(title = "轮播图", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TBanner tBanner)
	{		
		return toAjax(tBannerService.updateTBanner(tBanner));
	}
	
	/**
	 * 删除轮播图
	 */
	@RequiresPermissions("web:tBanner:remove")
	@Log(title = "轮播图", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tBannerService.deleteTBannerByIds(ids));
	}
	
}
