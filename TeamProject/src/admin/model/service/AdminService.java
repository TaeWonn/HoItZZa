package admin.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import admin.model.dao.AdminDAO;
import board.model.vo.Board;
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

	public List<Board> selectSuggestionBoardList() {
		Connection conn=getConnection();
		List<Board> list=new AdminDAO().selectSuggestionBoardList(conn);
		close(conn);
		return list;
	}

	public List<Board> selectReportBoardList() {
		Connection conn=getConnection();
		List<Board> list=new AdminDAO().selectReportBoardList(conn);
		close(conn);
		return list;
	}


	public int warningCount(String userId) {
		Connection conn=getConnection();
		int result=new AdminDAO().warningCount(conn,userId);
		close(conn);
		return result;
	}

	public int warningUserCodeD_A(String userId, String[] reasonArr) {
		Connection conn=getConnection();
		int result=new AdminDAO().warningUserCodeD_A(userId,reasonArr,conn);
		close(conn);
		return result;
	}

	public int warningUserCodeD_S(String userId, String[] reasonArr) {
		Connection conn=getConnection();
		int result=new AdminDAO().warningUserCodeD_S(userId,reasonArr,conn);
		close(conn);
		return result;
	}

	public int warningUserCodeD_M(String userId, String[] reasonArr) {
		Connection conn=getConnection();
		int result=new AdminDAO().warningUserCodeD_M(userId,reasonArr,conn);
		close(conn);
		return result;
	}

	public int warningUserCodeD_P(String userId, String[] reasonArr) {
		Connection conn=getConnection();
		int result=new AdminDAO().warningUserCodeD_P(userId,reasonArr,conn);
		close(conn);
		return result;
	}

	public int warningUserCodeD_R(String userId, String[] reasonArr) {
		Connection conn=getConnection();
		int result=new AdminDAO().warningUserCodeD_R(userId,reasonArr,conn);
		close(conn);
		return result;
	}

	public String selectBlackUserReason(String userId) {
		Connection conn=getConnection();
		String result=new AdminDAO().selectBlackUserReason(conn,userId);
		close(conn);
		return result;
	}

	public int insertBlackUser(String userId, String reason) {
		Connection conn=getConnection();
		int result=new AdminDAO().insertBlackUser(userId,reason,conn);
		close(conn);
		return result;
	}


	
}
