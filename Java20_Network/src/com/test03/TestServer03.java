package com.test03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

// UDP
public class TestServer03 {

	public static void main(String[] args) throws Exception {
		// 서버 생성
		DatagramSocket ds = new DatagramSocket(8888);         // DatagramSocket : UDP, UDP 포트 8888에서 브로드캐스트를 받을 수 있는 데이터그램소켓을 생성한다.
		System.out.println("서버입니다.");
		
		// 보내준 걸 담을 공간
		byte[] buff = new byte[1024];	// client에서 보낸 데이터를 받는 byte배열
		
		// 패킷을 받을 준비
		DatagramPacket recieveP = new DatagramPacket(buff, buff.length);	// DatagramPacket : 연결되지 않은 패킷을 배달하는 서비스, 해당 패킷 내의 정보를 기반으로 라우팅,
																			//					여러 패킷들은 다르게 라우팅될 수 있고, 순서에 상관없이 도착할 수 있다. 패킷 배달은 보장되지 않는다.
																			// client에서 보내는 데이터를 보관한다.
		// 클라이언트가 보낸 패킷을 받음
		ds.receive(recieveP);  // receiveP에서 보관된 데이터를 받는다.
		
		
		System.out.println(new String(recieveP.getData()));		// 받은 데이터를 출력
		
		ds.close();
		ds.disconnect();
	}
}
