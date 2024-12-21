package com.sharath.java8.concepts.repository;

import java.util.Arrays;
import java.util.List;

public class PersonRepository {

	public List<PersonInfo> getAllPersonsData() {
		return Arrays.asList(
				new PersonInfo("Java1", 6, 100000, "Male", 1, Arrays.asList("music", "games", "movies"), 21),
				new PersonInfo("Java2", 4, 80000, "Female", 2, Arrays.asList("reading", "traveling", "sports"), 20),
				new PersonInfo("Java3", 7, 120000, "Male", 3, Arrays.asList("coding", "music", "movies"), 18));
	}

	public PersonInfo getPersonData() {
		return new PersonInfo("Java1", 6, 100000, "Male", 1, Arrays.asList("music", "games", "movies"), 21);
	}

}
