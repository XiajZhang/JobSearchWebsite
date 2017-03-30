package com.springmvc.service;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.MessageDaoImpl;
import com.springmvc.model.Message;

@Service
public class MessageService {

	@Autowired
	private MessageDaoImpl messageDao;
	
	@Transactional
	public void sendMessage(Message message) {
		messageDao.sendMessage(message);
	}

	@Transactional
	public void deleteMessage(Message message) {
		messageDao.deleteMessage(message);
	}

	@Transactional
	public Message getMessage(Long id) {
		return messageDao.getMessage(id);
	}

	@Transactional
	public List<Message> getMessage(String receiverName) {
		return messageDao.getMessage(receiverName);
	}
}
