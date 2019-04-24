package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.project.common.base.BaseEntity;
import java.util.Date;

/**
 * 车辆机损事故登记表 t_car_trouble
 * 
 * @author rbf
 * @date 2019-04-23
 */
public class TCarTrouble extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 车辆ID */
	private String carId;
	/** 事故时间 */
	private Date troubleDate;
	/** 事故地点 */
	private String troubleAddress;
	/** 事故性质 */
	private String troubleType;
	/** 事故责任 */
	private String troubleDuty;
	/** 车辆损坏情况 */
	private String lossSituation;
	/** 登记人员id */
	private String addUserId;
	/** 登记日期 */
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
	public void setCarId(String carId) 
	{
		this.carId = carId;
	}

	public String getCarId() 
	{
		return carId;
	}
	public void setTroubleDate(Date troubleDate) 
	{
		this.troubleDate = troubleDate;
	}

	public Date getTroubleDate() 
	{
		return troubleDate;
	}
	public void setTroubleAddress(String troubleAddress) 
	{
		this.troubleAddress = troubleAddress;
	}

	public String getTroubleAddress() 
	{
		return troubleAddress;
	}
	public void setTroubleType(String troubleType) 
	{
		this.troubleType = troubleType;
	}

	public String getTroubleType() 
	{
		return troubleType;
	}
	public void setTroubleDuty(String troubleDuty) 
	{
		this.troubleDuty = troubleDuty;
	}

	public String getTroubleDuty() 
	{
		return troubleDuty;
	}
	public void setLossSituation(String lossSituation) 
	{
		this.lossSituation = lossSituation;
	}

	public String getLossSituation() 
	{
		return lossSituation;
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
            .append("carId", getCarId())
            .append("troubleDate", getTroubleDate())
            .append("troubleAddress", getTroubleAddress())
            .append("troubleType", getTroubleType())
            .append("troubleDuty", getTroubleDuty())
            .append("lossSituation", getLossSituation())
            .append("addUserId", getAddUserId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
