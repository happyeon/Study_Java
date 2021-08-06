package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MTest05 {
	
	// delete
	// 부서 번호 받아서, 삭제하자
	// DELETE FROM DEPT WHERE DEPTNO = ?
	// 50번 삭제
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. driver 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		// 3. query 준비
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 부서번호 : ");
		int deptno = sc.nextInt();
		
		String sql = " DELETE FROM DEPT "
				   + " WHERE DEPTNO = " 
				   + deptno;
		
		Statement stmt = con.createStatement(); 
		
		// 4. query 실행 및 리턴
		int res = stmt.executeUpdate(sql);
		
		if(res > 0) {
			System.out.println("delete 성공");
		} else {
			System.out.println("delete 실패");
		}
		
		// 5. db 종료
		stmt.close();
		con.close();
		
		
	}

}
