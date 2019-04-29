package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 人员台账表 t_users_management
 * 
 * @author rbf
 * @date 2019-04-18
 */
public class TUsersManagement extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 对应sys_user表中的user_id值 */
	private Long managementUserId;
	/** 姓名 */
	private String managementName;
	/** 性别 0：男 1：女 */
	private String managementSex;
	/** 手机号码 */
	private String managementPhone;
	/** 是否在职  0:在职  1:离职 */
	private String isIncumbency;
	/** 邮箱地址 */
	private String managementEmail;
	/** 身份证号 */
	private String managementIdNum;
	/** 文化程度 */
	private String managementEducation;
	/** 出生日期 */
	private Date managementBirth;
	/** 入职日期 */
	private Date entryDate;
	/** 入职日期字符串 */
	private String entryDateStr;
	/** 地址 */
	private String managementAddr;
	/** 部门 */
	private Long managementDeptId;
	/** 岗位 */
	private Long managementPost;
	/** 工号 */
	private String managementNum;
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

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	
	public void setManagementUserId(Long managementUserId) 
	{
		this.managementUserId = managementUserId;
	}

	public Long getManagementUserId() 
	{
		return managementUserId;
	}
	public void setManagementName(String managementName) 
	{
		this.managementName = managementName;
	}

	public String getManagementName() 
	{
		return managementName;
	}
	public void setManagementSex(String managementSex) 
	{
		this.managementSex = managementSex;
	}

	public String getManagementSex() 
	{
		return managementSex;
	}
	public void setManagementPhone(String managementPhone) 
	{
		this.managementPhone = managementPhone;
	}

	public String getManagementPhone() 
	{
		return managementPhone;
	}
	public void setIsIncumbency(String isIncumbency) 
	{
		this.isIncumbency = isIncumbency;
	}

	public String getIsIncumbency() 
	{
		return isIncumbency;
	}
	public void setManagementEmail(String managementEmail) 
	{
		this.managementEmail = managementEmail;
	}

	public String getManagementEmail() 
	{
		return managementEmail;
	}
	public void setManagementIdNum(String managementIdNum) 
	{
		this.managementIdNum = managementIdNum;
	}

	public String getManagementIdNum() 
	{
		return managementIdNum;
	}
	public void setManagementEducation(String managementEducation) 
	{
		this.managementEducation = managementEducation;
	}

	public String getManagementEducation() 
	{
		return managementEducation;
	}
	public void setManagementBirth(Date managementBirth) 
	{
		this.managementBirth = managementBirth;
	}

	public Date getManagementBirth() 
	{
		return managementBirth;
	}
	public void setManagementAddr(String managementAddr) 
	{
		this.managementAddr = managementAddr;
	}

	public String getManagementAddr() 
	{
		return managementAddr;
	}

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

	public Long getManagementDeptId() {
		return managementDeptId;
	}

	public void setManagementDeptId(Long managementDeptId) {
		this.managementDeptId = managementDeptId;
	}

	public Long getManagementPost() {
		return managementPost;
	}

	public void setManagementPost(Long managementPost) {
		this.managementPost = managementPost;
	}

	public void setManagementNum(String managementNum) 
	{
		this.managementNum = managementNum;
	}

	public String getManagementNum() 
	{
		return managementNum;
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
            .append("managementUserId", getManagementUserId())
            .append("managementName", getManagementName())
            .append("managementSex", getManagementSex())
            .append("managementPhone", getManagementPhone())
            .append("isIncumbency", getIsIncumbency())
            .append("managementEmail", getManagementEmail())
            .append("managementIdNum", getManagementIdNum())
            .append("managementEducation", getManagementEducation())
            .append("managementBirth", getManagementBirth())
            .append("managementAddr", getManagementAddr())
            .append("managementDeptId", getManagementDeptId())
            .append("managementPost", getManagementPost())
            .append("managementNum", getManagementNum())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}

