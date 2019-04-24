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
import com.project.web.domian.TUserMessage;
import com.project.web.service.ITUserMessageService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 用户消息 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tUserMessage")
public class TUserMessageController extends BaseController
{
    private String prefix = "web/tUserMessage";
	
	@Autowired
	private ITUserMessageService tUserMessageService;
	
	@RequiresPermissions("web:tUserMessage:view")
	@GetMapping()
	public String tUserMessage()
	{
	    return prefix + "/tUserMessage";
	}
	
	/**
	 * 查询用户消息列表
	 */
	@RequiresPermissions("web:tUserMessage:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TUserMessage tUserMessage)
	{
		startPage();
        List<TUserMessage> list = tUserMessageService.selectTUserMessageList(tUserMessage);
		return getDataTable(list);
	}
	
	/**
	 * 新增用户消息
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户消息
	 */
	@RequiresPermissions("web:tUserMessage:add")
	@Log(title = "用户消息", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TUserMessage tUserMessage)
	{		
		return toAjax(tUserMessageService.insertTUserMessage(tUserMessage));
	}

	/**
	 * 修改用户消息
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TUserMessage tUserMessage = tUserMessageService.selectTUserMessageById(id);
		mmap.put("tUserMessage", tUserMessage);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户消息
	 */
	@RequiresPermissions("web:tUserMessage:edit")
	@Log(title = "用户消息", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TUserMessage tUserMessage)
	{		
		return toAjax(tUserMessageService.updateTUserMessage(tUserMessage));
	}
	
	/**
	 * 删除用户消息
	 */
	@RequiresPermissions("web:tUserMessage:remove")
	@Log(title = "用户消息", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tUserMessageService.deleteTUserMessageByIds(ids));
	}
	
}
