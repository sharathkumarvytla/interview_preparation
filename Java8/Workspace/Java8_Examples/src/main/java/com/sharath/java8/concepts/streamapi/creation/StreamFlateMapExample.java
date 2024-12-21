package com.sharath.java8.concepts.streamapi.creation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlateMapExample {

	public static void main(String[] args) {
		List<Integer> evenNumber = Arrays.asList(2, 4, 6, 8);
		List<Integer> addNumber = Arrays.asList(1, 3, 5, 7, 9);
		List<List<Integer>> listAllNumb = Arrays.asList(evenNumber, addNumber);
		List<Integer> listNuum = listAllNumb.stream().flatMap(List::stream).sorted().collect(Collectors.toList());
		listNuum.forEach(System.out::print);
		System.out.println("");
		List<Integer> listNuum2 = listAllNumb.stream().flatMap(List::stream).sorted((i, j) -> j.compareTo(i))
				.collect(Collectors.toList());
		listNuum2.forEach(System.out::print);
		System.out.println("");
		List<String> listNames = Arrays.asList("Java", "Angular", "spring");
		List<String> listUpdatedNames = listNames.stream().sorted(String.CASE_INSENSITIVE_ORDER)
				.collect(Collectors.toList());
		listUpdatedNames.forEach(System.out::println);

		List<String> listNames2 = Arrays.asList("Java", "Angular", "spring");
		List<String> listUpdatedNames2 = listNames2.stream().sorted(String.CASE_INSENSITIVE_ORDER.reversed())
				.collect(Collectors.toList());
		listUpdatedNames2.forEach(System.out::println);

	}
}