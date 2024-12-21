package com.sharath.java8.concepts;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.sharath.java8.concepts.repository.PersonInfo;
import com.sharath.java8.concepts.repository.PersonRepository;

public class Method_Reference {
	// Method Reference exp1
	public static Predicate<Integer> p = Method_Reference::isCheck;

	public static Boolean isCheck(Integer height) {
		return height > 150;
	}

	// Method Reference exp2
	public static int compare(Integer x, Integer y) {
		return x.compareTo(y);
	}

	// Method Reference exp3
	static Predicate<PersonInfo> p2 = person -> !person.getHobbies().contains("music");

	public static void main(String[] args) {
		// Method Reference exp1
		System.out.println(p.test(130));

		// Method Reference exp2
		Comparator<Integer> c = Method_Reference::compare;
		System.out.println("Reference :  " + c.compare(10, 20));

		// Method Reference exp3
		PersonRepository repository = new PersonRepository();
		Map<String, List<String>> listDetails = repository.getAllPersonsData().stream().filter(p2)
				.collect(Collectors.toMap(PersonInfo::getName, PersonInfo::getHobbies));
		System.out.println(listDetails);

	}

}
