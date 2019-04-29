package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 岗位表 sys_post
 * 
 * @author rbf
 * @date 2019-04-23
 */
public class Post extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 岗位ID */
	private Long postId;
	/** 岗位编码 */
	private String postCode;
	/** 岗位名称 */
	private String postName;
	/** 显示顺序 */
	private Integer postSort;
	/** 状态（0正常 1停用） */
	private String status;
	/** 创建者 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 创建时间 */
	private Date createTimeEnd;
	/** 更新者 */
	private String updateBy;
	/** 更新时间 */
	private Date updateTime;
	/** 部门ID */
	private Long deptId;
	/** 备注 */
	private String remark;
	//部门名称
	private String deptName;
	//企业ID
	private String businessId;
	
	

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public void setPostId(Long postId) 
	{
		this.postId = postId;
	}

	public Long getPostId() 
	{
		return postId;
	}
	public void setPostCode(String postCode) 
	{
		this.postCode = postCode;
	}

	public String getPostCode() 
	{
		return postCode;
	}
	public void setPostName(String postName) 
	{
		this.postName = postName;
	}

	public String getPostName() 
	{
		return postName;
	}
	public void setPostSort(Integer postSort) 
	{
		this.postSort = postSort;
	}

	public Integer getPostSort() 
	{
		return postSort;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setDeptId(Long deptId) 
	{
		this.deptId = deptId;
	}

	public Long getDeptId() 
	{
		return deptId;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("postId", getPostId())
            .append("postCode", getPostCode())
            .append("postName", getPostName())
            .append("postSort", getPostSort())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("deptId", getDeptId())
            .append("remark", getRemark())
            .toString();
    }
}
