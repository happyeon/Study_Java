package com.java05_class;

import java.util.Scanner;

public class MTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("반려동물을 골라주세요 [1:기린 / 2:코뿔소]");
		int select = sc.nextInt();
		
		Animal family = null;
		switch (select) {
		case 1:
			family = new Giraffe("기리니", 1);
			break;
		case 2:
			family = new Rhinoceros("코뿔소", "코뿌리", 2);
			break;
		default:
			System.out.println("잘못 선택했슈~");
		}
		System.out.println(family);
		
		family.bark();
	}

}
