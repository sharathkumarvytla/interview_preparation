package com.sharath.task.examples;

public class CoreJava_Task {

	public static void main(String[] args) {

		System.out.println("------------------------------------------------------");
		// String Swap without third variable
		String name1 = "IGSA";
		String name2 = "LABS";
		name1 = name1 + name2;
		name2 = name1.substring(0, (name1.length()) - (name2.length()));
		name1 = name1.substring(name2.length());
		System.out.println("name1 " + name1 + " : names2 " + name2);
		System.out.println("------------------------------------------------------");
		// Find no of digites in number values
		int number = 123456;
		int digits = 0;
		while (number != 0) {
			digits++;
			number = number / 10;
		}
		System.out.println("No of digits : " + digits);
		System.out.println("------------------------------------------------------");
		// Swap int values without third variable
		int a = 10;
		int b = 20;
		b = b + a;
		a = b - a;
		b = b - a;
		System.out.println("a : " + a + " - b: " + b);
		System.out.println("------------------------------------------------------");
		// Reverse String without pre defined methods
		String name = "IGSALABS";
		char[] listChar = name.toCharArray();
		for (int i = listChar.length - 1; i >= 0; i--) {
			System.out.print(listChar[i]);
		}
		System.out.println("------------------------------------------------------");
		// Reverse String with pre defined methods
		String name4 = "IGSALABS";
		StringBuilder b4 = new StringBuilder();
		b4.append(name4);
		System.out.println(b4.reverse());

	}

}
