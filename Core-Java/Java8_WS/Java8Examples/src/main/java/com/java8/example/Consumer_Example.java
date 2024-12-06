package com.java8.example;

import java.util.function.Consumer;

public class Consumer_Example {
	public static void main(String[] args) {
		Consumer<String> c1 = (s) -> {
			System.out.println(s.toUpperCase());
		};
		
		Consumer<String> c2 = (s) -> {
			System.out.println(s.toLowerCase());
		};
		//c.accept("Hello world");
		c1.andThen(c2).accept("Hello World");
	}
}