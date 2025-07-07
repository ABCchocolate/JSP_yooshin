package com.sinse.hiberasync.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
	private SessionFactory sessionFactory;
	private static HibernateConfig instance;
	
	private HibernateConfig() {
		//hibernate does not notify the location.. so you could locate config file in resources folder
		sessionFactory= new Configuration().configure().buildSessionFactory();
	}
	public static HibernateConfig getInstance() {
		if(instance ==null) {
			instance = new HibernateConfig();
		}
		return instance;
	};
	
	
	//From the SessionFactory, there is a method that performed the query.
	public Session getSesstion() {
		return sessionFactory.openSession();
	}
}
