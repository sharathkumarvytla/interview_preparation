package com.java8.example.function;

import java.util.function.Function;

public class Function_Example {
	static Function<String, String> f = name -> name.toUpperCase();
	
	static Function<String, Integer> f2= name -> name.length();

	public static void main(String[] args) {
		System.out.println(f.apply("Hello"));
		System.out.println(f2.apply("Hello World"));
	}
}