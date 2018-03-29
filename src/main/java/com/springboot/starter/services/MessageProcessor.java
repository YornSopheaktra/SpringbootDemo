package com.springboot.starter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.starter.dao.MessageDao;
import com.springboot.starter.ws.Response;

@Service
public class MessageProcessor {
	
	@Autowired
	MessageDao messageDao;

	public Response getMessage(Response respone, String msgIds) {
		
		System.out.println("-------------------Messages --------------------------");
		try {
			System.out.println("-------------------getting Messages--------------------------");
			respone.setData(messageDao.getMessageById(msgIds));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respone;
	}
	public Response getMessages(Response respone) {
		
		System.out.println("-------------------Messages --------------------------");
		try {
			System.out.println("-------------------getting Messages--------------------------");
			respone.setData(messageDao.getMessages());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respone;
	}


}
