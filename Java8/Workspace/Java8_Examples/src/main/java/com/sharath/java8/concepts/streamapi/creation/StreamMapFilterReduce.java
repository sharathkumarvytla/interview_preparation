package com.sharath.java8.concepts.streamapi.creation;

import java.util.Arrays;
import java.util.List;

public class StreamMapFilterReduce {

	public static void main(String[] args) {

		PersonInfo info1 = new PersonInfo("AAA", 20, 5000, "male", 2, Arrays.asList("abc", "bcd", "def"));
		PersonInfo info2 = new PersonInfo("BBB", 30, 6000, "female", 3, Arrays.asList("bac", "cbd", "edf"));
		PersonInfo info3 = new PersonInfo("CCC", 40, 7000, "male", 5, Arrays.asList("cab", "dbc", "fde"));
		PersonInfo info4 = new PersonInfo("DDD", 50, 8000, "female", 6, Arrays.asList("ebc", "fcd", "gef"));
		List<PersonInfo> listPersonInfo = Arrays.asList(info1, info2, info3, info4);
		listPersonInfo.stream().filter(Person -> Person.getSalary() >= 7000).map(person -> person.toString())
				.forEach(System.out::println);

	}
}