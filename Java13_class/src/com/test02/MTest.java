package com.test02;

public class MTest {
	
	public static void main(String[] args) {
		/*
		Cat cat = new Cat();
		cat.bark();
		
		Dog dog = new Dog();
		dog.bark();
		*/
		
		Animal some = new Dog();
		some.bark();
		
		some = new Cat();
		some.bark();
		// some.eat();   -> some은 부모타입이기 때문에 자식이 가지고 있는 eat 객체를 호출할 수 없음.
		
		
		/*
		 * 다형성
		 * 1. 부모(선조)타입으로 자식(후손) 생성
		 *    Parent P = new Child();
		 * 2. 부모의 이름에 자식객체 대입
		 *    Child c = new Child();
		 *    Parent p = c;
		 * 3. 부모의 메서드를 통해 자식의 메서드 호출
		 */
		
	}

}
