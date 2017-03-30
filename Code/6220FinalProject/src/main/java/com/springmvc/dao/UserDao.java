package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.User;

public interface UserDao {
	//Register
	public void RegistryUser(User user);
	//Update Information
	public void UpdateUser(User user);
	//Search User by User Name
	public User SearchUser(String username);
	
	public User GetById(Long id);
	
	public List<User> getUsers();
		
}
