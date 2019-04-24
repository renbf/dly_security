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
import com.project.web.domian.TMessage;
import com.project.web.service.ITMessageService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 消息 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tMessage")
public class TMessageController extends BaseController
{
    private String prefix = "web/tMessage";
	
	@Autowired
	private ITMessageService tMessageService;
	
	@RequiresPermissions("web:tMessage:view")
	@GetMapping()
	public String tMessage()
	{
	    return prefix + "/tMessage";
	}
	
	/**
	 * 查询消息列表
	 */
	@RequiresPermissions("web:tMessage:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TMessage tMessage)
	{
		startPage();
        List<TMessage> list = tMessageService.selectTMessageList(tMessage);
		return getDataTable(list);
	}
	
	/**
	 * 新增消息
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存消息
	 */
	@RequiresPermissions("web:tMessage:add")
	@Log(title = "消息", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TMessage tMessage)
	{		
		return toAjax(tMessageService.insertTMessage(tMessage));
	}

	/**
	 * 修改消息
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TMessage tMessage = tMessageService.selectTMessageById(id);
		mmap.put("tMessage", tMessage);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存消息
	 */
	@RequiresPermissions("web:tMessage:edit")
	@Log(title = "消息", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TMessage tMessage)
	{		
		return toAjax(tMessageService.updateTMessage(tMessage));
	}
	
	/**
	 * 删除消息
	 */
	@RequiresPermissions("web:tMessage:remove")
	@Log(title = "消息", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tMessageService.deleteTMessageByIds(ids));
	}
	
}
