package com.java05_class;

public class Rhinoceros extends Animal {
	
	public Rhinoceros() {
		
	}
	
	public Rhinoceros(String kind, String name, int age) {
		super(kind, name, age);
	}
	
	public void bark() {
		System.out.print("코뿔소가 ");
		super.bark();
	}

}
