package com.springboot.starter.ws.controller;

import com.springboot.starter.processor.PromotionProcessor;
import com.springboot.starter.services.PromotionService;
import com.springboot.starter.ws.request.RequestDTO;
import com.springboot.starter.ws.response.ResponseDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

/*
 * Author: Sopheaktra Yorn
 * Date: 02-07-2019
 */
@RestController
@RequestMapping("/")
@Api(value = "Spring Boot Starter",description = "Spring Boot Description about API")
public class SpringBootController {

	@GetMapping("/")
	public Map<String, Object> greeting() {
		return Collections.singletonMap("message", "Hello World");
	}

	@Autowired
    PromotionService promotionService;

	@GetMapping("home")
	public String Welcome() {
		System.out.println("============================XXXXX===============================");
		return "---------------------- Welcome to Spring Boot Starter! ---------------------------------";
	}

	@PostMapping("promotion")
	public ResponseEntity promotion(@RequestBody RequestDTO requestDTO){
		  return new ResponseEntity(promotionService.run(requestDTO), HttpStatus.OK);
	}
}
