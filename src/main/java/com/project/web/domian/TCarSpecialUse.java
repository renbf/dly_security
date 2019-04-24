package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.project.common.base.BaseEntity;
import java.util.Date;

/**
 * 压力容器和罐式专用车辆的罐体检测报告表 t_car_special_use
 * 
 * @author rbf
 * @date 2019-04-23
 */
public class TCarSpecialUse extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 车辆ID */
	private String carId;
	/** 检验有效期 */
	private Date validityDate;
	/** 设备名称 */
	private String deviceName;
	/** 设备品种 */
	private String deviceType;
	/** 设备代码 */
	private String deviceCode;
	/** 检测类型 */
	private String testingType;
	/** 检验单位 */
	private String testingUnit;
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
	public void setValidityDate(Date validityDate) 
	{
		this.validityDate = validityDate;
	}

	public Date getValidityDate() 
	{
		return validityDate;
	}
	public void setDeviceName(String deviceName) 
	{
		this.deviceName = deviceName;
	}

	public String getDeviceName() 
	{
		return deviceName;
	}
	public void setDeviceType(String deviceType) 
	{
		this.deviceType = deviceType;
	}

	public String getDeviceType() 
	{
		return deviceType;
	}
	public void setDeviceCode(String deviceCode) 
	{
		this.deviceCode = deviceCode;
	}

	public String getDeviceCode() 
	{
		return deviceCode;
	}
	public void setTestingType(String testingType) 
	{
		this.testingType = testingType;
	}

	public String getTestingType() 
	{
		return testingType;
	}
	public void setTestingUnit(String testingUnit) 
	{
		this.testingUnit = testingUnit;
	}

	public String getTestingUnit() 
	{
		return testingUnit;
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
            .append("validityDate", getValidityDate())
            .append("deviceName", getDeviceName())
            .append("deviceType", getDeviceType())
            .append("deviceCode", getDeviceCode())
            .append("testingType", getTestingType())
            .append("testingUnit", getTestingUnit())
            .append("remark", getRemark())
            .append("fileUrl", getFileUrl())
            .append("addUserId", getAddUserId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
