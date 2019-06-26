package com.springboot.starter.ws.controller;

import com.springboot.starter.processor.PromotionProcessor;
import com.springboot.starter.services.PromotionService;
import com.springboot.starter.ws.response.Response;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
@Api(value = "Spring Boot Starter",description = "Spring Boot Description about API")
public class SpringBootController {


	@Autowired
    PromotionService promotionService;

	@GetMapping("home")
	public String Welcome() {
		return "---------------------- Welcome to Spring Boot Starter! ---------------------------------";
	}

	@PostMapping("promotion")
	public Response promotion(HttpServletRequest request){
		return  promotionService.run(request);
	}
}
