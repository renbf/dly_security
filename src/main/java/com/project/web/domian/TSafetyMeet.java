package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 安全会议表 t_safety_meet
 * 
 * @author rbf
 * @date 2019-04-18
 */
public class TSafetyMeet extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 会议类型 */
	private String meetType;
	/** 会议名称 */
	private String meetName;
	/** 应到人数 */
	private Integer meetShouldNum;
	/** 实到人数 */
	private Integer meetActNum;
	/** 会议日期 */
	private Date meetDate;
	/** 会议地点 */
	private String meetPlace;
	/** 会议形式 */
	private String meetForm;
	/** 会议部门 */
	private String meetDeptId;
	/** 主持人 */
	private String hostPer;
	/** 标注 */
	private String tagging;
	/** 记录人 */
	private String noteTaker;
	/** 文件路径 */
	private String filePath;
	/** 会议内容 */
	private String meetInfo;
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
	public void setMeetType(String meetType) 
	{
		this.meetType = meetType;
	}

	public String getMeetType() 
	{
		return meetType;
	}
	public void setMeetName(String meetName) 
	{
		this.meetName = meetName;
	}

	public String getMeetName() 
	{
		return meetName;
	}
	public void setMeetShouldNum(Integer meetShouldNum) 
	{
		this.meetShouldNum = meetShouldNum;
	}

	public Integer getMeetShouldNum() 
	{
		return meetShouldNum;
	}
	public void setMeetActNum(Integer meetActNum) 
	{
		this.meetActNum = meetActNum;
	}

	public Integer getMeetActNum() 
	{
		return meetActNum;
	}
	public void setMeetDate(Date meetDate) 
	{
		this.meetDate = meetDate;
	}

	public Date getMeetDate() 
	{
		return meetDate;
	}
	public void setMeetPlace(String meetPlace) 
	{
		this.meetPlace = meetPlace;
	}

	public String getMeetPlace() 
	{
		return meetPlace;
	}
	public void setMeetForm(String meetForm) 
	{
		this.meetForm = meetForm;
	}

	public String getMeetForm() 
	{
		return meetForm;
	}
	public void setMeetDeptId(String meetDeptId) 
	{
		this.meetDeptId = meetDeptId;
	}

	public String getMeetDeptId() 
	{
		return meetDeptId;
	}
	public void setHostPer(String hostPer) 
	{
		this.hostPer = hostPer;
	}

	public String getHostPer() 
	{
		return hostPer;
	}
	public void setTagging(String tagging) 
	{
		this.tagging = tagging;
	}

	public String getTagging() 
	{
		return tagging;
	}
	public void setNoteTaker(String noteTaker) 
	{
		this.noteTaker = noteTaker;
	}

	public String getNoteTaker() 
	{
		return noteTaker;
	}
	public void setFilePath(String filePath) 
	{
		this.filePath = filePath;
	}

	public String getFilePath() 
	{
		return filePath;
	}
	public void setMeetInfo(String meetInfo) 
	{
		this.meetInfo = meetInfo;
	}

	public String getMeetInfo() 
	{
		return meetInfo;
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
            .append("meetType", getMeetType())
            .append("meetName", getMeetName())
            .append("meetShouldNum", getMeetShouldNum())
            .append("meetActNum", getMeetActNum())
            .append("meetDate", getMeetDate())
            .append("meetPlace", getMeetPlace())
            .append("meetForm", getMeetForm())
            .append("meetDeptId", getMeetDeptId())
            .append("hostPer", getHostPer())
            .append("tagging", getTagging())
            .append("noteTaker", getNoteTaker())
            .append("filePath", getFilePath())
            .append("meetInfo", getMeetInfo())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
