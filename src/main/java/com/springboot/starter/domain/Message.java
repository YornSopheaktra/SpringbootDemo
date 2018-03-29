package com.springboot.starter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="message")
public class Message {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name ="msg_id", nullable = false, unique = true)
	private int msgId;
	
	@Column(name="message")
	private String message;

	public int getMsgId() {
		return msgId;
	}

	public void setMsg_id(int msg_id) {
		this.msgId = msg_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	


}
