package com.java8.example.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java8.example.consumer.Person;
import com.java8.example.consumer.PersonRepository;

public class Streams_Example1 {
	
	public static void main(String[] args) {
		PersonRepository repository = new PersonRepository();	
		
		Stream<Integer> listNumbers = Stream.of(new Integer[] {1,2,3,4,5});
		listNumbers.forEach(System.out::println);
		System.out.println("---------------------------------------------------------");
		Map<String, List<String>> listDetails = repository.getAllPersonsData().stream().filter(person -> person.getHeight() >= 2).collect(Collectors.toMap(Person::getName, Person::getHobbies));
		System.out.println("listDetails "+listDetails);
		System.out.println("---------------------------------------------------------");
		List<String> listHobies = repository.getAllPersonsData() //List of persons
		.stream() //Stream of persons
		.map(Person::getHobbies) //Stream<List<String>>
		.flatMap(List::stream) //Stream<String>
		.distinct()
		.collect(Collectors.toList());
		listHobies.forEach(System.out::println);
		System.out.println("---------------------------------------------------------");
	}
}