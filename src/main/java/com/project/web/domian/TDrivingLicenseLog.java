package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.project.common.base.BaseEntity;
import java.util.Date;

/**
 * 行驶证变更表 t_driving_license_log
 * 
 * @author rbf
 * @date 2019-04-23
 */
public class TDrivingLicenseLog extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 行驶证号 */
	private String travelNumber;
	/** 有效期 */
	private String validityTerm;
	/** 证件附件 */
	private String attachmentUrl;
	/** 发证日期 */
	private Date startDate;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setTravelNumber(String travelNumber) 
	{
		this.travelNumber = travelNumber;
	}

	public String getTravelNumber() 
	{
		return travelNumber;
	}
	public void setValidityTerm(String validityTerm) 
	{
		this.validityTerm = validityTerm;
	}

	public String getValidityTerm() 
	{
		return validityTerm;
	}
	public void setAttachmentUrl(String attachmentUrl) 
	{
		this.attachmentUrl = attachmentUrl;
	}

	public String getAttachmentUrl() 
	{
		return attachmentUrl;
	}
	public void setStartDate(Date startDate) 
	{
		this.startDate = startDate;
	}

	public Date getStartDate() 
	{
		return startDate;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("travelNumber", getTravelNumber())
            .append("validityTerm", getValidityTerm())
            .append("attachmentUrl", getAttachmentUrl())
            .append("startDate", getStartDate())
            .toString();
    }
}
