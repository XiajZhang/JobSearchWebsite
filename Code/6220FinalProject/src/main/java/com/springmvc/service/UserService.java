package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.UserDaoImpl;
import com.springmvc.model.User;

@Service
public class UserService {

	@Autowired
	private UserDaoImpl userDaoImpl;
	//Register
	@Transactional
	public void RegistryUser(User user){
		userDaoImpl.RegistryUser(user);
	}
	//Update Information
	@Transactional
	public void UpdateUser(User user){
		userDaoImpl.UpdateUser(user);
	}
	//Search User by User Name
	@Transactional
	public User SearchUser(String username){
		return userDaoImpl.SearchUser(username);
		
	}
		
	@Transactional
	public List<User> getUsers(){
		return userDaoImpl.getUsers();
	}
	@Transactional
	public User getById(Long id){
		return userDaoImpl.GetById(id);
	}

//	public void DeleteUser(User user){
//		
//	}
}
