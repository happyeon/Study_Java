package com.java01_type;

public class MTest {
	
	public static void main(String[] args) {
		// type 변수 = 값;
		// 기본타입
		// 정수형 실수형 문자형 논리형 + 문자열
		int i = 100;
		i = 200;
		System.out.println(i);
		
		// 참조타입
		// (Object를 상속받는) 모든 class
		String s01 = "abc";
		String s02 = new String("abc");
		String s03 = "abc";
		
		System.out.println(s01 == s02);
		System.out.println(s01.equals(s02));
		System.out.println(s01 == s03);     
	}

}
