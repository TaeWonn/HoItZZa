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

	
}
