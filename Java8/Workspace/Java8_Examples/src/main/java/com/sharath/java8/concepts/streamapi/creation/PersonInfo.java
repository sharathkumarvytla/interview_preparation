package com.sharath.java8.concepts.streamapi.creation;

import java.util.List;

public class PersonInfo {

	private String name;
	private long height;
	private double salary;
	private String gender;
	private int kids;
	private List<String> hobbies;

	public PersonInfo(String name, long height, double salary, String gender, int kids, List<String> hobbies) {
		super();
		this.name = name;
		this.height = height;
		this.salary = salary;
		this.gender = gender;
		this.kids = kids;
		this.hobbies = hobbies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getHeight() {
		return height;
	}

	public void setHeight(long height) {
		this.height = height;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getKids() {
		return kids;
	}

	public void setKids(int kids) {
		this.kids = kids;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "PersonInfo [name=" + name + ", height=" + height + ", salary=" + salary + ", gender=" + gender
				+ ", kids=" + kids + ", hobbies=" + hobbies + "]";
	}

}
