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
@Table(name="messages")
public class Message {
	
	@Id
	@Column
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name="users_id")
	private User receiver;
	@Column
	private String receiverName;
	@Column
	private String senderName;
	@Column
	private Long senderId;
	@Lob
	@NotBlank
	private String content;
	@Column
	@Temporal(TemporalType.DATE)
	private Date sendDate;
	
	public Message(){
		
	}
	
	
	public Message(Long id, String senderName, Date sendDate) {
		super();
		this.id = id;
		this.senderName = senderName;
		this.sendDate = sendDate;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	
	public String getReceiverName() {
		return receiverName;
	}


	public void setReceiverName() {
		this.receiverName = this.receiver.getUsername();
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	
	public Long getSenderId() {
		return senderId;
	}
	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}


	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}


	@Override
	public String toString() {
		return "Message [id=" + id + ", receiverName=" + receiverName + ", senderName=" + senderName + ", content="
				+ content + ", sendDate=" + sendDate + "]";
	}
	
}
