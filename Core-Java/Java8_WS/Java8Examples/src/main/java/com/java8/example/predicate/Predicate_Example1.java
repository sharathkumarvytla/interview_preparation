package com.java8.example.predicate;

import java.util.function.Predicate;

public class Predicate_Example1 {
	
	public static void main(String[] args) {
		Predicate<Integer> lessThen = i -> (i <= 50);
		Predicate<Integer> greaterThen = i -> (i >= 50);
		Predicate<Integer> equals = i -> (i == 0);
		
		boolean lessThenFlag = lessThen.test(10);
		System.out.println("lessThenFlag "+lessThenFlag);
		boolean greaterThenFlag = greaterThen.test(10);
		System.out.println("greaterThenFlag "+greaterThenFlag);
		boolean equalsFlag = equals.test(0);
		System.out.println("equalsFlag "+equalsFlag);
		
		boolean andFlag = lessThen.and(greaterThen).and(equals).test(50);
		System.out.println("andFlag "+andFlag);
		
		boolean orFlag = lessThen.or(greaterThen).or(equals).test(50);
		System.out.println("orFlag "+orFlag);
		
		boolean negateFlag = lessThen.or(greaterThen).or(equals).negate().test(50);
		System.out.println("negateFlag "+negateFlag);
		
	}

}
