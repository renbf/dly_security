package com.project.web.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TUserDriverBasic;

/**
 * 驾驶员台账基础 服务层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface ITUserDriverBasicService 
{
	/**
     * 查询驾驶员台账基础信息
     * 
     * @param id 驾驶员台账基础ID
     * @return 驾驶员台账基础信息
     */
	public TUserDriverBasic selectTUserDriverBasicById(String id);
	
	/**
     * 查询驾驶员台账基础列表
     * 
     * @param tUserDriverBasic 驾驶员台账基础信息
     * @return 驾驶员台账基础集合
     */
	public List<TUserDriverBasic> selectTUserDriverBasicList(TUserDriverBasic tUserDriverBasic);
	
	/**
     * 新增驾驶员台账基础
     * 
     * @param tUserDriverBasic 驾驶员台账基础信息
     * @return 结果
     */
	public AjaxResult insertTUserDriverBasic(TUserDriverBasic tUserDriverBasic,MultipartFile headImg, //头像图片
			 MultipartFile personalImg,//个人照片
			 MultipartFile idCardCopyImg,//身份证复印件照片
			MultipartFile certificateCopyImg, //驾驶证复印件照片
			MultipartFile practitionersCopyImg,//从业资格证复印件照片
			 MultipartFile examinationPaperImg,//考试试卷正
			 MultipartFile examinationPaperSecondImg,//考试试卷第二页
			 MultipartFile examinationPaperThirdImg,//考试试卷第三页
			MultipartFile examinationPaperFourImg,//考试试卷第四页
			MultipartFile threeNotAccidentImg,//三年无重大事故
			MultipartFile oneYearIllegalRecordImg//一年违法记录查询 
);
	
	/**
     * 修改驾驶员台账基础
     * 
     * @param tUserDriverBasic 驾驶员台账基础信息
     * @return 结果
     */
	public AjaxResult updateTUserDriverBasic(TUserDriverBasic tUserDriverBasic,MultipartFile headImg, //头像图片
			 MultipartFile personalImg,//个人照片
			 MultipartFile idCardCopyImg,//身份证复印件照片
			MultipartFile certificateCopyImg, //驾驶证复印件照片
			MultipartFile practitionersCopyImg,//从业资格证复印件照片
			 MultipartFile examinationPaperImg,//考试试卷正
			 MultipartFile examinationPaperSecondImg,//考试试卷第二页
			 MultipartFile examinationPaperThirdImg,//考试试卷第三页
			MultipartFile examinationPaperFourImg,//考试试卷第四页
			MultipartFile threeNotAccidentImg,//三年无重大事故
			MultipartFile oneYearIllegalRecordImg);//一年违法记录查询 
		
	/**
     * 删除驾驶员台账基础信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTUserDriverBasicByIds(String ids);
	
}
