package com.java8.example.method_reference;

import java.util.function.Predicate;

public class Method_Reference_Examples2 {
	
	public static Predicate<Integer> p = Method_Reference_Examples2::isCheck;
	
	
	public static void main(String[] args) {
		System.out.println(p.test(130));
	}
	public static Boolean isCheck(Integer height) {
		return height > 150;
	}

}
