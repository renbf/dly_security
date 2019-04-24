package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.project.common.base.BaseEntity;
import java.util.Date;

/**
 * 行车中检查事项表 t_driver_middle_log
 * 
 * @author rbf
 * @date 2019-04-23
 */
public class TDriverMiddleLog extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 行车日志ID */
	private String driverLogId;
	/** 填报日期 */
	private Date writeTime;
	/** 检查事项 */
	private String carCheckProject;
	/** 换驾休息地点 */
	private String changeAddress;
	/** 停车时间 */
	private Date stopCarTime;
	/** 发车时间 */
	private Date startCarTime;
	/** 故障处理 */
	private String troubleShooting;
	/** 行车照片 */
	private String drivingPhoto;
	/** 签名照片 */
	private String autograph;
	/** 备注 */
	private String remark;
	/** 创建人id */
	private String addUserId;
	/** 创建时间 */
	private Date createDate;
	/** 修改时间 */
	private Date updateDate;
	/** 修改人id */
	private String updateUserId;

	public void setDriverLogId(String driverLogId) 
	{
		this.driverLogId = driverLogId;
	}

	public String getDriverLogId() 
	{
		return driverLogId;
	}
	public void setWriteTime(Date writeTime) 
	{
		this.writeTime = writeTime;
	}

	public Date getWriteTime() 
	{
		return writeTime;
	}
	public void setCarCheckProject(String carCheckProject) 
	{
		this.carCheckProject = carCheckProject;
	}

	public String getCarCheckProject() 
	{
		return carCheckProject;
	}
	public void setChangeAddress(String changeAddress) 
	{
		this.changeAddress = changeAddress;
	}

	public String getChangeAddress() 
	{
		return changeAddress;
	}
	public void setStopCarTime(Date stopCarTime) 
	{
		this.stopCarTime = stopCarTime;
	}

	public Date getStopCarTime() 
	{
		return stopCarTime;
	}
	public void setStartCarTime(Date startCarTime) 
	{
		this.startCarTime = startCarTime;
	}

	public Date getStartCarTime() 
	{
		return startCarTime;
	}
	public void setTroubleShooting(String troubleShooting) 
	{
		this.troubleShooting = troubleShooting;
	}

	public String getTroubleShooting() 
	{
		return troubleShooting;
	}
	public void setDrivingPhoto(String drivingPhoto) 
	{
		this.drivingPhoto = drivingPhoto;
	}

	public String getDrivingPhoto() 
	{
		return drivingPhoto;
	}
	public void setAutograph(String autograph) 
	{
		this.autograph = autograph;
	}

	public String getAutograph() 
	{
		return autograph;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
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
            .append("driverLogId", getDriverLogId())
            .append("writeTime", getWriteTime())
            .append("carCheckProject", getCarCheckProject())
            .append("changeAddress", getChangeAddress())
            .append("stopCarTime", getStopCarTime())
            .append("startCarTime", getStartCarTime())
            .append("troubleShooting", getTroubleShooting())
            .append("drivingPhoto", getDrivingPhoto())
            .append("autograph", getAutograph())
            .append("remark", getRemark())
            .append("addUserId", getAddUserId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
