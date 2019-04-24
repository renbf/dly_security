package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 安全费用台账表 t_safety_fee_account
 * 
 * @author rbf
 * @date 2019-04-18
 */
public class TSafetyFeeAccount extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 投入类型 */
	private String investmentType;
	/** 经办人 */
	private String chargePerson;
	/** 使用日期 */
	private Date useDate;
	/** 金额 */
	private Long amt;
	/** 投入部门id */
	private String investmentDeptId;
	/** 用途 */
	private String feePurpose;
	/** 部门id */
	private String deptId;
	/** 记录人 */
	private String noteTaker;
	/** 文件路径 */
	private String feeFilePath;
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
	public void setInvestmentType(String investmentType) 
	{
		this.investmentType = investmentType;
	}

	public String getInvestmentType() 
	{
		return investmentType;
	}
	public void setChargePerson(String chargePerson) 
	{
		this.chargePerson = chargePerson;
	}

	public String getChargePerson() 
	{
		return chargePerson;
	}
	public void setUseDate(Date useDate) 
	{
		this.useDate = useDate;
	}

	public Date getUseDate() 
	{
		return useDate;
	}
	public void setAmt(Long amt) 
	{
		this.amt = amt;
	}

	public Long getAmt() 
	{
		return amt;
	}
	public void setInvestmentDeptId(String investmentDeptId) 
	{
		this.investmentDeptId = investmentDeptId;
	}

	public String getInvestmentDeptId() 
	{
		return investmentDeptId;
	}
	public void setFeePurpose(String feePurpose) 
	{
		this.feePurpose = feePurpose;
	}

	public String getFeePurpose() 
	{
		return feePurpose;
	}
	public void setDeptId(String deptId) 
	{
		this.deptId = deptId;
	}

	public String getDeptId() 
	{
		return deptId;
	}
	public void setNoteTaker(String noteTaker) 
	{
		this.noteTaker = noteTaker;
	}

	public String getNoteTaker() 
	{
		return noteTaker;
	}
	public void setFeeFilePath(String feeFilePath) 
	{
		this.feeFilePath = feeFilePath;
	}

	public String getFeeFilePath() 
	{
		return feeFilePath;
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
            .append("investmentType", getInvestmentType())
            .append("chargePerson", getChargePerson())
            .append("useDate", getUseDate())
            .append("amt", getAmt())
            .append("investmentDeptId", getInvestmentDeptId())
            .append("feePurpose", getFeePurpose())
            .append("deptId", getDeptId())
            .append("noteTaker", getNoteTaker())
            .append("feeFilePath", getFeeFilePath())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
