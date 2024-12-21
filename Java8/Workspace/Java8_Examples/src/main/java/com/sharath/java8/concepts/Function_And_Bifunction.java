package com.sharath.java8.concepts;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import com.sharath.java8.concepts.repository.PersonInfo;
import com.sharath.java8.concepts.repository.PersonRepository;

public class Function_And_Bifunction {

	// Function
	static Function<String, String> f = name -> name.toUpperCase();
	static Function<String, Integer> f2 = name -> name.length();
	static Function<List<PersonInfo>, Map<String, Double>> f3 = listPersons -> {
		Map<String, Double> map = new HashMap<String, Double>();
		listPersons.forEach(p -> {
			map.put(p.getName(), p.getSalary());
		});
		return map;
	};

	// Binary & Unary Operator
	static Comparator<Integer> com = (a, b) -> a.compareTo(b);

	public static void main(String[] args) {
		// Function
		System.out.println(f.apply("Hello"));
		System.out.println(f2.apply("Hello World"));

		PersonRepository repository = new PersonRepository();
		List<PersonInfo> listPersons = repository.getAllPersonsData();
		Map<String, Double> map = f3.apply(listPersons);
		System.out.println(map);

		// Binary & Unary Operator
		UnaryOperator<String> uo1 = name -> name.toUpperCase();
		System.out.println(uo1.apply("Sharath"));
		BinaryOperator<Integer> bo = BinaryOperator.maxBy(com);
		System.out.println(bo.apply(20, 30));
	}

}
