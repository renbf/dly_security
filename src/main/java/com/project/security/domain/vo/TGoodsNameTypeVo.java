package com.project.security.domain.vo;

import java.io.Serializable;

/**
 * 货物名称类项关系表 t_goods_name_type
 * 
 * @author rbf
 * @date 2019-04-18
 */
public class TGoodsNameTypeVo implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 货物类项 */
	private String typeItem;
	/** 货物名称 */
	private String goodsName;
	/** 货物类项名称 */
	private String typeItemName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTypeItem() {
		return typeItem;
	}
	public void setTypeItem(String typeItem) {
		this.typeItem = typeItem;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getTypeItemName() {
		return typeItemName;
	}
	public void setTypeItemName(String typeItemName) {
		this.typeItemName = typeItemName;
	}

}
