package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 体检记录明细表 t_physical_examination_detail
 * 
 * @author rbf
 * @date 2019-04-18
 */
public class TPhysicalExaminationDetail extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 体检记录表 主键id */
	private String examinationId;
	/** 体检人user_id */
	private Long examinationUserId;
	/** 创建日期 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;
	/** 创建人ID */
	private Long userId;
	/** 企业ID */
	private String businessId;
	/** 修改人id */
	private Long updateUserId;
	//姓名
	private String managementName;
	//性别
	private String managementSex;
	//手机号
	private String managementPhone;
	//入职日期
	private String entryDateStr;
	
	private String managementUserId;
	


	public String getManagementUserId() {
		return managementUserId;
	}

	public void setManagementUserId(String managementUserId) {
		this.managementUserId = managementUserId;
	}

	public String getManagementName() {
		return managementName;
	}

	public void setManagementName(String managementName) {
		this.managementName = managementName;
	}

	public String getManagementSex() {
		return managementSex;
	}

	public void setManagementSex(String managementSex) {
		this.managementSex = managementSex;
	}

	public String getManagementPhone() {
		return managementPhone;
	}

	public void setManagementPhone(String managementPhone) {
		this.managementPhone = managementPhone;
	}

	public String getEntryDateStr() {
		return entryDateStr;
	}

	public void setEntryDateStr(String entryDateStr) {
		this.entryDateStr = entryDateStr;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}

	public String getExaminationId() {
		return examinationId;
	}

	public void setExaminationId(String examinationId) {
		this.examinationId = examinationId;
	}

	public void setExaminationUserId(Long examinationUserId) 
	{
		this.examinationUserId = examinationUserId;
	}

	public Long getExaminationUserId() 
	{
		return examinationUserId;
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
            .append("examinationId", getExaminationId())
            .append("examinationUserId", getExaminationUserId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
