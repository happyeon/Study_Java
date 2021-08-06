package com.java02_method;

public class MyMethod {
	
	// method : 명령문들의 집합. 기능
	// 접근제한자 메모리영역 리턴타입 메소드명(파라미터/아규먼트)
	
	public static void myPublic() {
		System.out.println("public : 어디서나");
	}
	
	protected static void myProtected() {
		System.out.println("상속일 때 : 상속된 자식클래스에서");
		System.out.println("상속 아닐 때 : 같은 패키지");
	}
	
	static void myDefault() {
		System.out.println("같은 패키지!");
	}
	
	private static void myPrivate() {
		System.out.println("해당 클래스 내에서만!");
	}
	
	public void myNonStatic() {
		System.out.println("객체 생성해야!");
		myPrivate();
	}

}
