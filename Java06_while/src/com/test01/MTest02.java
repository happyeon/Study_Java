package com.test01;

public class MTest02 {
	
	public static void main(String[] args) {
		// 1) 1 ~ 100 까지의 숫자를 역순으로 출력하자.
		prn01();
		System.out.println("--------------");
		
		// 2) 1 ~ 100 까지의 숫자 중 2의 배수만 출력하자.
		prn02();
		System.out.println("----------------");
		
		// 3) 1 ~ 100 까지의 숫자 중 7의 배수의 갯수와 총 합을 출력하자.
		prn03();
		System.out.println("------------------");
	}
	
	public static void prn01() {
		int i = 100;
		
		while (i > 0) {
			System.out.println(i);
			i--;
		}
	}
	
	public static void prn02() {
		int i = 1;
		
		while (i <= 100) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
			i++;
		}
	}
	
	public static void prn03() {
		int i = 1;
		int count = 0;
		int sum = 0;
		
		while (i < 101) {
			// 만약 7의 배수라면,
			if (i % 7 == 0) {
				// count++ 해주고 (배수의 개수 증가)
				count++;
				// sum에다가 sum + 현재 값을 넣자.
				sum += i;
			}
			i++;
		}
		System.out.println();
		System.out.println("7의 배수의 개수 : " + count);
		System.out.println("7의 배수의 총합 : " + sum);
	}

}
