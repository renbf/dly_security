package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 劳动防护物品明细表 t_labour_goods_detail
 * 
 * @author rbf
 * @date 2019-04-23
 */
public class TLabourGoodsDetail extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 劳动防护物品表主键id */
	private String labourGoodsId;
	/** 领取人 */
	private String receivePer;
	/** 领取人的user_id */
	private Long receiveUserId;
	/** 手机号 */
	private String phone;
	/** 入职日期 */
	private Date entryDate;
	//性别
	private String sex;

	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setLabourGoodsId(String labourGoodsId) 
	{
		this.labourGoodsId = labourGoodsId;
	}

	public String getLabourGoodsId() 
	{
		return labourGoodsId;
	}
	public void setReceivePer(String receivePer) 
	{
		this.receivePer = receivePer;
	}

	public String getReceivePer() 
	{
		return receivePer;
	}
	public void setReceiveUserId(Long receiveUserId) 
	{
		this.receiveUserId = receiveUserId;
	}

	public Long getReceiveUserId() 
	{
		return receiveUserId;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}
	public void setEntryDate(Date entryDate) 
	{
		this.entryDate = entryDate;
	}

	public Date getEntryDate() 
	{
		return entryDate;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("labourGoodsId", getLabourGoodsId())
            .append("receivePer", getReceivePer())
            .append("receiveUserId", getReceiveUserId())
            .append("phone", getPhone())
            .append("entryDate", getEntryDate())
            .toString();
    }
}
