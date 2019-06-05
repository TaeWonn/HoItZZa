package index.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import buy.model.vo.Buy;
import free.model.vo.Free;

import static common.JDBCTemplate.*;

import sell.model.vo.Sell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class IndexDAO {
		Properties prop=new Properties();
	public IndexDAO() {
		String filePath = getClass().getResource("/sql/index/index.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<Sell> selectSellBoardList(Connection conn) {
		List<Sell>list=new ArrayList<>();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("selectSellBoardList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				Sell s=new Sell();
				s.setBoardNo(rset.getString("board_no"));
				s.setBoardTitle(rset.getString("board_title"));
				s.setBoardContent(rset.getString("board_content"));
				s.setBoardWriter(rset.getString("board_writer"));
				s.setBoardCodeNo(rset.getString("board_code_no"));
				s.setBoardDeal(rset.getString("board_deal"));
				s.setBoardDate(rset.getDate("board_date"));
				s.setBoardReadCounter(rset.getInt("board_read_count"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	public List<Buy> selectBuyBoardList(Connection conn) {
		List<Buy>list=new ArrayList<>();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("selectBuyBoardList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				Buy s=new Buy();
				s.setBoardNo(rset.getString("board_no"));
				s.setBoardTitle(rset.getString("board_title"));
				s.setBoardContent(rset.getString("board_content"));
				s.setBoardWriter(rset.getString("board_writer"));
				s.setBoardCodeNo(rset.getString("board_code_no"));
				s.setBoardDeal(rset.getString("board_deal"));
				s.setBoardDate(rset.getDate("board_date"));
				s.setBoardReadCounter(rset.getInt("board_read_count"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	public List<Free> selectSudaBoardList(Connection conn) {
		List<Free>fList1=new ArrayList<>();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("selectSudaBoardList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				Free s=new Free();
				s.setBoardNo(rset.getString("board_no"));
				s.setBoardTitle(rset.getString("board_title"));
				s.setBoardContent(rset.getString("board_content"));
				s.setBoardWriter(rset.getString("board_writer"));
				s.setBoardDate(rset.getDate("board_date"));
				s.setBoardReadCounter(rset.getInt("board_read_count"));
				fList1.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return fList1;
	}
	public List<Free> selectMediaBoardList(Connection conn) {
		List<Free>fList2=new ArrayList<>();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("selectMediaBoardList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				Free s=new Free();
				s.setBoardNo(rset.getString("board_no"));
				s.setBoardTitle(rset.getString("board_title"));
				s.setBoardContent(rset.getString("board_content"));
				s.setBoardWriter(rset.getString("board_writer"));
	
				s.setBoardDate(rset.getDate("board_date"));
				s.setBoardReadCounter(rset.getInt("board_read_count"));
				fList2.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return fList2;
	}
	public List<Free> selectSenseBoardList(Connection conn) {
		List<Free>fList2=new ArrayList<>();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("selectSenseBoardList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				Free s=new Free();
				s.setBoardNo(rset.getString("board_no"));
				s.setBoardTitle(rset.getString("board_title"));
				s.setBoardContent(rset.getString("board_content"));
				s.setBoardWriter(rset.getString("board_writer"));
				s.setBoardDate(rset.getDate("board_date"));
				s.setBoardReadCounter(rset.getInt("board_read_count"));
				fList2.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return fList2;
	}
	public List<Free> selectNanumBoardList(Connection conn) {
		List<Free>fList2=new ArrayList<>();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("selectNanumBoardList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				Free s=new Free();
				s.setBoardNo(rset.getString("board_no"));
				s.setBoardTitle(rset.getString("board_title"));
				s.setBoardContent(rset.getString("board_content"));
				s.setBoardWriter(rset.getString("board_writer"));
				s.setBoardDate(rset.getDate("board_date"));
				s.setBoardReadCounter(rset.getInt("board_read_count"));
				fList2.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return fList2;
	}


}
