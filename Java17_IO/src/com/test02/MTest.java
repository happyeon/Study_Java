package com.test02;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MTest {
	
	public static void main(String[] args) throws IOException {
		
		String fileName = "a.jpg";
		
		//FileInputStream fi = new FileInputStream(fileName);
		//BufferedInputStream bi = new BufferedInputStream(fi);    //buffer : 데이터 임시 저장
		BufferedInputStream bi = new BufferedInputStream(new FileInputStream(fileName));     //위에 두 줄 한줄에 쓴 것
		
		FileOutputStream fo = new FileOutputStream(new File("b.jpg"));
		
		
		// 이 코드는 한줄씩 가져오는 것. api에서 버퍼머시기를 사용해서 뭉텅이로 가져올 수 있도록 변경해보자...
		int a = 0;
		while((a = bi.read()) != -1) {
			fo.write(a);
		}
		
		// 나중에 만든 객체부터 먼저 닫자.(중요)
		fo.close();
		bi.close();
		
		
	}

}
