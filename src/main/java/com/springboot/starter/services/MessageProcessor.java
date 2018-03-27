package com.springboot.starter.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.starter.dao.MessageDao;
import com.springboot.starter.ws.Response;

@Service
public class MessageProcessor {
	
	@Autowired
	MessageDao messageDao;

	public Response getMessage(Response respone) {
		
		System.out.println("-------------------Messages --------------------------");
		try {
			System.out.println("-------------------getting Messages--------------------------");
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("list Message: ",  messageDao.getMessages());
			//Debugger.debugObject("Users: ",data);
			respone.setData(data);
			respone.setStatus("T");
			respone.setErrorCode("N/A");
			respone.setErrorMessage("list Messages successfully");
		} catch (Exception e) {
			respone.setStatus("F");
			respone.setErrorCode("N/A");
			respone.setErrorMessage("No data Messages");
			e.printStackTrace();
		}
		return respone;
	}


}
