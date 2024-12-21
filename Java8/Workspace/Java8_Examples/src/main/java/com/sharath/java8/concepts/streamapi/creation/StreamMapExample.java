package com.sharath.java8.concepts.streamapi.creation;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMapExample {

	public static void main(String[] args) {
		List<String> listNames = Arrays.asList("Java", "Angular", "spring");
		List<Integer> listValues = listNames.stream().map(String::length).collect(Collectors.toList());
		listValues.forEach(System.out::println);

		Map<Integer, String> listval = listNames.stream().collect(Collectors.toMap(String::length, s -> s));
		System.out.println("listval " + listval);

		listNames.stream().map(String::toUpperCase).forEach(System.out::println);
	}
}