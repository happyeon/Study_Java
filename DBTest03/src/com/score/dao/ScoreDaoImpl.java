package com.score.dao;

import static com.score.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.score.dto.ScoreDto;

// ~Impl : ~상속받아서 구현시킨 클래스 (보편적인 약속)
// Dao : Data Access Object
// db와 연결하는 코드만 작성
public class ScoreDaoImpl implements ScoreDao {

	@Override
	public List<ScoreDto> selectList() {		
		Connection con = getConnection();
		// 3.
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<ScoreDto> list = new ArrayList<ScoreDto>();
		
		
		try {
			pstm = con.prepareStatement(SELECT_LIST_SQL);
			
			// 4.
			rs = pstm.executeQuery();
			while(rs.next()) {
				ScoreDto sc = new ScoreDto();
				sc.setS_name(rs.getString(1));
				sc.setS_kor(rs.getInt(2));
				sc.setS_eng(rs.getInt(3));
				sc.setS_math(rs.getInt(4));
				sc.setS_sum(rs.getInt(5));
				sc.setS_avg(rs.getDouble(6));
				sc.setS_grade(rs.getString(7));
				
				list.add(sc);
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

	@Override
	public ScoreDto selectOne(String s_name) {
		Connection con = getConnection();
		
		// 3.
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ScoreDto dto = new ScoreDto();
	
		
		try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);
			pstm.setString(1, s_name);
			
			// 4.
			rs = pstm.executeQuery();
			while(rs.next()) {
				dto.setS_name(rs.getString("S_NAME"));
				dto.setS_kor(rs.getInt("S_KOR"));
				dto.setS_eng(rs.getInt("S_ENG"));
				dto.setS_math(rs.getInt("S_MATH"));
				dto.setS_sum(rs.getInt("S_SUM"));
				dto.setS_avg(rs.getDouble("S_AVG"));
				dto.setS_grade(rs.getString("S_GRADE"));
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

	@Override
	public int insert(ScoreDto dto) {
		Connection con = getConnection();
		// 3.
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(INSERT_SQL);
			pstm.setString(1, dto.getS_name());
			pstm.setInt(2, dto.getS_kor());
			pstm.setInt(3, dto.getS_eng());
			pstm.setInt(4, dto.getS_math());
			pstm.setInt(5, dto.getS_sum());
			pstm.setDouble(6, dto.getS_avg());
			pstm.setString(7, dto.getS_grade());
			
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

	@Override
	public int update(ScoreDto dto) {
		Connection con = getConnection();
		// 3.
		PreparedStatement pstm = null;
		int res = 0;
		
		
		
		try {
			pstm = con.prepareStatement(UPDATE_SQL);
			pstm.setInt(1, dto.getS_kor());
			pstm.setInt(2, dto.getS_eng());
			pstm.setInt(3, dto.getS_math());
			pstm.setInt(4, dto.getS_sum());
			pstm.setDouble(5, dto.getS_avg());
			pstm.setString(6, dto.getS_grade());
			pstm.setString(7, dto.getS_name());
			
			// 4.
			res = pstm.executeUpdate();
			if(res > 0) {
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

	@Override
	public int delete(String s_name) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		
		
		try {
			pstm = con.prepareStatement(DELETE_SQL);
			pstm.setString(1, s_name);
			
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

	@Override
	public ScoreDto topNproc(int n) {
		Connection con = getConnection();
		// 3.
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ScoreDto dto = null;
		
		try {
			pstm = con.prepareStatement(TOP_N_SQL);
			pstm.setInt(1, n);
			
			// 4.
			rs = pstm.executeQuery();
			while(rs.next()) {
				dto = new ScoreDto(
						rs.getString(2),
						rs.getInt(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getDouble(7),
						rs.getString(8)
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		
		
		return dto;
	}
	
	

}
