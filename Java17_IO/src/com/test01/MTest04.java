package com.test01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MTest04 {
	
	public static void main(String[] args) {
		File fi = new File("a.txt");
		
		
		try {
			MyOutput(fi);
			MyInput(fi);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void MyInput(File fi) throws IOException {
		FileReader fr = new FileReader(fi);
		int ch;
		while ((ch = fr.read()) != -1) {
			System.out.print((char)ch);
		}
		
		fr.close();
		
	}

	// throws : 예외를 위임 -> "예외가 발생할 수 있는 명령문을 가진 메소드"를 호출한 메소드
	// throw : 예외를 발생
	private static void MyOutput(File fi) throws IOException {
		FileWriter fw = new FileWriter(fi, true);     // true : file이 끝나는 부분에 추가
		
		fw.write("abcdefg\n");
		fw.append("연습중입니다.").append("java.io 재밌다. \n\n");  // method chaining
		
		fw.close();
		
	}

}
