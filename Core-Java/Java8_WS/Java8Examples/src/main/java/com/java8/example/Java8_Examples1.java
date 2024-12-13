package com.java8.example;

import java.util.stream.IntStream;

public class Java8_Examples1 {
	
	//Without java 8
	public void findSum(int maxValue) {
	//find sum of numbers
	int sumValue = 0;
	for(int i = 1; i <=maxValue; i++) {
		sumValue += i;
	}
	System.out.println("Sum value "+sumValue);
	}
	
	//With java 8
	public void findSum_8(int maxValue) {
		int sumValue = IntStream.rangeClosed(0, maxValue).map(Integer :: new).sum();
		System.out.println("Sum value in 8 "+sumValue);
	}
	
	public static void main(String[] args) {
		Java8_Examples1 obj= new Java8_Examples1();
		obj.findSum(50);
		obj.findSum_8(50);
	}
}
