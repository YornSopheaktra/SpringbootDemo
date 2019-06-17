package com.springboot.starter.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.starter.services.MessageService;
import com.springboot.starter.ws.response.Response;

@RestController
@RequestMapping("/")
public class SpringBootController {
	
	@Autowired
	MessageService messageService;

	@RequestMapping("home")
	public String MyPring() {
		return "---------------------- Welcome to Spring Boot Starter! ---------------------------------";
	}
	@RequestMapping("get_messages")
	public Response GetMessages(){
		return messageService.run(new Response());
	}
	@RequestMapping("get_message/{msgIds}")
	public Response GetMessage(@PathVariable String msgIds ){
		return messageService.run(new Response(),msgIds);
	}
}
