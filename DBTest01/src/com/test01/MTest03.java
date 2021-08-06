package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MTest03 {
	
	// insert
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. driver 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user ="kh";
		String password = "kh";
		
		// 자바와 데이터베이스랑 연결해주는 객체
		Connection con = DriverManager.getConnection(url,user,password);
		
		// 3. query 준비
		Scanner sc = new Scanner(System.in);
		System.out.println("부서번호 : ");
		int deptno = sc.nextInt();
		System.out.println("부서이름 : ");
		String dname = sc.next();
		System.out.println("부서위치 : ");
		String loc = sc.next();
		
		String sql = " INSERT INTO DEPT(DEPTNO, DNAME, LOC) "
				   + " VALUES(" + deptno + ", '" + dname + "', '" + loc + "') ";
		
		Statement stmt = con.createStatement();  //쿼리가 실행되고 나오는 결과를 담아서 리턴 결과 받아주는 역할
		
		// 4. query 실행 및 리턴
		
		// 4-1. SELECT 일 때는, 결과 테이블을 받아줄 ResultSet 사용
		// ResultSet rs = stmt.executeQuery(sql);    // 응답되는 '결과 테이블'을 받아줌
		
		//4-2. INSERT, UPDATE, DELETE 일 때는, 적용된 갯수를 받는다.
		int res = stmt.executeUpdate(sql);
		if (res > 0) {
			System.out.println("insert 성공");
		} else {
			System.out.println("insert 실패");
		}
		
		// 5. db 종료
		stmt.close();
		con.close();
		
	}

}





