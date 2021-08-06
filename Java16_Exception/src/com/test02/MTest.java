package com.test02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MTest {
	
	public static void main(String[] args) {
		int a = 0;
		
		try {
			System.out.println("숫자를 입력해 주세요");
			Scanner sc = new Scanner(System.in);
			a = sc.nextInt();
			
			if(a == 4) {
				throw new MyException("반장이 좋아하는 4");   // throw : 예외를 발생시킬 수 있다
			}
		} catch(MyException e) {
			System.out.println("MyException 발생");
			e.printStackTrace();
			
		} catch(InputMismatchException e) {
			System.out.println("숫자가 아닌 다른것!");
			e.printStackTrace();
			
		} catch(ArithmeticException e) {
			System.out.println("계산 잘못되었을 때!");
			e.printStackTrace();
			
		} catch(Exception e) {
			System.out.println("뭔진 몰라도 어쨌든 예외 발생");
			e.printStackTrace();
			
		} finally {									// 위에 try에서 정상적으로 실행되거나 catch에서 오류가 생기더라도 가장 마지막에 무조건 꼭! 실행해야하는 명령문
			System.out.println("입력한 값 : " + a);
		}
	}

}
