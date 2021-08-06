package com.test02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Address {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		while(true) {
			System.out.println("번호 선택");
			System.out.println("1: 전체 출력");
			System.out.println("2: 선택 출력");
			System.out.println("3: 추가");
			System.out.println("4: 수정");
			System.out.println("5: 삭제");
			System.out.println("6: 종료");
			
			int select = sc.nextInt();
			
			switch (select) {
			case 1:
				System.out.println("전체 출력");
				selectList();
				break;
			case 2:
				System.out.println("선택 출력");
				selectOne();
				break;
			case 3:
				System.out.println("추가");
				insert();
				break;
			case 4:
				System.out.println("수정");
				update();
				break;
			case 5:
				System.out.println("삭제");
				delete();
				break;
			case 6:
				System.out.println("프로그램 종료...");
				System.exit(0);
			}
		}
	}
	
	public static void selectList() {
		// 1.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 2.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3.
		String sql = " SELECT NAME, PHONE, ADDR, EMAIL FROM ADDRESS ORDER BY NAME ";
		
		Statement stmt = null;
		ResultSet rs = null;
				
		try {
			stmt = con.createStatement();
			
			// 4.
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString(1) + " \t "
						         + rs.getString(2) + " \t "
						         + rs.getString(3) + " \t "
						         + rs.getString(4));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. 
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void selectOne() {
		// 1. driver 연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
				
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3. query 준비
		System.out.println("출력할 이름 : ");
		String name = sc.next();
		
		String sql = " SELECT NAME, PHONE, ADDR, EMAIL FROM ADDRESS WHERE NAME = ? ";
				
		PreparedStatement pstm = null;       //쿼리문을 미리 컴파일해서 가지고 있다가 쿼리 실행할 때 가져가서 실행해서 리턴해줌
		ResultSet rs = null;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, name);
			
			// 4. query 실행 및 리턴
			rs = pstm.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1) + " \t "
						         + rs.getString(2) + " \t "
						         + rs.getString(3) + " \t "
						         + rs.getString("EMAIL"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 5. db 종료
				rs.close();
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	
	public static void insert() {
		// 1.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 2.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3.
		System.out.println("입력할 이름 : ");
		String name = sc.next();
		System.out.println("입력할 번호 : ");
		String phone = sc.next();
		System.out.println("입력할 주소 : ");
		String addr = sc.next();
		System.out.println("입력할 이메일 : ");
		String email = sc.next();
		
		String sql = " INSERT INTO ADDRESS "
				   + " VALUES (?, ?, ?, ?) ";
		
		PreparedStatement pstm = null;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, phone);
			pstm.setString(3, addr);
			pstm.setString(4, email);
			
			// 4.
			int res = pstm.executeUpdate();   //statement와 달리 여기서 (sql) 해주지 않아도 됨
			if (res > 0) {
				System.out.println("추가 성공");
			} else {
				System.out.println("추가 실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}
	
	public static void update() {
		// 1.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 2.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3.
		System.out.println("수정할 이름 :");
		String name = sc.next();
		System.out.println("수정할 번호 :");
		String phone = sc.next();
		System.out.println("수정할 주소 :");    // 공백 쓰면 다음 토큰으로 넘어감!
		String addr = sc.next();
		System.out.println("수정할 메일 :");
		String email = sc.next();
		
		String sql = " UPDATE ADDRESS "
				   + " SET PHONE = ?, "
				   + " ADDR = ?, "
				   + " EMAIL = ? "
				   + " WHERE NAME = ? ";
		
		PreparedStatement pstm = null;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1,phone);
			pstm.setString(2,addr);
			pstm.setString(3,email);
			pstm.setString(4,name);
			
			// 4.
			int res = pstm.executeUpdate();   // 갯수를 리턴해주기 때문에 int 로 받음 (INSERT,UPDATE,DELETE)
			if (res > 0) {
				System.out.println("수정 성공");
			} else {
				System.out.println("수정 실패");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
				
		
		
	}
	
	public static void delete() {
		// 1.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		// 2.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
				
		Connection con = null;     // try 안에서 한 번에 안쓰고 밖으로 빼주는 이유는 try안에 쓰면 {} 여기 안에서만 쓸 수 있어서
								   // 밑에 식에서도 con을 사용할 것이기 때문에 일부러 빼주는 것임
				
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3.
		System.out.println("삭제할 이름 : ");
		String name = sc.next();
		
		String sql = " DELETE FROM ADDRESS "
				   + " WHERE NAME = ? ";
		
		PreparedStatement pstm = null;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, name);
			
			// 4.
			int res = pstm.executeUpdate();
			if (res > 0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	
		
	}

}
