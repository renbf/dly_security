package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 安全会议详细表 t_safety_meet_detail
 *
 * @author rbf
 * @date 2019-04-24
 */
public class TSafetyMeetDetail extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 主键ID */
	private String id;
	/** 安全会议表 主键id */
	private String meetId;
	/** 参与部门 */
	private Long participateDeptId;
	/** 参与岗位 */
	private Long participatePost;
	/** 参与人员 id */
	private Long participateUser;
	/** 创建日期 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;
	/** 创建人id */
	private Long userId;
	/** 备用字段 */
	private String meno;
	/** 企业ID */
	private String businessId;
	/** 修改人id */
	private Long updateUserId;

	public void setId(String id)
	{
		this.id = id;
	}

	public String getId()
	{
		return id;
	}
	public void setMeetId(String meetId)
	{
		this.meetId = meetId;
	}

	public String getMeetId()
	{
		return meetId;
	}
	public void setParticipateDeptId(Long participateDeptId)
	{
		this.participateDeptId = participateDeptId;
	}

	public Long getParticipateDeptId()
	{
		return participateDeptId;
	}
	public void setParticipatePost(Long participatePost)
	{
		this.participatePost = participatePost;
	}

	public Long getParticipatePost()
	{
		return participatePost;
	}
	public void setParticipateUser(Long participateUser)
	{
		this.participateUser = participateUser;
	}

	public Long getParticipateUser()
	{
		return participateUser;
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
	public void setMeno(String meno)
	{
		this.meno = meno;
	}

	public String getMeno()
	{
		return meno;
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
				.append("meetId", getMeetId())
				.append("participateDeptId", getParticipateDeptId())
				.append("participatePost", getParticipatePost())
				.append("participateUser", getParticipateUser())
				.append("createTime", getCreateTime())
				.append("updateTime", getUpdateTime())
				.append("userId", getUserId())
				.append("meno", getMeno())
				.append("businessId", getBusinessId())
				.append("updateUserId", getUpdateUserId())
				.toString();
	}
}
