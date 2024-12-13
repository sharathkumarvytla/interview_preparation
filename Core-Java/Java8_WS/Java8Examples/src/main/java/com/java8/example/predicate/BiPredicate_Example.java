package com.java8.example.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

import com.java8.example.consumer.Person;

public class BiPredicate_Example {
	
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
		//PersonRepository repository = new PersonRepository();
		//List<Person> listPersons = repository.getAllPersonsData();
		List<Person> listPersons = Arrays.asList(
	            new Person("Java1", 6, 100000, "Male", 1, Arrays.asList("music", "games", "movies"),21),
	            new Person("Java2", 4, 80000, "Female", 2, Arrays.asList("reading", "traveling", "sports"),20),
	            new Person("Java3", 7, 120000, "Male", 3, Arrays.asList("coding", "music", "movies"),18)
	        );
		System.out.println("listPersons "+listPersons);
		listPersons.forEach(person -> {
			System.out.println("person "+person);
			 bp.test(person.getAge(),person.getGender());		
		});
	 
	}

}
