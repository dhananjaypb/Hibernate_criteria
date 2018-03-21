package com.hibernate.sample;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class HibernateOperations  {

	public boolean addUser(User u) {
		Session s = HibernateCommonOperations.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(u);
		HibernateCommonOperations.closeResource(s, t);
		return true;
	}

	public boolean addAllUser(List<User> l) {
		Session s = HibernateCommonOperations.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		for (User u : l) {
			s.save(u);
		}
		HibernateCommonOperations.closeResource(s, t);
		return true;
	}

	public boolean updateUser(User u) {
		Session s = HibernateCommonOperations.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		s.update(u);
		HibernateCommonOperations.closeResource(s, t);
		return true;
	}

	public User getUser(int i) {
		Session s = HibernateCommonOperations.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		User u = (User) s.get(User.class, i);

		HibernateCommonOperations.closeResource(s, t);
		return u;
	}

	public boolean deleteUser(int i) {
		Session s = HibernateCommonOperations.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		if (getUser(i) == null) {
			System.out.println("User not present");
		}
		User u = getUser(i);
		s.delete(u);
		HibernateCommonOperations.closeResource(s, t);
		return true;
	}

	public List<User> getAllUser() {
		Session s = HibernateCommonOperations.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		List<User> l = s.createQuery("from User").list();
		return l;
	}

	/*--------------Criteria practicals---------------*/

	public List<User> getUserWhoseLess40k() {
		Session s = HibernateCommonOperations.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		Criteria c = s.createCriteria(User.class);
		Criterion cr = Restrictions.le("pincode", 40000);
		c.add(cr);
		List<User> l = c.list();
		HibernateCommonOperations.closeResource(s, t);
		return l;
	}

	public List<User> getMaxPincode() {
		Session s = HibernateCommonOperations.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		Criteria c = s.createCriteria(User.class);
		c.setProjection(Projections.max("pincode"));
		List<User> l = c.list();
		HibernateCommonOperations.closeResource(s, t);
		return l;
	}

	public List<User> getDistinctCountOfCity() {
		Session s = HibernateCommonOperations.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		Criteria c = s.createCriteria(User.class);
		c.setProjection(Projections.countDistinct("city"));
		List<User> l = c.list();
		HibernateCommonOperations.closeResource(s, t);
		return l;
	}

	public User getSecondMaxPincode() {
		Session s = HibernateCommonOperations.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		Criteria c = s.createCriteria(User.class);
		c.addOrder(Order.desc("pincode"));
		List<User> l = c.list();
		HibernateCommonOperations.closeResource(s, t);
		return l.get(1);
	}

	public List<User> getDistinctOfCity() {
		Session s = HibernateCommonOperations.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		Criteria c = s.createCriteria(User.class);
		c.setProjection(Projections.countDistinct("city"));
		List<User> l = c.list();
		HibernateCommonOperations.closeResource(s, t);
		return l;
	}
	
	public List<User> getGreaterId() {
		Session s = HibernateCommonOperations.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		Criteria c = s.createCriteria(User.class);
		Criterion cr = Restrictions.gt("id", 100);
		c.add(cr);
		List<User> l = c.list();
		HibernateCommonOperations.closeResource(s, t);
		return l;
	}
	
	public List<User> getWithTwoCondition() {
		Session s = HibernateCommonOperations.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		Criteria c = s.createCriteria(User.class);
		
		/*Criterion cr = Restrictions.gt("id", 100);
		Criterion cr1 = Restrictions.le("pincode", 41000);*/
		
		/*Criterion cr = Restrictions.ilike("name", "A%");
		Criterion cr1 = Restrictions.ilike("city", "P%");*/
		
		Criterion cr = Restrictions.between("id", 99, 107);
		Criterion cr1 = Restrictions.ilike("city", "k%");
		Criterion cr2 = Restrictions.and(cr1,cr);
		c.add(cr2);
		List<User> l = c.list();
		HibernateCommonOperations.closeResource(s, t);
		return l;
	}
	
	public List<User> getMaxDistinct(){
		Session s = HibernateCommonOperations.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		Criteria c = s.createCriteria(User.class);
		c.setProjection(Projections.id());
		List<User> l= c.list();
		HibernateCommonOperations.closeResource(s, t);
		return l;
		}
	
	public List<User> getUserAscending(){
		Session s = HibernateCommonOperations.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		Criteria c = s.createCriteria(User.class);
		c.addOrder(Order.asc("city"));
		List<User> l= c.list();
		return l;
	}

}
