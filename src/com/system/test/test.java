package com.system.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.system.domain.User;

public class test {
	
	@Test
	public void testdata(){
		User user = new User();
		
		user.setUsername("Ð¡ºÚ");
		user.setPassword("123");
		
		Configuration config = new Configuration();
		config.configure();
		
		SessionFactory sf = config.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		sf.close();
	}

}
