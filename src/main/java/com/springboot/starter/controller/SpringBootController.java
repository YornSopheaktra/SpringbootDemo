package com.springboot.starter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.starter.services.MessageService;
import com.springboot.starter.ws.Response;

@RestController
@RequestMapping("/")
public class SpringBootController {
	
	@Autowired
	MessageService messageService;

	@RequestMapping("starter")
	public Response MyPring() {
		Response re = new Response();
		System.out.println("lel-------------------------------------");
		return re;
	}
	@RequestMapping("get_messages")
	public Response GetMessages(){
		return messageService.run(new Response());
	}
	@RequestMapping("get_message/{msgId}")
	public Response GetMessage(@PathVariable int msgId ){
		return messageService.run(new Response(),msgId);
	}
}
