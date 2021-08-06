package com.test06;

public class MyProfile extends Profile implements Display, Job {
	
	
	private String loc;
	
	// 기본 생성자 안되는 이유가 뭘까?
	// 부모한테 기본생성자가 없어서 부모의 기본생성자를 호출할 수 없음.
	public MyProfile(String name, String phone) {
		super(name, phone);
	}
	
	
	// 사실 setter(필드값 설정해주는 메소드)의 기능을 하고 있다. 
	@Override
	public void jobLoc(String loc) {
		// this -> 나 "객체"
		this.loc = loc;

	}
	
	
	@Override
	public void display() {
		// super -> 부모 "객체"
		super.printProfile();			// profile 클래스에 있는 printProfile 메소드를 가져옴.
		System.out.println("회사 주소 : " + loc);
		// JOB_ID = "Singer";  -> final 필드는 상속 안됨. 상수임. 변하지 않음
		System.out.println("직무 : " + JOB_ID);
		// super.JOB_ID 안되는 이유 -> super는 부모 "객체" / JOB_ID는 인터페이스꺼라서 super 사용 못함!
		// Job.JOB_ID 로 사용해야 됨!

	}

}
