package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.project.common.base.BaseEntity;

/**
 * 标题和检查项目关系表 t_inspect_title_team
 * 
 * @author rbf
 * @date 2019-04-23
 */
public class TInspectTitleTeam extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 标题ID */
	private String titleId;
	/** 检查项目id */
	private String checkTeam;

	public void setTitleId(String titleId) 
	{
		this.titleId = titleId;
	}

	public String getTitleId() 
	{
		return titleId;
	}
	public void setCheckTeam(String checkTeam) 
	{
		this.checkTeam = checkTeam;
	}

	public String getCheckTeam() 
	{
		return checkTeam;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("titleId", getTitleId())
            .append("checkTeam", getCheckTeam())
            .toString();
    }
}
