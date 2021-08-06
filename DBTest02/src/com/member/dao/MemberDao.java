package com.member.dao;

import static com.member.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.member.dto.MemberDto;

// Dao : Data Access Object
// db와 연결하는 코드만 작성
public class MemberDao {
	
	public List<MemberDto> selectList() {
		// 1.
		// 2.
		// Connection con = JDBCTemplate.getConnection();  //다른 클래스에 있는 static 메소드를 호출할 때는 이렇게 해야함 원래는
		// 그런데 import static 해서 임포트 해주면 class.(JDBCTemplate.)을 생략할 수 있다. 메소드만 바로 호출할 수 있음
		Connection con = getConnection();
		
		
		// 3.
		String sql = " SELECT M_NO, M_NAME, M_AGE, M_GENDER, M_LOCATION, M_JOB, M_TEL, M_EMAIL "
				   + " FROM MEMBER "
				   + " ORDER BY M_NO DESC ";
		
		Statement stmt = null;
		ResultSet rs = null;
		
		List<MemberDto> list = new ArrayList<MemberDto>();    // list로 만들어 주는 이유는 순서대로 저장하고 순서대로 출력하기 위함 
		                                                      // (list이외에 array. collection 사용 가능)
		
		try {
			stmt = con.createStatement();
			
			// 4.
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				MemberDto dto = new MemberDto();
				dto.setM_no(rs.getInt(1));
				dto.setM_name(rs.getString(2));
				dto.setM_age(rs.getInt(3));
				dto.setM_gender(rs.getString(4));
				dto.setM_location(rs.getString(5));
				dto.setM_job(rs.getString(6));
				dto.setM_tel(rs.getString(7));
				dto.setM_email(rs.getString(8));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.
			close(rs);
			close(stmt);
			close(con);
		}
		

		return list;
	}
	
	// 선택출력
	public MemberDto selectOne(int m_no) {
		// 1.
		// 2.
		Connection con = getConnection();
		
		// 3.
		String sql = " SELECT M_NO, M_NAME, M_AGE, M_GENDER, M_LOCATION, M_JOB, M_TEL, M_EMAIL "
				   + " FROM MEMBER "
				   + " WHERE M_NO = ? ";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		MemberDto dto = null;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, m_no);
			
			// 4.
			rs = pstm.executeQuery();
			while(rs.next()) {
				dto = new MemberDto();
				dto.setM_no(rs.getInt("M_NO"));
				dto.setM_name(rs.getString("M_NAME"));
				dto.setM_age(rs.getInt("M_AGE"));
				dto.setM_gender(rs.getString("M_GENDER"));
				dto.setM_location(rs.getString("M_LOCATION"));
				dto.setM_job(rs.getString("M_JOB"));
				dto.setM_tel(rs.getString("M_TEL"));
				dto.setM_email(rs.getString("M_EMAIL"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.
			close(rs);
			close(pstm);
			close(con);
		}
		
		
		return dto;		//dto를 리턴하는 이유? 디비가 테이블 하나를 가져와줄꺼니까, 테이블 안에는 로우가 1줄이라서, 2줄이면 list에 담는다
	}
	// 추가
	public int insert(MemberDto dto) {
		// 1.
		// 2.
		Connection con = getConnection();
		
		// 3.
		String sql = " INSERT INTO MEMBER "
				  +  " VALUES (MEMBERSEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?) ";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getM_name());
			pstm.setInt(2, dto.getM_age());
			pstm.setString(3, dto.getM_gender());
			pstm.setString(4, dto.getM_location());
			pstm.setString(5, dto.getM_job());
			pstm.setString(6, dto.getM_tel());
			pstm.setString(7, dto.getM_email());
			
			// 4.
			res = pstm.executeUpdate();
			if (res > 0) {
				commit(con);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 5.
			close(pstm);
			close(con);
		}
		

		return res;
	}
	
	// 수정
	public int update(MemberDto dto) {
		// 1.
		// 2.
		Connection con = getConnection();
		
		// 3.
		String sql = " UPDATE MEMBER "
				   + " SET M_NAME = ?, "
				   + " M_AGE = ?, "
				   + " M_GENDER = ?, "
				   + " M_LOCATION = ?, "
				   + " M_JOB = ?, "
				   + " M_TEL = ?, "
				   + " M_EMAIL = ? "
				   + " WHERE M_NO = ? ";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getM_name());
			pstm.setInt(2, dto.getM_age());
			pstm.setString(3, dto.getM_gender());
			pstm.setString(4, dto.getM_location());
			pstm.setString(5, dto.getM_job());
			pstm.setString(6, dto.getM_tel());
			pstm.setString(7, dto.getM_email());
			pstm.setInt(8, dto.getM_no());
			
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
	// 삭제
	public int delete(int m_no) {
		// 1.
		// 2.
		Connection con = getConnection();
				
		// 3.
		String sql = " DELETE FROM MEMBER "
				   + " WHERE M_NO = ? ";
		
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, m_no);
			
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
