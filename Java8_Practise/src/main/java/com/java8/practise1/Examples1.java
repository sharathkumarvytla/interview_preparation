package com.java8.practise1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
interface MyFunctionalInterface {

	public int sum(int a, int b);

}

class Employee {
	String name;
	double salary;

	Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String toString() {
		return name + ": " + salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}

class Employee2 {
	String name;
	String department;

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

	Employee2(String name, String department) {
		this.name = name;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee2 [name=" + name + ", department=" + department + "]";
	}
	
}

public class Examples1 {

	public static void main(String[] args) {

		// What is a functional interface? Write an example of one
		MyFunctionalInterface function = (val1, val2) -> val1 + val2;
		System.out.println("Sum of values : " + function.sum(10, 20));
		System.out.println("---------------------------------------------");

		// Given a list of integers, filter all even numbers, multiply them by 2, and
		// collect them into a list
		List<Integer> listNumber = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> listUpdatedValues = listNumber.stream().filter(n -> n % 2 == 0).map(n -> n * 2)
				.collect(Collectors.toList());
		listUpdatedValues.forEach(System.out::println);
		System.out.println("---------------------------------------------");

		// Write a program to safely access a value using Optional
		String message = "Hello world";
		Optional<String> optionalMessage = Optional.ofNullable(message);
		optionalMessage.ifPresent(System.out::println);

		String defultMessage = optionalMessage.orElse("Defualt Message");
		System.out.println(defultMessage);
		System.out.println("---------------------------------------------");

		// Sort a list of Employee objects by their salary in descending order
		List<Employee> employees = Arrays.asList(new Employee("John", 40000), new Employee("Emma", 60000),
				new Employee("Sam", 50000));

		List<Employee> updatedEmpData = employees.stream()
				.sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).collect(Collectors.toList());
		updatedEmpData.forEach(System.out::println);

		// Group a list of strings by their length
		List<String> words = Arrays.asList("Java", "Kotlin", "Stream", "Codes");
		Map<Integer, List<String>> listWordLength = words.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(listWordLength);

		// Write a program to calculate the sum of a list of integers using parallel
		// streams
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		int sumValue = numbers.stream().mapToInt(Integer::intValue).sum();
		System.out.println("Sum value is " + sumValue);

		// Write a custom collector to concatenate strings in uppercase
		Stream<String> stream = Stream.of("java", "streams", "collector");
		String result = stream.collect(Collector.of(StringBuilder::new, (sb, s) -> sb.append(s.toUpperCase()),
				StringBuilder::append, StringBuilder::toString));
		System.out.println("result : " + result);

		// Demonstrate the difference between map() and flatMap()
		List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));

		List<List<Integer>> listValues1 = nestedList.stream().map(list -> list).collect(Collectors.toList());
		listValues1.forEach(System.out::print);
		System.out.println();
		List<Integer> listValues2 = nestedList.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
		listValues2.forEach(System.out::print);
		System.out.println();

		// Count the occurrences of each character in a string using streams
		String input = "java8streams";
		Map<Character, Long> charCount = input.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(charCount);

		// Check if all elements in a list are even
		List<Integer> numbers2 = Arrays.asList(2, 4, 6, 8, 11);
		Boolean ifMatchAll = numbers2.stream().allMatch(n -> n % 2 == 0);
		System.out.println("ifMatchAll : " + ifMatchAll);

		// Given a list of integers, find the second-highest number using Java 8
		// features
		List<Integer> listNumbers = Arrays.asList(3, 1, 4, 6, 5, 2);
		Optional<Integer> secoundHighestValue = listNumbers.stream().distinct().sorted(Comparator.reverseOrder())
				.skip(1).findFirst();
		System.out.println("secoundHighestValue : " + secoundHighestValue.get());

		// Given a list of employees, group them by their department using Java 8
		List<Employee2> employees2 = Arrays.asList(
			    new Employee2("John", "HR"),
			    new Employee2("Jane", "Finance"),
			    new Employee2("Jack", "HR"),
			    new Employee2("Anna", "Finance")
			);
		Map<String, List<Employee2>> groupedByDepartment = employees2.stream().collect(Collectors.groupingBy(Employee2::getDepartment));
		groupedByDepartment.forEach((dept, empList) -> {
		    System.out.println(dept + ": " + empList.stream().map(e -> e.name).collect(Collectors.joining(", ")));
		});
		
	}

}
