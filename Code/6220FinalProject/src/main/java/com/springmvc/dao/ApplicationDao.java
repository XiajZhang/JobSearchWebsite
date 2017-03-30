package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Application;

public interface ApplicationDao {

	public void sendApplication(Application application);
	
	public void cancelApplication(Application application);
	
	public List<Application> getApplicationsByUser(Long userId);
	
	public List<Application> getApplicationByJob(Long jobId);
}
