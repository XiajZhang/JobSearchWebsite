 package com.springmvc.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Application;
import com.springmvc.model.JobInfo;
@Repository
public class JobDaoImpl implements JobDao{

	@Resource
	SessionFactory sessionFactory;
	
	@Override
	public void publishJob(JobInfo Job) {
		sessionFactory.getCurrentSession().save(Job);
	}

	@Override
	public void updateJob(JobInfo Job) {
		sessionFactory.getCurrentSession().update(Job);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public List<JobInfo> searchJobByPosition(String Position) {
		Query query = sessionFactory.getCurrentSession().createQuery("from JobInfo where position = :position");
		query.setString("position", Position);
		return query.list();
	}

	@Override
	public List<JobInfo> listJobs() {
		return sessionFactory.getCurrentSession().createQuery("from JobInfo").list();
	}

	@Override
	public JobInfo getJob(Long id) {
		return (JobInfo) sessionFactory.getCurrentSession().get(JobInfo.class, id);
		
	}

	@Override
	public List<JobInfo> getJobByUser(Long userid) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(JobInfo.class);
		crit.add(Restrictions.eq("user.id", userid));
		return crit.list();
	}

}
