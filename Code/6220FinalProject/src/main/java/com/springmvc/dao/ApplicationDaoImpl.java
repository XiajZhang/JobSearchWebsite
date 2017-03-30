package com.springmvc.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.springmvc.model.Application;

@Repository
public class ApplicationDaoImpl implements ApplicationDao{

	@Resource
	SessionFactory sessionFactory;
	
	@Override
	public void sendApplication(Application application) {
		sessionFactory.getCurrentSession().save(application);
	}

	@Override
	public void cancelApplication(Application application) {
		sessionFactory.getCurrentSession().delete(application);
	}

	@Override
	public List<Application> getApplicationsByUser(Long userId) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Application.class);
		crit.add(Restrictions.eq("applicant.id", userId));
		return crit.list();
	}

	@Override
	public List<Application> getApplicationByJob(Long jobId) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Application.class);
		crit.add(Restrictions.eq("job.id", jobId));
		return crit.list();
	}

}
