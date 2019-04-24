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
import com.project.web.domian.TAccidentAnalysisTopic;
import com.project.web.service.ITAccidentAnalysisTopicService;

/**
 * 事故分析专题会议 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/system/tAccidentAnalysisTopic")
public class TAccidentAnalysisTopicController extends BaseController
{
    private String prefix = "system/tAccidentAnalysisTopic";
	
	@Autowired
	private ITAccidentAnalysisTopicService tAccidentAnalysisTopicService;
	
	@RequiresPermissions("system:tAccidentAnalysisTopic:view")
	@GetMapping()
	public String tAccidentAnalysisTopic()
	{
	    return prefix + "/tAccidentAnalysisTopic";
	}
	
	/**
	 * 查询事故分析专题会议列表
	 */
	@RequiresPermissions("system:tAccidentAnalysisTopic:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TAccidentAnalysisTopic tAccidentAnalysisTopic)
	{
		startPage();
        List<TAccidentAnalysisTopic> list = tAccidentAnalysisTopicService.selectTAccidentAnalysisTopicList(tAccidentAnalysisTopic);
		return getDataTable(list);
	}
	
	/**
	 * 新增事故分析专题会议
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存事故分析专题会议
	 */
	@RequiresPermissions("system:tAccidentAnalysisTopic:add")
	@Log(title = "事故分析专题会议", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TAccidentAnalysisTopic tAccidentAnalysisTopic)
	{		
		return toAjax(tAccidentAnalysisTopicService.insertTAccidentAnalysisTopic(tAccidentAnalysisTopic));
	}

	/**
	 * 修改事故分析专题会议
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TAccidentAnalysisTopic tAccidentAnalysisTopic = tAccidentAnalysisTopicService.selectTAccidentAnalysisTopicById(id);
		mmap.put("tAccidentAnalysisTopic", tAccidentAnalysisTopic);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存事故分析专题会议
	 */
	@RequiresPermissions("system:tAccidentAnalysisTopic:edit")
	@Log(title = "事故分析专题会议", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TAccidentAnalysisTopic tAccidentAnalysisTopic)
	{		
		return toAjax(tAccidentAnalysisTopicService.updateTAccidentAnalysisTopic(tAccidentAnalysisTopic));
	}
	
	/**
	 * 删除事故分析专题会议
	 */
	@RequiresPermissions("system:tAccidentAnalysisTopic:remove")
	@Log(title = "事故分析专题会议", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tAccidentAnalysisTopicService.deleteTAccidentAnalysisTopicByIds(ids));
	}
	
}
