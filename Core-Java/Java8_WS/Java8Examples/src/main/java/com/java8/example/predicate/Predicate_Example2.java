package com.java8.example.predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.java8.example.consumer.Person;
import com.java8.example.consumer.PersonRepository;

public class Predicate_Example2 {
	

	static Predicate<Person> salaryPredicate = p -> p.getSalary() <= 100000;
	
	public static void main(String[] args) {
		PersonRepository repository = new PersonRepository();
	List<Person> listPersons = repository.getAllPersonsData();
	List<Person> listData = listPersons.stream().filter(salaryPredicate).collect(Collectors.toList());
	listData.forEach(p -> System.out.println(p));
	}

}
