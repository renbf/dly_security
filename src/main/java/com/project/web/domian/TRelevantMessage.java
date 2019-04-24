package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 相关方表 t_relevant_message
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TRelevantMessage extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 类别 */
	private String relevantType;
	/** 编码 */
	private String relevantCode;
	/** 名称 */
	private String relevantName;
	/** 联系人 */
	private String relevantContacts;
	/** 联系电话 */
	private String relevantPhone;
	/** 传真 */
	private String relevantFax;
	/** 地址 */
	private String relevantAddress;
	/** 备注 */
	private String relevantRemark;
	/** 评价 */
	private String relevantEvaluate;
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

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setRelevantType(String relevantType) 
	{
		this.relevantType = relevantType;
	}

	public String getRelevantType() 
	{
		return relevantType;
	}
	public void setRelevantCode(String relevantCode) 
	{
		this.relevantCode = relevantCode;
	}

	public String getRelevantCode() 
	{
		return relevantCode;
	}
	public void setRelevantName(String relevantName) 
	{
		this.relevantName = relevantName;
	}

	public String getRelevantName() 
	{
		return relevantName;
	}
	public void setRelevantContacts(String relevantContacts) 
	{
		this.relevantContacts = relevantContacts;
	}

	public String getRelevantContacts() 
	{
		return relevantContacts;
	}
	public void setRelevantPhone(String relevantPhone) 
	{
		this.relevantPhone = relevantPhone;
	}

	public String getRelevantPhone() 
	{
		return relevantPhone;
	}
	public void setRelevantFax(String relevantFax) 
	{
		this.relevantFax = relevantFax;
	}

	public String getRelevantFax() 
	{
		return relevantFax;
	}
	public void setRelevantAddress(String relevantAddress) 
	{
		this.relevantAddress = relevantAddress;
	}

	public String getRelevantAddress() 
	{
		return relevantAddress;
	}
	public void setRelevantRemark(String relevantRemark) 
	{
		this.relevantRemark = relevantRemark;
	}

	public String getRelevantRemark() 
	{
		return relevantRemark;
	}
	public void setRelevantEvaluate(String relevantEvaluate) 
	{
		this.relevantEvaluate = relevantEvaluate;
	}

	public String getRelevantEvaluate() 
	{
		return relevantEvaluate;
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
            .append("relevantType", getRelevantType())
            .append("relevantCode", getRelevantCode())
            .append("relevantName", getRelevantName())
            .append("relevantContacts", getRelevantContacts())
            .append("relevantPhone", getRelevantPhone())
            .append("relevantFax", getRelevantFax())
            .append("relevantAddress", getRelevantAddress())
            .append("relevantRemark", getRelevantRemark())
            .append("relevantEvaluate", getRelevantEvaluate())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
