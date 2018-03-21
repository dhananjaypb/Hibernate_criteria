package com.hibernate.sample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateCommonOperations {
	
	static SessionFactory sf= null;
	
	public static SessionFactory getSessionFactory(){
		
		if(sf==null){
			Configuration cf = new Configuration();
			SessionFactory sf = cf.configure().buildSessionFactory();
			return sf;
		}
		else
			return sf;
	}

	public static void closeResource(Session s,Transaction t){
		t.commit();
		s.close();	
	}
	
}
