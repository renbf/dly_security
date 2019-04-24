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
import com.project.web.domian.TCarTrouble;
import com.project.web.service.ITCarTroubleService;
import com.project.system.core.base.BaseController;
import com.project.framework.web.page.TableDataInfo;
import com.project.common.base.AjaxResult;

/**
 * 车辆机损事故登记 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tCarTrouble")
public class TCarTroubleController extends BaseController
{
    private String prefix = "web/tCarTrouble";
	
	@Autowired
	private ITCarTroubleService tCarTroubleService;
	
	@RequiresPermissions("web:tCarTrouble:view")
	@GetMapping()
	public String tCarTrouble()
	{
	    return prefix + "/tCarTrouble";
	}
	
	/**
	 * 查询车辆机损事故登记列表
	 */
	@RequiresPermissions("web:tCarTrouble:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TCarTrouble tCarTrouble)
	{
		startPage();
        List<TCarTrouble> list = tCarTroubleService.selectTCarTroubleList(tCarTrouble);
		return getDataTable(list);
	}
	
	/**
	 * 新增车辆机损事故登记
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存车辆机损事故登记
	 */
	@RequiresPermissions("web:tCarTrouble:add")
	@Log(title = "车辆机损事故登记", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TCarTrouble tCarTrouble)
	{		
		return toAjax(tCarTroubleService.insertTCarTrouble(tCarTrouble));
	}

	/**
	 * 修改车辆机损事故登记
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TCarTrouble tCarTrouble = tCarTroubleService.selectTCarTroubleById(id);
		mmap.put("tCarTrouble", tCarTrouble);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存车辆机损事故登记
	 */
	@RequiresPermissions("web:tCarTrouble:edit")
	@Log(title = "车辆机损事故登记", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TCarTrouble tCarTrouble)
	{		
		return toAjax(tCarTroubleService.updateTCarTrouble(tCarTrouble));
	}
	
	/**
	 * 删除车辆机损事故登记
	 */
	@RequiresPermissions("web:tCarTrouble:remove")
	@Log(title = "车辆机损事故登记", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tCarTroubleService.deleteTCarTroubleByIds(ids));
	}
	
}
