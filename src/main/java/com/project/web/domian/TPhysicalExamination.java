package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * 体检记录表 t_physical_examination
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TPhysicalExamination extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 体检时间 */
	private Date physicalDate;
	/** 体检时间 */
	private Date physicalDateEnd;
	/** 体检时间字符串 */
	private String physicalStr;
	/** 体检单位 */
	private String physicalUnit;
	/** 疑似病人数 */
	private String suspectedNum;
	/** 文件路径 */
	private String filePath;
	/** 备注(描述) */
	private String remark;
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
	
	private String physicalExaminationDetail1;
	/** 体检人user_id */
	private Long examinationUserId;
	
	
	private List<TPhysicalExaminationDetail> physicalExaminationDetail;
	
	
	

	public Long getExaminationUserId() {
		return examinationUserId;
	}

	public void setExaminationUserId(Long examinationUserId) {
		this.examinationUserId = examinationUserId;
	}

	//姓名
	private String userName;
	//性别
	private String sex;
	//手机号
	private String phone;
	//入职日期
	private String entryDateStr;
	
	
	

	public String getPhysicalExaminationDetail1() {
		return physicalExaminationDetail1;
	}

	public void setPhysicalExaminationDetail1(String physicalExaminationDetail1) {
		this.physicalExaminationDetail1 = physicalExaminationDetail1;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEntryDateStr() {
		return entryDateStr;
	}

	public void setEntryDateStr(String entryDateStr) {
		this.entryDateStr = entryDateStr;
	}

	public Date getPhysicalDateEnd() {
		return physicalDateEnd;
	}

	public void setPhysicalDateEnd(Date physicalDateEnd) {
		this.physicalDateEnd = physicalDateEnd;
	}

	public String getPhysicalStr() {
		return physicalStr;
	}

	public void setPhysicalStr(String physicalStr) {
		this.physicalStr = physicalStr;
	}

	public List<TPhysicalExaminationDetail> getPhysicalExaminationDetail() {
		return physicalExaminationDetail;
	}

	public void setPhysicalExaminationDetail(List<TPhysicalExaminationDetail> physicalExaminationDetail) {
		this.physicalExaminationDetail = physicalExaminationDetail;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setPhysicalDate(Date physicalDate) 
	{
		this.physicalDate = physicalDate;
	}

	public Date getPhysicalDate() 
	{
		return physicalDate;
	}
	public void setPhysicalUnit(String physicalUnit) 
	{
		this.physicalUnit = physicalUnit;
	}

	public String getPhysicalUnit() 
	{
		return physicalUnit;
	}
	public void setSuspectedNum(String suspectedNum) 
	{
		this.suspectedNum = suspectedNum;
	}

	public String getSuspectedNum() 
	{
		return suspectedNum;
	}
	public void setFilePath(String filePath) 
	{
		this.filePath = filePath;
	}

	public String getFilePath() 
	{
		return filePath;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
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
            .append("physicalDate", getPhysicalDate())
            .append("physicalUnit", getPhysicalUnit())
            .append("suspectedNum", getSuspectedNum())
            .append("filePath", getFilePath())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}

