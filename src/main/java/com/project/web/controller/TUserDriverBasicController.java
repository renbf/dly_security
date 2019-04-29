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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TUserDriverBasic;
import com.project.web.service.ITUserDriverBasicService;

/**
 * 驾驶员台账基础 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Controller
@RequestMapping("/system/tUserDriverBasic")
public class TUserDriverBasicController extends BaseController
{
    private String prefix = "system/tUserDriverBasic";
	
	@Autowired
	private ITUserDriverBasicService tUserDriverBasicService;
	
	@RequiresPermissions("system:tUserDriverBasic:view")
	@GetMapping()
	public String tUserDriverBasic()
	{
	    return prefix + "/tUserDriverBasic";
	}
	
	/**
	 * 查询驾驶员台账基础列表
	 */
	@RequiresPermissions("system:tUserDriverBasic:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TUserDriverBasic tUserDriverBasic)
	{
		startPage();
        List<TUserDriverBasic> list = tUserDriverBasicService.selectTUserDriverBasicList(tUserDriverBasic);
		return getDataTable(list);
	}
	
	/**
	 * 新增驾驶员台账基础
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存驾驶员台账基础
	 */
//	@RequiresPermissions("system:tUserDriverBasic:add")
	@Log(title = "驾驶员台账基础", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TUserDriverBasic tUserDriverBasic,
			@RequestParam(name = "headImg",required = false) MultipartFile headImg, //头像图片
			@RequestParam(name = "personalImg",required = false) MultipartFile personalImg,//个人照片
			@RequestParam(name = "idCardCopyImg",required = false) MultipartFile idCardCopyImg,//身份证复印件照片
			@RequestParam(name = "certificateCopyImg",required = false) MultipartFile certificateCopyImg, //驾驶证复印件照片
			@RequestParam(name = "practitionersCopyImg",required = false) MultipartFile practitionersCopyImg,//从业资格证复印件照片
			@RequestParam(name = "examinationPaperImg",required = false) MultipartFile examinationPaperImg,//考试试卷正
			@RequestParam(name = "examinationPaperSecondImg",required = false) MultipartFile examinationPaperSecondImg,//考试试卷第二页
			@RequestParam(name = "examinationPaperThirdImg",required = false) MultipartFile examinationPaperThirdImg,//考试试卷第三页
			@RequestParam(name = "examinationPaperFourImg",required = false) MultipartFile examinationPaperFourImg,//考试试卷第四页
			@RequestParam(name = "threeNotAccidentImg",required = false) MultipartFile threeNotAccidentImg,//三年无重大事故
			@RequestParam(name = "oneYearIllegalRecordImg",required = false) MultipartFile oneYearIllegalRecordImg)//一年违法记录查询 
	{		
		return tUserDriverBasicService.insertTUserDriverBasic(tUserDriverBasic,headImg,personalImg,idCardCopyImg,
				certificateCopyImg,practitionersCopyImg,examinationPaperImg,examinationPaperSecondImg,examinationPaperThirdImg,
				examinationPaperFourImg,threeNotAccidentImg,oneYearIllegalRecordImg);
	}

	/**
	 * 修改驾驶员台账基础
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TUserDriverBasic tUserDriverBasic = tUserDriverBasicService.selectTUserDriverBasicById(id);
		mmap.put("tUserDriverBasic", tUserDriverBasic);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存驾驶员台账基础
	 */
	@RequiresPermissions("system:tUserDriverBasic:edit")
	@Log(title = "驾驶员台账基础", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TUserDriverBasic tUserDriverBasic,
			@RequestParam(name = "headImg",required = false) MultipartFile headImg, //头像图片
			@RequestParam(name = "personalImg",required = false) MultipartFile personalImg,//个人照片
			@RequestParam(name = "idCardCopyImg",required = false) MultipartFile idCardCopyImg,//身份证复印件照片
			@RequestParam(name = "certificateCopyImg",required = false) MultipartFile certificateCopyImg, //驾驶证复印件照片
			@RequestParam(name = "practitionersCopyImg",required = false) MultipartFile practitionersCopyImg,//从业资格证复印件照片
			@RequestParam(name = "examinationPaperImg",required = false) MultipartFile examinationPaperImg,//考试试卷正
			@RequestParam(name = "examinationPaperSecondImg",required = false) MultipartFile examinationPaperSecondImg,//考试试卷第二页
			@RequestParam(name = "examinationPaperThirdImg",required = false) MultipartFile examinationPaperThirdImg,//考试试卷第三页
			@RequestParam(name = "examinationPaperFourImg",required = false) MultipartFile examinationPaperFourImg,//考试试卷第四页
			@RequestParam(name = "threeNotAccidentImg",required = false) MultipartFile threeNotAccidentImg,//三年无重大事故
			@RequestParam(name = "oneYearIllegalRecordImg",required = false) MultipartFile oneYearIllegalRecordImg)//一年违法记录查询)
	{		
		return tUserDriverBasicService.updateTUserDriverBasic(tUserDriverBasic,headImg,personalImg,idCardCopyImg,
				certificateCopyImg,practitionersCopyImg,examinationPaperImg,examinationPaperSecondImg,examinationPaperThirdImg,
				examinationPaperFourImg,threeNotAccidentImg,oneYearIllegalRecordImg);
	}
	
	/**
	 * 删除驾驶员台账基础
	 */
	@RequiresPermissions("system:tUserDriverBasic:remove")
	@Log(title = "驾驶员台账基础", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tUserDriverBasicService.deleteTUserDriverBasicByIds(ids));
	}
	
}
