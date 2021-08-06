package com.test03;

public class MySum {
	
	//파라미터의 개수 or 타입이 다르면 메소드명이 같아도 가능
	
	public static int sum (int i, int j) {
		return i + j;
	}
	
	public static double sum (double i, double j) {
		return i + j;
	}
	
	public static void sum (int i, int j, int k) {
		System.out.println(i + j + k);
	}

	
	
}
