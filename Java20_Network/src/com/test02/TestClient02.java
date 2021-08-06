package com.test02;

import java.io.*;
import java.net.Socket;

public class TestClient02 implements Runnable {

	@Override
	public void run() {
		try{
			Socket clientSocket;
			PrintWriter out = null;
			BufferedReader in = null;
			BufferedReader stdin = null;
			
			System.out.println("server에 접속합니다...");
			clientSocket = new Socket("localhost",9999); //접속 
			
			// 출력 (클라이언트에서 서버로)
			out = new PrintWriter(clientSocket.getOutputStream(),true);
			// 입력 (서버에서 클라이언트로)
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));		
			// 입력 (console에서 code로)
			stdin = new BufferedReader(new InputStreamReader(System.in));	
			
			String inputLine;
			while((inputLine = stdin.readLine()) != null){
				out.println(inputLine);
				System.out.println("server로부터 다시 받은 메시지 :" + in.readLine());
			}
			
			out.close();
			in.close();
			stdin.close();
			clientSocket.close();
			
			System.out.println("소켓을 닫는다...");
			
		}catch(IOException e){
		}
	}
	
	public static void main(String[] args) throws Exception{
		Thread t1 = new Thread(new TestClient02());
		t1.start();
	}
}
