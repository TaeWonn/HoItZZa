package opinion.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import opinion.model.vo.Opinion;

public class OpinionDAO {
	
	private Properties prop = new Properties();
	
	public OpinionDAO() {
		String filePath = getClass().getResource("/opinion/opinion-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int selectOpinionCount(Connection conn) {
	    int count = 0;
	    String sql = prop.getProperty("selectOpinionCount");
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

	public List<Opinion> selectAllOpinionList(Connection conn) {
		List<Opinion> opinion = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectAllOpinionList");
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Opinion o = new Opinion();
				o.setBoardNo(rs.getString("board_no"));
				o.setBoardTitle(rs.getString("board_title"));
				o.setBoardContent(rs.getString("board_content"));
				o.setBoardCodeNo(rs.getString("board_code_no"));
				o.setBoardDate(rs.getDate("board_date"));
				o.setBoardDeal(rs.getString("board_deal"));
				o.setBoardReadCounter(rs.getInt("board_read_count"));
				o.setBoardWriter(rs.getString("board_writer"));
				
				opinion.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return opinion;
	}

	public int insertBoard(Connection conn, Opinion o) {
		String sql = prop.getProperty("insertBoard");
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, o.getBoardTitle());
			ps.setString(2, o.getBoardCodeNo());
			ps.setString(3, o.getBoardContent());
			ps.setString(4, o.getBoardDeal());
			
			result =ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}
}
