package com.yatin.example.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@Transient
	private Set<String> images = new HashSet<String>();
	
	public Item() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getImages() {
		return images;
	}

	public void setImages(Set<String> images) {
		this.images = images;
	}
}
