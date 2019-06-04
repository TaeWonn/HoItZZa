package sell.model.dao;

import static common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import comment.model.vo.Comment;
import file.model.vo.FileTable;
import sell.model.vo.Sell;

public class SellDAO {
	
	private Properties prop = new Properties();
	
	public SellDAO() {
		String filePath = getClass().getResource("/sql/sell/sell-query.properties").getPath();
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
				s.setBoardCodeNo(rs.getString("board_code_no"));
				s.setBoardDate(rs.getDate("board_date"));
				s.setBoardDeal(rs.getString("board_deal"));
				s.setBoardReadCounter(rs.getInt("board_read_count"));
				s.setBoardWriter(rs.getString("board_writer"));
				
				sell.add(s);
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
			ps.setString(5, s.getBoardDeal());//이부분이 빠져있어서 추가했어-세웅
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}

	public Sell selectOneSell(Connection conn, String boardNo) {
		String sql = prop.getProperty("selectOneSell");
		Sell s = new Sell();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, boardNo);
			
			rs= ps.executeQuery();
			if(rs.next()) {
				s.setBoardTitle(rs.getString("board_title"));
				s.setBoardContent(rs.getString("board_content"));
				s.setBoardWriter(rs.getString("board_writer"));
				s.setBoardDeal(rs.getString("board_deal"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return s;
	}

	public String selectOneBoardNo(Connection conn) {
		//현재 시퀀스 번호 가져오기
		String boardNo = null;
		String sql = prop.getProperty("selectOneBoardNo");
		PreparedStatement ps = null;
		ResultSet rs= null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				boardNo = rs.getString("boardNo");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			close(rs);
			close(ps);
		}
		return boardNo;
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
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}

	public int updateSell(Connection conn, Sell s) {
		int result =0;
		String sql = prop.getProperty("updateSell");
		PreparedStatement ps =null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, s.getBoardTitle());
			ps.setString(2, s.getBoardContent());
			ps.setString(3, s.getBoardDeal());
			ps.setString(4, s.getBoardCodeNo());
			ps.setString(5, s.getBoardNo());
			
			result = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}

	public List<FileTable> selectFiles(Connection conn, String boardNo) {
		List<FileTable> ft = new ArrayList<>();
		String sql = prop.getProperty("selectFiles");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, boardNo);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				FileTable f = new FileTable();
				f.setBoardNo(rs.getString("board_no"));
				f.setOriginalFileName("original_file_name");
				f.setRenamedFileName(rs.getString("renamed_file_name"));
				ft.add(f);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return ft;
	}

	public int warningCnt(Connection conn, String boardWriter) {
		int warningCnt = 0;
		String sql = prop.getProperty("warningCnt");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, boardWriter);
			rs = ps.executeQuery();
			if(rs.next()) {
				warningCnt = rs.getInt("warningCnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return warningCnt;
	}

	public int SellDelte(Connection conn, String boardNo) {
		int result = 0;
		String sql = prop.getProperty("sellDelte");
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, boardNo);
			
			result = ps.executeUpdate();
		} catch( Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}

	public int insertComment(Connection conn, Comment c) {
		int result = 0;
		String sql = prop.getProperty("insertComment");
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, c.getBoardNo());
			ps.setString(2, c.getCommentContent());
			ps.setString(3, c.getCommnetWriter());
			ps.setInt(4, c.getCommentLevel());
			ps.setInt(5, c.getCommentNoRef());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}
	public List<Sell> selectInterestSellListByUser(Connection conn, String userId) {
		List<Sell> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectInterestSellListByUser");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Sell s = new Sell();
				s.setBoardNo(rs.getString("board_no"));
				s.setBoardCodeNo(rs.getString("board_code_no"));
				s.setBoardTitle(rs.getString("board_title"));
				s.setBoardContent("board_content");
				s.setBoardDeal(rs.getString("board_deal"));
				s.setBoardWriter(rs.getString("board_writer"));
				s.setBoardReadCounter(rs.getInt("board_read_counter"));
				s.setBoardDate(rs.getDate("board_date"));
				
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Sell> selectInterestSellListByCategory(Connection conn, String interest) {
		List<Sell> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectInterestSellListByCategory");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, interest);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Sell s = new Sell();
				s.setBoardNo(rs.getString("board_no"));
				s.setBoardCodeNo(rs.getString("board_code_no"));
				s.setBoardTitle(rs.getString("board_title"));
				s.setBoardContent("board_content");
				s.setBoardDeal(rs.getString("board_deal"));
				s.setBoardWriter(rs.getString("board_writer"));
				s.setBoardReadCounter(rs.getInt("board_read_counter"));
				s.setBoardDate(rs.getDate("board_date"));
				
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Comment> commentList(Connection conn, String boardNo) {
		List<Comment> clist = new ArrayList<>();
		String sql = prop.getProperty("commentList");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, boardNo);
			
			rs= ps.executeQuery();
			while(rs.next()) {
				Comment c = new Comment();
				c.setCommentContent(rs.getString("comment_comment"));
				c.setCommentNo(rs.getInt("comment_no"));
				c.setCommnetWriter(rs.getString("comment_writer"));
				c.setCommentDate(rs.getDate("comment_date"));
				c.setCommentNoRef(rs.getInt("comment_no_ref"));
				c.setBoardNo(boardNo);
				
				clist.add(c);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return clist;
	}

	public int deleteComment(Connection conn, int commentNo) {
		int result =0;
		String sql = prop.getProperty("deleteComment");
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, commentNo);
			
			result = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}

	public List<Integer> warningListCnt(Connection conn, List<Sell> sell) {
		List<Integer> wList = new ArrayList<>();
		String sql = prop.getProperty("warningListCnt");
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			for(int i=0; i<wList.size(); i++) {
				ps.setString(1, sell.get(i).getBoardWriter());
				
				rs = ps.executeQuery();
				if(rs.next()) 
					wList.add(rs.getInt("cnt"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return wList;
	}

	public List<Sell> sellFind(Connection conn, String searchType, String searchKeyword, int cPage, int numPerPage) {
		List<Sell> sList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "";
		switch(searchType) {
		case "sellTitle_find":
			query ="titleFind";
			break;
		case "sellContent_find":
			query ="contentFind";
			break;
		case "sellWriter_find":
			query ="writerFind";
			break;
			
		}
		String sql = prop.getProperty(query);
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+searchKeyword+"%");
			ps.setInt(2, (cPage-1)*numPerPage+1);
			ps.setInt(3, cPage*numPerPage);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Sell s = new Sell();
				s.setBoardNo(rs.getString("board_no"));
				s.setBoardTitle(rs.getString("board_title"));
				s.setBoardWriter(rs.getString("board_writer"));
				s.setBoardContent(rs.getString("board_content"));
				s.setBoardCodeNo(rs.getString("board_code_no"));
				s.setBoardDeal(rs.getString("board_deal"));
				s.setBoardDate(rs.getDate("board_date"));
				s.setBoardReadCounter(rs.getInt("board_read_count"));
				sList.add(s);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return sList;
	}

	public int findContents(Connection conn, String searchType, String searchKeyword) {
		int count =0;
		String query="";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		switch(searchType) {
		case "sellTitle_find":
			query = "titleCotents";
			break;
		case "sellContent_find":
			query = "contentContents";
			break;
		case "sellWriter_find":
			query = "writerContents";
			break;
		}
		String sql= prop.getProperty(query);
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, "%"+searchKeyword+"%");
			rs = ps.executeQuery();
			if(rs.next())
				count = rs.getInt("cnt");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return count;
	}
	
	

}
