package com.bhusal.config;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
	
	public static Session config() {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		return session;
	}

}
