package com.test06;

public interface Job {
	
	// 인터페이스 안에서의 변수는 자동으로 상수화 = static final
	public String JOB_ID = "IT";
	public void jobLoc(String loc);   // 추상메소드

}
