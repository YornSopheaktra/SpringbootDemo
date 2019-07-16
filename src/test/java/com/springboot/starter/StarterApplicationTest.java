package com.springboot.starter;

import com.springboot.starter.domain.Entity.SysCampaign;
import com.springboot.starter.domain.dao.Implements.SysCampaignImp;
import com.springboot.starter.services.PromotionService;
import com.springboot.starter.ws.controller.SpringBootController;
import com.springboot.starter.ws.request.RequestDTO;
import com.springboot.starter.ws.response.ResponseDTO;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureWebMvc
@WebMvcTest(SpringBootController.class)
@ContextConfiguration(classes={StarterApplication.class})
public class StarterApplicationTest {

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PromotionService promotionService;

	@Rule
	public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

	private HttpServletRequest httpRequest;

	private RequestDTO requestDTO;
	@Before
	public void setUp(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
				.apply(documentationConfiguration(this.restDocumentation))
				.build();
		requestDTO= new RequestDTO();
		HashMap<String,Object> data = new HashMap<>();
		data.put("promoionId",1);
		requestDTO.setData(data);
	}
	@Test
	public void welcomeTest() throws Exception {

		this.mockMvc.perform(get("/home")).andExpect(status().isOk())
		.andDo(document("welcome"));

	}

	@Test
	public void contextLoadsTest() throws Exception {

		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello World")))
				.andDo(document("home"));

	}


	@Test
	public void TestPromotion() throws Exception {
		JSONObject jsObject = new JSONObject();
		jsObject.put("promotionId",1);

		String requestJson = jsObject.toString();

		mockMvc.perform(post("/promotion").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(requestJson))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(containsString("T")))
				.andDo(document("Promotion"));
	}
}
