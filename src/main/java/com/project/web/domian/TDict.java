package com.project.web.domian;


import java.io.Serializable;
import java.util.Date;
import java.util.List;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.project.common.base.BaseEntity;

/**
 * 字典表 t_dict
 * 
 * @author rbf
 * @date 2019-04-23
 */
public class TDict extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 字典主键 */
	private String id;
	/** 父级编码 */
	private String parentId;
	/** 字典名称 */
	private String dictName;
	/** 字典编码 */
	private String dictCode;
	/** 字典排序 */
	private Integer dictSort;
	/** 状态（1正常 0停用） */
	private String status;
	/** 企业id */
	private String businessId;
	/** 创建人id */
	private String addUserId;
	/** 创建时间 */
	private Date createDate;
	/** 修改时间 */
	private Date updateDate;
	/** 修改人id */
	private String updateUserId;
	/** 备注 */
	private String remark;
	
    private String[] array;
    //子类型一级
    private List<TDict> childOneList;
    //子类型二级
    private List<TDict> childTwoList;
    
	/**
	 * 子级列表
	 */
 	private List<TDict> childrens;
    
    
    

	public List<TDict> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<TDict> childrens) {
		this.childrens = childrens;
	}

	public List<TDict> getChildOneList() {
		return childOneList;
	}

	public void setChildOneList(List<TDict> childOneList) {
		this.childOneList = childOneList;
	}

	public List<TDict> getChildTwoList() {
		return childTwoList;
	}

	public void setChildTwoList(List<TDict> childTwoList) {
		this.childTwoList = childTwoList;
	}

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setParentId(String parentId) 
	{
		this.parentId = parentId;
	}

	public String getParentId() 
	{
		return parentId;
	}
	public void setDictName(String dictName) 
	{
		this.dictName = dictName;
	}

	public String getDictName() 
	{
		return dictName;
	}
	public void setDictCode(String dictCode) 
	{
		this.dictCode = dictCode;
	}

	public String getDictCode() 
	{
		return dictCode;
	}
	public void setDictSort(Integer dictSort) 
	{
		this.dictSort = dictSort;
	}

	public Integer getDictSort() 
	{
		return dictSort;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setBusinessId(String businessId) 
	{
		this.businessId = businessId;
	}

	public String getBusinessId() 
	{
		return businessId;
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
            .append("id", getId())
            .append("parentId", getParentId())
            .append("dictName", getDictName())
            .append("dictCode", getDictCode())
            .append("dictSort", getDictSort())
            .append("status", getStatus())
            .append("businessId", getBusinessId())
            .append("addUserId", getAddUserId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("updateUserId", getUpdateUserId())
            .append("remark", getRemark())
            .toString();
    }
}
