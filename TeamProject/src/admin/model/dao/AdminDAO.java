package admin.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static common.JDBCTemplate.*;
import user.model.vo.User;

public class AdminDAO {
	
	private Properties prop = new Properties();
	
	public AdminDAO() {
		String filePath = getClass().getResource("/sql/admin/admin-query/properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public List<User> AllUser(Connection conn, int cPage, int numPerPage) {
		List<User> userList = new ArrayList<>();
		String sql = prop.getProperty("AllUser");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, (cPage - 1)*numPerPage +1);
			pstmt.setInt(2, cPage*numPerPage);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				User u = new User();
				u.setUserId(rs.getString("user_id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setJoin_date(rs.getDate("join_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return userList;
	}

	public int selectUserCount(Connection conn) {
		String sql = prop.getProperty("selectUserCount");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalContents = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				totalContents = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return totalContents;
	}

	public int UserDelete(Connection conn, String[] userIds) {
		int result = 0;
		String first = "delete from users where user_id = ";
		String second = "";
		for(int i=0; i<userIds.length; i++) {
			if(i < userIds.length-1) {
				second += "'"+userIds[i]+"'"+" or ";
			}else {
				second += "'"+userIds+"'";
			}
		}
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(first+second);
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public User selectOneUser(Connection conn, String userId) {
		String sql = prop.getProperty("selectOneUser");
		User u = new User();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				u.setUserId(userId);
				u.setEmail(rs.getString("email"));
				u.setGender(rs.getString("gender"));
				u.setJoin_date(rs.getDate("join_date"));
				u.setName(rs.getString("name"));
				u.setPhone(rs.getString("phone"));
				u.setPoint(rs.getInt("point"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return u;
	}


	
}
