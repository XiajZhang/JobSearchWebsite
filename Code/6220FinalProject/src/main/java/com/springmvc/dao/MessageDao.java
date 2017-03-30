package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Message;

public interface MessageDao {

	public void sendMessage(Message message);
	
	public void deleteMessage(Message message);
	
	public Message getMessage(Long id);
	
	public List<Message> getMessage(String receiverName); 
	
}
