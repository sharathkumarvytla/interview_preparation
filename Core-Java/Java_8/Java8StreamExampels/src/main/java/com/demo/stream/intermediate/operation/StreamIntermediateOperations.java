package com.demo.stream.intermediate.operation;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class StreamIntermediateOperations {
	
//	    We have 11 types of intermediate operations
//		filter(Predicate<? super T> predicate): Filters elements based on the predicate.
//		map(Function<? super T, ? extends R> mapper): Transforms elements by applying a function.
//		flatMap(Function<? super T, ? extends Stream<? extends R>> mapper): Flattens streams of streams into a single stream.
//		distinct(): Removes duplicate elements.
//		sorted(): Sorts elements in natural order.
//		sorted(Comparator<? super T> comparator): Sorts elements using a comparator.
//		peek(Consumer<? super T> action): Allows performing actions on elements without modifying them.
//		limit(long maxSize): Truncates the stream to a specific size.
//		skip(long n): Skips the first n elements.
//		takeWhile(Predicate<? super T> predicate) (Java 9+): Takes elements while the predicate is true.
//		dropWhile(Predicate<? super T> predicate) (Java 9+): Drops elements while the predicate is true.

	public static void main(String[] args) {
		// filter(Predicate<? super T> predicate)
		List<String> listNames = Arrays.asList("AAA", "BBB", "CCC", "DDD");
		listNames.stream().filter(name -> name.startsWith("A")).forEach(System.out::println);
		System.out.println("---------------------------------------------------");
		// map(Function<? super T, ? extends R> mapper)
		listNames.stream().map(String::toLowerCase).forEach(System.out::println);
		System.out.println("---------------------------------------------------");
		// flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
		List<List<String>> nestedLists = Arrays.asList(Arrays.asList("A", "B"), Arrays.asList("C", "D"));
		nestedLists.stream().flatMap(Collection::stream).forEach(System.out::println);
		System.out.println("---------------------------------------------------");
		// distinct():
		List<String> duplicateNames = Arrays.asList("Alice", "Bob", "Alice");
		duplicateNames.stream().distinct().forEach(System.out::println);
		System.out.println("---------------------------------------------------");
		// sorted()
		List<String> names = Arrays.asList("Ccc","Ddddd","Bb","A");
		names.stream().sorted().forEach(System.out::println);
		System.out.println("---------------------------------------------------");
		names.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		System.out.println(names);
		System.out.println("---------------------------------------------------");
		//peek(Consumer<? super T> action)
		listNames.stream().peek(name -> System.out.println("processing "+name)).forEach(System.out::println);
		System.out.println("---------------------------------------------------");
		// limit(long maxSize)
		listNames.stream().limit(2).forEach(System.out::println);
		System.out.println("---------------------------------------------------");
		// skip(long n)
		listNames.stream().skip(1).forEach(System.out::println);
		System.out.println("---------------------------------------------------");
		// takeWhile(Predicate<? super T> predicate)
		 List<String> words = List.of("apple", "banana", "cherry", "avocado", "blueberry");
	    // Take words starting with 'a'
		List<String> result = words.stream().takeWhile(word -> word.startsWith("a")).toList();
		System.out.println("Words starting with 'a': " + result);
		System.out.println("---------------------------------------------------");
	    // dropWhile(Predicate<? super T> predicate) - java 9
		List<String> words2 = List.of("apple", "avocado", "banana", "cherry", "blueberry");
        // Drop words starting with 'a' - java 9
        List<String> result2 = words2.stream()
                .dropWhile(word -> word.startsWith("a"))
                .toList();
        System.out.println("Words after skipping those starting with 'a': " + result2);
	}
}
