package com.java04_array;

public class MTest {
	
	public static void main(String[] args) {
		// array : 같은 타입의 여러 개의 값을 효과적으로 관리하기 위한 객체
		Person p01 = new Person("홍길동", 100);
		Person p02 = new Person("이순신", 43);
		Person p03 = new Person("김선달", 65);
		Person p04 = new Person("유재석", 23);
		Person p05 = new Person("강호동", 66);
		Person p06 = new Person("신동엽", 22);
		
		Person[] people = {p01, p02, p03, p04, p05, p06, new Person("박자바", 30), new Person("김씨샵", 50)};
		
		System.out.println("4번째 사람의 이름 : " + people[3].name);
		System.out.println("2번째 사람의 나이 : " + people[1].age);
	}

}
