package com.sharath.java8.concepts;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.sharath.java8.concepts.repository.Employee;
import com.sharath.java8.concepts.repository.Employee2;
import com.sharath.java8.concepts.repository.MyFunctionalInterface;

public class StreamAPI {

	public static void main(String[] args) {

		System.out.println("---------------------------------------------");
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

		System.out.println("---------------------------------------------");
		// Group a list of strings by their length
		List<String> words = Arrays.asList("Java", "Kotlin", "Stream", "Codes");
		Map<Integer, List<String>> listWordLength = words.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(listWordLength);

		System.out.println("---------------------------------------------");
		// Write a program to calculate the sum of a list of integers using parallel
		// streams
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		int sumValue = numbers.stream().mapToInt(Integer::intValue).sum();
		System.out.println("Sum value is " + sumValue);

		System.out.println("---------------------------------------------");
		// Write a custom collector to concatenate strings in uppercase
		Stream<String> stream = Stream.of("java", "streams", "collector");
		String result = stream.collect(Collector.of(StringBuilder::new, (sb, s) -> sb.append(s.toUpperCase()),
				StringBuilder::append, StringBuilder::toString));
		System.out.println("result : " + result);

		System.out.println("---------------------------------------------");
		// Demonstrate the difference between map() and flatMap()
		List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));

		List<List<Integer>> listValues1 = nestedList.stream().map(list -> list).collect(Collectors.toList());
		listValues1.forEach(System.out::print);
		System.out.println();
		List<Integer> listValues2 = nestedList.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
		listValues2.forEach(System.out::print);
		System.out.println();

		System.out.println("---------------------------------------------");
		// Count the occurrences of each character in a string using streams
		String input = "java8streams";
		Map<Character, Long> charCount = input.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(charCount);

		System.out.println("---------------------------------------------");
		// Check if all elements in a list are even
		List<Integer> numbers2 = Arrays.asList(2, 4, 6, 8, 11);
		Boolean ifMatchAll = numbers2.stream().allMatch(n -> n % 2 == 0);
		System.out.println("ifMatchAll : " + ifMatchAll);

		System.out.println("---------------------------------------------");
		// Given a list of integers, find the second-highest number using Java 8
		// features
		List<Integer> listNumbers = Arrays.asList(3, 1, 4, 6, 5, 2);
		Optional<Integer> secoundHighestValue = listNumbers.stream().distinct().sorted(Comparator.reverseOrder())
				.skip(1).findFirst();
		System.out.println("secoundHighestValue : " + secoundHighestValue.get());

		System.out.println("---------------------------------------------");
		// Given a list of employees, group them by their department using Java 8
		List<Employee2> employees2 = Arrays.asList(new Employee2("John", "HR"), new Employee2("Jane", "Finance"),
				new Employee2("Jack", "HR"), new Employee2("Anna", "Finance"));
		Map<String, List<Employee2>> groupedByDepartment = employees2.stream()
				.collect(Collectors.groupingBy(Employee2::getDepartment));
		groupedByDepartment.forEach((dept, empList) -> {
			System.out.println(dept + ": " + empList.stream().map(e -> e.name).collect(Collectors.joining(", ")));
		});

		System.out.println("---------------------------------------------");
		// Convert a list of strings to uppercase using Java 8
		List<String> values = Arrays.asList("apple", "banana", "cherry");
		values.stream().map(value -> value.toUpperCase()).forEach(System.out::println);

		System.out.println("---------------------------------------------");
		// Find the first non-repeated character in a string using Java 8.
		String value = "swiss";
		Character firstNonRepeated = value.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);
		System.out.println("firstNonRepeated " + firstNonRepeated);
		// --------------------------------------------------------
		Optional<Character> findValue = value.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(entry -> entry.getValue() == 1).map(entry -> entry.getKey()).findFirst();
		System.out.println(findValue.get());

		System.out.println("---------------------------------------------");
		// Sort a map by its values in ascending order
		Map<String, Integer> listValue = new HashMap<String, Integer>();
		listValue.put("A", 5);
		listValue.put("C", 2);
		listValue.put("D", 8);
		listValue.put("B", 6);

		Map<String, Integer> listUpdated = listValue.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println("listUpdated " + listUpdated);

		System.out.println("---------------------------------------------");
		// Count the occurrences of each word in a string
		String text = "hello world hello everyone";
		Map<String, Long> listWordCount = Arrays.stream(text.split("\\s+"))
				.collect(Collectors.groupingBy(word -> word, Collectors.counting()));
		System.out.println(listWordCount);

		System.out.println("---------------------------------------------");
		// Given a large list of numbers, compute their squares in parallel and collect
		// the results
		List<Integer> numbers3 = IntStream.rangeClosed(1, 1000).boxed().collect(Collectors.toList());
		List<Integer> squares = numbers3.parallelStream().map(n -> n * n).collect(Collectors.toList());
		squares.forEach(System.out::print);
		System.out.println();

		System.out.println("---------------------------------------------");
		// Flatten a list of lists into a single list using Java 8.
		List<List<String>> listObj = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"),
				Arrays.asList("c", "d"));
		List<String> updatedList = listObj.stream().flatMap(List::stream).collect(Collectors.toList());
		updatedList.forEach(System.out::print);

		System.out.println("---------------------------------------------");
		// Find Maximum Element in a List
		List<Integer> numbers5 = Arrays.asList(3, 5, 7, 2, 8);
		Optional<Integer> maxNum = numbers5.stream().max(Integer::compareTo);
		System.out.println("Max number is : " + maxNum.get());

		System.out.println("---------------------------------------------");
		// Remove duplicates from a list and sort it in ascending order
		List<Integer> numbers6 = Arrays.asList(5, 3, 5, 2, 8, 3, 9);
		numbers6.stream().distinct().sorted().forEach(System.out::println);
	}

}
