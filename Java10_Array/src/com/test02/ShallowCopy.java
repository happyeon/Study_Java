package com.test02;

import java.util.Arrays;

public class ShallowCopy {
	
	public static void main(String[] args) {
		// reference 복사 (얕은 값 복사, 주소값 복사)
		int[] original = {10, 20, 30, 40};
		int[] copy = original;                  // copy라는 빈 배열 주소값에 original *주소값*을 넣는다. 배열은 참조타입이기 때문
		
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy));
		
		System.out.println(original == copy);
		
		copy[1] = 200;                                         // 같은 결과가 나오는 이유 : 주소값이 같기 때문.
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy));        
		
		System.out.println("---------------------------");
		
		System.out.println(original.hashCode());       // hashCode : 주소값을 알려주는 코드
		System.out.println(copy.hashCode());
	}

}
