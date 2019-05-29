package sell.model.dao;

import static common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import sell.model.vo.Sell;

public class SellDAO {
	
	private Properties prop = new Properties();
	
	public SellDAO() {
		String filePath = getClass().getResource("/sell/sell-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public int selectSellCount(Connection conn) {
		int count =0;
		PreparedStatement ps = null;
		ResultSet  rs = null;
		String sql = prop.getProperty("selectSellCount");
		try {
			ps = conn.prepareStatement(sql);
			
			rs= ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch( Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return count;
	}

	public List<Sell> selectAllSellList(Connection conn) {
		List<Sell> sell = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectAllSellList");
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Sell s = new  Sell();
				s.setBoardNo(rs.getString("board_no"));
				s.setBoardTitle(rs.getString("board_title"));
				s.setBoardContent(rs.getString("board_content"));
				s.setBoardCode(rs.getString("board_code"));
				s.setBoardDate(rs.getDate("board_date"));
				s.setBoardDeal(rs.getString("board_deal"));
				s.setBoardReadCounter(rs.getInt("board_read_count"));
				s.setBoardWriter(rs.getString("board_writer"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
 		 
		return sell;
	}

	public int insertSell(Connection conn, Sell s) {
		int result= 0;
		
		
		PreparedStatement ps = null;
		String sql = prop.getProperty("insertSell");
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, s.getBoardTitle());
			ps.setString(2, s.getBoardContent());
			ps.setString(3, s.getBoardWriter());
			ps.setString(4, s.getBoardCodeNo());
			 
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}

}
