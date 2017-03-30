package com.springmvc.dao;

import java.util.Collection;
import java.util.List;

import com.springmvc.model.JobInfo;


public interface JobDao {

	public void publishJob(JobInfo Job);
	
	public void updateJob(JobInfo Job);
	
	public JobInfo getJob(Long id);
	
	public List<JobInfo> getJobByUser(Long userid);
	
	public List<JobInfo> searchJobByPosition(String Position);
	
	public Collection<JobInfo> listJobs();
	
}
