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
import com.project.web.domian.TSafetyMeetDetail;
import com.project.web.service.ITSafetyMeetDetailService;

/**
 * 安全会议详细 信息操作处理
 *
 * @author rbf
 * @date 2019-04-18
 */
//注释了以下注解,该类废除,功能合并到安全会议的控制器中, TSafetyMeetController
//@Controller
@RequestMapping("/system/tSafetyMeetDetail")
public class TSafetyMeetDetailController extends BaseController
{
    private String prefix = "system/tSafetyMeetDetail";
	
	@Autowired
	private ITSafetyMeetDetailService tSafetyMeetDetailService;
	
	@RequiresPermissions("system:tSafetyMeetDetail:view")
	@GetMapping()
	public String tSafetyMeetDetail()
	{
	    return prefix + "/tSafetyMeetDetail";
	}
	
	/**
	 * 查询安全会议详细列表
	 */
	@RequiresPermissions("system:tSafetyMeetDetail:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TSafetyMeetDetail tSafetyMeetDetail)
	{
		startPage();
        List<TSafetyMeetDetail> list = tSafetyMeetDetailService.selectTSafetyMeetDetailList(tSafetyMeetDetail);
		return getDataTable(list);
	}
	
	/**
	 * 新增安全会议详细
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存安全会议详细
	 */
	@RequiresPermissions("system:tSafetyMeetDetail:add")
	@Log(title = "安全会议详细", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TSafetyMeetDetail tSafetyMeetDetail)
	{		
		return toAjax(tSafetyMeetDetailService.insertTSafetyMeetDetail(tSafetyMeetDetail));
	}

	/**
	 * 修改安全会议详细
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TSafetyMeetDetail tSafetyMeetDetail = tSafetyMeetDetailService.selectTSafetyMeetDetailById(id);
		mmap.put("tSafetyMeetDetail", tSafetyMeetDetail);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存安全会议详细
	 */
	@RequiresPermissions("system:tSafetyMeetDetail:edit")
	@Log(title = "安全会议详细", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TSafetyMeetDetail tSafetyMeetDetail)
	{		
		return toAjax(tSafetyMeetDetailService.updateTSafetyMeetDetail(tSafetyMeetDetail));
	}
	
	/**
	 * 删除安全会议详细
	 */
	@RequiresPermissions("system:tSafetyMeetDetail:remove")
	@Log(title = "安全会议详细", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tSafetyMeetDetailService.deleteTSafetyMeetDetailByIds(ids));
	}
	
}
