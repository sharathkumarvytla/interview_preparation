package com.demo.stream.terminal.operation;

import java.lang.System.Logger;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamTerminalOperations {
	
	//  We have 15 type of terminal operations like 
	//	forEach(Consumer<? super T> action): Performs the given action for each element.
	//	forEachOrdered(Consumer<? super T> action): Performs the action on elements in encounter order.
	//	toArray(): Collects elements into an array.
	//	reduce(BinaryOperator<T> accumulator): Reduces the elements of the stream into a single value using the provided function.
	//	reduce(T identity, BinaryOperator<T> accumulator): Reduces with an initial value and accumulator.
	//	collect(Collector<? super T, A, R> collector): Performs a mutable reduction using a collector (e.g., Collectors.toList()).
	//	collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner): Another way to collect elements manually.
	//	count(): Returns the number of elements in the stream.
	//	anyMatch(Predicate<? super T> predicate): Returns true if any element matches the predicate.
	//	allMatch(Predicate<? super T> predicate): Returns true if all elements match the predicate.
	//	noneMatch(Predicate<? super T> predicate): Returns true if no elements match the predicate.
	//	findFirst(): Returns the first element in the stream (Optional).
	//	findAny(): Returns any element in the stream (Optional).
	//	max(Comparator<? super T> comparator): Returns the maximum element.
	//	min(Comparator<? super T> comparator): Returns the minimum element.
	
	public static void main(String[] args) {
		// forEach(Consumer<? super T> action)
		List<String> listValues = Arrays.asList("AAA", "BBB", "CCC", "DDD");
		listValues.forEach(System.out::println);
		System.out.println("---------------------------------------------------");
		// forEachOrdered(Consumer<? super T> action)
		List<String> listValues2 = Arrays.asList("A", "B", "C", "D");
		listValues2.parallelStream().forEach(System.out::println);
		System.out.println("");
		listValues2.parallelStream().forEachOrdered(System.out::println);
		System.out.println("----------------------------------------------------");
		// toArray()
		List<String> listValues3 = Arrays.asList("A", "B", "C", "D");
		String[] namesArray = listValues3.stream().toArray(String[]::new);
		System.out.println(Arrays.toString(namesArray));
		System.out.println("----------------------------------------------------");
		// reduce(BinaryOperator<T> accumulator)
		List<Integer> listNumber = Arrays.asList(1, 2, 3, 4, 5);
		int sum = listNumber.stream().reduce(0, Integer::sum); // 0 indicate start value for doing sum like 0+1 = 1, 1+2 = 3 ...
		System.out.println("Exp1 sum is " + sum); // Output is 15
		Optional<Integer> sum2 = listNumber.stream().reduce(Integer::sum);
		System.out.println("Exp2 sum is " + sum2); // Output Optional[15]
		System.out.println("----------------------------------------------------");
		// collect(Collector<? super T, A, R> collector)
		List<String> listNames = Arrays.asList("AAA", "BBB", "CCC", "DDD", "AAA");
		Set<String> uniqueData = listNames.stream().collect(Collectors.toSet());
		uniqueData.forEach(System.out::println);
		System.out.println("----------------------------------------------------");
		// count()
		List<String> listNames2 = Arrays.asList("AAA", "BBB", "CCC", "DDD", "AAA");
		long count = listNames2.stream().count();
		System.out.println("Count " + count);
		System.out.println("----------------------------------------------------");
		// anyMatch(Predicate<? super T> predicate)
		List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 8);
		boolean isHaveEven = numbers.stream().anyMatch(n -> n % 2 == 0);
		System.out.println("Is have even number : " + isHaveEven);
		System.out.println("----------------------------------------------------");
		// anyMatch(Predicate<? super T> predicate)
		List<Integer> numbers2 = Arrays.asList(2, 4, 6, 8);
		boolean isHaveEvenAll = numbers2.stream().allMatch(n -> n % 2 == 0);
		System.out.println("Is all even number : " + isHaveEvenAll);
		System.out.println("----------------------------------------------------");
		// noneMatch(Predicate<? super T> predicate)
		List<Integer> numbers3 = Arrays.asList(1, 3, 5, 7);
		boolean isHaveEven3 = numbers3.stream().noneMatch(n -> n % 2 == 0);
		System.out.println("Is not have even number : " + isHaveEven3);
		System.out.println("----------------------------------------------------");
		// findFirst()
		List<String> listNames3 = Arrays.asList("AAA", "BBB", "CCC", "DDD", "AAA");
		Optional<String> value = listNames3.stream().findFirst();
		System.out.println("value " + value);
		System.out.println("----------------------------------------------------");
		List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
		Optional<String> values = words.stream().filter(n -> n.contains("an")).findAny();
		System.out.println("values " + values);
		System.out.println("----------------------------------------------------");
		// max(Comparator<? super T> comparator)
		List<Integer> listNumbers = Arrays.asList(1, 2, 3, 4);
		Optional<Integer> maxNumber = listNumbers.stream().max(Integer::compareTo);
		System.out.println("Max number is " + maxNumber);
		System.out.println("----------------------------------------------------");
		// min(Comparator<? super T> comparator)
		List<Integer> listNumbers2 = Arrays.asList(1, 2, 3, 4);
		Optional<Integer> minNumber = listNumbers2.stream().min(Integer::compareTo);
		System.out.println("Min number is " + minNumber);
		System.out.println("----------------------------------------------------");
	}

}
