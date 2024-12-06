package com.java8.example;

import java.util.Comparator;

public class Comparator_Lambda_Example {
	
	public static void main(String[] args) {
		
		Comparator<Integer> c= new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
			
		};
		System.out.println("Without using lambda "+c.compare(15,15));
		
		Comparator<Integer> c2 = (Integer o1, Integer o2) -> o1.compareTo(o2);
		System.out.println("With using lambda "+c2.compare(20, 15));
		
		Comparator<Integer> c3 = (o1, o2) -> o1.compareTo(o2);
		System.out.println("With using lambda "+c3.compare(15, 20));
	}

}
