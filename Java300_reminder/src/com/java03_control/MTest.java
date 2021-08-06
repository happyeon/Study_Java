package com.java03_control;

import java.util.Scanner;

public class MTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("i : ");
		int i = sc.nextInt();
		System.out.println("j : ");
		int j = sc.nextInt();
		
		// i의 j제곱
		System.out.println(forTest(i, j));
		System.out.println(whileTest(i, j));
		
		switchTest(i, j);
		
		// 큰 수의 작은 수 제곱 출력
		ifTest(i, j);
		
	}
	
	private static void ifTest(int i, int j) {
		if (i > j) {
			System.out.println(Math.pow(i, j));
		} else if (j > i) {
			System.out.println(Math.pow(j, i));
		} else {
			System.out.println(Math.pow(i, j));
		}
		
	}

	private static void switchTest(int i, int j) {
		switch(i) {
		case 0:
			System.out.println("0은 몇 번을 곱해도 0입니다. ");
			break;
		case 1:
			System.out.println("1은 몇 번을 곱해도 1입니다.");
		default:
			System.out.println(Math.pow(i, j));
		}
		
	}

	public static int forTest(int i, int j) {
		int sum = 1;
		
		for (int a = 0; a < j; a++) {
			sum *= i;
		}
		
		return sum;
	}
	
	public static int whileTest(int i, int j) {
		int sum = 1;
		
		int a = 0;
		while (a < j) {
			a++;
			sum *= i;
		}
		
		return sum;
	}

}
