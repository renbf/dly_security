package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.common.utils.TimeUuidUtil;
import com.project.framework.shiro.service.PasswordService;
import com.project.framework.util.ShiroUtils;
import com.project.system.domain.SysUser;
import com.project.system.service.ISysUserService;
import com.project.util.UUIDUtil;
import com.project.web.domian.TUserDriverBasic;
import com.project.web.domian.TUserDriverInfo;
import com.project.web.domian.TUserDriverOthers;
import com.project.web.domian.TUserDriverPhotos;
import com.project.web.domian.TUserDriverPractitioners;
import com.project.web.mapper.TUserDriverBasicMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITUserDriverBasicService;
import com.project.web.service.ITUserDriverInfoService;
import com.project.web.service.ITUserDriverOthersService;
import com.project.web.service.ITUserDriverPhotosService;
import com.project.web.service.ITUserDriverPractitionersService;

/**
 * 驾驶员台账基础 服务层实现
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TUserDriverBasicServiceImpl implements ITUserDriverBasicService 
{
	@Autowired
	private TUserDriverBasicMapper tUserDriverBasicMapper;
	@Autowired
	private ITUserDriverInfoService tUserDriverInfoService;
	@Autowired
	private ITUserDriverOthersService tUserDriverOthersService;	
	@Autowired
	private ITUserDriverPhotosService tUserDriverPhotosService;
	@Autowired
	private ITUserDriverPractitionersService tUserDriverPractitionersService;
	@Autowired
	private ISysUserService userService;	
	@Autowired
    private PasswordService passwordService;
	@Autowired
	private IFileService fileService;

	/**
     * 查询驾驶员台账基础信息
     * 
     * @param id 驾驶员台账基础ID
     * @return 驾驶员台账基础信息
     */
    @Override
	public TUserDriverBasic selectTUserDriverBasicById(String id)
	{
	    return tUserDriverBasicMapper.selectTUserDriverBasicById(id);
	}
	
	/**
     * 查询驾驶员台账基础列表
     * 
     * @param tUserDriverBasic 驾驶员台账基础信息
     * @return 驾驶员台账基础集合
     */
	@Override
	public List<TUserDriverBasic> selectTUserDriverBasicList(TUserDriverBasic tUserDriverBasic)
	{
	    return tUserDriverBasicMapper.selectTUserDriverBasicList(tUserDriverBasic);
	}
	
    /**
     * 新增驾驶员台账基础
     * 
     * @param tUserDriverBasic 驾驶员台账基础信息
     * @return 结果
     */
	@Override
    @Transactional
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
			 MultipartFile oneYearIllegalRecordImg)//一年违法记录查询
	{

		try {
			//新增
			/**
			 * 新增驾驶员时，也需要向sys_user表插入一条数据
			 */
			
			
			if(checkObj(tUserDriverBasic.getDriverName())) {
				return AjaxResult.error(2, "姓名不能为空");
			}
			if(checkObj(tUserDriverBasic.getDriverSex())) {
				return AjaxResult.error(2, "性别不能为空");
			}
			if(checkObj(tUserDriverBasic.getDriverPhone())) {
				return AjaxResult.error(2, "手机号不能为空");
			}
			if(checkObj(tUserDriverBasic.getDriverDept()) ) {
				return AjaxResult.error(2, "任职部门不能为空");
			}
			if(checkObj(tUserDriverBasic.getDriverPost())) {
				return AjaxResult.error(2, "任职岗位不能为空");
			}
			if(checkObj(tUserDriverBasic.getDriverIdNum())) {
				return AjaxResult.error(2, "身份证号不能为空");
			}
			if(checkObj(tUserDriverBasic.getDriverEmail())) {
				return AjaxResult.error(2, "邮箱不能为空");
			}
			if(checkObj(tUserDriverBasic.getDriverEducation())) {
				return AjaxResult.error(2, "文化程度不能为空");
			}
			if(checkObj(tUserDriverBasic.getDriverBirth())) {
				return AjaxResult.error(2, "出生日期不能为空");
			}
			if(checkObj(tUserDriverBasic.getDriverAddr())) {
				return AjaxResult.error(2, "住址不能为空");
			}
			if(checkObj(tUserDriverBasic.getUserDriverInfo())) {
				return AjaxResult.error(2, "驾驶员驾驶信息不能为空");
			}
			if(checkObj(tUserDriverBasic.getUserDriverOthers())) {
				return AjaxResult.error(2, "驾驶员诚信信息不能为空");
			}
//			//校验输入的手机号是否存在
			SysUser userTemp =new SysUser();
			userTemp.setPhonenumber(tUserDriverBasic.getDriverPhone());
			String j= userService.checkPhoneUnique(userTemp);
			if("1".equals(j)) {
				AjaxResult.error(2, "该手机号已存在");
			}
			SysUser user =new SysUser();
			long userUuid = TimeUuidUtil.get16UUID();//生成的user_id
			user.setSalt(ShiroUtils.randomSalt());
		    user.setPassword(passwordService.encryptPassword(user.getLoginName(), "123456", user.getSalt()));//默认密码
		    user.setCreateBy(ShiroUtils.getLoginName());
		    user.setCreateTime(new Date());
		    user.setDeptId(tUserDriverBasic.getDriverDept());//部门ID
		    user.setLoginName(tUserDriverBasic.getDriverPhone());//登录账号 就是手机号
		    user.setUserName(tUserDriverBasic.getDriverName());//用户姓名
		    user.setEmail(tUserDriverBasic.getDriverEmail());//用户邮箱
		    user.setPhonenumber(tUserDriverBasic.getDriverPhone());//手机号码	    
		    int i=userService.insertUserByManagement(user, userUuid);//新增一条数据	  
		    if(i==0) {
				return AjaxResult.error();
			}
			
			String uuid = UUIDUtil.getUUID();//生成主键		
			tUserDriverBasic.setId(uuid);
			tUserDriverBasic.setCreateTime(new Date());
			tUserDriverBasic.setUserId(ShiroUtils.getUserId());	
			tUserDriverBasic.setDriverUserId(userUuid);
			//向驾驶员基础表中新增数据
		    i=tUserDriverBasicMapper.insertTUserDriverBasic(tUserDriverBasic);
			if(i==0) {
				return AjaxResult.error();
			}
			i=0;
			//向驾驶员驾驶信息表中新增数据
			TUserDriverInfo driverIno = tUserDriverBasic.getUserDriverInfo();
			if(driverIno!=null) {
				String uuidTemp = UUIDUtil.getUUID();//生成主键		
				driverIno.setId(uuidTemp);
				driverIno.setDriverUserId(userUuid);
				i=tUserDriverInfoService.insertTUserDriverInfo(driverIno);
				if(i==0) {
					return AjaxResult.error();
				}
			}
			
			//向驾驶员照片表中新增数据
			//若文件不为空   则进行上传文件
			TUserDriverPhotos driverPhoto = new TUserDriverPhotos();
			String uuidTemp = UUIDUtil.getUUID();//生成主键	
			driverPhoto.setId(uuidTemp);
			driverPhoto.setDriverUserId(userUuid);
			driverPhoto.setCreateTime(new Date());
			//驾驶员头像
			if(Objects.nonNull(headImg)&&StringUtils.isNotEmpty(headImg.getOriginalFilename())){	
				String Str = fileService.upolad("jiashiyuantouxiang",uuidTemp,"驾驶员头像图片",headImg,0,driverPhoto.getBusinessId());
				driverPhoto.setHeadImg(Str);				
			}	
			//个人照片图片
			if(Objects.nonNull(personalImg)&&StringUtils.isNotEmpty(personalImg.getOriginalFilename())){	
				String Str = fileService.upolad("gerenzhaopian",uuidTemp,"个人照片图片",personalImg,0,driverPhoto.getBusinessId());
				driverPhoto.setPersonalImg(Str);				
			}	
			//身份证复印件照片图片
			if(Objects.nonNull(idCardCopyImg)&&StringUtils.isNotEmpty(idCardCopyImg.getOriginalFilename())){	
				String Str = fileService.upolad("shenfenzhengzhaopian",uuidTemp,"身份证复印件照片图片",idCardCopyImg,0,driverPhoto.getBusinessId());
				driverPhoto.setIdCardCopyImg(Str);				
			}	
			//从业资格证复印件照片图片
			if(Objects.nonNull(practitionersCopyImg)&&StringUtils.isNotEmpty(practitionersCopyImg.getOriginalFilename())){	
				String Str = fileService.upolad("congyezigezheng",uuidTemp,"从业资格证复印件照片图片",practitionersCopyImg,0,driverPhoto.getBusinessId());
				driverPhoto.setPractitionersCopyImg(Str);				
			}	
			//考试试卷正
			if(Objects.nonNull(examinationPaperImg)&&StringUtils.isNotEmpty(examinationPaperImg.getOriginalFilename())){	
				String Str = fileService.upolad("kaoshishijuanzheng",uuidTemp,"考试试卷正图片",examinationPaperImg,0,driverPhoto.getBusinessId());
				driverPhoto.setExaminationPaperImg(Str);				
			}	
			//考试试卷第二页
			if(Objects.nonNull(examinationPaperSecondImg)&&StringUtils.isNotEmpty(examinationPaperSecondImg.getOriginalFilename())){	
				String Str = fileService.upolad("kaoshishijuandier",uuidTemp,"考试试卷第二页图片",examinationPaperSecondImg,0,driverPhoto.getBusinessId());
				driverPhoto.setExaminationPaperSecondImg(Str);				
			}	
			//考试试卷第三页
			if(Objects.nonNull(examinationPaperThirdImg)&&StringUtils.isNotEmpty(examinationPaperThirdImg.getOriginalFilename())){	
				String Str = fileService.upolad("kaoshishijuandisan",uuidTemp,"考试试卷第三页图片",examinationPaperThirdImg,0,driverPhoto.getBusinessId());
				driverPhoto.setExaminationPaperThirdImg(Str);				
			}	
			//考试试卷第四页
			if(Objects.nonNull(examinationPaperFourImg)&&StringUtils.isNotEmpty(examinationPaperFourImg.getOriginalFilename())){	
				String Str = fileService.upolad("kaoshishijuandisi",uuidTemp,"考试试卷第四页图片",examinationPaperFourImg,0,driverPhoto.getBusinessId());
				driverPhoto.setExaminationPaperFourImg(Str);				
			}	
			//三年无重大事故
			if(Objects.nonNull(threeNotAccidentImg)&&StringUtils.isNotEmpty(threeNotAccidentImg.getOriginalFilename())){	
				String Str = fileService.upolad("sannianwuzhongdashigu",uuidTemp,"三年无重大事故图片",threeNotAccidentImg,0,driverPhoto.getBusinessId());
				driverPhoto.setThreeNotAccidentImg(Str);				
			}	
			//一年违法记录查询 
			if(Objects.nonNull(oneYearIllegalRecordImg)&&StringUtils.isNotEmpty(oneYearIllegalRecordImg.getOriginalFilename())){	
				String Str = fileService.upolad("yinianweifajiluchaxun",uuidTemp,"一年违法记录查询图片",oneYearIllegalRecordImg,0,driverPhoto.getBusinessId());
				driverPhoto.setOneYearIllegalRecordImg(Str);				
			}	
			

			i =tUserDriverPhotosService.insertTUserDriverPhotos(driverPhoto);
			if(i==0) {
				return AjaxResult.error();
			}
			//向驾驶员从业资格证表 中新增数据
			TUserDriverPractitioners driverPractitioner =tUserDriverBasic.getUserDriverPractitioners();
			if(driverPractitioner!=null) {
				String uuidTemp1 = UUIDUtil.getUUID();//生成主键		
				driverPractitioner.setId(uuidTemp1);
				driverPractitioner.setDriverUserId(userUuid);
				i =tUserDriverPractitionersService.insertTUserDriverPractitioners(driverPractitioner);
				if(i==0) {
					return AjaxResult.error();
				}
			}
			//向驾驶员其他信息表 中新增数据
			TUserDriverOthers userDriverOthers =tUserDriverBasic.getUserDriverOthers();
			if(userDriverOthers!=null) {
				String uuidTemp1 = UUIDUtil.getUUID();//生成主键		
				userDriverOthers.setId(uuidTemp1);
				userDriverOthers.setDriverUserId(userUuid);
				i =tUserDriverOthersService.insertTUserDriverOthers(userDriverOthers);
				if(i==0) {
					return AjaxResult.error();
				}
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		return AjaxResult.success();
	}
	
	/**
     * 修改驾驶员台账基础
     * 
     * @param tUserDriverBasic 驾驶员台账基础信息
     * @return 结果
     */
	@Override
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
			MultipartFile oneYearIllegalRecordImg)
	{		
		if(checkObj(tUserDriverBasic.getDriverName())) {
			return AjaxResult.error(2, "姓名不能为空");
		}
		if(checkObj(tUserDriverBasic.getDriverSex())) {
			return AjaxResult.error(2, "性别不能为空");
		}
		if(checkObj(tUserDriverBasic.getDriverPhone())) {
			return AjaxResult.error(2, "手机号不能为空");
		}
		if(checkObj(tUserDriverBasic.getDriverDept()) ) {
			return AjaxResult.error(2, "任职部门不能为空");
		}
		if(checkObj(tUserDriverBasic.getDriverPost())) {
			return AjaxResult.error(2, "任职岗位不能为空");
		}
		if(checkObj(tUserDriverBasic.getDriverIdNum())) {
			return AjaxResult.error(2, "身份证号不能为空");
		}
		if(checkObj(tUserDriverBasic.getDriverEmail())) {
			return AjaxResult.error(2, "邮箱不能为空");
		}
		if(checkObj(tUserDriverBasic.getDriverEducation())) {
			return AjaxResult.error(2, "文化程度不能为空");
		}
		if(checkObj(tUserDriverBasic.getDriverBirth())) {
			return AjaxResult.error(2, "出生日期不能为空");
		}
		if(checkObj(tUserDriverBasic.getDriverAddr())) {
			return AjaxResult.error(2, "住址不能为空");
		}
		if(checkObj(tUserDriverBasic.getUserDriverInfo())) {
			return AjaxResult.error(2, "驾驶员驾驶信息不能为空");
		}
		if(checkObj(tUserDriverBasic.getUserDriverOthers())) {
			return AjaxResult.error(2, "驾驶员诚信信息不能为空");
		}
		TUserDriverPhotos driverPhoto = new TUserDriverPhotos();
		String uuidTemp = tUserDriverBasic.getUserDriverPhotos().getId();
		driverPhoto.setId(uuidTemp);	
		driverPhoto.setUpdateTime(new Date());
		driverPhoto.setUpdateUserId(ShiroUtils.getUserId());
		try {
			//驾驶员头像
			if(Objects.nonNull(headImg)&&StringUtils.isNotEmpty(headImg.getOriginalFilename())){	
				String Str = fileService.upolad("jiashiyuantouxiang",uuidTemp,"驾驶员头像图片",headImg,0,driverPhoto.getBusinessId());
				driverPhoto.setHeadImg(Str);				
			}	
			//个人照片图片
			if(Objects.nonNull(personalImg)&&StringUtils.isNotEmpty(personalImg.getOriginalFilename())){	
				String Str = fileService.upolad("gerenzhaopian",uuidTemp,"个人照片图片",personalImg,0,driverPhoto.getBusinessId());
				driverPhoto.setPersonalImg(Str);				
			}	
			//身份证复印件照片图片
			if(Objects.nonNull(idCardCopyImg)&&StringUtils.isNotEmpty(idCardCopyImg.getOriginalFilename())){	
				String Str = fileService.upolad("shenfenzhengzhaopian",uuidTemp,"身份证复印件照片图片",idCardCopyImg,0,driverPhoto.getBusinessId());
				driverPhoto.setIdCardCopyImg(Str);				
			}	
			//从业资格证复印件照片图片
			if(Objects.nonNull(practitionersCopyImg)&&StringUtils.isNotEmpty(practitionersCopyImg.getOriginalFilename())){	
				String Str = fileService.upolad("congyezigezheng",uuidTemp,"从业资格证复印件照片图片",practitionersCopyImg,0,driverPhoto.getBusinessId());
				driverPhoto.setPractitionersCopyImg(Str);				
			}	
			//考试试卷正
			if(Objects.nonNull(examinationPaperImg)&&StringUtils.isNotEmpty(examinationPaperImg.getOriginalFilename())){	
				String Str = fileService.upolad("kaoshishijuanzheng",uuidTemp,"考试试卷正图片",examinationPaperImg,0,driverPhoto.getBusinessId());
				driverPhoto.setExaminationPaperImg(Str);				
			}	
			//考试试卷第二页
			if(Objects.nonNull(examinationPaperSecondImg)&&StringUtils.isNotEmpty(examinationPaperSecondImg.getOriginalFilename())){	
				String Str = fileService.upolad("kaoshishijuandier",uuidTemp,"考试试卷第二页图片",examinationPaperSecondImg,0,driverPhoto.getBusinessId());
				driverPhoto.setExaminationPaperSecondImg(Str);				
			}	
			//考试试卷第三页
			if(Objects.nonNull(examinationPaperThirdImg)&&StringUtils.isNotEmpty(examinationPaperThirdImg.getOriginalFilename())){	
				String Str = fileService.upolad("kaoshishijuandisan",uuidTemp,"考试试卷第三页图片",examinationPaperThirdImg,0,driverPhoto.getBusinessId());
				driverPhoto.setExaminationPaperThirdImg(Str);				
			}	
			//考试试卷第四页
			if(Objects.nonNull(examinationPaperFourImg)&&StringUtils.isNotEmpty(examinationPaperFourImg.getOriginalFilename())){	
				String Str = fileService.upolad("kaoshishijuandisi",uuidTemp,"考试试卷第四页图片",examinationPaperFourImg,0,driverPhoto.getBusinessId());
				driverPhoto.setExaminationPaperFourImg(Str);				
			}	
			//三年无重大事故
			if(Objects.nonNull(threeNotAccidentImg)&&StringUtils.isNotEmpty(threeNotAccidentImg.getOriginalFilename())){	
				String Str = fileService.upolad("sannianwuzhongdashigu",uuidTemp,"三年无重大事故图片",threeNotAccidentImg,0,driverPhoto.getBusinessId());
				driverPhoto.setThreeNotAccidentImg(Str);				
			}	
			//一年违法记录查询 
			if(Objects.nonNull(oneYearIllegalRecordImg)&&StringUtils.isNotEmpty(oneYearIllegalRecordImg.getOriginalFilename())){	
				String Str = fileService.upolad("yinianweifajiluchaxun",uuidTemp,"一年违法记录查询图片",oneYearIllegalRecordImg,0,driverPhoto.getBusinessId());
				driverPhoto.setOneYearIllegalRecordImg(Str);				
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		//更新驾驶员照片表中数据
		int i =tUserDriverPhotosService.updateTUserDriverPhotos(driverPhoto);
		if(i==0) {
			return AjaxResult.error();
		}
		//更新驾驶员基础表中数据
		tUserDriverBasic.setUpdateTime(new Date());
		tUserDriverBasic.setUpdateUserId(ShiroUtils.getUserId());
	    i=tUserDriverBasicMapper.updateTUserDriverBasic(tUserDriverBasic);
		if(i==0) {
			return AjaxResult.error();
		}
		//更新驾驶员从业资格证表数据
		TUserDriverPractitioners driverPractitioner =tUserDriverBasic.getUserDriverPractitioners();
		if(driverPractitioner!=null) {
			String uuidTemp1 = 	driverPractitioner.getId();
			driverPractitioner.setId(uuidTemp1);
			driverPractitioner.setUpdateTime(new Date());
			driverPractitioner.setUpdateUserId(ShiroUtils.getUserId());
			i =tUserDriverPractitionersService.updateTUserDriverPractitioners(driverPractitioner);
			if(i==0) {
				return AjaxResult.error();
			}
		}
		//更新驾驶员其他信息表 数据
		TUserDriverOthers userDriverOthers =tUserDriverBasic.getUserDriverOthers();
		if(userDriverOthers!=null) {
			String uuidTemp1 = userDriverOthers.getId();
			userDriverOthers.setId(uuidTemp1);
			userDriverOthers.setUpdateTime(new Date());
			userDriverOthers.setUpdateUserId(ShiroUtils.getUserId());
			i =tUserDriverOthersService.insertTUserDriverOthers(userDriverOthers);
			if(i==0) {
				return AjaxResult.error();
			}
		}
		//向驾驶员驾驶信息表中新增数据
		TUserDriverInfo driverIno = tUserDriverBasic.getUserDriverInfo();
		if(driverIno!=null) {
			driverIno.setId(driverIno.getId());
			driverIno.setUpdateTime(new Date());
			driverIno.setUpdateUserId(ShiroUtils.getUserId());
			i=tUserDriverInfoService.insertTUserDriverInfo(driverIno);
			if(i==0) {
				return AjaxResult.error();
			}
		}
//		return tUserDriverBasicMapper.updateTUserDriverBasic(tUserDriverBasic);
		return AjaxResult.success();
	}

	/**
     * 删除驾驶员台账基础对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTUserDriverBasicByIds(String ids)
	{
		return tUserDriverBasicMapper.deleteTUserDriverBasicByIds(Convert.toStrArray(ids));
	}
	
	private boolean checkObj(Object obj) {
		if(obj ==null || "".equals(obj)) {
			return true;
		}
		return false;
	}
	
}
