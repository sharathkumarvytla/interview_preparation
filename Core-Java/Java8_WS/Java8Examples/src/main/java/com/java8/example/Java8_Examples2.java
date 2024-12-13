package com.java8.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8_Examples2 {
	
	//Without java 8
	public void removeDuplicate() {
		List<String> listItems = Arrays.asList("A","B","C","A");
		List<String> listDuplicateItems =new ArrayList<String>();
		for(String item : listItems) {
			if(!listDuplicateItems.contains(item))
				listDuplicateItems.add(item);
			
		}
		System.out.println("list items "+listDuplicateItems);
	}
	
	//with java 8
	public void removeDuplicate_8() {
		List<String> listItems = Arrays.asList("A","B","C","A");
		List<String> listDuplicateItems = listItems.stream().distinct().collect(Collectors.toList());
		System.out.println("list of items in 8 "+listDuplicateItems);
	}
	
	public static void main(String[] args) {
		Java8_Examples2 obj = new Java8_Examples2();
		obj.removeDuplicate();
		obj.removeDuplicate_8();
	}

}
