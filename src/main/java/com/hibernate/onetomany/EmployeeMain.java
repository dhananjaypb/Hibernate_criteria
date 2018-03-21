package com.hibernate.onetomany;

import com.hibernate.sample.HibernateOperations;

public class EmployeeMain {

	public static void main(String[] args) {
		Project p = new Project(1, "IBM", "Complete");
		Project p1 = new Project(2, "Vodafone", "Complete");
		
		Project p2 = new Project(3, "Coditas", "Complete");
		Project p3 = new Project(4, "UBS", "Complete");
		
		Employee e = new Employee(100, "Dhananjay", "Kolhapur", 416004, p);
		Employee e1 = new Employee(100, "Dhananjay", "Kolhapur", 416004, p1);
		
		Employee e3 = new Employee(101, "Adnaan", "Wagholi", 461004, p2);
		Employee e4 = new Employee(101, "Adnaan", "Wagholi", 461004, p3);
		
		HibernateOperation ho = new HibernateOperation();
/*		ho.addEmployee(e);
		ho.addEmployee(e1);
		ho.addEmployee(e3);
		ho.addEmployee(e4);
*/		
		System.out.println(ho.getJoin());
	}
}
