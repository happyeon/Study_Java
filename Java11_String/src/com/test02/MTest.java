package com.test02;

public class MTest {
	
	// string을 + 연산할 때, 내부적으로는 StringBuilder로 변환하여 연산함 (jdk 1.5)
	public static void main(String[] args) {
		
		stringTest();
		stringBufferTest();
		
	}
	
	public static void stringBufferTest() {
		// mutable
		StringBuffer sb = new StringBuffer();
		sb.append("안녕하세요!")                // method chaining
		  .append("저는 ")
		  .append("김선달 입니다.");
		
		System.out.println(sb);
		System.out.println(sb.hashCode());
		
		sb.replace(0, 6, "하이!");
		System.out.println(sb);
		System.out.println(sb.hashCode());      // 값은 변하지만 주소값은 변하지 않음.
		
		sb.reverse();
		System.out.println(sb);
		
		
	}
	
	public static void stringTest() {
		// immutable
		String s = "안녕하세요!";
		s += "저는 ";
		s += "홍길동입니다.";
		
		System.out.println(s);
		System.out.println(s.hashCode());     // s라는 문자열의 주소값
		
		s.replace("안녕하세요!", "하이!"); 
		System.out.println(s);
		
		// s에 대입하지 않으면, 변하지 않는다. (만들어져 있긴 하다.)
		s = s.replace("안녕하세요!", "하이!");   
		System.out.println(s);
	}

}
