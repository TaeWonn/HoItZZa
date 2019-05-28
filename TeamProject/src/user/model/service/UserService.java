package user.model.service;

import static common.JDBCTemplate.*;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import user.model.dao.UserDAO;
import user.model.vo.User;

public class UserService {
	//로그인처리를 위한 상수를 선언
	public static final int LOGIN_OK = 1;
	public static final int WRONG_PASSWORD = 0;
	public static final int ID_NOT_EXIST = -1;
	
	public int insertUser(User u) {
		Connection conn = getConnection();
		int result = new UserDAO().insertMember(conn, u);
		//dml인 경우 transaction처리 직접하기
		if(result > 0)
			commit(conn);
		else 
			rollback(conn);
		
		//연결객체 반납
		close(conn);
		return result;
	}
	
	public boolean checkIdDuplicate(String userId) {
		Connection conn = getConnection();
		boolean isUsable = new UserDAO().checkIdDuplicate(conn, userId);
		close(conn);
		return isUsable;
	}

	public User selectOne(String userId) {
		Connection conn = getConnection();
		User user = new UserDAO().selectOne(conn, userId);
		close(conn);
		return user;
	}

	public int deleteUser(String userId) {
		Connection conn = getConnection();
		int result = new UserDAO().deleteUser(conn, userId);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);		
		return result;
	}

	public int loginCheck(User u) {
		Connection conn = getConnection();
		int result = new UserDAO().loginCheck(conn, u);
		close(conn);
		return result;
	}

	public int updatePassword(User user) {
		Connection conn = getConnection();
		int result = new UserDAO().updatePassword(conn, user);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int updateUser(User user) {
		Connection conn = getConnection();
		int result = new UserDAO().updateUser(conn, user);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

}
