package admin.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import board.model.vo.Board;

import static common.JDBCTemplate.*;
import user.model.vo.User;

public class AdminDAO {
	
	private Properties prop = new Properties();
	
	public AdminDAO() {
		String filePath = getClass().getResource("/sql/admin/admin-query.properties").getPath();
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
			
			System.out.println((cPage-1)*numPerPage +1);
			System.out.println(cPage* numPerPage);
			
			pstmt.setInt(1, (cPage - 1)*numPerPage +1);
			pstmt.setInt(2, cPage*numPerPage);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				User u = new User();
				u.setUserId(rs.getString("user_id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setJoin_date(rs.getDate("join_date"));
				u.setGender(rs.getString("gender"));
				u.setSsn(rs.getString("ssn"));
				u.setPhone(rs.getString("phone"));
				
				userList.add(u);
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

	public List<User> userIdFind(Connection conn, String searchKeyword) {
		List<User> ulist = new ArrayList<>();
		String sql = prop.getProperty("userIdFind");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, "%"+searchKeyword+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				User u = new User();
				u.setUserId(rs.getString("user_id"));
				u.setEmail(rs.getString("email"));
				u.setGender(rs.getString("gender"));
				u.setJoin_date(rs.getDate("join_date"));
				u.setSsn(rs.getString("ssn"));
				u.setName(rs.getString("name"));
				u.setPhone(rs.getString("phone"));
				u.setPoint(rs.getInt("point"));
				
				ulist.add(u);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return ulist;
	}
	
	public List<User> userNameFind(Connection conn, String searchKeyword) {
		List<User> ulist = new ArrayList<>();
		String sql = prop.getProperty("userNameFind");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, "%"+searchKeyword+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				User u = new User();
				u.setUserId(rs.getString("user_id"));
				u.setEmail(rs.getString("email"));
				u.setGender(rs.getString("gender"));
				u.setJoin_date(rs.getDate("join_date"));
				u.setSsn(rs.getString("ssn"));
				u.setName(rs.getString("name"));
				u.setPhone(rs.getString("phone"));
				u.setPoint(rs.getInt("point"));
				
				ulist.add(u);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return ulist;
	}
	
	public List<User> genderFind(Connection conn, String searchKeyword) {
		List<User> ulist = new ArrayList<>();
		String sql = prop.getProperty("genderFind");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, searchKeyword);
			rs = ps.executeQuery();
			while(rs.next()) {
				User u = new User();
				u.setUserId(rs.getString("user_id"));
				u.setEmail(rs.getString("email"));
				u.setGender(rs.getString("gender"));
				u.setSsn(rs.getString("ssn"));
				u.setJoin_date(rs.getDate("join_date"));
				u.setName(rs.getString("name"));
				u.setPhone(rs.getString("phone"));
				u.setPoint(rs.getInt("point"));
				
				ulist.add(u);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return ulist;
	}

	public int userIdContents(Connection conn, String searchKeyword) {
		int result = 0;
		String sql = prop.getProperty("userIdContents");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, "%"+searchKeyword+"%");
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return result;
	}
	
	public int userNameContents(Connection conn, String searchKeyword) {
		int result = 0;
		String sql = prop.getProperty("userNameContents");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, "%"+searchKeyword+"%");
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return result;
	}
	
	public int genderContents(Connection conn, String searchKeyword) {
		int result = 0;
		String sql = prop.getProperty("genderContents");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, searchKeyword);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return result;
	}

	public List<Board> selectSuggestionBoardList(Connection conn) {
		List<Board>list=new ArrayList<>();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("selectSuggestionBoardList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				Board b=new Board();
				b.setBoardNo(rset.getString("board_no"));
				b.setBoardTitle(rset.getString("board_title"));
				b.setBoardContent(rset.getString("board_content"));
				b.setBoardWriter(rset.getString("board_writer"));
				b.setBoardDate(rset.getDate("board_date"));
				b.setBoardReadCounter(rset.getInt("board_read_count"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(list);
		return list;
	}

	public List<Board> selectReportBoardList(Connection conn) {
		List<Board>list=new ArrayList<>();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("selectReportBoardList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				Board b=new Board();
				b.setBoardNo(rset.getString("board_no"));
				b.setBoardTitle(rset.getString("board_title"));
				b.setBoardContent(rset.getString("board_content"));
				b.setBoardWriter(rset.getString("board_writer"));
				b.setBoardDate(rset.getDate("board_date"));
				b.setBoardReadCounter(rset.getInt("board_read_count"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(list);
		return list;
	}

	public int warningCount(Connection conn, String userId) {
		int result=0;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("warningCount");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				result=rset.getInt("cnt");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(userId+"유저의 경고 횟수: "+result);
		return result;
	}

	public int warningUserCodeD_A(String userId, String[] reasonArr, Connection conn) {
		int result=0;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("warningUserCodeD_A");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, reasonArr[0]);
			pstmt.setString(2, userId);
			pstmt.setString(3, reasonArr[1]);
			result=pstmt.executeUpdate();
			if(result>0) {
				commit(conn);
			}else rollback(conn); 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int warningUserCodeD_S(String userId, String[] reasonArr, Connection conn) {
		int result=0;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("warningUserCodeD_S");
		System.out.println(sql);
		System.out.println(reasonArr[0]);
		System.out.println(reasonArr[1]);
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, reasonArr[0]);
			pstmt.setString(2, userId);
			pstmt.setString(3, reasonArr[1]);
			result=pstmt.executeUpdate();
			if(result>0) {
				commit(conn);
			}else rollback(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int warningUserCodeD_M(String userId, String[] reasonArr, Connection conn) {
		int result=0;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("warningUserCodeD_M");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, reasonArr[0]);
			pstmt.setString(2, userId);
			pstmt.setString(3, reasonArr[1]);
			result=pstmt.executeUpdate();
			if(result>0) {
				commit(conn);
			}else rollback(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int warningUserCodeD_P(String userId, String[] reasonArr, Connection conn) {
		int result=0;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("warningUserCodeD_P");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, reasonArr[0]);
			pstmt.setString(2, userId);
			pstmt.setString(3, reasonArr[1]);
			result=pstmt.executeUpdate();
			if(result>0) {
				commit(conn);
			}else rollback(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int warningUserCodeD_R(String userId, String[] reasonArr, Connection conn) {
		int result=0;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("warningUserCodeD_R");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, reasonArr[0]);
			pstmt.setString(2, userId);
			pstmt.setString(3, reasonArr[1]);
			result=pstmt.executeUpdate();
			if(result>0) {
				commit(conn);
			}else rollback(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public String selectBlackUserReason(Connection conn, String userId) {
		String result="";
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("selectBlackUserReason");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				if(rset.next()) {
				result+=rset.getString("code")+",";
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("코드"+result);
		return result;
	}

	public int insertBlackUser(String userId, String reason, Connection conn) {
		int result=0;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("insertBlackUser");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, reason);
			result=pstmt.executeUpdate();
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}



	
}
