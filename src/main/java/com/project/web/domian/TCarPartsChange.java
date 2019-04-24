package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.project.common.base.BaseEntity;
import java.util.Date;

/**
 * 车辆主要部件更换登记表 t_car_parts_change
 * 
 * @author rbf
 * @date 2019-04-23
 */
public class TCarPartsChange extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 车辆ID */
	private String carId;
	/** 更换日期 */
	private Date changeDate;
	/** 部件名称 */
	private String partName;
	/** 规格型号 */
	private String model;
	/** 生产厂名称 */
	private String factoryName;
	/** 部件编号 */
	private String partNum;
	/** 维修单位 */
	private String repairUnit;
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
	public void setChangeDate(Date changeDate) 
	{
		this.changeDate = changeDate;
	}

	public Date getChangeDate() 
	{
		return changeDate;
	}
	public void setPartName(String partName) 
	{
		this.partName = partName;
	}

	public String getPartName() 
	{
		return partName;
	}
	public void setModel(String model) 
	{
		this.model = model;
	}

	public String getModel() 
	{
		return model;
	}
	public void setFactoryName(String factoryName) 
	{
		this.factoryName = factoryName;
	}

	public String getFactoryName() 
	{
		return factoryName;
	}
	public void setPartNum(String partNum) 
	{
		this.partNum = partNum;
	}

	public String getPartNum() 
	{
		return partNum;
	}
	public void setRepairUnit(String repairUnit) 
	{
		this.repairUnit = repairUnit;
	}

	public String getRepairUnit() 
	{
		return repairUnit;
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
            .append("changeDate", getChangeDate())
            .append("partName", getPartName())
            .append("model", getModel())
            .append("factoryName", getFactoryName())
            .append("partNum", getPartNum())
            .append("repairUnit", getRepairUnit())
            .append("addUserId", getAddUserId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
