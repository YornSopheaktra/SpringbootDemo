package com.springboot.starter.ws.response;

import java.io.Serializable;
import java.util.HashMap;

public class Response implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> data;
	
	public static Response newObject(Response re){
		Response tmpRe = new Response();
		tmpRe.data=re.getData();
		return tmpRe;
	}
	public HashMap<String, Object> getData() {
		return data;
	}
	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}	
}
