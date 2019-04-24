package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.project.common.base.BaseEntity;
import java.util.Date;

/**
 * 车辆检测和评定登记表 t_car_testing_evaluate
 * 
 * @author rbf
 * @date 2019-04-23
 */
public class TCarTestingEvaluate extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 车辆ID */
	private String carId;
	/** 检测/评定类型 */
	private String testingType;
	/** 检测/评定单位 */
	private String testingUnit;
	/** 检测/评定日期 */
	private Date testingDate;
	/** 检测/评定有效期 */
	private Date testingValidity;
	/** 报告编号 */
	private String reportNumber;
	/** 备注 */
	private String remark;
	/** 附件url */
	private String fileUrl;
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
	public void setCarId(String carId) 
	{
		this.carId = carId;
	}

	public String getCarId() 
	{
		return carId;
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
	public void setTestingDate(Date testingDate) 
	{
		this.testingDate = testingDate;
	}

	public Date getTestingDate() 
	{
		return testingDate;
	}
	public void setTestingValidity(Date testingValidity) 
	{
		this.testingValidity = testingValidity;
	}

	public Date getTestingValidity() 
	{
		return testingValidity;
	}
	public void setReportNumber(String reportNumber) 
	{
		this.reportNumber = reportNumber;
	}

	public String getReportNumber() 
	{
		return reportNumber;
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
            .append("testingType", getTestingType())
            .append("testingUnit", getTestingUnit())
            .append("testingDate", getTestingDate())
            .append("testingValidity", getTestingValidity())
            .append("reportNumber", getReportNumber())
            .append("remark", getRemark())
            .append("fileUrl", getFileUrl())
            .append("addUserId", getAddUserId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
