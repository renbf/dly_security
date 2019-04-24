package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.project.common.base.BaseEntity;
import java.util.Date;

/**
 * 车辆维护和修理登记表 t_car_repair
 * 
 * @author rbf
 * @date 2019-04-23
 */
public class TCarRepair extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 车辆ID */
	private String carId;
	/** 维修日期 */
	private Date repairDate;
	/** 累计行驶里程(KM) */
	private String totalKm;
	/** 维修类别 */
	private String repairType;
	/** 合格证编号 */
	private String certificateNum;
	/** 维修内容 */
	private String repairContent;
	/** 维修单位 */
	private String repairUnit;
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
	public void setRepairDate(Date repairDate) 
	{
		this.repairDate = repairDate;
	}

	public Date getRepairDate() 
	{
		return repairDate;
	}
	public void setTotalKm(String totalKm) 
	{
		this.totalKm = totalKm;
	}

	public String getTotalKm() 
	{
		return totalKm;
	}
	public void setRepairType(String repairType) 
	{
		this.repairType = repairType;
	}

	public String getRepairType() 
	{
		return repairType;
	}
	public void setCertificateNum(String certificateNum) 
	{
		this.certificateNum = certificateNum;
	}

	public String getCertificateNum() 
	{
		return certificateNum;
	}
	public void setRepairContent(String repairContent) 
	{
		this.repairContent = repairContent;
	}

	public String getRepairContent() 
	{
		return repairContent;
	}
	public void setRepairUnit(String repairUnit) 
	{
		this.repairUnit = repairUnit;
	}

	public String getRepairUnit() 
	{
		return repairUnit;
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
            .append("repairDate", getRepairDate())
            .append("totalKm", getTotalKm())
            .append("repairType", getRepairType())
            .append("certificateNum", getCertificateNum())
            .append("repairContent", getRepairContent())
            .append("repairUnit", getRepairUnit())
            .append("remark", getRemark())
            .append("fileUrl", getFileUrl())
            .append("addUserId", getAddUserId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
