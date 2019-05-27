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

}
