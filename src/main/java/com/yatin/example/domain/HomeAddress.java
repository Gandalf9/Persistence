package com.yatin.example.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class HomeAddress {

	@Column(name = "STREET")
	private String street;
	
	@Column(name = "POSTCODE")
	private String postCode;
	
	public HomeAddress() {
	}
	
	public HomeAddress(String street, String postCode) {
		this.street = street;
		this.postCode = postCode;
	}
	
	public String getStreet() {
		return street;
	}

	public String getPostCode() {
		return postCode;
	}
}
