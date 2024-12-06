package com.java8.example.method_reference;

import java.util.Comparator;

public class Method_Reference_Example1 {
	
	public static void main(String[] args) {
		System.out.println("Reference 1 "+Method_Reference_Example1.compare(10, 20));
		Comparator<Integer> c= Method_Reference_Example1 :: compare;
		System.out.println("Reference 2 "+c.compare(20, 10));
	}
	
	public static int compare(Integer x, Integer y) {
		return x.compareTo(y);
	}

}
