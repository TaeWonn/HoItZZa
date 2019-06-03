package admin.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import admin.model.dao.AdminDAO;
import user.model.vo.User;

public class AdminService {

	public List<User> AllUser(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<User> userList = new AdminDAO().AllUser(conn, cPage, numPerPage);
		close(conn);
		return userList;
	}

	public int selectUserCount() {
		Connection conn = getConnection();
		int totalContents = new AdminDAO().selectUserCount(conn);
		close(conn);
		return totalContents;
	}

	public int UserDelete(String[] userIds) {
		Connection conn = getConnection();
		int result = new AdminDAO().UserDelete(conn, userIds);
		
		if(result> 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
	
		
		return result;
	}

	public User selectOneUser(String userId) {
		Connection conn = getConnection();
		User u = new AdminDAO().selectOneUser(conn, userId);
		close(conn);
		return u;
	}

	public List<User> userIdFind(String searchKeyword) {
		Connection conn = getConnection();
		List<User> ulist = new AdminDAO().userIdFind(conn, searchKeyword);
		close(conn);
		return ulist;
	}

	public int userIdCotents(String searchKeyword) {
		Connection conn = getConnection();
		int result = new AdminDAO().userIdContents(conn, searchKeyword);
		close(conn);
		return result;
	}

	public List<User> userNameFind(String searchKeyword) {
		Connection conn = getConnection();
		List<User> ulist = new AdminDAO().userNameFind(conn, searchKeyword);
		close(conn);
		return ulist;
	}

	public int userNameCotents(String searchKeyword) {
		Connection conn = getConnection();
		int result = new AdminDAO().userNameContents(conn, searchKeyword);
		close(conn);
		return result;
	}

	public List<User> genderFind(String searchKeyword) {
		Connection conn = getConnection();
		List<User> ulist = new AdminDAO().genderFind(conn, searchKeyword);
		close(conn);
		return ulist;
	}

	public int genderCotents(String searchKeyword) {
		Connection conn = getConnection();
		int result = new AdminDAO().genderContents(conn, searchKeyword);
		close(conn);
		return result;
	}


	
}
