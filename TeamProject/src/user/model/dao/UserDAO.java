package user.model.dao;

import static common.JDBCTemplate.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

	public int updateUser(Connection conn, User user) {
//		int result = 0;
//		PreparedStatement pstmt = null;
//		String query = prop.getProperty("updateMember"); 
//
//		try {
//			//미완성쿼리문을 가지고 객체생성.
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, member.getMemberName());
//			pstmt.setString(2, member.getGender());
//			pstmt.setInt(3, member.getAge());
//			pstmt.setString(4, member.getEmail());
//			pstmt.setString(5, member.getPhone());
//			pstmt.setString(6, member.getAddress());
//			pstmt.setString(7, member.getHobby());
//			pstmt.setString(8, member.getMemberId());
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

}