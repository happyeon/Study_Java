package com.test01;

public class MTest02 {
	
	// 정수형 type : byte(1), short(2), int(4), long(8)
	public static void main(String[] args) {
		
		// 타입 변수 = 값;
		byte b01 = 1;
		System.out.println(b01);
		
		b01 = 2;
		System.out.println(b01);
		
		byte b02 = 125;
		System.out.println(b02);
		
		// java 정수 연산의 기본 타입 : int
		byte sumB = (byte) (b01 + b02);		// 형 변환
		System.out.println(sumB);
		
		System.out.println("--------------------------");
		
		short s01 = 32767;
		System.out.println(s01);
		short s02 = 2;
		System.out.println(s02);
		short sumS = (short) (s01 + s02);
		System.out.println(sumS);
		// sumS의 결과가 -32767 이 나오는 이유는?
		
		System.out.println("---------------------------");
		
		// 0b : 2진수
		System.out.println(0b10);
		// 00 : 8진수
		System.out.println(0010);
		// 0x : 16진수
		System.out.println(0x10);
	}

}
