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
import com.project.web.domian.TNotice;
import com.project.web.service.ITNoticeService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 公告管理 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tNotice")
public class TNoticeController extends BaseController
{
    private String prefix = "web/tNotice";
	
	@Autowired
	private ITNoticeService tNoticeService;
	
	@RequiresPermissions("web:tNotice:view")
	@GetMapping()
	public String tNotice()
	{
	    return prefix + "/tNotice";
	}
	
	/**
	 * 查询公告管理列表
	 */
	@RequiresPermissions("web:tNotice:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TNotice tNotice)
	{
		startPage();
        List<TNotice> list = tNoticeService.selectTNoticeList(tNotice);
		return getDataTable(list);
	}
	
	/**
	 * 新增公告管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存公告管理
	 */
	@RequiresPermissions("web:tNotice:add")
	@Log(title = "公告管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TNotice tNotice)
	{		
		return toAjax(tNoticeService.insertTNotice(tNotice));
	}

	/**
	 * 修改公告管理
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TNotice tNotice = tNoticeService.selectTNoticeById(id);
		mmap.put("tNotice", tNotice);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存公告管理
	 */
	@RequiresPermissions("web:tNotice:edit")
	@Log(title = "公告管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TNotice tNotice)
	{		
		return toAjax(tNoticeService.updateTNotice(tNotice));
	}
	
	/**
	 * 删除公告管理
	 */
	@RequiresPermissions("web:tNotice:remove")
	@Log(title = "公告管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tNoticeService.deleteTNoticeByIds(ids));
	}
	
}
