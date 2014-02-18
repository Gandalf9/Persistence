package com.yatin.example.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private int id;
	
	private String userName;
	
	private String firstName;
	
	private String surname;
	
	@Embedded
	private HomeAddress homeAddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="Billing_street")),
		@AttributeOverride(name="postCode", column=@Column(name="Billing_postcode"))
	})
	private HomeAddress billingAddress;
	
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

	public HomeAddress getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(HomeAddress homeAddress) {
		this.homeAddress = homeAddress;
	}

	public HomeAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(HomeAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
}
