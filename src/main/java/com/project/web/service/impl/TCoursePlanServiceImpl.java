package com.project.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Objects;
import java.io.IOException;
import java.util.Date;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.web.mapper.TCoursePlanMapper;
import com.project.web.domian.TCourse;
import com.project.web.domian.TCoursePlan;
import com.project.web.service.IFileService;
import com.project.web.service.ITCoursePlanService;
import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.common.utils.ValidationUtils;

/**
 * 课程计划 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCoursePlanServiceImpl implements ITCoursePlanService 
{
	private static final Logger log = LoggerFactory.getLogger(TCoursePlanServiceImpl.class);
	@Autowired
	@Qualifier("tCoursePlanMapper")
	private TCoursePlanMapper tCoursePlanMapper;
	@Autowired
	private IFileService fileService;

	/**
     * 查询课程计划信息
     * 
     * @param id 课程计划ID
     * @return 课程计划信息
     */
    @Override
	public TCoursePlan selectTCoursePlanById(String id)
	{
	    return tCoursePlanMapper.selectTCoursePlanById(id);
	}
	
	/**
     * 查询课程计划列表
     * 
     * @param tCoursePlan 课程计划信息
     * @return 课程计划集合
     */
	@Override
	public List<TCoursePlan> selectTCoursePlanList(TCoursePlan tCoursePlan)
	{
	    return tCoursePlanMapper.selectTCoursePlanList(tCoursePlan);
	}
	
    /**
     * 新增课程计划
     * 
     * @param tCoursePlan 课程计划信息
     * @return 结果
     */
	@Override
	public AjaxResult insertTCoursePlan(TCoursePlan tCoursePlan,MultipartFile attachmentFile)
	{
		AjaxResult aj = insertValidation(tCoursePlan);
		if(aj!=null) {
			return aj;
		}
		try {
			String uuid = UUIDUtil.getUUID();
			//上传文件
			if(Objects.nonNull(attachmentFile)&&StringUtils.isNotEmpty(attachmentFile.getOriginalFilename())){
				String courseUrl = fileService.upolad("kechengjihua",uuid,"课程计划文件",attachmentFile,0,tCoursePlan.getBusinessId());
				tCoursePlan.setAttachmentUrl(courseUrl);			
				
			}
			tCoursePlan.setCreateDate(new Date());
			tCoursePlan.setAddUserId(ShiroUtils.getUserId().toString());
			int i = tCoursePlanMapper.insertTCoursePlan(tCoursePlan);
			if(i==0) {
				return AjaxResult.error();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	    return AjaxResult.success();
	}
	
	/**
     * 修改课程计划
     * 
     * @param tCoursePlan 课程计划信息
     * @return 结果
     */
	@Override
	public AjaxResult updateTCoursePlan(TCoursePlan tCoursePlan,MultipartFile attachmentFile)
	{
		try {
			AjaxResult aj = insertValidation(tCoursePlan);
			if(aj!=null) {
				return aj;
			}
			//上传文件
			if(Objects.nonNull(attachmentFile)&&StringUtils.isNotEmpty(attachmentFile.getOriginalFilename())){
				String courseUrl = fileService.upolad("kechengjihua",tCoursePlan.getId(),"课程计划文件",attachmentFile,0,tCoursePlan.getBusinessId());
				tCoursePlan.setAttachmentUrl(courseUrl);			
				
			}
			tCoursePlan.setUpdateDate(new Date());
			tCoursePlan.setUpdateUserId(ShiroUtils.getUserId()+"");
			int i = tCoursePlanMapper.updateTCoursePlan(tCoursePlan);
			if(i==0) {
				return AjaxResult.error();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return AjaxResult.success();
	}

	/**
     * 删除课程计划对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTCoursePlanByIds(String ids)
	{
		return tCoursePlanMapper.deleteTCoursePlanByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
	 private AjaxResult insertValidation(TCoursePlan tCoursePlan) {
	        //应急预案发布：预案名称   预案类型(没有这个字段)  发布日期
	        if (ValidationUtils.objIsNull(tCoursePlan.getPlanYear())) {
	            return AjaxResult.error(2, "年份不能为空");
	        }
	        if (ValidationUtils.objIsNull(tCoursePlan.getTitle())) {
	            return AjaxResult.error(2, "标题不能为空");
	        }
	        if (ValidationUtils.objIsNull(tCoursePlan.getDeptId())) {
	            return AjaxResult.error(2, "部门不能为空");
	        }
	        return null;
	    }
}
