package com.springboot.starter.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.starter.domain.Message;

@Repository
public class MessageDao implements MessageDaoI{
	
	@Autowired
	SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getMessages() {
		String sql="";
    	List<Message> users = null;
    	try{
    		sql="select * from message";
    		Session session = sessionFactory.openSession();
    		SQLQuery query = session.createSQLQuery(sql);
    	    //query.addEntity(Users.class);
    	    users =  query.list();
    	    System.out.println("Message size:"+ users.size());
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
		return users;
	}

	@Override
	public List<Message> getMessageById(int patient_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
