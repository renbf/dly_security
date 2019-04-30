package com.project.util.aliyun;

import java.io.Serializable;

/**
 * 
 * @author rbf
 *
 */
public class FaceVerifyResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4914558867871904606L;
	private float confidence;
	private int errno;
	private String err_msg;
	private String request_id;
	private float[] thresholds;
	private int[] rectA;
	private int[] rectB;
	public float getConfidence() {
		return confidence;
	}
	public void setConfidence(float confidence) {
		this.confidence = confidence;
	}
	public int getErrno() {
		return errno;
	}
	public void setErrno(int errno) {
		this.errno = errno;
	}
	public String getErr_msg() {
		return err_msg;
	}
	public void setErr_msg(String err_msg) {
		this.err_msg = err_msg;
	}
	public String getRequest_id() {
		return request_id;
	}
	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}
	public float[] getThresholds() {
		return thresholds;
	}
	public void setThresholds(float[] thresholds) {
		this.thresholds = thresholds;
	}
	public int[] getRectA() {
		return rectA;
	}
	public void setRectA(int[] rectA) {
		this.rectA = rectA;
	}
	public int[] getRectB() {
		return rectB;
	}
	public void setRectB(int[] rectB) {
		this.rectB = rectB;
	}
	
	
}
