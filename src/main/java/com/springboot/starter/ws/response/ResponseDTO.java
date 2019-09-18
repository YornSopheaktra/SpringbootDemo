package com.springboot.starter.ws.response;

import com.springboot.starter.utils.ToString;
import org.joda.time.Days;
import org.joda.time.LocalDate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/*
 * Author: Sopheaktra Yorn
 * Date: 02-07-2019
 */
public class ResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String requestId;
	private Integer accountId;
	private String sessionId;
	private Timestamp timestamp;
	private HashMap<String,Object> data;
	private String code;
	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public HashMap<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public static ResponseDTO newObject(ResponseDTO re){
		ResponseDTO tmpRe = new ResponseDTO();
		tmpRe.data=re.getData();
		return tmpRe;
	}

	@Override
	public String toString(){
		String res;
		res= ToString.pgson.toJson(this);
		return res;
	}


	public static void main(String[] args) throws ParseException {

		List<String> a= new ArrayList<>();

		if (a!=null)
			System.out.println("not nul");

		for (String b:a) {

		}

		}
}
