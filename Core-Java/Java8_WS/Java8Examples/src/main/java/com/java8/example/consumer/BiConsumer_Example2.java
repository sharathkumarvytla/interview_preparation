package com.java8.example.consumer;

import java.util.function.BiConsumer;

public class BiConsumer_Example2 {
	
	public static void main(String[] args) {
		BiConsumer<Person, Person> bc1 = (i1, i2) -> System.out.println(i1.getName() + " " + i2.getHobbies());
		BiConsumer<Person , Person> bc2 = (i1, i2) -> System.out.println(i1.getName() + " " + i2.getSalary());
		PersonRepository repository = new PersonRepository();
		repository.getAllPersonsData().forEach(obj -> bc1.accept(obj, obj));
		repository.getAllPersonsData().forEach(obj -> bc1.andThen(bc2).accept(obj, obj));
	}

}
