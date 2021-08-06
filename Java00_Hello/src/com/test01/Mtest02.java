package com.test01;

public class Mtest02 {

	public static void main(String[] args) {
		// 연산자를 사용하여 su의 각 자리수를 모두 더하여서 출력하자
		
		int su = 1234;
		
		int a = (su/1)%10;
		int b = (su/10)%10;
		int c = (su/1000)%10;
		int d = (su/1000)%10;
		
		int sum = a + b + c + d;
		
		System.out.println(su + "의 각 자리수의 총 합은 " + sum + " 입니다.");
		
		// while을 사용하여 위의 문제를 다시 풀어보자
		
		// for을 사용하여 위의 문제를 다시 풀어보자
	}

}
