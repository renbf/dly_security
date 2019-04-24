package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.project.common.base.BaseEntity;
import java.util.Date;

/**
 * 卫星定位表 t_car_satellite_position
 * 
 * @author rbf
 * @date 2019-04-23
 */
public class TCarSatellitePosition extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 车辆ID */
	private String carId;
	/** 时间 */
	private Date positionTime;
	/** 终端类型 */
	private String terminalType;
	/** 安装日期 */
	private Date setupDate;
	/** 接入系统 */
	private String system;
	/** 费用到期时间 */
	private Date endDate;
	/** 备注 */
	private String remark;
	/** 附件url */
	private String fileUrl;
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
	public void setPositionTime(Date positionTime) 
	{
		this.positionTime = positionTime;
	}

	public Date getPositionTime() 
	{
		return positionTime;
	}
	public void setTerminalType(String terminalType) 
	{
		this.terminalType = terminalType;
	}

	public String getTerminalType() 
	{
		return terminalType;
	}
	public void setSetupDate(Date setupDate) 
	{
		this.setupDate = setupDate;
	}

	public Date getSetupDate() 
	{
		return setupDate;
	}
	public void setSystem(String system) 
	{
		this.system = system;
	}

	public String getSystem() 
	{
		return system;
	}
	public void setEndDate(Date endDate) 
	{
		this.endDate = endDate;
	}

	public Date getEndDate() 
	{
		return endDate;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setFileUrl(String fileUrl) 
	{
		this.fileUrl = fileUrl;
	}

	public String getFileUrl() 
	{
		return fileUrl;
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
            .append("positionTime", getPositionTime())
            .append("terminalType", getTerminalType())
            .append("setupDate", getSetupDate())
            .append("system", getSystem())
            .append("endDate", getEndDate())
            .append("remark", getRemark())
            .append("fileUrl", getFileUrl())
            .append("addUserId", getAddUserId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
