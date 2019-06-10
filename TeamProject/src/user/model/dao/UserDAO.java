package user.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import user.model.service.UserService;
import user.model.vo.User;

public class UserDAO {
	
	private Properties prop = new Properties();
	
	public UserDAO() {
		String filePath = getClass().getResource("/sql/user/user-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertUser(Connection conn, User u) {
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("insertUser");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUserId());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getName());
			ps.setString(4, u.getGender());
			ps.setString(5, u.getSsn());
			ps.setString(6, u.getEmail());
			ps.setString(7, u.getPhone());
			ps.setString(8, u.getAddr());
			ps.setString(9, String.join(",", u.getInterest()));
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}

	public boolean checkIdDuplicate(Connection conn, String userId) {
		boolean isUsable = false;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("checkIdDuplicate");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int cnt = rs.getInt("cnt");
				
				if(cnt == 0) 
					isUsable = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		
		return isUsable;
	}
	
	public String[] selectCategory(Connection conn, String [] interest) {
		String [] categoryNames = new String[3];
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectCategory");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, interest[0]);
			ps.setString(2, interest[1]);
			ps.setString(3, interest[2]);
			
			rs = ps.executeQuery();
			
			int i = 0;
			while(rs.next()) {
				categoryNames[i] = rs.getString("SUBJECT_NAME");
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return categoryNames;
	}
	
	public String[] selectCategoryNo(Connection conn, String [] interest) {
		String [] categoryNos = new String[3];
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectCategoryNo");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, interest[0]);
			ps.setString(2, interest[1]);
			ps.setString(3, interest[2]);
			
			rs = ps.executeQuery();
			
			int i = 0;
			while(rs.next()) {
				categoryNos[i] = rs.getString("SUBJECT_No");
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return categoryNos;
	}

	public User selectOne(Connection conn, String userId) {
		User u = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectOne");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				u = new User();
				u.setUserId(rs.getString("user_Id"));
				u.setPassword(rs.getString("password"));
				u.setName(rs.getString("name"));
				u.setGender(rs.getString("gender"));
				u.setSsn(rs.getString("ssn"));
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getString("phone"));
				u.setAddr(rs.getString("addr"));
				u.setPoint(rs.getInt("point"));
				String interestStr = rs.getString("interest");
				String [] interest = selectCategory(conn, interestStr.split(","));
				u.setInterest(interest);
				u.setJoin_date(rs.getDate("join_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		
		System.out.println("User@DAO="+u);
		return u;
	}

	public int deleteUser(Connection conn, String userId) {
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("deleteUser");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}

	public int loginCheck(Connection conn, User u) {
		int result = UserService.ID_NOT_EXIST;
		String sql = prop.getProperty("loginCheck");
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUserId());
			
			rs = ps.executeQuery();
			
			String userId = "";
			String password = "";
			
			if(rs.next()) {
				userId = rs.getString("user_Id");//이부분 열이름 틀려서 수정
				password = rs.getString("password");
			}
			if(userId.equals(u.getUserId())
					&& password.equals(u.getPassword())) {
				result = UserService.LOGIN_OK;
			}
			else if(userId.equals(u.getUserId())) {
				result = UserService.WRONG_PASSWORD;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		
		return result;
	}

	public int updatePassword(Connection conn, User user) {
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("updatePassword");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getUserId());
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}

	public int updateUser(Connection conn, User u) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updateUser"); 

		try { 
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			System.out.println("updateUser@DAO="+u);
			pstmt.setString(1, u.getName());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getPhone());
			pstmt.setString(4, u.getAddr());
			pstmt.setString(5, String.join(",", u.getInterest()));
			pstmt.setString(6, u.getUserId());
			
			//쿼리문실행 : 완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			//DML은 executeUpdate()
			result = pstmt.executeUpdate();
			System.out.println("updateResult@DAO="+result);
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
				userId = rs.getString("user_Id");
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
		System.out.println("findUserPwd@SQL="+sql);
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getSsn());
			ps.setString(3, u.getUserId());
			
			rs = ps.executeQuery();
			int result = 0;
			if(rs.next()) 
				result = rs.getInt("cnt");
			
			System.out.println("result@userDAO="+result);
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
