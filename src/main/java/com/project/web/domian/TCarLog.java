package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.project.common.base.BaseEntity;
import java.util.Date;

/**
 * 车牌号牌变更表 t_car_log
 * 
 * @author rbf
 * @date 2019-04-23
 */
public class TCarLog extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 车牌号码 */
	private String carNumber;
	/** 颜色 */
	private String color;
	/** 注册(变更)日期 */
	private Date updateDate;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setCarNumber(String carNumber) 
	{
		this.carNumber = carNumber;
	}

	public String getCarNumber() 
	{
		return carNumber;
	}
	public void setColor(String color) 
	{
		this.color = color;
	}

	public String getColor() 
	{
		return color;
	}
	public void setUpdateDate(Date updateDate) 
	{
		this.updateDate = updateDate;
	}

	public Date getUpdateDate() 
	{
		return updateDate;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("carNumber", getCarNumber())
            .append("color", getColor())
            .append("updateDate", getUpdateDate())
            .toString();
    }
}
