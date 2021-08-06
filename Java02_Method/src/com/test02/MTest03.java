package com.test02;

import com.test01.MTest01;

public class MTest03 {
	
	public static void main(String[] args) {
		
		MTest01.publicMethod();
		// 아래 method는 같은 package가 아니라서 실행이 안됨
		// MTest01.protectedMethod();
		// MTest01.defaultMethod();
		// MTest01.privateMethod();
	}

}
