package com.springmvc.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.JobDaoImpl;
import com.springmvc.model.JobInfo;

@Service
public class JobService {
	
	@Autowired
	private JobDaoImpl jobDao;

	@Transactional
	public void publishJob(JobInfo Job){
		jobDao.publishJob(Job);
	}
	@Transactional
	public void updateJob(JobInfo Job){
		jobDao.updateJob(Job);
	}
	@Transactional
	public List<JobInfo> searchJobByPosition(String Position){
		return jobDao.searchJobByPosition(Position);
	}
	@Transactional
	public Collection<JobInfo> listJobs() {
		return jobDao.listJobs();
	}
	@Transactional
	public JobInfo getJob(Long id) {
		return jobDao.getJob(id);
	}
	@Transactional
	public List<JobInfo> getJobByUser(Long userid) {
		return jobDao.getJobByUser(userid);
	}
}
