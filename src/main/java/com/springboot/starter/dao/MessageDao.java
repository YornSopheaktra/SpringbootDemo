package com.springboot.starter.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.starter.domain.Message;
import com.springboot.starter.util.Debugger;

@Repository
public class MessageDao implements MessageDaoI{
	
	@Autowired
	SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Object> getMessages() {
		String sql="";
		HashMap<String, Object> message = new HashMap<String, Object>();
    	List<Message> messages = null;
    	try{
    		sql="select * from message";
    		Session session = sessionFactory.openSession();
    		SQLQuery query = session.createSQLQuery(sql);
    	    //query.addEntity(Users.class);
    		messages =  query.list();
    		for(int i=0;i<messages.size();i++){
    			Object[] row = (Object[]) query.list().get(i);
    			Debugger.debugObject("row: ", row);
    			message.put(row[0].toString(), row[1].toString());
    		}
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
		return message;
	}

	@Override
	public HashMap<String, Object> getMessageById(int msg_id) {
		String sql="";
		HashMap<String, Object> message =new HashMap<String, Object>();
    	try{
    		sql="select msg_id as msgId, message from message where msg_id = :msg_id";
    		Session session = sessionFactory.openSession();
    		SQLQuery query = session.createSQLQuery(sql);
    		query.setParameter("msg_id",msg_id);
    		if(query.list().size()>0){
    			Object[] row = (Object[]) query.list().get(0);
        		message.put(row[0].toString(), row[1].toString());
    		}
    		

    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
		return message;
	}

}
