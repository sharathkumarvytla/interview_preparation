package com.java8.example;

public class Lambda_Example {

	public static void main(String[] args) {

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread was created without lambda");

			}
		};
		new Thread(runnable).start();
		
		Runnable runnable2 = () -> {
			System.out.println("Thread was created with lambda");
		};
		new Thread(runnable2).start();
	}
}
