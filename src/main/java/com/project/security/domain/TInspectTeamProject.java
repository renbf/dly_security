package com.project.security.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.io.Serializable;

/**
 * 检查计划和检查项关系表 t_inspect_team_project
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TInspectTeamProject implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 检查计划ID */
	private String inspectPlanId;
	/** 检查项目id */
	private String checkTeamId;
	/** 检查项id */
	private String checkProjectId;
	/** 检查结果1通过0未通过 */
	private String isOk;

	public void setInspectPlanId(String inspectPlanId) 
	{
		this.inspectPlanId = inspectPlanId;
	}

	public String getInspectPlanId() 
	{
		return inspectPlanId;
	}
	public void setCheckTeamId(String checkTeamId) 
	{
		this.checkTeamId = checkTeamId;
	}

	public String getCheckTeamId() 
	{
		return checkTeamId;
	}
	public void setCheckProjectId(String checkProjectId) 
	{
		this.checkProjectId = checkProjectId;
	}

	public String getCheckProjectId() 
	{
		return checkProjectId;
	}
	public void setIsOk(String isOk) 
	{
		this.isOk = isOk;
	}

	public String getIsOk() 
	{
		return isOk;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("inspectPlanId", getInspectPlanId())
            .append("checkTeamId", getCheckTeamId())
            .append("checkProjectId", getCheckProjectId())
            .append("isOk", getIsOk())
            .toString();
    }
}
