package com.sharath.java8.examples;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8_Task {
	public static void main(String[] args) {
		System.out.println("----------------------------------------------------------------------");
		String[] values = { "plant_code", "mill_code", "product_code", "sub_productcode", "plant_code",
				"product_code" };
		List<String> listObj = Arrays.asList(values);
		List<String> uniqueValue = listObj.stream().distinct().collect(Collectors.toList());
		uniqueValue.forEach(System.out::println);

		System.out.println("----------------------------------------------------------------------");
		Integer[] numbers = { 1, 3, 5, 8, 12 };
		List<Integer> listNumbers = Arrays.asList(numbers);
		int uniqueNumbers = listNumbers.stream().max(Integer::compareTo).get();
		// int uniqueNumbers=listNumbers.stream().min(Integer::compareTo).get();
		System.out.println("Biggest Value " + uniqueNumbers);

		System.out.println("----------------------------------------------------------------------");
		String value = "viewConstraintEngine";
		Map<Character, Long> listChar = value.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));
		listChar.entrySet().stream().filter(c -> c.getValue() > 1).forEach(c -> System.out.print(c));

		System.out.println("----------------------------------------------------------------------");
		Integer[] numbers2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Arrays.asList(numbers2).stream().filter(n -> n % 2 == 0).collect(Collectors.toList())
				.forEach(System.out::println);

		System.out.println("----------------------------------------------------------------------");
		String name1 = "Master";
		String name2 = "Constraints";
		String name3 = "Packages";
		StringJoiner stringValues = new StringJoiner(",");
		stringValues.add(name1);
		stringValues.add(name2);
		stringValues.add(name3);
		System.out.println("full name " + stringValues);

		System.out.println("----------------------------------------------------------------------");
		Random r = new Random();
		r.ints().limit(5).forEach(System.out::println);

		System.out.println("----------------------------------------------------------------------");
		String[] names = { "PlantCode", "ProductCode", "Stock" };
		Arrays.asList(names).stream().filter(name -> name.length() > 5).collect(Collectors.toList())
				.forEach(System.out::println);

		System.out.println("----------------------------------------------------------------------");
		Integer[] number = { 1, 2, 3, 4, 5 };
		Arrays.asList(number).stream().map(i -> i * 3).collect(Collectors.toList()).forEach(System.out::println);

		System.out.println("----------------------------------------------------------------------");
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> list2 = Arrays.asList(6, 7, 8, 9, 10);
		Stream<Integer> listNumbers2 = Stream.concat(list1.stream(), list2.stream());
		listNumbers2.forEach(System.out::print);

		System.out.println("----------------------------------------------------------------------");
		int[] listNumbers3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		long count = Arrays.stream(listNumbers3).count();
		System.out.println(count);

		System.out.println("----------------------------------------------------------------------");
		List<Integer> listNumb = Arrays.asList(1, 3, 4, 2, 8, 4, 7, 10, 5, 1);
		listNumb.stream().distinct().sorted().forEach(System.out::println);

		System.out.println("----------------------------------------------------------------------");
		List<Integer> listNumb3 = Arrays.asList(1, 3, 4);
		System.out.println(listNumb3.stream().mapToInt(Integer::intValue).sum());

		System.out.println("----------------------------------------------------------------------");
		List<Integer> listNumb4 = Arrays.asList(10, 20, 30, 40, 50, 60);
		listNumb4.stream().filter(i -> i > 50).forEach(System.out::println);
	}

}
