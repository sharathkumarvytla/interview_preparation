package com.java8.example.consumer;

import java.util.Arrays;
import java.util.function.Consumer;

public class Consumer_Example1 {
	
	static Consumer<Person> c1 = (p) -> System.out.println(p);
	static Consumer<Person> c2 = (p) -> System.out.println(p.getName().toLowerCase());
	static Consumer<Person> c3 = (p) -> System.out.println(p.getHobbies());
	
	public static void main(String[] args) {
		
		c1.andThen(c2).andThen(c3).accept(getPersonData());
		
	}
	
	public static Person getPersonData(){
		Person p1 = new Person("AAA",6,100000,"Male",1,Arrays.asList("music","games","movies"), 21);
		Person p2 = new Person("AAA2",8,150000,"Male",1,Arrays.asList("music2","games2","movies2"),20);
		Person p3 = new Person("AAA3",10,180000,"Female",1,Arrays.asList("music3","games3","movies3"),18);
		//return Arrays.asList(p1,p2,p3);
		return p1;
	}

}
