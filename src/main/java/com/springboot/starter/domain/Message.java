package com.springboot.starter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="message")
public class Message {

	@Id
	@Column(name="msg_id")
	private int msg_id;
	
	@Column(name="message")
	private String message;

	public int getMsg_id() {
		return msg_id;
	}

	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	


}
