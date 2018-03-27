package com.springboot.starter.dao;

import java.util.List;

import com.springboot.starter.domain.Message;

public interface MessageDaoI {

	public List<Message> getMessages();
	public List<Message> getMessageById(int patient_id);
}
