package com.b;

import com.a.AAA;

public class MTest {
	
	public static void main(String[] args) {
		BBB b1 = new BBB();    // 객체 생성, 필드 초기화
		b1.setAbc(10);
		b1.setB(20);
		System.out.println(b1.getAbc());
		System.out.println(b1.getSum());
		
		BBB b2 = new BBB(10);
		System.out.println(b2.getAbc());
		System.out.println(b2.getB());
		System.out.println(b2.getSum());
		b2.prn();
		
		
		// 다형성
		AAA a1 = new AAA();
		AAA a2 = new BBB();
		
		a1.prn();
		a2.prn();
		
		
		
		
		//AAA a1 = new AAA();
		//System.out.println(a1.getAbc());
		//AAA a2 = new AAA(10);
		//System.out.println(a2.getAbc());
	}

}
