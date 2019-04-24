package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.project.common.base.BaseEntity;
import java.util.Date;

/**
 * 道路运输证变更表 t_road_transport_log
 * 
 * @author rbf
 * @date 2019-04-23
 */
public class TRoadTransportLog extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 业户名称 */
	private String ownerName;
	/** 道路运输证号 */
	private String roadTransportNumber;
	/** 有效期 */
	private String validityTerm;
	/** 经营范围 */
	private String businessScope;
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
	public void setOwnerName(String ownerName) 
	{
		this.ownerName = ownerName;
	}

	public String getOwnerName() 
	{
		return ownerName;
	}
	public void setRoadTransportNumber(String roadTransportNumber) 
	{
		this.roadTransportNumber = roadTransportNumber;
	}

	public String getRoadTransportNumber() 
	{
		return roadTransportNumber;
	}
	public void setValidityTerm(String validityTerm) 
	{
		this.validityTerm = validityTerm;
	}

	public String getValidityTerm() 
	{
		return validityTerm;
	}
	public void setBusinessScope(String businessScope) 
	{
		this.businessScope = businessScope;
	}

	public String getBusinessScope() 
	{
		return businessScope;
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
            .append("ownerName", getOwnerName())
            .append("roadTransportNumber", getRoadTransportNumber())
            .append("validityTerm", getValidityTerm())
            .append("businessScope", getBusinessScope())
            .append("startDate", getStartDate())
            .toString();
    }
}
