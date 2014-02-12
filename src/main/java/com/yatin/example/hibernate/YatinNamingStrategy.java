package com.yatin.example.hibernate;

import org.hibernate.cfg.ImprovedNamingStrategy;

public class YatinNamingStrategy extends ImprovedNamingStrategy {

	private static final long serialVersionUID = 1037094587947288990L;
	
	@Override
	public String tableName(String tableName) {
		String s = super.tableName(tableName);
		return "yatin_" + s;
	}
}
