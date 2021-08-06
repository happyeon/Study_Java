package com.vehicle;

public class SportsCar extends Car{
	
	public SportsCar() {
		
	}
	
	public SportsCar(int speed) {
		super(speed);
	}
	
	@Override
	public void accelPedal() {
		// speed += 15;
		// speed = speed + 15;
		setSpeed(getSpeed() + 15);
		System.out.println("속도가 더 빨리 증가합니다");
	}
	
	public void breakPedal() {
		setSpeed(getSpeed() - 15);
		if (getSpeed() >= 0) {
			System.out.println("속도가 더 빨리 감소합니다.");
		} else {
			System.out.println("멈췄습니다.");
			setSpeed(0);
		}
		
		
	}

}
