package com.test05;

public class QClass {
	
	// 2. QClass에다가 이름을 받아서 "안녕하세요 XX님"을 리턴하는 getName이라는 메소드를 만들자.
	//    어디에서나 접근 가능하고, static 영역에 저장되는 메소드
	public static String getName(String name) {
		
		String result = "안녕하세요 " + name + "님";
		return result;
	}
	
	// 3. QClass에다가 전화번호 가장 뒷 4자리를 받아서, "XXXX번호님 안녕하세요."를 리턴하는
	//    getPhone 이라는 메소드를 만들자.
	//    상속인 경우 상속된 곳에서 / 아닌 경우 같은 패키지 내에서 접근 가능하고,
	//    non-static 영역에 저장되는 메소드
	protected String getPhone(String phone) {
		return phone + "번호님 안녕하세요.";
	}

}
