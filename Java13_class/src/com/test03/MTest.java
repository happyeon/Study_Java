package com.test03;

import java.util.Arrays;

public class MTest {
	
	public static void main(String[] args) {
		
		System.out.println(MySum.sum(10, 20));
		
		System.out.println(MySum.sum(11.2, 22.2));
		
		MySum.sum(1, 2, 3);
		
		
		
		
		String[] abc = {"A", "B", "C"};
		int[] i = {1, 2, 3};
		
		// 배열의 주소값 출력
		System.out.println(i.toString());
		
		//배열 내용 출력
		System.out.println(Arrays.toString(abc));
		System.out.println(Arrays.toString(i));
	}

}
