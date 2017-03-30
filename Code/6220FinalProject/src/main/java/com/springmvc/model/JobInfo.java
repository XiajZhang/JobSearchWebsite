package com.springmvc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="jobs")
public class JobInfo {

	@Id
	@Column
	@GeneratedValue
	private Long id;
	@Column
	private String title;
	@Column
	private String position;
	@Lob
	private String introduction;
	@ManyToOne
	@JoinColumn(name="users_id")
	private User user;
	@Column
	@Temporal(TemporalType.DATE)
	private Date duedate;
	@Column
	@Temporal(TemporalType.DATE)
	private Date publishDate;
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "job", fetch = FetchType.EAGER)
	private Set<Application> applications = new HashSet<Application>();
	
	public JobInfo(){
		
	}
	
	public JobInfo(User user, String title,String position, String introduction) {
		this.user = user;
		this.title = title;
		this.position = position;
		this.introduction = introduction;
	}

	public JobInfo(Long id, User user, String title, String position, String introduction) {
		this.id = id;
		this.user = user;
		this.title = title;
		this.position = position;
		this.introduction = introduction;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
//	public String getPublisher() {
//		return publisher;
//	}
//	public void setPublisher(String publisher) {
//		this.publisher = publisher;
//	}

	
	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	
	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Set<Application> getApplications() {
		return applications;
	}

	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "JobInfo [id=" + id + ", title=" + title + ", position=" + position + ", introduction=" + introduction
				+ ", duedate=" + duedate + "]";
	}

	

	
}
