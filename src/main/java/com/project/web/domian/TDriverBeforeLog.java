package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.project.common.base.BaseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * 行车前检查事项表 t_driver_before_log
 * 
 * @author rbf
 * @date 2019-04-23
 */
public class TDriverBeforeLog extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 行车日志ID */
	private String driverLogId;
	/** 检查事项 */
	private String carCheckProject;
	/** 不符合项 */
	private String noAccord;
	/** 确认评论 */
	private String sureComment;
	/** 行车照片 */
	private String drivePhotoUrl;
	/** 签名照片 */
	private String autograph;
	/** 备注 */
	private String remark;
	/** 交接备注 */
	private String exchangeRemark;
	/** 创建人id */
	private String addUserId;
	/** 创建时间 */
	private Date createDate;
	/** 修改时间 */
	private Date updateDate;
	/** 修改人id */
	private String updateUserId;

	/*查询输入新增*/
	/*查询输出新增*/
	private String createDateStr;


	/*修改输入新增*/
	private List<String> updatePhotoUrls;
	private List<MultipartFile> newPhotoFiles;
	private MultipartFile newAutographFile;


	public List<String> getUpdatePhotoUrls() {
		return updatePhotoUrls;
	}

	public TDriverBeforeLog setUpdatePhotoUrls(List<String> updatePhotoUrls) {
		this.updatePhotoUrls = updatePhotoUrls;
		return this;
	}

	public List<MultipartFile> getNewPhotoFiles() {
		return newPhotoFiles;
	}

	public TDriverBeforeLog setNewPhotoFiles(List<MultipartFile> newPhotoFiles) {
		this.newPhotoFiles = newPhotoFiles;
		return this;
	}

	public MultipartFile getNewAutographFile() {
		return newAutographFile;
	}

	public TDriverBeforeLog setNewAutographFile(MultipartFile newAutographFile) {
		this.newAutographFile = newAutographFile;
		return this;
	}

	public String getCreateDateStr() {
		return createDateStr;
	}

	public TDriverBeforeLog setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
		return this;
	}

	public void setDriverLogId(String driverLogId)
	{
		this.driverLogId = driverLogId;
	}

	public String getDriverLogId() 
	{
		return driverLogId;
	}
	public void setCarCheckProject(String carCheckProject) 
	{
		this.carCheckProject = carCheckProject;
	}

	public String getCarCheckProject() 
	{
		return carCheckProject;
	}
	public void setNoAccord(String noAccord) 
	{
		this.noAccord = noAccord;
	}

	public String getNoAccord() 
	{
		return noAccord;
	}
	public void setSureComment(String sureComment) 
	{
		this.sureComment = sureComment;
	}

	public String getSureComment() 
	{
		return sureComment;
	}
	public void setDrivePhotoUrl(String drivePhotoUrl) 
	{
		this.drivePhotoUrl = drivePhotoUrl;
	}

	public String getDrivePhotoUrl() 
	{
		return drivePhotoUrl;
	}
	public void setAutograph(String autograph) 
	{
		this.autograph = autograph;
	}

	public String getAutograph() 
	{
		return autograph;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setExchangeRemark(String exchangeRemark) 
	{
		this.exchangeRemark = exchangeRemark;
	}

	public String getExchangeRemark() 
	{
		return exchangeRemark;
	}
	public void setAddUserId(String addUserId) 
	{
		this.addUserId = addUserId;
	}

	public String getAddUserId() 
	{
		return addUserId;
	}
	public void setCreateDate(Date createDate) 
	{
		this.createDate = createDate;
	}

	public Date getCreateDate() 
	{
		return createDate;
	}
	public void setUpdateDate(Date updateDate) 
	{
		this.updateDate = updateDate;
	}

	public Date getUpdateDate() 
	{
		return updateDate;
	}
	public void setUpdateUserId(String updateUserId) 
	{
		this.updateUserId = updateUserId;
	}

	public String getUpdateUserId() 
	{
		return updateUserId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("driverLogId", getDriverLogId())
            .append("carCheckProject", getCarCheckProject())
            .append("noAccord", getNoAccord())
            .append("sureComment", getSureComment())
            .append("drivePhotoUrl", getDrivePhotoUrl())
            .append("autograph", getAutograph())
            .append("remark", getRemark())
            .append("exchangeRemark", getExchangeRemark())
            .append("addUserId", getAddUserId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
