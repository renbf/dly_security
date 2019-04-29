package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * 劳动防护物品表 t_labour_goods
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TLabourGoods extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 发放日期 */
	private Date grantDate;
	/** 发放日期 */
	private Date grantDateEnd;
	/** 发放日期字符串 */
	private Date grantDateStr;
	/** 领取人 */
	private String receivePer;
	/** 领取人的user_id */
	private Long receiveUserId;
	/** 文件路径 */
	private String filePath;
	/** 备注(描述) */
	private String remark;
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
	//发放物品名称
	private String goodsName;
	
	private List<TLabourGoodsDetail> labourGoodDetailList;
	
	

	

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Date getGrantDateEnd() {
		return grantDateEnd;
	}

	public void setGrantDateEnd(Date grantDateEnd) {
		this.grantDateEnd = grantDateEnd;
	}

	public Date getGrantDateStr() {
		return grantDateStr;
	}

	public void setGrantDateStr(Date grantDateStr) {
		this.grantDateStr = grantDateStr;
	}

	public List<TLabourGoodsDetail> getLabourGoodDetailList() {
		return labourGoodDetailList;
	}

	public void setLabourGoodDetailList(List<TLabourGoodsDetail> labourGoodDetailList) {
		this.labourGoodDetailList = labourGoodDetailList;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setGrantDate(Date grantDate) 
	{
		this.grantDate = grantDate;
	}

	public Date getGrantDate() 
	{
		return grantDate;
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
	public void setFilePath(String filePath) 
	{
		this.filePath = filePath;
	}

	public String getFilePath() 
	{
		return filePath;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
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
            .append("grantDate", getGrantDate())
            .append("receivePer", getReceivePer())
            .append("receiveUserId", getReceiveUserId())
            .append("filePath", getFilePath())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}

