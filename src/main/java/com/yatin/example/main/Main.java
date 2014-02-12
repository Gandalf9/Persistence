package com.yatin.example.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.ejb.HibernateEntityManager;

import com.yatin.example.domain.Address;
import com.yatin.example.domain.HomeAddress;
import com.yatin.example.domain.Message;
import com.yatin.example.domain.User;

public class Main {

	public static void main(String[] args) {
//		startEntityManager();
		saveEmmbeddedComponent();
	}
	
	private static void saveEmmbeddedComponent() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("helloworld");
		EntityManager em = emf.createEntityManager();
		
		User user = new User(1, "Bob");
		HomeAddress homeAddress = new HomeAddress("street", "postcode");
		user.setHomeAddress(homeAddress);
		
		HomeAddress billingAddress = new HomeAddress("street1", "postcode1");
		user.setBillingAddress(billingAddress);
		
		em.getTransaction().begin();
		
		em.persist(user);
		
		em.getTransaction().commit();
		em.close();
	}

	private static void startEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("helloworld");
		EntityManager em = emf.createEntityManager();
		
		HibernateEntityManager hem = (HibernateEntityManager) em;
		Session sess = hem.getSession();
		
		Message msg = new Message();
		msg.setId(2L);
//		msg.setText("Something");
		
		sess.getTransaction().begin();
		sess.persist(msg);
		sess.save(msg);
		
		System.out.println(msg.getText());
		
		sess.flush();
		
		System.out.println(msg.getText());
		
		sess.getTransaction().commit();
		sess.close();
	}
}
