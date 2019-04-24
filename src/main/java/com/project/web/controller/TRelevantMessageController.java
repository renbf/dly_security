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
import com.project.web.domian.TRelevantMessage;
import com.project.web.service.ITRelevantMessageService;


/**
 * 相关方 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Controller
@RequestMapping("/system/tRelevantMessage")
public class TRelevantMessageController extends BaseController
{
    private String prefix = "system/tRelevantMessage";
	
	@Autowired
	private ITRelevantMessageService tRelevantMessageService;
	
	@RequiresPermissions("system:tRelevantMessage:view")
	@GetMapping()
	public String tRelevantMessage()
	{
	    return prefix + "/tRelevantMessage";
	}
	
	/**
	 * 查询相关方列表
	 */
	@RequiresPermissions("system:tRelevantMessage:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TRelevantMessage tRelevantMessage)
	{
		startPage();
        List<TRelevantMessage> list = tRelevantMessageService.selectTRelevantMessageList(tRelevantMessage);
		return getDataTable(list);
	}
	
	/**
	 * 新增相关方
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存相关方
	 */
	@RequiresPermissions("system:tRelevantMessage:add")
	@Log(title = "相关方", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TRelevantMessage tRelevantMessage)
	{		
		return toAjax(tRelevantMessageService.insertTRelevantMessage(tRelevantMessage));
	}

	/**
	 * 修改相关方
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		TRelevantMessage tRelevantMessage = tRelevantMessageService.selectTRelevantMessageById(id);
		mmap.put("tRelevantMessage", tRelevantMessage);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存相关方
	 */
	@RequiresPermissions("system:tRelevantMessage:edit")
	@Log(title = "相关方", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TRelevantMessage tRelevantMessage)
	{		
		return toAjax(tRelevantMessageService.updateTRelevantMessage(tRelevantMessage));
	}
	
	/**
	 * 删除相关方
	 */
	@RequiresPermissions("system:tRelevantMessage:remove")
	@Log(title = "相关方", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tRelevantMessageService.deleteTRelevantMessageByIds(ids));
	}
	
}
