package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

/**
 * 附件表 gwt_file
 * 
 * @author lws
 * @date 2019-02-22
 */
public class File extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 附件ID */
	private String fileId;
	/** 附件名称 */
	private String fileName;
	/** 附件路径 */
	private String filePath;
	/** 状态 0-有效，9-删除 */
	private Integer state;
	/** 创建时间 */
	private Date createTime;
	/** 创建人ID */
	private String createrUserId;
	/** 备注 */
	private String memo;
	/** 附件来源类型 */
	private String sourceType;
	/** 附件来源ID */
	private String sourceId;

	public void setFileId(String fileId) 
	{
		this.fileId = fileId;
	}

	public String getFileId() 
	{
		return fileId;
	}
	public void setFileName(String fileName) 
	{
		this.fileName = fileName;
	}

	public String getFileName() 
	{
		return fileName;
	}
	public void setFilePath(String filePath) 
	{
		this.filePath = filePath;
	}

	public String getFilePath() 
	{
		return filePath;
	}
	public void setState(Integer state) 
	{
		this.state = state;
	}

	public Integer getState() 
	{
		return state;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setCreaterUserId(String createrUserId) 
	{
		this.createrUserId = createrUserId;
	}

	public String getCreaterUserId() 
	{
		return createrUserId;
	}
	public void setMemo(String memo) 
	{
		this.memo = memo;
	}

	public String getMemo() 
	{
		return memo;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public void setSourceId(String sourceId) 
	{
		this.sourceId = sourceId;
	}

	public String getSourceId() 
	{
		return sourceId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fileId", getFileId())
            .append("fileName", getFileName())
            .append("filePath", getFilePath())
            .append("state", getState())
            .append("createTime", getCreateTime())
            .append("createrUserId", getCreaterUserId())
            .append("memo", getMemo())
            .append("sourceType", getSourceType())
            .append("sourceId", getSourceId())
            .toString();
    }
}
