package com.test04;

public class MTest {
	
	// 1. int형 아큐먼트 3개를 전달하면, 해당 값들을 모두 더해서 리턴하는 getSum이라는 이름의 메소드를 만들자.
	//    헤당 메소드는 어디서든 접근 가능하며, static 영역에 만들어진다.
	public static int getSum(int kor, int eng, int math) {
		return kor + eng + math;
	}
	
	// 2. int형 아규먼트 1개를 전달하면, 해당 값을 3으로 나눠 실수형 결과값을 리턴하는 getAvg라는 이름의 메소드를 만들자.
	//    해당 메소드는 같은 패키지 내에서만 접근 가능하며, static 영역에 만들어진다.
	static double getAvg(int sum) {
		return (double) sum / 3;
	}
	
	public static void main(String[] args) {
		// 3. main 메소드에서 위의 두 메소드를 호출하여, 총점과 평균을 출력하자.
		
		// 다중 선언
		int kor, eng, math;
		
		// 다중 초기화
		kor = eng = math = 0;
		
		kor = 100;
		eng = 40;
		math = 78;
		
		// 총점
		int sum;
		// 평균
		double avg;
		
		sum = getSum(kor, eng, math);
		avg = getAvg(getSum(kor, eng, math));
		
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);
	}

}
