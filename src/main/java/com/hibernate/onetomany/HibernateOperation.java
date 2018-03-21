package com.hibernate.onetomany;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.sample.HibernateCommonOperations;
import com.hibernate.sample.User;

public class HibernateOperation {

	public boolean addEmployee(Employee u) {
		Session s = HibernateCommonOperations.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(u);
		HibernateCommonOperations.closeResource(s, t);
		return true;
	}

	public boolean addAllEmployee(List<Employee> l) {
		Session s = HibernateCommonOperations.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		for (Employee u : l) {
			s.save(u);
		}
		HibernateCommonOperations.closeResource(s, t);
		return true;
	}

	public boolean updateEmployee(Employee u) {
		Session s = HibernateCommonOperations.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		s.update(u);
		HibernateCommonOperations.closeResource(s, t);
		return true;
	}

	public Employee getEmployee(int i) {
		Session s = HibernateCommonOperations.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		Employee u = (Employee) s.get(Employee.class, i);

		HibernateCommonOperations.closeResource(s, t);
		return u;
	}

	public boolean deleteEmployee(int i) {
		Session s = HibernateCommonOperations.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		if (getEmployee(i) == null) {
			System.out.println("Employee not present");
		}
		Employee u = getEmployee(i);
		s.delete(u);
		HibernateCommonOperations.closeResource(s, t);
		return true;
	}

	public List<Employee> getAllEmployee() {
		Session s = HibernateCommonOperations.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		List<Employee> l = s.createQuery("from Employee").list();
		return l;
	}
	
					/*-------Criteria methods-----------*/
	
	public List<Employee> getJoin(){
		Session s = HibernateCommonOperations.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		Criteria cr = s.createCriteria(Employee.class);
		cr.setFetchMode("project", FetchMode.LAZY);
		List<Employee> l = cr.list();
		return l;
	}

}
