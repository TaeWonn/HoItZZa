package buy.model.dao;

import static common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import buy.model.vo.Buy;

public class BuyDAO {
	
	private Properties prop = new Properties();
	
	public BuyDAO() {
		String filePath = getClass().getResource("/buy/buy-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int selectBuyCount(Connection conn) {
	    int count = 0;
	    String sql = prop.getProperty("selectBuyCount");
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

	public List<Buy> selectAllBuyList(Connection conn) {
		List<Buy> buy = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectAllBuyList");
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Buy b = new Buy();
				b.setBoardNo(rs.getString("board_no"));
				b.setBoardTitle(rs.getString("board_title"));
				b.setBoardContent(rs.getString("board_content"));
				b.setBoardCode(rs.getString("board_code"));
				b.setBoardDate(rs.getDate("board_date"));
				b.setBoardDeal(rs.getString("board_deal"));
				b.setBoardReadCounter(rs.getInt("board_read_count"));
				b.setBoardWriter(rs.getString("board_writer"));
				
				buy.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return buy;
	}

	public int insertBoard(Connection conn, Buy b) {
		String sql = prop.getProperty("insertBoard");
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, b.getBoardTitle());
			ps.setString(2, b.getBoardCodeNo());
			ps.setString(3, b.getBoardContent());
			ps.setString(4, b.getBoardDeal());
			
			result =ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}

}
