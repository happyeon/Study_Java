package com.java02_method;

public class MTest {
	
	public static void main(String[] args) {
		
		MyMethod.myPublic();
		MyMethod.myProtected();
		MyMethod.myDefault();
		// MyMethod.myprivate();
		
		MyMethod my = new MyMethod();
		my.myNonStatic();
	}

}
