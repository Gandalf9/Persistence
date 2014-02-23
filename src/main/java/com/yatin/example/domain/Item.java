package com.yatin.example.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@ElementCollection
	private Map<String, Image> images = new HashMap<String, Image>();
	
	@OneToMany(mappedBy="item", orphanRemoval=true, cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<Bid> bids = new HashSet<Bid>();
	
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

	public Map<String, Image> getImages() {
		return images;
	}

	public void setImages(Map<String, Image> images) {
		this.images = images;
	}

	public Set<Bid> getBids() {
		return bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}
	
	public void addBid(Bid bid) {
		bid.setItem(this);
		bids.add(bid);
	}
}
