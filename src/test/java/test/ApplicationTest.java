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
		setMsgId("1,2,3,4,5,6");
		setMessage("Poy,vv,AA,BB,CC,dd");
	}
	
	@Test
	public void contextLoads() {
		getMessageTest();
	}
	
	public void getMessageTest() {
		String body = this.restTemplate.getForObject("/get_message/"+getMsgId(), String.class);
		try {
			JSONObject jObject  = new JSONObject(body);
			String message = "";
			
			String[] msgIdList = getMsgId().split(",");
			String[] messageList =getMessage().split(",");
		
			if(msgIdList.length !=messageList.length){
				Assert.assertFalse(true);
			}
			boolean isErorr = true;
			String messages ="";
			for (int i=0; i<msgIdList.length; i++) {
				message = jObject.getJSONObject("data").getString(msgIdList[i].toString());
				
				if (!messageList[i].equalsIgnoreCase(message)){
					isErorr = false;
					messages += "\n expected: Id:"+msgIdList[i]+":{"+ messageList[i] +"} but actual: Id:"+msgIdList[i]+"{"+ message + "}";
				}
					
			}
			System.out.println("messages: "+messages);
			Assert.assertTrue(messages, isErorr);
		} catch (JSONException e) {
			Assert.assertFalse(true);
			e.printStackTrace();
		}
	}

	public String getMsgId() {
		return msg_id;
	}

	public void setMsgId(String msg_id) {
		this.msg_id = msg_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
