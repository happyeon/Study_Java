package com.score;

public class Score {
	
	private String name;		// 왜 굳이 field를 private으로 만들어서 getter & setter를 만들까?
	private int kor;			// 1. 내가 원하는 기능을 위해서
	private int eng;			// 2. 내가 해당 필드에 대한 값을 내 마음대로 제어할 수 있다.
	private int math;			
	
	// 기본 생성자
	public Score() {
		
	}	
	
	// 파라미터 4개 생성자
	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	// getter & setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getKor() {
		return kor;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	public int getSum() {
		return kor + eng + math;
	}
	public double getAvg() {
		return (kor + eng + math) / 3.0;
	}
	public String getGrade() {
		switch((int)getAvg()/10) {
		case 10:
		case 9:
			return "A";
		case 8:
			return "B";
		case 7:
			return "C";
		case 6:
			return "D";
		default:
			return "F";
		}
	}
	
	@Override
	public String toString() {
		return "이름: " + name + " \t 국어: " + kor + " \t 영어: " + eng + " \t 수학: " + math + " \t 총점: " + getSum() + " \t 평균: " + getAvg() + " \t 등급: " + getGrade();
	}

}
