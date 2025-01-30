package com.sharath.java8.codedecod;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {

	public static void main(String[] args) {

		List<Employee> listEmp = Arrays.asList(new Employee("Alice", 30, "123 Elm Street"),
				new Employee("Bob", 25, "456 Oak Avenue"), new Employee("Alice", 30, "789 Pine Road"));

		Comparator<Employee> listEmployee = Comparator.comparing(Employee::getName).thenComparing(Employee::getAge)
				.thenComparing(Employee::getAddress);
		listEmp.sort(listEmployee);
		listEmp.forEach(System.out::println);
	}
}