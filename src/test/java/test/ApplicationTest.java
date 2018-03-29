package test;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.starter.StarterApplication;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = StarterApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class ApplicationTest {
	
	
	@Autowired
	private TestRestTemplate restTemplate;
			
	private String msg_id;
	private String message;
	
	@Before
	public void initiatTest(){
		setMsg_id("1");
		setMessage("Poy");
	}
	
	@Test
	public void contextLoads() {
		System.out.println("9999999999999999999999999");
		getMessageTest();
	}
	
	public void getMessageTest() {
		String body = this.restTemplate.getForObject("/get_message/"+getMsg_id(), String.class);
		try {
			JSONObject jObject  = new JSONObject(body);
			String message = jObject.getJSONObject("data").getString(getMsg_id().toString());
			Assert.assertEquals(getMessage(),message);
		} catch (JSONException e) {
			Assert.assertFalse(true);
			e.printStackTrace();
		}
	}

	public String getMsg_id() {
		return msg_id;
	}

	public void setMsg_id(String msg_id) {
		this.msg_id = msg_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
