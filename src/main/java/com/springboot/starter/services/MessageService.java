package com.springboot.starter.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.starter.ws.Response;

@Service
public class MessageService {
	@Autowired
	MessageProcessor messageProcessor;

	public Response run(Response respone) {
		try{
			System.out.println("-------------------User Requested--------------------------");
			respone=messageProcessor.getMessage(respone);
			//Debugger.debugObject("respone: ",respone);
		}catch(Exception e){
			e.printStackTrace();
		}
		return respone;
	}
}
