package com.springmvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="applications")
public class Application {
	@Id
	@Column
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name="users_id")
	private User applicant;
	@ManyToOne
	@JoinColumn(name="jobs_id")
	private JobInfo job;
	@Lob
	@NotBlank(message="This cannot be blank.")
	private String content;
	@Column
	@Temporal(TemporalType.DATE)
	private Date applyDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getApplicant() {
		return applicant;
	}
	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}
	public JobInfo getJob() {
		return job;
	}
	public void setJob(JobInfo job) {
		this.job = job;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	@Override
	public String toString() {
		return "Application [id=" + id + ", applicant=" + applicant.getUsername() + ", job=" + job.getId() + ", content=" + content + "]";
	}

}
