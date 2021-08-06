package com.cal02;

import java.util.Calendar;

// java.util.Calendar 사용하여 달력만들기
public class CalendarUseApi {

	public void prn(int year, int month) {

		// singleton -> 객체를 단 한번만 생성
		Calendar cal = Calendar.getInstance();    //현재 날짜와 시간 정보를 가진 Calendar 객체를 생성한다.
		
		
		System.out.printf("\t\t%d년 %d월\n", year, month);
		System.out.printf("일\t월\t화\t수\t목\t금\t토\n");
		
		// year년 month월 1일로 Calendar 객체 설정
		cal.set(year, month - 1, 1);
		
		// year년 month월 1일의 요일 값 (1:일요일, 2:월요일 ..., 7:토요일)
		int start = cal.get(Calendar.DAY_OF_WEEK);   
		
		// 요일 앞 공백
		for (int i = 1; i < start; i++) {
			System.out.printf("\t");
		}
		
		// i : 1일부터 해당 연,월의 마지막 일까지
		for (int i = 1; i <= cal.getActualMaximum(Calendar.DATE); i++) {   
			// 달력의 일 출력
			System.out.printf("%d\t", i);
			// 요일값(1 ~ 7)을 증가시키면서, 7의 배수가 되면 다음 줄로.
			if (start % 7 == 0) {
				System.out.println();
			}
			start++;
		}
	}
}
