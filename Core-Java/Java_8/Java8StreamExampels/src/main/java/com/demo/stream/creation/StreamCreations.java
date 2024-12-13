package com.demo.stream.creation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreations {
	
	//  We have 5 types of creation methods in java8 like 
	//	1. of(T... values): Creates a stream from specified values.
	//	2. ofNullable(T value): Creates a single-element stream if the value is non-null; otherwise, an empty stream.
	//	3. generate(Supplier<T> s): Creates an infinite stream where each element is generated using the supplier.
	//	4. iterate(T seed, UnaryOperator<T> f): Creates an infinite stream starting with a seed and iteratively applying a function.
	//	5. builder(): Creates a builder for a stream.
	
	public static void main(String[] args) {
		
		// of(T... values)
		Stream<String> listChar = Stream.of("A","B","C","D");
		listChar.forEach(System.out::println);
		System.out.println("----------------------------------------------------------");
		// ofNullable(T value)
		Stream<String> nullableStream = Stream.ofNullable(null);
		System.out.println("Exp1 - Count is : "+nullableStream.count());
		System.out.println("----------------------------------------------------------");
		List<String> listValues = Arrays.asList("A","B",null,"D",null);
		long count = listValues.stream().filter( value -> value == null).count();
		System.out.println("Exp2 - count is "+count);
		System.out.println("----------------------------------------------------------");
		// generate(Supplier<T> s)
		Stream<Double> randomNumber = Stream.generate(Math::random).limit(5);
		randomNumber.forEach(System.out::println);
		System.out.println("----------------------------------------------------------");
		// iterate
		Stream<Integer> iterateStream = Stream.iterate(1, n -> n+2).limit(5);
		iterateStream.forEach(System.out::println);
		System.out.println("----------------------------------------------------------");
		// builder
		Stream<String> streamBuild = Stream.<String>builder().add("X").add("Y").add("Z").build();
		streamBuild.forEach(System.out::println);
	}


}
