package com.project.web.controller;

import java.util.List;

import com.project.web.domian.TSafetyMeetDetail;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TSafetyMeet;
import com.project.web.service.ITSafetyMeetService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 安全会议 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Controller
@RequestMapping("/system/tSafetyMeet")
public class TSafetyMeetController extends BaseController
{
    private String prefix = "system/tSafetyMeet";
	
	@Autowired
	private ITSafetyMeetService tSafetyMeetService;
	
	@RequiresPermissions("system:tSafetyMeet:view")
	@GetMapping()
	public String tSafetyMeet()
	{
	    return prefix + "/tSafetyMeet";
	}
	
	/**
	 * 查询安全会议列表
	 */
	//@RequiresPermissions("system:tSafetyMeet:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TSafetyMeet tSafetyMeet)
	{
		startPage();
        List<TSafetyMeet> list = tSafetyMeetService.selectTSafetyMeetList(tSafetyMeet);
		return getDataTable(list);
	}
	
	/**
	 * 新增安全会议
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存安全会议
	 */
	//@RequiresPermissions("system:tSafetyMeet:add")
	@Log(title = "安全会议", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave( TSafetyMeet tSafetyMeet, MultipartFile meetFile)
	{
		try {
			return tSafetyMeetService.insertTSafetyMeet(tSafetyMeet, meetFile);
		} catch (RuntimeException e) {
			//回滚了.....
			e.printStackTrace();
			return AjaxResult.error(2, "操作失败");
		}
	}

	/**
	 * 修改安全会议
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TSafetyMeet tSafetyMeet = tSafetyMeetService.selectTSafetyMeetById(id);
		mmap.put("tSafetyMeet", tSafetyMeet);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存安全会议
	 */
	//@RequiresPermissions("system:tSafetyMeet:edit")
	@Log(title = "安全会议", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TSafetyMeet tSafetyMeet,MultipartFile meetFile)
	{
		try {
			return tSafetyMeetService.updateTSafetyMeet(tSafetyMeet, meetFile);
		} catch (RuntimeException e) {
			//回滚了
			e.printStackTrace();
			return AjaxResult.error(2, "操作失败");
		}
	}
	
	/**
	 * 删除安全会议
	 */
	//@RequiresPermissions("system:tSafetyMeet:remove")
	@Log(title = "安全会议", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		try {
			return toAjax(tSafetyMeetService.deleteTSafetyMeetByIds(ids));
		} catch (RuntimeException e) {
			e.printStackTrace();
			return AjaxResult.error(2, "操作失败");
		}
	}
	
}
