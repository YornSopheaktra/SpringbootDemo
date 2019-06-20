package com.springboot.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.*"})
public class StarterApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(StarterApplication.class, args);
	}
}
