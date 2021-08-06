package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MTest01 {
	
	// SELECT LIST
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 1. driver 연결 (ojdbc6.jar 잊지말자!!!)   // jar: library, oracle java database connection
		Class.forName("oracle.jdbc.driver.OracleDriver");    //오라클이 우리 데이터베이스랑 자바랑 연결하고 싶으면 쓰라고 준 것
		
		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = DriverManager.getConnection(url,user,password);      // 중요! 자바와 데이터베이스 연결해주는 통로 
		
		// 3. query 준비
		String sql = " SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO "     // 앞, 뒤 무조건 공백
				   + " FROM EMP ";
		
		Statement stmt = con.createStatement();     //실행, 리턴된 값을 ResultSet에 담아줌
		
		// 4. query 실행 및 리턴
		ResultSet rs = stmt.executeQuery(sql);       //ResultSet <- 커서로 한 줄씩 읽고 rs.next() 식이 나올때 마다 한 줄씩 내려감
		while (rs.next()) {
			System.out.printf("%6d %10s %10s %6d %10s %7.2f %7.2f %3d \n",
								rs.getInt("EMPNO"),       // 컬럼이름으로 써도 되고 숫자로 써도 됨
								rs.getString(2),
								rs.getString("JOB"),
								rs.getInt(4),
								rs.getDate("HIREDATE"),
								rs.getDouble(6),
								rs.getDouble("COMM"),
								rs.getInt(8));
		}
		
		// 5. db 종료
		rs.close();       //마지막에 객체 생성한 것 부터 close
		stmt.close();
		con.close();
		
	}

}
