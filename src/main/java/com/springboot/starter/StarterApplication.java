package com.springboot.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//@ServletComponentScan
public class StarterApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(StarterApplication.class, args);
	}
}
