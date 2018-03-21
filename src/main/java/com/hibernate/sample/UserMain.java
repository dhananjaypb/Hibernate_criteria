package com.hibernate.sample;

import java.util.ArrayList;
import java.util.List;

public class UserMain {

	public static void main(String[] args) {

		User u = new User(106, "Dhananjay", "Kolhapur", 416004);
		User u1 = new User(101, "Adnaan", "Patna", 60005);
		User u2 = new User(102, "Amar", "Sangli", 50004);
		User u3 = new User(103, "Nitin", "Sangli", 50004);
		User u4 = new User(104, "Vivek", "Pune", 20005);
		User u5 = new User(105, "Abhijeet", "PCMC", 10005);
		/*
		 * List<User> l = new ArrayList<User>(); l.add(u1); l.add(u2);
		 * l.add(u3); l.add(u4); l.add(u5); l.add(u);
		 */

		// System.out.println(u);

		HibernateOperations ho = new HibernateOperations();
		// ho.addUser(u);
		// ho.addAllUser(l);
		// System.out.println(ho.getUserWhoseLess40k());
		// System.out.println(ho.getMaxPincode());
		// System.out.println(ho.getDistinctCountOfCity());
		// System.out.println(ho.getSecondMaxPincode());
		// System.out.println(ho.getGreaterId());
		// System.out.println(ho.getWithTwoCondition());
		// System.out.println(ho.getMaxDistinct());
		// System.out.println(ho.getUserAscending());

	}

}
