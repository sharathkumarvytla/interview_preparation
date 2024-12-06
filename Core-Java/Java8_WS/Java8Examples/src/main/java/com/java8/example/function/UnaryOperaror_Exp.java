package com.java8.example.function;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperaror_Exp {
	
	static Comparator<Integer> com= (a,b) -> a.compareTo(b); 
	public static void main(String[] args) {
		UnaryOperator<String> uo1= name -> name.toUpperCase();
			System.out.println(uo1.apply("Sharath"));
			
		BinaryOperator<Integer> bo= BinaryOperator.maxBy(com);
		System.out.println(bo.apply(20, 30));
	}

}
