package com.test01;

public class MTest01 {
	
	public static void main(String[] args) {
		prn01();
		System.out.println("-----------------");
		prn02();
	}
	
	public static void prn01() {
		//   초기값;      조건식;  증감식
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
	}
	
	// 순서 : 초기값 조건식 명령 증감식 -> 조건식 명령 증감식 -> 조건식 명령 증감식 (조건식이 일치할 때 까지)
	public static void prn02() {
		for (int i = 100; i > 0; i--) {
			System.out.println(i);
		}
	}

}
