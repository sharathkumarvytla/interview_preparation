package com.sharath.java8.concepts;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.sharath.java8.concepts.repository.PersonInfo;
import com.sharath.java8.concepts.repository.PersonRepository;

public class Consumer_And_Biconsumer {
	
	//Consumer
	static Consumer<PersonInfo> c1 = (p) -> System.out.println(p);
	static Consumer<PersonInfo> c2 = (p) -> System.out.println(p.getName().toLowerCase());
	static Consumer<PersonInfo> c3 = (p) -> System.out.println(p.getHobbies());

	//BiConsumer
	static BiConsumer<PersonInfo, PersonInfo> bc1 = (i1, i2) -> System.out.println(i1.getName() + " " + i2.getHobbies());
	static BiConsumer<PersonInfo , PersonInfo> bc2 = (i1, i2) -> System.out.println(i1.getName() + " " + i2.getSalary());
	
	@SuppressWarnings("removal")
	public static void main(String[] args) {
		//Consumer
		PersonRepository repository = new PersonRepository();
		c1.andThen(c2).andThen(c3).accept(repository.getPersonData());
		
		//Biconsumer
		repository.getAllPersonsData().forEach(obj -> bc1.accept(obj, obj));
		repository.getAllPersonsData().forEach(obj -> bc1.andThen(bc2).accept(obj, obj));
		
		//Biconsumer
		BiConsumer<Integer, Integer> bc = (i1, i2) -> {
			System.out.println("Sum value is : " + (i1 + i2));
		};
		bc.accept(10, 20);

		List<Integer> l1 = Arrays.asList(new Integer(10), new Integer(10), new Integer(10), new Integer(10));
		List<Integer> l2 = Arrays.asList(new Integer(10), new Integer(10), new Integer(10));
		BiConsumer<List<Integer>, List<Integer>> bicons = (i1, i2) -> {
			if (i1.size() == i2.size())
				System.out.println("Equals");
			else
				System.out.println("Not Equals");
		};
		bicons.accept(l1, l2);
		
	}
}
