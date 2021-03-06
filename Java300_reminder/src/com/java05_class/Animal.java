package com.java05_class;

// class : 설계도
// instance : 객체 - class를 가지고 memory에 실제로 구현된 구현체
public class Animal {
	
	// field : 속성
	private String kind;
	private String name;
	private int age;
	
	// constructor : 필드 초기화, 객체 생성
	// 기본 생성자
	public Animal() {		
	}
	
	// 생성자 overloading 
	// 파라미너 있는 생성자
	public Animal(String kind, String name, int age) {
		this.kind = kind;
		this.name = name;
		this.age = age;
	}
	
	// method : 기능
	public void bark() {
		System.out.println("운다ㅠㅠ");
	}
	
	// getter  /  setter 
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// overriding : 재정의 - 부모의 메소드를 내가 마음대로 다시 확장시킴
	public String toString() {
		return String.format("[%s] %5s (%d)", kind, name, age);
	}
	
}
