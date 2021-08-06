package com.test03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;

public class TestClient03 {
	
	public static void main(String[] args) throws Exception {
		
		// 클라이언트 생성 (서버와 차이점은 포트번호의 유무)
		DatagramSocket ds = new DatagramSocket();
		System.out.println("클라이언트 입니다.");
		
		// 보낼 데이터
		byte[] buff = "연습입니다.".getBytes();		//입력받은 문자열을 byte[] 배열로 변환시켜 준다.
		
		// packet으로 감싼다. (데이터, 데이터크기, 주소, 포트)
		DatagramPacket sendP = new DatagramPacket(buff, buff.length,InetAddress.getByName("localhost"),8888);    // 해당 호스트의 포트 넘버에 패킷의 길이만큼 보내기 위한 데이터그램 패킷을 생성한다.
																												 // (전송할데이터 / 데이터길이 / 호스트주소 / 포트번호)
		// packet 보낸다.
		ds.send(sendP);		// sendP에 저장된 정보를 DatagramSocket을 이용해 server에 전달
		
		ds.close();
		ds.disconnect();
	}

}
