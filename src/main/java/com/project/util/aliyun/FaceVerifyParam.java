package com.project.util.aliyun;

import java.io.Serializable;

/**
 * 
 * @author rbf
 *
 */
public class FaceVerifyParam implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4096970159008448897L;
	private String type;
	private String image_url_1;
	private String content_1;
	private String image_url_2;
	private String content_2;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImage_url_1() {
		return image_url_1;
	}
	public void setImage_url_1(String image_url_1) {
		this.image_url_1 = image_url_1;
	}
	public String getContent_1() {
		return content_1;
	}
	public void setContent_1(String content_1) {
		this.content_1 = content_1;
	}
	public String getImage_url_2() {
		return image_url_2;
	}
	public void setImage_url_2(String image_url_2) {
		this.image_url_2 = image_url_2;
	}
	public String getContent_2() {
		return content_2;
	}
	public void setContent_2(String content_2) {
		this.content_2 = content_2;
	}
	
}
