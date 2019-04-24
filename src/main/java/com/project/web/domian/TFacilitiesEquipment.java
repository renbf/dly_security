package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 设施设备表 t_facilities_equipment
 * 
 * @author rbf
 * @date 2019-04-18
 */
public class TFacilitiesEquipment extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 负责人 */
	private Long responsibleUserId;
	/** 负责人名称 */
	private Long responsibleUserName;
	/** 设备名称 */
	private String equipmentName;
	/** 规格型号 */
	private String equipmentType;
	/** 地址 */
	private String equipmentAddr;
	/** 状态 0:正常 1:维修中  2:报废 */
	private String equipmentStatus;
	/** 报废年限 */
	private Date scrapDate;
	/** 检查日期 */
	private Date checkDate;
	/** 使用等级附件 */
	private String filePath;
	/** 备注 */
	private String remark;
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
	//报废年限  字符串
	private String scrapDateStr;
	//检查日期字符串
	private String checkDateStr;
	/**
	 * 下次检验日期
	 * @param id
	 */
	private Date nextCheckDate;
	//下次检验日期字符串
	private Date nextCheckDateStr;
	//检验周期
	private String checkReq;
	
	
	
	public String getScrapDateStr() {
		return scrapDateStr;
	}

	public void setScrapDateStr(String scrapDateStr) {
		this.scrapDateStr = scrapDateStr;
	}

	public String getCheckDateStr() {
		return checkDateStr;
	}

	public void setCheckDateStr(String checkDateStr) {
		this.checkDateStr = checkDateStr;
	}

	public Date getNextCheckDate() {
		return nextCheckDate;
	}

	public void setNextCheckDate(Date nextCheckDate) {
		this.nextCheckDate = nextCheckDate;
	}

	public Date getNextCheckDateStr() {
		return nextCheckDateStr;
	}

	public void setNextCheckDateStr(Date nextCheckDateStr) {
		this.nextCheckDateStr = nextCheckDateStr;
	}

	public String getCheckReq() {
		return checkReq;
	}

	public void setCheckReq(String checkReq) {
		this.checkReq = checkReq;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public Long getResponsibleUserName() {
		return responsibleUserName;
	}

	public void setResponsibleUserName(Long responsibleUserName) {
		this.responsibleUserName = responsibleUserName;
	}

	public void setResponsibleUserId(Long responsibleUserId) 
	{
		this.responsibleUserId = responsibleUserId;
	}

	public Long getResponsibleUserId() 
	{
		return responsibleUserId;
	}
	public void setEquipmentName(String equipmentName) 
	{
		this.equipmentName = equipmentName;
	}

	public String getEquipmentName() 
	{
		return equipmentName;
	}
	public void setEquipmentType(String equipmentType) 
	{
		this.equipmentType = equipmentType;
	}

	public String getEquipmentType() 
	{
		return equipmentType;
	}
	public void setEquipmentAddr(String equipmentAddr) 
	{
		this.equipmentAddr = equipmentAddr;
	}

	public String getEquipmentAddr() 
	{
		return equipmentAddr;
	}
	public void setEquipmentStatus(String equipmentStatus) 
	{
		this.equipmentStatus = equipmentStatus;
	}

	public String getEquipmentStatus() 
	{
		return equipmentStatus;
	}
	public void setScrapDate(Date scrapDate) 
	{
		this.scrapDate = scrapDate;
	}

	public Date getScrapDate() 
	{
		return scrapDate;
	}
	public void setCheckDate(Date checkDate) 
	{
		this.checkDate = checkDate;
	}

	public Date getCheckDate() 
	{
		return checkDate;
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
            .append("responsibleUserId", getResponsibleUserId())
            .append("equipmentName", getEquipmentName())
            .append("equipmentType", getEquipmentType())
            .append("equipmentAddr", getEquipmentAddr())
            .append("equipmentStatus", getEquipmentStatus())
            .append("scrapDate", getScrapDate())
            .append("checkDate", getCheckDate())
            .append("filePath", getFilePath())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
