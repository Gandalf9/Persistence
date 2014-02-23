package com.yatin.example.main;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.yatin.example.domain.Bid;
import com.yatin.example.domain.Item;


public class Main {

	public static void main(String[] args) {
		saveChildAndThenDelete();
	}
	
	private static void saveParentChildandThenDelete() {
		
		Item i = new Item();
		i.setName("pingu");
		
		Bid b = new Bid();
		b.setAmount(22.33);
		
		i.addBid(b);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("helloworld");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(i);
		
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		
		em.remove(i);
		
		em.getTransaction().commit();
	}
	
	private static void saveChildAndThenDelete() {
		Item i = new Item();
		i.setName("pingu");
		
		Bid b1 = new Bid();
		b1.setAmount(11.11);
		
		Bid b2 = new Bid();
		b2.setAmount(22.22);
		
		Bid b3 = new Bid();
		b3.setAmount(33.33);
		
		i.addBid(b1);
		i.addBid(b2);
		i.addBid(b3);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("helloworld");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(i);
		
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		
		Item item = em.find(Item.class, i.getId());
		Set<Bid> bids = item.getBids();
		Bid bid = bids.iterator().next();
		item.getBids().remove(bid);
		
		em.persist(item);
		
		em.getTransaction().commit();
	}
}
