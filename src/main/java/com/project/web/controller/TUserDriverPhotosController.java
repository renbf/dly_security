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
import com.project.web.domian.TUserDriverPhotos;
import com.project.web.service.ITUserDriverPhotosService;

/**
 * 驾驶员照片 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Controller
@RequestMapping("/system/tUserDriverPhotos")
public class TUserDriverPhotosController extends BaseController
{
    private String prefix = "system/tUserDriverPhotos";
	
	@Autowired
	private ITUserDriverPhotosService tUserDriverPhotosService;
	
	@RequiresPermissions("system:tUserDriverPhotos:view")
	@GetMapping()
	public String tUserDriverPhotos()
	{
	    return prefix + "/tUserDriverPhotos";
	}
	
	/**
	 * 查询驾驶员照片列表
	 */
	@RequiresPermissions("system:tUserDriverPhotos:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TUserDriverPhotos tUserDriverPhotos)
	{
		startPage();
        List<TUserDriverPhotos> list = tUserDriverPhotosService.selectTUserDriverPhotosList(tUserDriverPhotos);
		return getDataTable(list);
	}
	
	/**
	 * 新增驾驶员照片
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存驾驶员照片
	 */
	@RequiresPermissions("system:tUserDriverPhotos:add")
	@Log(title = "驾驶员照片", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TUserDriverPhotos tUserDriverPhotos)
	{		
		return toAjax(tUserDriverPhotosService.insertTUserDriverPhotos(tUserDriverPhotos));
	}

	/**
	 * 修改驾驶员照片
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TUserDriverPhotos tUserDriverPhotos = tUserDriverPhotosService.selectTUserDriverPhotosById(id);
		mmap.put("tUserDriverPhotos", tUserDriverPhotos);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存驾驶员照片
	 */
	@RequiresPermissions("system:tUserDriverPhotos:edit")
	@Log(title = "驾驶员照片", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TUserDriverPhotos tUserDriverPhotos)
	{		
		return toAjax(tUserDriverPhotosService.updateTUserDriverPhotos(tUserDriverPhotos));
	}
	
	/**
	 * 删除驾驶员照片
	 */
	@RequiresPermissions("system:tUserDriverPhotos:remove")
	@Log(title = "驾驶员照片", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tUserDriverPhotosService.deleteTUserDriverPhotosByIds(ids));
	}
	
}
