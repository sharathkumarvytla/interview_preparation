package com.sharath.java8.concepts.repository;

public class Employee2 {
	public String name;
	public String department;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Employee2(String name, String department) {
		this.name = name;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee2 [name=" + name + ", department=" + department + "]";
	}
}
