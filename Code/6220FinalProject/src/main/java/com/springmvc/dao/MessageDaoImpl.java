package com.springmvc.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.springmvc.model.JobInfo;
import com.springmvc.model.Message;

@Repository
public class MessageDaoImpl implements MessageDao{
	
	@Resource
	SessionFactory sessionFactory;

	@Override
	public void sendMessage(Message message) {
		sessionFactory.getCurrentSession().save(message);
	}

	@Override
	public void deleteMessage(Message message) {
		sessionFactory.getCurrentSession().delete(message);
	}

	@Override
	public Message getMessage(Long id) {
		
		return (Message) sessionFactory.getCurrentSession().get(Message.class, id);
	}

	@Override
	public List<Message> getMessage(String receiverName) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Message where receiverName = :receiverName");
		query.setString("receiverName", receiverName);
		return query.list();
	}

}
