package com.test01;

import java.io.IOException;

public class MTest01 {
	
	public static void main(String[] args) {
		
		Runtime rt = Runtime.getRuntime();    //싱글톤 (new 안쓰고 ...)
		
		// mac os : String[] path = {"/usr/bin/open", "-a", "/Applications/Safari.app"};
		String path = "notepad.exe";
		
		try {
			Process prc = rt.exec(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

// 작업관리자 : ctrl + alt + delete