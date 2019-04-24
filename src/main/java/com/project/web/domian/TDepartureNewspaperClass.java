package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 车辆报班表 t_departure_newspaper_class
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TDepartureNewspaperClass extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 班次日期 */
	private Date shiftsDate;
	/** 班次号 */
	private String shiftsNum;
	/** 班次类型 */
	private String shiftsType;
	/** 驾驶员 */
	private String driver;
	/** 线路名称 */
	private String lineName;
	/** 报班时间 */
	private Date newspaperClassDate;
	/** 报班人 */
	private String newspaperClassPer;
	/** 最后一次同步时间 */
	private Date lastDate;
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
	public void setShiftsDate(Date shiftsDate) 
	{
		this.shiftsDate = shiftsDate;
	}

	public Date getShiftsDate() 
	{
		return shiftsDate;
	}
	public void setShiftsNum(String shiftsNum) 
	{
		this.shiftsNum = shiftsNum;
	}

	public String getShiftsNum() 
	{
		return shiftsNum;
	}
	public void setShiftsType(String shiftsType) 
	{
		this.shiftsType = shiftsType;
	}

	public String getShiftsType() 
	{
		return shiftsType;
	}
	public void setDriver(String driver) 
	{
		this.driver = driver;
	}

	public String getDriver() 
	{
		return driver;
	}
	public void setLineName(String lineName) 
	{
		this.lineName = lineName;
	}

	public String getLineName() 
	{
		return lineName;
	}
	public void setNewspaperClassDate(Date newspaperClassDate) 
	{
		this.newspaperClassDate = newspaperClassDate;
	}

	public Date getNewspaperClassDate() 
	{
		return newspaperClassDate;
	}
	public void setNewspaperClassPer(String newspaperClassPer) 
	{
		this.newspaperClassPer = newspaperClassPer;
	}

	public String getNewspaperClassPer() 
	{
		return newspaperClassPer;
	}
	public void setLastDate(Date lastDate) 
	{
		this.lastDate = lastDate;
	}

	public Date getLastDate() 
	{
		return lastDate;
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
            .append("shiftsDate", getShiftsDate())
            .append("shiftsNum", getShiftsNum())
            .append("shiftsType", getShiftsType())
            .append("driver", getDriver())
            .append("lineName", getLineName())
            .append("newspaperClassDate", getNewspaperClassDate())
            .append("newspaperClassPer", getNewspaperClassPer())
            .append("lastDate", getLastDate())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
