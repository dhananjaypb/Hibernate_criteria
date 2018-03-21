package com.hibernate.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Project")
public class Project {
	@Id
	@Column(name="Project_number")
	private int number;
	@Column(name="Project_name")
	private String name;
	@Column(name="Project_status")
	private String status;
	
	public Project(int number, String name, String status) {
		super();
		this.number = number;
		this.name = name;
		this.status = status;
	}

	public Project() {
		super();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Project [number=" + number + ", name=" + name + ", status=" + status + "]";
	}
	
}
