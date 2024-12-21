package com.sharath.java8.concepts;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.sharath.java8.concepts.repository.PersonInfo;
import com.sharath.java8.concepts.repository.PersonRepository;

public class Predicate_And_Bipredicate {

	// Predicate
	static Predicate<Integer> lessThen = i -> (i <= 50);
	static Predicate<Integer> greaterThen = i -> (i >= 50);
	static Predicate<Integer> equals = i -> (i == 0);
	static Predicate<PersonInfo> salaryPredicate = p -> p.getSalary() <= 100000;

	// Bipredicate
	static BiPredicate<Integer, String> bp = (age, gender) -> {
		if (gender.equals("Male") && age == 21) {
			return true;
		} else if (gender.equals("Female") && age == 18) {
			return true;
		} else {
			return false;
		}
	};

	public static void main(String[] args) {
		// Predicate
		boolean lessThenFlag = lessThen.test(10);
		System.out.println("lessThenFlag " + lessThenFlag);

		boolean greaterThenFlag = greaterThen.test(10);
		System.out.println("greaterThenFlag " + greaterThenFlag);

		boolean equalsFlag = equals.test(0);
		System.out.println("equalsFlag " + equalsFlag);

		boolean andFlag = lessThen.and(greaterThen).and(equals).test(50);
		System.out.println("andFlag " + andFlag);

		boolean orFlag = lessThen.or(greaterThen).or(equals).test(50);
		System.out.println("orFlag " + orFlag);

		boolean negateFlag = lessThen.or(greaterThen).or(equals).negate().test(50);
		System.out.println("negateFlag " + negateFlag);

		PersonRepository repository = new PersonRepository();
		List<PersonInfo> listPersons = repository.getAllPersonsData();
		List<PersonInfo> listData = listPersons.stream().filter(salaryPredicate).collect(Collectors.toList());
		listData.forEach(p -> System.out.println(p));

		// Bipredicate
		listPersons.forEach(person -> {
			Boolean flag = bp.test(person.getAge(), person.getGender());
			System.out.println("Flag " + flag);
		});

	}
}