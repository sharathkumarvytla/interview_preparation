package com.demo.stream.closable.method;

import java.util.stream.Stream;

public class StreamClosableMethods {
	
	// We have two types of closable methods
	// close(): Closes the stream, useful for streams tied to resources (like files).
	// onClose(Runnable closeHandler): Registers a close handler for the stream.
	
	public static void main(String[] args) {
		System.out.println("---------------------------------------------------");
		// close()
		Stream<String> listValues = Stream.of("A","B","C","D");
		listValues.close();
		listValues.forEach(System.out::println);
		System.out.println("---------------------------------------------------");
		// onClose(Runnable closeHandler)
		Stream<String> listValues2 = Stream.of("D","C","D","A").onClose(() -> System.out.println("Stream Closed"));
		listValues2.forEach(System.out::println);		
	}
}