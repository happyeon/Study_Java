package com.lotto;

import java.util.Arrays;

/*
 * 중복되지 않는 6개 숫자 (1 ~ 45)를 작은 순부터 차례대로 정렬하여 콘솔에 출력하는 프로그램
 */
public class Lotto {
	
	// 로또 배열 생성
	private int[] make() {
		int[] arr  = new int[6];
		int index = 0;
		
		while (index < 6) {
			int insert = (int)(Math.random()*45) + 1;
			
			if (!isSame(arr, insert)) {                 // 중복값인지 확인 (true면 중복값, false면 중복값아님)
				arr[index] = insert;
				index++;
			}
		}
		
		return arr;
	}
	
	// 중복 값 판별
	private boolean isSame(int[] arr, int insert) {
		boolean same = false;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == insert) {
				same = true;
				break;
			}
		}
		
		return same;
	}
	
	// 정렬
	private void sorting(int[] arr) {
		// bubble sort
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-1; j++) {
				//System.out.println(i + "->" + Arrays.toString(arr));
				if (arr[j] > arr[j+1]) {
					// swap
					int tmp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = tmp;
					
				}
				
			}
		}
		
	}
	
	// 배열 출력
	public void prn() {
		int[] arr = make();
		sorting(arr);
		//Arrays.sort(arr);
		
		System.out.print("[ ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("]");
		//System.out.println(Arrays.toString(arr));
	
	
	
	}
	

}
