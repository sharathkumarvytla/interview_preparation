package com.java8.example.method_reference;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.java8.example.consumer.Person;
import com.java8.example.consumer.PersonRepository;

public class Method_Reference_Example3 {

	static Predicate<Person> p= person -> !person.getHobbies().contains("music");
	
	public static void main(String[] args) {
		PersonRepository repository = new PersonRepository();
		
		Map<String, List<String>> listDetails = repository.getAllPersonsData().stream().filter(p).collect(Collectors.toMap(Person :: getName, Person :: getHobbies));
		System.out.println(listDetails);
	}
}
