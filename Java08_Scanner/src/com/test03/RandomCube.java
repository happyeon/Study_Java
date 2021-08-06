package com.test03;

public class RandomCube {
	
	public static void main(String[] args) {
		prn();
	}
	
	
	/*
	 * 1) 1 ~ 9 사이의 랜덤한 숫자를 가지고 5 * 5 형태의 숫자 규브를 출력하자.
	 * 1 4 7 4 7
	 * 4 7 2 8 5
	 * 7 5 3 7 5
	 * 2 4 7 8 4
	 * 9 7 6 5 7
	 * 
	 * 2) 만들어진 큐브에서 x의 합을 출력하고, 전체 (25개 숫자)의 평균을 출력하자.
	 */
	public static void prn() {
		int sumX = 0;
		
		int sumAll = 0;
		int cnt = 0;
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int ran = (int) (Math.random() * 9) + 1;
				System.out.printf("%2d", ran);
				
				// X (대각선)의 합
				if ( (i+j == 4) || (i == j)) {
					sumX += ran;
				}
				
				// 전체 합
				sumAll += ran;
				cnt++;
			}
			System.out.println();
		}
		double avg = (double) sumAll / cnt;
		
		System.out.println("X의 합 : " + sumX);
		System.out.println("전체 평균 : " + avg);
	}

}
