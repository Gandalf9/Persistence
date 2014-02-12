package com.yatin.example.domain;

import javax.persistence.Entity;

@Entity
public class BankAccount extends BillingDetails {

	private String account;
	
	private String bankname;
	
	private String swift;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getSwift() {
		return swift;
	}

	public void setSwift(String swift) {
		this.swift = swift;
	}
}
