package com.project.security.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.io.Serializable;
import java.util.Date;

/**
 * 企业管理表 t_business
 * 
 * @author rbf
 * @date 2019-04-30
 */
public class TBusiness implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 企业名称 */
	private String name;
	/** 企业地址 */
	private String addressId;
	/** 详细地址 */
	private String addressDetail;
	/** 企业类别 */
	private String businessType;
	/** 专业类别 */
	private String majorType;
	/** 联系人 */
	private String linknameId;
	/** 电话 */
	private String phone;
	/** 账号 */
	private String account;
	/** 账号id */
	private String accountId;
	/** 状态 */
	private String status;
	/** 是否开启识别1开启0未开启 */
	private String isVerify;
	/** 创建人id */
	private String addUserId;
	/** 创建时间 */
	private Date createDate;
	/** 修改时间 */
	private Date updateDate;
	/** 修改人id */
	private String updateUserId;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setAddressId(String addressId) 
	{
		this.addressId = addressId;
	}

	public String getAddressId() 
	{
		return addressId;
	}
	public void setAddressDetail(String addressDetail) 
	{
		this.addressDetail = addressDetail;
	}

	public String getAddressDetail() 
	{
		return addressDetail;
	}
	public void setBusinessType(String businessType) 
	{
		this.businessType = businessType;
	}

	public String getBusinessType() 
	{
		return businessType;
	}
	public void setMajorType(String majorType) 
	{
		this.majorType = majorType;
	}

	public String getMajorType() 
	{
		return majorType;
	}
	public void setLinknameId(String linknameId) 
	{
		this.linknameId = linknameId;
	}

	public String getLinknameId() 
	{
		return linknameId;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}
	public void setAccount(String account) 
	{
		this.account = account;
	}

	public String getAccount() 
	{
		return account;
	}
	public void setAccountId(String accountId) 
	{
		this.accountId = accountId;
	}

	public String getAccountId() 
	{
		return accountId;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setIsVerify(String isVerify) 
	{
		this.isVerify = isVerify;
	}

	public String getIsVerify() 
	{
		return isVerify;
	}
	public void setAddUserId(String addUserId) 
	{
		this.addUserId = addUserId;
	}

	public String getAddUserId() 
	{
		return addUserId;
	}
	public void setCreateDate(Date createDate) 
	{
		this.createDate = createDate;
	}

	public Date getCreateDate() 
	{
		return createDate;
	}
	public void setUpdateDate(Date updateDate) 
	{
		this.updateDate = updateDate;
	}

	public Date getUpdateDate() 
	{
		return updateDate;
	}
	public void setUpdateUserId(String updateUserId) 
	{
		this.updateUserId = updateUserId;
	}

	public String getUpdateUserId() 
	{
		return updateUserId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("addressId", getAddressId())
            .append("addressDetail", getAddressDetail())
            .append("businessType", getBusinessType())
            .append("majorType", getMajorType())
            .append("linknameId", getLinknameId())
            .append("phone", getPhone())
            .append("account", getAccount())
            .append("accountId", getAccountId())
            .append("status", getStatus())
            .append("isVerify", getIsVerify())
            .append("addUserId", getAddUserId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
