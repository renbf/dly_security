package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 驾驶员台账基础表 t_user_driver_basic
 * 
 * @author rbf
 * @date 2019-04-18
 */
public class TUserDriverBasic extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 对应sys_user表中的user_id值 */
	private Long driverUserId;
	/** 姓名 */
	private String driverName;
	/** 性别 0：男 1：女 */
	private String driverSex;
	/** 手机号码 */
	private String driverPhone;
	/** 是否在职  0:在职  1:离职 */
	private String isIncumbency;
	/** 邮箱地址 */
	private String driverEmail;
	/** 身份证号 */
	private String driverIdNum;
	/** 文化程度 */
	private String driverEducation;
	/** 出生日期 */
	private Date driverBirth;
	/** 地址 */
	private String driverAddr;
	/** 部门 */
	private Long driverDept;
	/** 岗位 */
	private Long driverPost;
	/** 入职日期 */
	private Date entryDate;
	/** 入职日期字符串 */
	private String entryDateStr;
	/** 创建日期 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;
	/** 创建人id */
	private Long userId;
	/** 备用字段 */
	private String meno;
	/** 企业ID */
	private String businessId;
	/** 修改人id */
	private Long updateUserId;
	/**
	 * 驾驶员信息表
	 */
	private TUserDriverInfo userDriverInfo;
	/**
	 * 驾驶员从业资格证表信息
	 * @param id
	 */
	private TUserDriverPractitioners userDriverPractitioners;
	/**驾驶员照片信息表
	 * 
	 * @param id
	 */
	private TUserDriverPhotos userDriverPhotos;
	/**
	 * 驾驶员其他信息表
	 * @param id
	 */
	private TUserDriverOthers userDriverOthers;
	
	
	
	
	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getEntryDateStr() {
		return entryDateStr;
	}

	public void setEntryDateStr(String entryDateStr) {
		this.entryDateStr = entryDateStr;
	}

	public TUserDriverInfo getUserDriverInfo() {
		return userDriverInfo;
	}

	public void setUserDriverInfo(TUserDriverInfo userDriverInfo) {
		this.userDriverInfo = userDriverInfo;
	}

	public TUserDriverPractitioners getUserDriverPractitioners() {
		return userDriverPractitioners;
	}

	public void setUserDriverPractitioners(TUserDriverPractitioners userDriverPractitioners) {
		this.userDriverPractitioners = userDriverPractitioners;
	}

	public TUserDriverPhotos getUserDriverPhotos() {
		return userDriverPhotos;
	}

	public void setUserDriverPhotos(TUserDriverPhotos userDriverPhotos) {
		this.userDriverPhotos = userDriverPhotos;
	}

	public TUserDriverOthers getUserDriverOthers() {
		return userDriverOthers;
	}

	public void setUserDriverOthers(TUserDriverOthers userDriverOthers) {
		this.userDriverOthers = userDriverOthers;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setDriverUserId(Long driverUserId) 
	{
		this.driverUserId = driverUserId;
	}

	public Long getDriverUserId() 
	{
		return driverUserId;
	}
	public void setDriverName(String driverName) 
	{
		this.driverName = driverName;
	}

	public String getDriverName() 
	{
		return driverName;
	}
	public void setDriverSex(String driverSex) 
	{
		this.driverSex = driverSex;
	}

	public String getDriverSex() 
	{
		return driverSex;
	}
	public void setDriverPhone(String driverPhone) 
	{
		this.driverPhone = driverPhone;
	}

	public String getDriverPhone() 
	{
		return driverPhone;
	}
	public void setIsIncumbency(String isIncumbency) 
	{
		this.isIncumbency = isIncumbency;
	}

	public String getIsIncumbency() 
	{
		return isIncumbency;
	}
	public void setDriverEmail(String driverEmail) 
	{
		this.driverEmail = driverEmail;
	}

	public String getDriverEmail() 
	{
		return driverEmail;
	}
	public void setDriverIdNum(String driverIdNum) 
	{
		this.driverIdNum = driverIdNum;
	}

	public String getDriverIdNum() 
	{
		return driverIdNum;
	}
	public void setDriverEducation(String driverEducation) 
	{
		this.driverEducation = driverEducation;
	}

	public String getDriverEducation() 
	{
		return driverEducation;
	}
	public void setDriverBirth(Date driverBirth) 
	{
		this.driverBirth = driverBirth;
	}

	public Date getDriverBirth() 
	{
		return driverBirth;
	}
	public void setDriverAddr(String driverAddr) 
	{
		this.driverAddr = driverAddr;
	}

	public String getDriverAddr() 
	{
		return driverAddr;
	}

	public Long getDriverDept() {
		return driverDept;
	}

	public void setDriverDept(Long driverDept) {
		this.driverDept = driverDept;
	}

	public Long getDriverPost() {
		return driverPost;
	}

	public void setDriverPost(Long driverPost) {
		this.driverPost = driverPost;
	}

	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	public Long getUserId() 
	{
		return userId;
	}
	public void setMeno(String meno) 
	{
		this.meno = meno;
	}

	public String getMeno() 
	{
		return meno;
	}
	public void setBusinessId(String businessId) 
	{
		this.businessId = businessId;
	}

	public String getBusinessId() 
	{
		return businessId;
	}
	public void setUpdateUserId(Long updateUserId) 
	{
		this.updateUserId = updateUserId;
	}

	public Long getUpdateUserId() 
	{
		return updateUserId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("driverUserId", getDriverUserId())
            .append("driverName", getDriverName())
            .append("driverSex", getDriverSex())
            .append("driverPhone", getDriverPhone())
            .append("isIncumbency", getIsIncumbency())
            .append("driverEmail", getDriverEmail())
            .append("driverIdNum", getDriverIdNum())
            .append("driverEducation", getDriverEducation())
            .append("driverBirth", getDriverBirth())
            .append("driverAddr", getDriverAddr())
            .append("driverDept", getDriverDept())
            .append("driverPost", getDriverPost())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
