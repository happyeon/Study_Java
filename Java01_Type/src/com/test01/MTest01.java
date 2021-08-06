package com.test01;

/**
 * Javadoc Test <br/>
 * Hello, World! 를 출력하는 class <br/><br/>
 * 
 * Javadoc 만드는 방법 <br/>
 * project 우클릭 - export - javadoc - %JAVA_HOME%\bin\javadoc.exe <br/>
 * 
 * VM 옵션에 -locale ko_KR -encoding UTF-8 -charset UFT-8 -decencoding UFT-8 추가
 * 
 * 
 * @author happy
 *
 */

public class MTest01 {
	
	/**
	 * main method 
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		// 한 줄 주석
		System.out.println("Hello, World!");
		
		/*
		 * 여러 줄 주석
		 * 주석 = 해당 코드를 확인하는 사람에게 설명하는 말
		 * compile 시, 주석은 제거됨
		 */
	}
}
