package com.test05;

public class SamsongTV implements TV {
	
	private int volume;
	
	public SamsongTV() {
		System.out.println("SamsongTV가 켜졌습니다.");
	}

	@Override
	public int volumeUp() {
		volume += 5;
		return volume;
	}

	@Override
	public int volumeDown() {
		volume -= 5;
		return volume;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "SamsongTV의 현재 볼륨은 " + volume + "입니다.";
	}
	
	

}
