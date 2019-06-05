package free.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import buy.model.vo.Buy;
import file.model.vo.FileTable;
import free.model.vo.Free;

public class FreeDAO {
	
	private Properties prop = new Properties();
	
	public FreeDAO() {
		String filePath = getClass().getResource("/sql/free/free-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int selectFreeCount(Connection conn) {
	    int count = 0;
	    String sql = prop.getProperty("selectFreeCount");
	    PreparedStatement ps = null;
	    ResultSet rs  = null;
	    try {
	    	ps = conn.prepareStatement(sql);
	    	
	    	rs = ps.executeQuery();
	    	if(rs.next()) {
	    		count = rs.getInt("cnt");
	    	}
	    }catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	close(rs);
	    	close(ps);
	    }
	    
		return count;
	}

	public List<Free> selectAllFreeList(Connection conn, int cPage, int numPerPage) {
		List<Free> free = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectAllFreeList");
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (cPage-1)*numPerPage+1);
			ps.setInt(2, cPage*numPerPage);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Free f = new Free();
				f.setBoardNo(rs.getString("board_no"));
				f.setBoardTitle(rs.getString("board_title"));
				f.setBoardContent(rs.getString("board_content"));
				f.setBoardDate(rs.getDate("board_date"));
				f.setBoardReadCounter(rs.getInt("board_read_count"));
				f.setBoardWriter(rs.getString("board_writer"));
				
				free.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		System.out.println("free@dao="+free+"\nlist.size()="+free.size());
		return free;
	}

	public int insertBoard(Connection conn, Free f) {
		String sql = prop.getProperty("insertBoard");
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, f.getBoardNo());
			ps.setString(2, f.getBoardTitle());
			ps.setString(3, f.getBoardWriter());
			ps.setString(4, f.getBoardWriter());
			
			result =ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}

	public int insertFileTable(Connection conn, FileTable t) {
		int result = 0;
		String sql = prop.getProperty("insertFileTable");
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, t.getBoardNo());
			ps.setString(2, t.getOriginalFileName());
			ps.setString(3, t.getRenamedFileName());
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}

	public int freeDelete(Connection conn, String boardNo) {
		int result = 0;
		String sql = prop.getProperty("freeDelete");
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, boardNo);
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}
}
