package com.java8.example.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class BiCOnsumer_Example {

	public static void main(String[] args) {
		BiConsumer<Integer, Integer> bc = (i1, i2) -> {
			System.out.println("Sum value is : " + (i1 + i2));
		};
		bc.accept(10, 20);

		List<Integer> l1 = Arrays.asList(new Integer(10), new Integer(10), new Integer(10), new Integer(10));
		List<Integer> l2 = Arrays.asList(new Integer(10), new Integer(10), new Integer(10));
		BiConsumer<List<Integer>, List<Integer>> bicons = (i1, i2) -> {
			if (i1.size() == i2.size())
				System.out.println("Equals");
			else
				System.out.println("Not Equals");
		};
		bicons.accept(l1, l2);

	}
}
