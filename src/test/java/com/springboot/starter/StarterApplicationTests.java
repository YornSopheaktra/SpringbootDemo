package com.springboot.starter;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StarterApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void contextLoads() {
		starterTest();
		getMessageTest();
	}
	public void starterTest() {
		String body = this.restTemplate.getForObject("/starter", String.class);
		System.out.println("body: "+body);
		Assert.assertFalse(body, body.contains("error"));
	}
	public void getMessageTest() {
		String body = this.restTemplate.getForObject("/get_message", String.class);
		System.out.println("body: "+body);
		Assert.assertFalse(body, body.contains("error"));
	}

}
