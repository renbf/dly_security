package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 法律法规表 t_legal_provisions
 * 
 * @author rbf
 * @date 2019-04-18
 */
public class TLegalProvisions extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 法规名称 */
	private String legalName;
	/**
	 * 法规标准号
	 */
	private String legalCode;
	/** 类型 */
	private String legalType;
	/** 颁发单位 */
	private String legalUnit;
	/** 实时日期 */
	private Date legalDate;
	/** 实时日期 */
	private Date legalDateEnd;
	/** 实时日期字符串 */
	private String legalDateStr;
	/** 适用部门 */
	private Long legalDeptId;
	/** 合规性评价 */
	private String legalEvaluate;
	/** 文件路径 */
	private String legalFilePath;
	/** 是否适用 1:适用 0:不适用 */
	private String isApply;
	/** 创建日期 */
	private Date createTime;
	/** 创建日期 */
	private Date createTimeEnd;
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
	private String deptName;
	

	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public void setId(String id) 
	{
		this.id = id;
	}

	
	public String getIsApply() {
		return isApply;
	}


	public void setIsApply(String isApply) {
		this.isApply = isApply;
	}


	public String getLegalCode() {
		return legalCode;
	}


	public void setLegalCode(String legalCode) {
		this.legalCode = legalCode;
	}


	public Date getLegalDateEnd() {
		return legalDateEnd;
	}

	public void setLegalDateEnd(Date legalDateEnd) {
		this.legalDateEnd = legalDateEnd;
	}

	public String getLegalDateStr() {
		return legalDateStr;
	}

	public void setLegalDateStr(String legalDateStr) {
		this.legalDateStr = legalDateStr;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public String getId() 
	{
		return id;
	}
	public void setLegalName(String legalName) 
	{
		this.legalName = legalName;
	}

	public String getLegalName() 
	{
		return legalName;
	}
	public void setLegalType(String legalType) 
	{
		this.legalType = legalType;
	}

	public String getLegalType() 
	{
		return legalType;
	}
	public void setLegalUnit(String legalUnit) 
	{
		this.legalUnit = legalUnit;
	}

	public String getLegalUnit() 
	{
		return legalUnit;
	}
	public void setLegalDate(Date legalDate) 
	{
		this.legalDate = legalDate;
	}

	public Date getLegalDate() 
	{
		return legalDate;
	}
	
	public Long getLegalDeptId() {
		return legalDeptId;
	}

	public void setLegalDeptId(Long legalDeptId) {
		this.legalDeptId = legalDeptId;
	}

	public void setLegalEvaluate(String legalEvaluate) 
	{
		this.legalEvaluate = legalEvaluate;
	}

	public String getLegalEvaluate() 
	{
		return legalEvaluate;
	}
	public void setLegalFilePath(String legalFilePath) 
	{
		this.legalFilePath = legalFilePath;
	}

	public String getLegalFilePath() 
	{
		return legalFilePath;
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
            .append("legalName", getLegalName())
            .append("legalType", getLegalType())
            .append("legalUnit", getLegalUnit())
            .append("legalDate", getLegalDate())
            .append("legalDeptId", getLegalDeptId())
            .append("legalEvaluate", getLegalEvaluate())
            .append("legalFilePath", getLegalFilePath())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
