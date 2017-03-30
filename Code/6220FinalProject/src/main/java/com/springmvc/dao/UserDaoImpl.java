package com.springmvc.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.model.User;

@Repository	
public class UserDaoImpl implements UserDao{

	@Resource
	private SessionFactory sessionFactory;

//	private Session getSession(){
//		return sessionFactory.getCurrentSession();
//	}
	
	@Override
	public void RegistryUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void UpdateUser(User user) {
		// TODO Auto-generated method stub
		System.out.println(user);
		sessionFactory.getCurrentSession().update(user);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public User SearchUser(String username) {
		
		Query query = sessionFactory.getCurrentSession().createQuery("from User where username=:username");
		query.setString("username", username);
		User user = (User) query.uniqueResult();
		return user;
	}

	@Override
	public List<User> getUsers() {
		Query query = sessionFactory.getCurrentSession().createQuery("from User");
		List users = query.list();
		return users;
	}

	@Override
	public User GetById(Long id) {
		return (User) sessionFactory.getCurrentSession().load(User.class, id);
	}

//	@Override
//	public void DeleteUser(User user) {
//		// TODO Auto-generated method stub
//		
//	}

}
