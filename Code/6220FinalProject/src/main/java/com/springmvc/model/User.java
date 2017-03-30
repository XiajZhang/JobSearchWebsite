package com.springmvc.model;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.validation.ValidEmail;

@Entity
@Table (name="users")
public class User {

	@Id
	@GeneratedValue
	private long id;
	@Column(unique=true)
	@NotEmpty
	@NotBlank
	@Size(min=3,max=15)
	private String username;
	@Column
	@ValidEmail(message="This does not appear to be a valid email address.")
	private String email;
	@Column
	private Integer age;
	@Column
	@NotEmpty
	@NotBlank
	@Size(min=6,max=15,message="Password must be between 6 and 15.")
	@Pattern(regexp="^\\S+$", message="Password cannot contain Spaces.")
	private String password;
	@Column
	private boolean enabled = true;
	@Lob
	private String education;
	@Lob
	private String workExperience;
	@Lob
	private String introduction;
	@Column
	@NotNull(message="You have to select a role.")
	@NotBlank(message="You have to choose a role.")
	private String authority;
	@Lob 
	private byte[] photoBytes;
	@Transient
	private MultipartFile photo;
	@Transient
	private MultipartFile photoChange;
	
	private String photoContentType; 
	
	private String photoFilename;
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "user", fetch = FetchType.EAGER)
	private Set<JobInfo> jobInfos = new HashSet<JobInfo>();
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "receiver", fetch = FetchType.EAGER)
	private Set<Message> messages = new HashSet<Message>();
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "applicant", fetch = FetchType.EAGER)
	private Set<Application> applications = new HashSet<Application>();
	
	
	public User(){
		
	}
	
	public User(long id, String username, String email, Integer age, String password, boolean enabled,
			String introduction, String authority, byte[] photoBytes, MultipartFile photo, String photoContentType,
			String photoFilename) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.age = age;
		this.password = password;
		this.enabled = enabled;
		this.introduction = introduction;
		this.authority = authority;
		this.photoBytes = photoBytes;
		this.photo = photo;
		this.photoContentType = photoContentType;
		this.photoFilename = photoFilename;
	}

	public Set<JobInfo> getJobInfos() {
		return jobInfos;
	}

	public void setJobInfos(Set<JobInfo> jobInfos) {
		this.jobInfos = jobInfos;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public byte[] getPhotoBytes() {
		return photoBytes;
	}

	public void setPhotoBytes(byte[] photoBytes) {
		this.photoBytes = photoBytes;
	}

	
	public MultipartFile getPhotoChange() {
		return photoChange;
	}

	public void setPhotoChange(MultipartFile photoChange) {
		this.photoChange = photoChange;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
		setPhotoContentType(photo.getContentType());
		setPhotoFilename(photo.getOriginalFilename());
		try {
			setPhotoBytes(photo.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getPhotoContentType() {
		return photoContentType;
	}
	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	public String getPhotoFilename() {
		return photoFilename;
	}
	public void setPhotoFilename(String photoFilename) {
		this.photoFilename = photoFilename;
	}
	
	
	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
	
	

	public Set<Application> getApplications() {
		return applications;
	}

	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}

	
	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", age=" + age + ", password="
				+ password +  ", introduction="
						+ introduction + "]";
	}	
	
	
	
}
