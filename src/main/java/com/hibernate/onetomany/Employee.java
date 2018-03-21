package com.hibernate.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@Column(name = "Employee_Id")
	private int id;
	@Column(name = "Employee_Name")
	private String name;
	@Column(name = "Employee_City")
	private String city;
	@Column(name = "Employee_Pincode")
	private int pincode;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	Project p;
	
	public Employee(int id, String name, String city, int pincode, Project p) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.pincode = pincode;
		this.p = p;
	}

	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Project getP() {
		return p;
	}

	public void setP(Project p) {
		this.p = p;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", city=" + city + ", pincode=" + pincode + ", p=" + p + "]";
	}
	
}
