package com.test07;

public abstract class AreaImpl implements Area{

	private String result;
	
	@Override
	public void print() {
		System.out.println(Area.PRINT + result);
	}
	
	@Override
	public abstract void make();
	
	// setter : 필드 값을 저장
	public void setResult(String result) {
		this.result = result;
	}
	
}
