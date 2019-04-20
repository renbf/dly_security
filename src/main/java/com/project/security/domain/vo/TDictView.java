package com.project.security.domain.vo;

import java.io.Serializable;

/**
 * 字典表 t_dict
 * 
 * @author rbf
 * @date 2019-04-16
 */
public class TDictView implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 字典主键 */
	private String id;
	/** 字典名称 */
	private String dictName;
	/** 字典编码 */
	private String dictCode;
	/** 状态 */
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public String getDictCode() {
		return dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
