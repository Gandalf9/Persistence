package com.yatin.example.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private int id;
	
	private String userName;
	
	private String firstName;
	
	private String surname;
	
	public User() {
	}
	
	public User(int id, String userName) {
		this.id = id;
		this.userName = userName;
	}
	
	public User(String userName) {
		this.userName = userName;
	}
	
	public int getId() {
		return id;
	}
	
	public String getUserName() {
		return userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
