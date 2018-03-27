package com.springboot.starter.ws;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class Response implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String serviceTypeId;
	private String status;
	private String errorCode;
	private String errorMessage;
	private String step;
	private HashMap<String, Object> data;
	private List<HashMap<String,Object>> dataDetail;
	
	public static Response newObject(Response re){
		Response tmpRe = new Response();
		tmpRe.serviceTypeId= re.getServiceTypeId();
		tmpRe.status=re.getStatus();
		tmpRe.errorCode= re.getErrorCode();
		tmpRe.errorMessage=re.getErrorMessage();	
		tmpRe.step=re.getStep();
		tmpRe.data=re.getData();
		tmpRe.dataDetail= re.getDataDetail();
		return tmpRe;
	}
	
	public String getServiceTypeId() {
		return serviceTypeId;
	}
	public void setServiceTypeId(String serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public HashMap<String, Object> getData() {
		return data;
	}
	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}
	public List<HashMap<String, Object>> getDataDetail() {
		return dataDetail;
	}
	public void setDataDetail(List<HashMap<String, Object>> dataDetail) {
		this.dataDetail = dataDetail;
	}
	
}
