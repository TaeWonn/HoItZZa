package user.model.dao;

import static common.JDBCTemplate.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import user.model.vo.User;

public class UserDAO {
	
	private Properties prop = new Properties();
	
	public UserDAO() {
		String filePath = getClass().getResource("/user/user-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertMember(Connection conn, User u) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "";
		
		return result;
	}

	public boolean checkIdDuplicate(Connection conn, String userId) {
		boolean isUsable = false;
		return isUsable;
	}

	public User selectOne(Connection conn, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteUser(Connection conn, String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int loginCheck(Connection conn, User u) {
//		int result = MemberService.ID_NOT_EXIST;
//		String sql = prop.getProperty("selectOne");
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		
//		try {
//			//미완성쿼리를 가지고 statement객체 생성
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, m.getMemberId());
//			//쿼리실행
//			rset = pstmt.executeQuery();
//			//rset의 결과를 변수에 담기
//			String memberId = "";
//			String password = "";
//			//리턴된 행이 있을 경우
//			if(rset.next()) {
//				memberId = rset.getString("memberid");
//				password = rset.getString("password");
//			}
//			
//			//비교 및 결과 도출
//			if(memberId.equals(m.getMemberId()) 
//					&& password.equals(m.getPassword())) {
//				result = MemberService.LOGIN_OK;
//			}
//			else if(memberId.equals(m.getMemberId())) {
//				result = MemberService.WRONG_PASSWORD;
//			}
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rset);
//			close(pstmt);
//		}
//		
//		return result;
		return 0;
	}

	public int updatePassword(Connection conn, User user) {
//		int result = 0;
//		PreparedStatement pstmt = null;
//		String query = prop.getProperty("updatePassword"); 
//
//		try {
//			//미완성쿼리문을 가지고 객체생성.
//			pstmt = conn.prepareStatement(query);
//			//쿼리문미완성
//			pstmt.setString(1, member.getPassword());
//			pstmt.setString(2, member.getMemberId());
//			
//			//쿼리문실행 : 완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
//			//DML은 executeUpdate()
//			result = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
		return 0;
	}

	public int updateUser(Connection conn, User u) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updateUser"); 

		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, u.getName());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getPhone());
			pstmt.setString(4, u.getAddr());
			pstmt.setString(5, String.join(",", u.getInterest()));
			pstmt.setString(6, u.getUserId());
			
			//쿼리문실행 : 완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			//DML은 executeUpdate()
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public String findUserId(Connection conn, User u) {
		String userId = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("findUserId");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getPhone());
			
			rs = ps.executeQuery();
			
			if(rs.next())
				userId = rs.getString("userId");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		
		return userId;
	}

	public Boolean findUserPwd(Connection conn, User u) {
		Boolean chkPwd = false;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 일치하는 회원 정보를 count로 받아올 것.
		String sql = prop.getProperty("findUserPwd");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getSsn());
			ps.setString(3, u.getUserId());
			
			rs = ps.executeQuery();
			int result = 0;
			if(rs.next()) 
				result = rs.getInt("cnt");
			
			if(result>0)
				chkPwd = true;
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		
		return chkPwd;
	}

}
