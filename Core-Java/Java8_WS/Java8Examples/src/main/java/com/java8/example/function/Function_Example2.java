package com.java8.example.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.java8.example.consumer.Person;
import com.java8.example.consumer.PersonRepository;

public class Function_Example2 {

	static Function<List<Person>, Map<String, Double>> f = listPersons -> {
		Map<String, Double> map = new HashMap<String, Double>();
		listPersons.forEach(p ->{
			map.put(p.getName(), p.getSalary());
		});
		return map;
	};
	
	public static void main(String[] args) {
		PersonRepository repository = new PersonRepository();
		List<Person> listPersons = repository.getAllPersonsData();	
		System.out.println("data is "+listPersons);
		Map<String, Double> map = f.apply(listPersons);
		System.out.println(map);
	}
}
