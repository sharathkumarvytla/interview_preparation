package com.demo.stream.parallel.sequal.operation;

import java.util.Arrays;
import java.util.List;

public class StreamParalelSequalOperations {
	
	//  We have 3 types of parallel and sequel operations
	//	parallel(): Converts a stream to parallel.
	//	sequential(): Converts a stream to sequential.
	//	unordered(): Removes encounter order, if any.
	
	public static void main(String[] args) {
		System.out.println("---------------------------------------------------");
		// parallel()
		List<String> listNames = Arrays.asList("C", "A", "D", "B");
		listNames.parallelStream().forEach(System.out::println);
		System.out.println("---------------------------------------------------");
		// sequential()
		listNames.stream().sequential().forEach(System.out::println);
		System.out.println("---------------------------------------------------");
		// unordered()
		listNames.stream().unordered().forEach(System.out::println);
		System.out.println("---------------------------------------------------");
		List<Integer> numbers = List.of(3, 1, 4, 5, 2);
		// Sorted stream
		numbers.stream().sorted().unordered().forEach(System.out::println);
		// Output: Elements may not be in sorted order
		System.out.println("---------------------------------------------------");
	}
}