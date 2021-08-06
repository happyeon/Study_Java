package com.test02;

public class Dog extends Animal{
	
	public Dog() {
		System.out.println("멍멍이");
	}
	
	// @Override  -> 안써도됨 생략 가능
	public void bark() {
		System.out.println("멍멍");
	}

}
