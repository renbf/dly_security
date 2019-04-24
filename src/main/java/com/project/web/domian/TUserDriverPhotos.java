package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 驾驶员照片表 t_user_driver_photos
 * 
 * @author rbf
 * @date 2019-04-18
 */
public class TUserDriverPhotos extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 对应sys_user表中的user_id值 */
	private Long driverUserId;
	/** 头像图片 */
	private String headImg;
	/** 个人照片 */
	private String personalImg;
	/** 身份证复印件照片 */
	private String idCardCopyImg;
	/** 驾驶证复印件照片 */
	private String certificateCopyImg;
	/** 从业资格证复印件照片 */
	private String practitionersCopyImg;
	/** 考试试卷正 */
	private String examinationPaperImg;
	/** 考试试卷第二页 */
	private String examinationPaperSecondImg;
	/** 考试试卷第三页 */
	private String examinationPaperThirdImg;
	/** 考试试卷第四页 */
	private String examinationPaperFourImg;
	/** 三年无重大事故 */
	private String threeNotAccidentImg;
	/** 一年违法记录查询 */
	private String oneYearIllegalRecordImg;
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
	public void setDriverUserId(Long driverUserId) 
	{
		this.driverUserId = driverUserId;
	}

	public Long getDriverUserId() 
	{
		return driverUserId;
	}
	public void setHeadImg(String headImg) 
	{
		this.headImg = headImg;
	}

	public String getHeadImg() 
	{
		return headImg;
	}
	public void setPersonalImg(String personalImg) 
	{
		this.personalImg = personalImg;
	}

	public String getPersonalImg() 
	{
		return personalImg;
	}
	public void setIdCardCopyImg(String idCardCopyImg) 
	{
		this.idCardCopyImg = idCardCopyImg;
	}

	public String getIdCardCopyImg() 
	{
		return idCardCopyImg;
	}
	public void setCertificateCopyImg(String certificateCopyImg) 
	{
		this.certificateCopyImg = certificateCopyImg;
	}

	public String getCertificateCopyImg() 
	{
		return certificateCopyImg;
	}
	public void setPractitionersCopyImg(String practitionersCopyImg) 
	{
		this.practitionersCopyImg = practitionersCopyImg;
	}

	public String getPractitionersCopyImg() 
	{
		return practitionersCopyImg;
	}
	public void setExaminationPaperImg(String examinationPaperImg) 
	{
		this.examinationPaperImg = examinationPaperImg;
	}

	public String getExaminationPaperImg() 
	{
		return examinationPaperImg;
	}
	public void setExaminationPaperSecondImg(String examinationPaperSecondImg) 
	{
		this.examinationPaperSecondImg = examinationPaperSecondImg;
	}

	public String getExaminationPaperSecondImg() 
	{
		return examinationPaperSecondImg;
	}
	public void setExaminationPaperThirdImg(String examinationPaperThirdImg) 
	{
		this.examinationPaperThirdImg = examinationPaperThirdImg;
	}

	public String getExaminationPaperThirdImg() 
	{
		return examinationPaperThirdImg;
	}
	public void setExaminationPaperFourImg(String examinationPaperFourImg) 
	{
		this.examinationPaperFourImg = examinationPaperFourImg;
	}

	public String getExaminationPaperFourImg() 
	{
		return examinationPaperFourImg;
	}
	public void setThreeNotAccidentImg(String threeNotAccidentImg) 
	{
		this.threeNotAccidentImg = threeNotAccidentImg;
	}

	public String getThreeNotAccidentImg() 
	{
		return threeNotAccidentImg;
	}
	public void setOneYearIllegalRecordImg(String oneYearIllegalRecordImg) 
	{
		this.oneYearIllegalRecordImg = oneYearIllegalRecordImg;
	}

	public String getOneYearIllegalRecordImg() 
	{
		return oneYearIllegalRecordImg;
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
            .append("driverUserId", getDriverUserId())
            .append("headImg", getHeadImg())
            .append("personalImg", getPersonalImg())
            .append("idCardCopyImg", getIdCardCopyImg())
            .append("certificateCopyImg", getCertificateCopyImg())
            .append("practitionersCopyImg", getPractitionersCopyImg())
            .append("examinationPaperImg", getExaminationPaperImg())
            .append("examinationPaperSecondImg", getExaminationPaperSecondImg())
            .append("examinationPaperThirdImg", getExaminationPaperThirdImg())
            .append("examinationPaperFourImg", getExaminationPaperFourImg())
            .append("threeNotAccidentImg", getThreeNotAccidentImg())
            .append("oneYearIllegalRecordImg", getOneYearIllegalRecordImg())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
