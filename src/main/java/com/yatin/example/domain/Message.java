package com.yatin.example.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "MESSAGES")
public class Message {

	@Id 
    @Column(name = "MESSAGE_ID")
	private Long id;
	
	@Column(name = "MESSAGE_TEXT",columnDefinition="varchar(255) default 'Hello'")
	@Generated(GenerationTime.ALWAYS)
	private String text;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NEXT_MESSAGE_ID")
	private Message nextMessage;
	
	public Message() {
	}
	
	public Message(String text) {
		this.text = text;
	}
	
	public Message(String text, long id) {
		this.text = text;
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	public Message getNextMessage() {
		return nextMessage;
	}

	public void setNextMessage(Message nextMessage) {
		this.nextMessage = nextMessage;
	}

	@Override
	public String toString() {
		return String.format("Message - id:%s text:%s", id, text);
	}
	
}
