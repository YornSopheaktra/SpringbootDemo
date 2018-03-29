package com.springboot.starter.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.starter.util.Debugger;
import com.springboot.starter.ws.Response;

@Service
public class MessageService {
	@Autowired
	MessageProcessor messageProcessor;
	public Response run(Response respone, String msgIds) {
		try{
			System.out.println("-------------------message id Requested: "+ msgIds);
			respone=messageProcessor.getMessage(respone,msgIds);
			Debugger.debugObject("respone: ",respone);
		}catch(Exception e){
			e.printStackTrace();
		}
		return respone;
	}
	public Response run(Response respone) {
		try{
			System.out.println("-------------------message Requested ");
			respone=messageProcessor.getMessages(respone);
			Debugger.debugObject("respone getMessages: ",respone);
		}catch(Exception e){
			e.printStackTrace();
		}
		return respone;
	}
}
