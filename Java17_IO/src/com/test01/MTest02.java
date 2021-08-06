package com.test01;

import java.io.File;

public class MTest02 {
	
	
	/*
	 * c:\ -> window
	 * /user/donghen -> linux (mac os)
	 * 
	 */
	public static void main(String[] args) {
		File fi = new File("c:\\");		// \를 2개 쓴 이유 : 하나만 쓰면 자바에서 이스케이프 문자로 해석하기 때문
		
		// prnFolder01(fi);
		prnFolder02(fi);
	}

	private static void prnFolder02(File fi) {
		/*
		 * 파일과 폴더를 구분해서 출력
		 * ex)
		 * file : 
		 * file : hiberfil.sys
		 * dir : Intel
		 * ....
		 * file의 총 갯수 : n개
		 * dir의 총 갯수 : m개
		 */
		int cntFile = 0;
		int cntDir = 0;
		
		for(File file : fi.listFiles()) {
			if(file.isFile()) {
				cntFile++;
				System.out.println("file : " + file);
			} else if(file.isDirectory()) {
				cntDir++;
				System.out.println("dir : " + file);
			}
		}
		
		
		System.out.println("file의 총 갯수 : " + cntFile + "개");
		System.out.println("dir의 총 갯수 : " + cntDir + "개");
		
	}

	private static void prnFolder01(File fi) {
		for (String list: fi.list()) {
			System.out.println(list);
		}
		
	}

}
