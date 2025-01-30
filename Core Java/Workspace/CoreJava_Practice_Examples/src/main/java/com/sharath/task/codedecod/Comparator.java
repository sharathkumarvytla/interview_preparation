package com.sharath.task.codedecod;

class EmployeeComparator implements java.util.Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {

		int nameComparision = o1.getName().compareTo(o2.getName());
		if (nameComparision != 0)
			return nameComparision;
		int ageComparision = Integer.compare(o1.getAge(), o2.getAge());
		if (ageComparision != 0)
			return ageComparision;
		int addressComparison = o1.getAddress().compareTo(o2.getAddress());
		return Integer.signum(addressComparison);
	}
}

public class Comparator {

	public static void main(String[] args) {

		Employee e1 = new Employee("Alice", 30, "123 Elm Street");
		Employee e2 = new Employee("Bob", 25, "456 Oak Avenue");
		Employee e3 = new Employee("Alice", 30, "789 Pine Road");
		EmployeeComparator empComparator = new EmployeeComparator();
		System.out.println("Comparison between e1 and e2: " + empComparator.compare(e1, e2)); // Based on name
		System.out.println("Comparison between e1 and e3: " + empComparator.compare(e1, e3)); // Based on address
		System.out.println("Comparison between e2 and e3: " + empComparator.compare(e2, e3)); // Based on name

	}
}
