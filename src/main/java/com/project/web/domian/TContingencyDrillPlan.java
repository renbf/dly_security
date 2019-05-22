package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

/**
 * 应急演练计划表 t_contingency_drill_plan
 * 
 * @author rbf
 * @date 2019-04-23
 */
public class TContingencyDrillPlan extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** #预案名称 */
	private String drillPlanName;
	/** ##预计演练时间 */
	private Date drillPlanDate;
	/** #预计演练地点 */
	private String drillPlanLocation;
	/** 部门ID */
	private Long deptId;
	/** 附件文件路径 */
	private String drillPlanFilePath;
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



	/** 用于查询的字段 */
	//预计演练时间的右侧
	private Date drillPlanDate1;

	/*时间返回强化*/
	//时间格式化的字符串   格式: yyyy-MM-dd
	private String drillPlanDateStr;


	public String getDrillPlanDateStr() {
		return drillPlanDateStr;
	}

	public TContingencyDrillPlan setDrillPlanDateStr(String drillPlanDateStr) {
		this.drillPlanDateStr = drillPlanDateStr;
		return this;
	}

	public Date getDrillPlanDate1() {
		return drillPlanDate1;
	}

	public TContingencyDrillPlan setDrillPlanDate1(Date drillPlanDate1) {
		this.drillPlanDate1 = drillPlanDate1;
		return this;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setDrillPlanName(String drillPlanName) 
	{
		this.drillPlanName = drillPlanName;
	}

	public String getDrillPlanName()
	{
		return drillPlanName;
	}

	public Date getDrillPlanDate() {
		return drillPlanDate;
	}

	public TContingencyDrillPlan setDrillPlanDate(Date drillPlanDate) {
		this.drillPlanDate = drillPlanDate;
		return this;
	}

	public void setDrillPlanLocation(String drillPlanLocation)
	{
		this.drillPlanLocation = drillPlanLocation;
	}

	public String getDrillPlanLocation() 
	{
		return drillPlanLocation;
	}
	
	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public void setDrillPlanFilePath(String drillPlanFilePath) 
	{
		this.drillPlanFilePath = drillPlanFilePath;
	}

	public String getDrillPlanFilePath() 
	{
		return drillPlanFilePath;
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
            .append("drillPlanName", getDrillPlanName())
            .append("drillPlanDate", getDrillPlanDate())
            .append("drillPlanLocation", getDrillPlanLocation())
            .append("deptId", getDeptId())
            .append("drillPlanFilePath", getDrillPlanFilePath())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
