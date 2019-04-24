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
import com.project.web.domian.TCarLog;
import com.project.web.service.ITCarLogService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 车牌号牌变更 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tCarLog")
public class TCarLogController extends BaseController
{
    private String prefix = "web/tCarLog";
	
	@Autowired
	private ITCarLogService tCarLogService;
	
	@RequiresPermissions("web:tCarLog:view")
	@GetMapping()
	public String tCarLog()
	{
	    return prefix + "/tCarLog";
	}
	
	/**
	 * 查询车牌号牌变更列表
	 */
	@RequiresPermissions("web:tCarLog:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TCarLog tCarLog)
	{
		startPage();
        List<TCarLog> list = tCarLogService.selectTCarLogList(tCarLog);
		return getDataTable(list);
	}
	
	/**
	 * 新增车牌号牌变更
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存车牌号牌变更
	 */
	@RequiresPermissions("web:tCarLog:add")
	@Log(title = "车牌号牌变更", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TCarLog tCarLog)
	{		
		return toAjax(tCarLogService.insertTCarLog(tCarLog));
	}

	/**
	 * 修改车牌号牌变更
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TCarLog tCarLog = tCarLogService.selectTCarLogById(id);
		mmap.put("tCarLog", tCarLog);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存车牌号牌变更
	 */
	@RequiresPermissions("web:tCarLog:edit")
	@Log(title = "车牌号牌变更", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TCarLog tCarLog)
	{		
		return toAjax(tCarLogService.updateTCarLog(tCarLog));
	}
	
	/**
	 * 删除车牌号牌变更
	 */
	@RequiresPermissions("web:tCarLog:remove")
	@Log(title = "车牌号牌变更", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tCarLogService.deleteTCarLogByIds(ids));
	}
	
}
