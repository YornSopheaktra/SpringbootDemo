package com.springboot.starter.dao;

import java.util.HashMap;

public interface MessageDaoI {

	public HashMap<String, Object> getMessages();
	public HashMap<String, Object> getMessageById(int patient_id);
}
