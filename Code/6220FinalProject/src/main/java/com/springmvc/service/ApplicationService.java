package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.ApplicationDaoImpl;
import com.springmvc.model.Application;

@Service
public class ApplicationService {
	
	@Autowired
	private ApplicationDaoImpl applicationDaoImpl;

	@Transactional
	public void sendApplication(Application application) {
		applicationDaoImpl.sendApplication(application);
	}

	@Transactional
	public void cancelApplication(Application application) {
		applicationDaoImpl.cancelApplication(application);
	}

	@Transactional
	public List<Application> getApplicationsByUser(Long userId) {
		return applicationDaoImpl.getApplicationsByUser(userId);
	}

	@Transactional
	public List<Application> getApplicationByJob(Long jobId) {
		return applicationDaoImpl.getApplicationByJob(jobId);
	}
}
