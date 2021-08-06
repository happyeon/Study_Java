package com.java05_class;

public class Giraffe extends Animal {
	
	public Giraffe(String name, int age) {
		super("기린", name, age);
	}
	
	public void bark() {
		System.out.println("기린이 ");
		super.bark();
	}

}
