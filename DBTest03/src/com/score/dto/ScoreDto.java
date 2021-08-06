package com.score.dto;

// Data Transfer Object (Value Object)
public class ScoreDto {
	
	private String s_name;
	private int s_kor;
	private int s_eng;
	private int s_math;
	private int s_sum;
	private double s_avg;
	private String s_grade;
	
	// 기본 생성자
	// 파라미터 전체 초기화하는 생성자
	public ScoreDto() {

	}
	
	public ScoreDto(String s_name, int s_kor, int s_eng, int s_math) {
		this.s_name = s_name;
		this.s_kor = s_kor;
		this.s_eng = s_eng;
		this.s_math = s_math;
	}

	public ScoreDto(String s_name, int s_kor, int s_eng, int s_math, int s_sum, double s_avg, String s_grade) {
		super();
		this.s_name = s_name;
		this.s_kor = s_kor;
		this.s_eng = s_eng;
		this.s_math = s_math;
		this.s_sum = s_sum;
		this.s_avg = s_avg;
		this.s_grade = s_grade;
	}
	
	// getter & setter
	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getS_kor() {
		return s_kor;
	}

	public void setS_kor(int s_kor) {
		this.s_kor = s_kor;
	}

	public int getS_eng() {
		return s_eng;
	}

	public void setS_eng(int s_eng) {
		this.s_eng = s_eng;
	}

	public int getS_math() {
		return s_math;
	}

	public void setS_math(int s_math) {
		this.s_math = s_math;
	}

	public int getS_sum() {
		return s_sum;
	}

	public void setS_sum(int s_sum) {
		this.s_sum = s_sum;
	}

	public double getS_avg() {
		return s_avg;
	}

	public void setS_avg(double s_avg) {
		this.s_avg = s_avg;
	}

	public String getS_grade() {
		return s_grade;
	}

	public void setS_grade(String s_grade) {
		this.s_grade = s_grade;
	}

	
	@Override
	public String toString() {
		return "[" + s_name + "] \t 국어: " + s_kor + " \t 영어 : " + s_eng + " \t 수학 : " + s_math
				+ "\t 총점 " + s_sum + "\t 평균 : " + s_avg + "\t 등급 :  " + s_grade;
	}
	
	
	
	
	
	
	

}
