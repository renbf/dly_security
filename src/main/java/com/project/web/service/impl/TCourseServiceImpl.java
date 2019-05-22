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

import com.project.web.mapper.TCourseMapper;
import com.project.web.domian.TCourse;
import com.project.web.domian.TEmergencyPlanRelease;
import com.project.web.service.IFileService;
import com.project.web.service.ITCourseService;
import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.common.utils.ValidationUtils;

/**
 * 课程 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCourseServiceImpl implements ITCourseService 
{
	private static final Logger log = LoggerFactory.getLogger(TCourseServiceImpl.class);
	@Autowired
	@Qualifier("tCourseMapper")
	private TCourseMapper tCourseMapper;
	@Autowired
	private IFileService fileService;

	/**
     * 查询课程信息
     * 
     * @param id 课程ID
     * @return 课程信息
     */
    @Override
	public TCourse selectTCourseById(String id)
	{
	    return tCourseMapper.selectTCourseById(id);
	}
	
	/**
     * 查询课程列表
     * 
     * @param tCourse 课程信息
     * @return 课程集合
     */
	@Override
	public List<TCourse> selectTCourseList(TCourse tCourse)
	{
	    return tCourseMapper.selectTCourseList(tCourse);
	}
	
    /**
     * 新增课程
     * 
     * @param tCourse 课程信息
     * @return 结果
     */
	@Override
	public AjaxResult insertTCourse(TCourse tCourse,MultipartFile courseImg,MultipartFile videoFile,MultipartFile courseFile)
	{
		AjaxResult aj = insertValidation(tCourse);
		if(aj!=null) {
			return aj;
		}
		try {
			String uuid = UUIDUtil.getUUID();
			//上传图片
			if(Objects.nonNull(courseImg)&&StringUtils.isNotEmpty(courseImg.getOriginalFilename())){
				String courseUrl = fileService.upolad("kechengtupian",uuid,"课程图片",courseImg,0,tCourse.getBusinessId());
				tCourse.setCourseUrl(courseUrl);				
				
			}
			//上传视频
			if(Objects.nonNull(videoFile)&&StringUtils.isNotEmpty(videoFile.getOriginalFilename())){
				String videoUrl = fileService.upolad("kechengshipin",uuid,"课程视频",videoFile,0,tCourse.getBusinessId());
				tCourse.setVideoUrl(videoUrl);				
			}
			//上传文件
			if(Objects.nonNull(courseFile)&&StringUtils.isNotEmpty(courseFile.getOriginalFilename())){
				String fileUrl = fileService.upolad("kechengshipin",uuid,"课程视频",courseFile,0,tCourse.getBusinessId());
				tCourse.setFileUrl(fileUrl);				
			}
			tCourse.setId(uuid);
			tCourse.setCreateDate(new Date());
			tCourse.setAddUserId(ShiroUtils.getUserId().toString());
			int i=tCourseMapper.insertTCourse(tCourse);
			if(i==0) {
				return AjaxResult.error();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	    return AjaxResult.success();
	}
	
	/**
     * 修改课程
     * 
     * @param tCourse 课程信息
     * @return 结果
     */
	@Override
	public AjaxResult updateTCourse(TCourse tCourse,MultipartFile courseImg,MultipartFile videoFile,MultipartFile courseFile)
	{
		AjaxResult aj = insertValidation(tCourse);
		if(aj!=null) {
			return aj;
		}
		try {
			String uuid = UUIDUtil.getUUID();
			//上传图片
			if(Objects.nonNull(courseImg)&&StringUtils.isNotEmpty(courseImg.getOriginalFilename())){
				String courseUrl = fileService.upolad("kechengtupian",tCourse.getId(),"课程图片",courseImg,0,tCourse.getBusinessId());
				tCourse.setCourseUrl(courseUrl);				
				
			}
			//上传视频
			if(Objects.nonNull(videoFile)&&StringUtils.isNotEmpty(videoFile.getOriginalFilename())){
				String videoUrl = fileService.upolad("kechengshipin",tCourse.getId(),"课程视频",videoFile,0,tCourse.getBusinessId());
				tCourse.setVideoUrl(videoUrl);				
			}
			//上传文件
			if(Objects.nonNull(courseFile)&&StringUtils.isNotEmpty(courseFile.getOriginalFilename())){
				String fileUrl = fileService.upolad("kechengshipin",tCourse.getId(),"课程视频",courseFile,0,tCourse.getBusinessId());
				tCourse.setFileUrl(fileUrl);				
			}
			tCourse.setUpdateDate(new Date());
			tCourse.setUpdateUserId(ShiroUtils.getUserId()+"");
			int i=tCourseMapper.updateTCourse(tCourse);
			if(i==0) {
				return AjaxResult.error();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return AjaxResult.success();
	}

	/**
     * 删除课程对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTCourseByIds(String ids)
	{
		return tCourseMapper.deleteTCourseByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
	
    private AjaxResult insertValidation(TCourse tCourse) {
        //应急预案发布：预案名称   预案类型(没有这个字段)  发布日期
        if (ValidationUtils.objIsNull(tCourse.getTrainingType())) {
            return AjaxResult.error(2, "培训类型不能为空");
        }
        if (ValidationUtils.objIsNull(tCourse.getCourseType())) {
            return AjaxResult.error(2, "课程分类不能为空");
        }
        if (ValidationUtils.objIsNull(tCourse.getCourseName())) {
            return AjaxResult.error(2, "课程名称不能为空");
        }
        return null;
    }
}
