package com.kh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.dto.TestDto;
import static com.kh.db.JDBCTemplate.*;


public class TestDao {
	
	public List<TestDto> selectList(){
		// 1. 	
		// 2.
		Connection con = getConnection();
		
		// 3.
		String sql = " SELECT NO, NAME, PHONE, ADDR "
				   + " FROM KHTEST "
				   + " ORDER BY NO DESC ";
		// Statement : 하나하나 다 만들어줘야 함
		// PreparedStatement : ? 미리 쿼리를 만들어 놓는다.
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<TestDto> list = new ArrayList<TestDto>();		
		
		try {
			pstm = con.prepareStatement(sql);
			
			// 4.
			// executeQuery() : "select" ->실행, ResultSet <-리턴 table
			// executeUpdate() : "insert, update, delete" ->실행, int <- n개(적용된 row 개수)
			rs = pstm.executeQuery();
			while(rs.next()) {
				TestDto dto = new TestDto();
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setPhone(rs.getString(3));
				dto.setAddr(rs.getString(4));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.
			close(rs);
			close(pstm);
			close(con);
			
		}
		
		
		return list;
	}
	
	public TestDto selectOne(int no) {
		// 1.
		// 2.
		Connection con = getConnection();
		
		// 3. 
		String sql = " SELECT NO, NAME, PHONE, ADDR "
				   + " FROM KHTEST "
				   + " WHERE NO = ? ";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		TestDto dto = null;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, no);
			
			// 4.
			rs = pstm.executeQuery();
			while(rs.next()) {
				dto = new TestDto();
				dto.setNo(rs.getInt("NO"));
				dto.setName(rs.getString("NAME"));
				dto.setPhone(rs.getString("PHONE"));
				dto.setAddr(rs.getString("ADDR"));
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			// 5.
			close(rs);
			close(pstm);
			close(con);
		}
		
		return dto;
	}
	
	public int insert(TestDto dto) {
		// 1.
		// 2.
		Connection con = getConnection();
		
		// 3.
		String sql = " INSERT INTO KHTEST "
				   + " VALUES(?,?,?,?) ";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, dto.getNo());
			pstm.setString(2, dto.getName());
			pstm.setString(3, dto.getPhone());
			pstm.setString(4, dto.getAddr());
			
			// 4.
			res = pstm.executeUpdate();
			if (res > 0) {
				commit(con);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.
			close(pstm);
			close(con);
		}
		
		
		return res;
	}
	
	public int update(TestDto dto) {
		// 1.
		// 2.
		Connection con = getConnection();
		
		// 3.
		String sql = " UPDATE KHTEST "
				   + " SET NAME = ?, "
				   + " PHONE = ?, "
				   + " ADDR = ? "
				   + " WHERE NO = ? ";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
	
			pstm.setString(1, dto.getName());
			pstm.setString(2, dto.getPhone());
			pstm.setString(3, dto.getAddr());
			pstm.setInt(4, dto.getNo());
			
			// 4.
			res = pstm.executeUpdate();
			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.
			close(pstm);
			close(con);
		}
		
		return res;
	}
	
	public int delete(int no) {
		// 1.
		// 2.
		Connection con = getConnection();
		
		// 3.
		String sql = " DELETE FROM KHTEST "
				   + " WHERE NO = ? ";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, no);
			
			// 4.
			res = pstm.executeUpdate();
			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.
			close(pstm);
			close(con);
		}
		
		return res;
	}

}
