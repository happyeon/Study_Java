package com.test01;

import java.util.Scanner;

public class MTest02 {
	
	public static void main(String[] args) {
		test01();
	}
	
	public static void test01() {
		Scanner sc = new Scanner(System.in);
		System.out.println("아무거나 입력해 주세요 : ");
		
		String token1 = sc.next();
		System.out.println(token1);
		
		String token2 = sc.next();
		System.out.println(token2);
		
		String token3 = sc.next();
		System.out.println(token3);
		
		System.out.println("nextLine 입력");
		sc.nextLine();
		String line = sc.nextLine();
		System.out.println(line);
	}

}
