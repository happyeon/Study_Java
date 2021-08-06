package com.test;

public class MTest01 {
	
	public static void main(String[] args) {
		// if : 만약에 ~라면
		
		prn01();
		
		prn02(false, false);
	}
	
	public static void prn01() {
		int i = 10;
		int j = 20;
		
		// if (조건) {조건이 참일 경우에 실행}
		// 거짓일 경우에는 실행되지 않음
		if (i >= 10) {
			System.out.println("i는 10보다 크거나 같습니다.");
		}
		
		// if ~ else
		if (j < 10) {
			System.out.println("j는 10보다 작습니다.");
		} else {
			System.out.println("j는 10보다 작지 않습니다.");
		}
		
		// if ~ else if ~ else
		if (i > j) {
			System.out.println("i가 j보다 큽니다.");
		} else if (i == j) {
			System.out.println("i와 j가 같습니다.");
		} else {
			System.out.println("i가 j보다 작습니다.");
		}
		
	}
	
	public static void prn02(boolean ring, boolean married) {
		
		if (ring) {
			
			if (married) {
				System.out.println("결혼하셨군요!");
			} else {
				System.out.println("연인이 있으시군요!");
			}
		} else {
			if (married) {
				System.out.println("결혼하셨군요!");
			} else {
				System.out.println("솔로셨군요!");
			}
		}
		
		System.out.println("----------------------------");
		
		if (ring && married) {
			System.out.println("결혼하셨군요!");
		} else if (ring || married) {
			System.out.println("연인이 있으시군요!");
		} else {
			System.out.println("솔로이군요!");
		}
		
	}

}
