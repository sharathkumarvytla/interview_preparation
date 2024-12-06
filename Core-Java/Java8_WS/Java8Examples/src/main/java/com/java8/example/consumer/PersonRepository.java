package com.java8.example.consumer;

import java.util.Arrays;
import java.util.List;

public class PersonRepository {
	
	public List<Person> getAllPersonsData(){
		 return Arrays.asList(
		            new Person("Java1", 6, 100000, "Male", 1, Arrays.asList("music", "games", "movies"),21),
		            new Person("Java2", 4, 80000, "Female", 2, Arrays.asList("reading", "traveling", "sports"),20),
		            new Person("Java3", 7, 120000, "Male", 3, Arrays.asList("coding", "music", "movies"),18)
		        );
	}
	
	public Person getPersonData(){
		 return  new Person("Java1", 6, 100000, "Male", 1, Arrays.asList("music", "games", "movies"),21);
	}

}
