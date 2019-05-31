package buy.model.dao;

import static common.JDBCTemplate.*;

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
import comment.model.vo.Comment;
import file.model.vo.FileTable;
import sell.model.vo.Sell;

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
				b.setBoardCodeNo(rs.getString("board_code_no"));
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

	public Buy selectOneBuy(Connection conn, String boardNo) {
		String sql = prop.getProperty("selectOneBuy");
		PreparedStatement ps = null;
		ResultSet rs = null;
		Buy b = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, boardNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				b = new Buy();
				b.setBoardNo(rs.getString("board_no"));
				b.setBoardTitle(rs.getString("board_title"));
				b.setBoardContent(rs.getString("board_content"));
				b.setBoardDate(rs.getDate("board_date"));
				b.setBoardDeal(rs.getString("board_deal"));
				b.setBoardWriter(rs.getString("board_writer"));
				b.setBoardCodeNo(rs.getString("board_code_no"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(ps); 
		}
		return b;
	}

	public String selectOneBoardNo(Connection conn, Buy b) {
		//시퀀스 현재 번호 가져오기
		String boardNo = null;
		String sql = prop.getProperty("selectOneBoardNo");
		PreparedStatement ps = null;
		ResultSet rs= null;
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				boardNo = rs.getString("board_no");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
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
				
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return warningCnt;
	}

	public int buyDelte(Connection conn, String boardNo) {
		int result= 0;
		String sql = prop.getProperty("buyDelete");
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, boardNo);
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
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
			ps.setInt(5, c.getCommentNo());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}

	public List<Buy> selectInterestBuyListByUser(Connection conn, String userId) {
		List<Buy> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectInterestBuyListByUser");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Buy b = new Buy();
				b.setBoardNo(rs.getString("board_no"));
				b.setBoardCodeNo(rs.getString("board_code_no"));
				b.setBoardTitle(rs.getString("board_title"));
				b.setBoardContent("board_content");
				b.setBoardDeal(rs.getString("board_deal"));
				b.setBoardWriter(rs.getString("board_writer"));
				b.setBoardReadCounter(rs.getInt("board_read_counter"));
				b.setBoardDate(rs.getDate("board_date"));
				
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<FileTable> selectFileList(Connection conn, String boardNo) {
		List<FileTable> flist = new ArrayList<>();
		String sql = prop.getProperty("selectFileList");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, boardNo);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				FileTable t = new FileTable();
				t.setBoardNo(rs.getString("board_no"));
				t.setOriginalFileName(rs.getString("original_file_name"));
				t.setRenamedFileName(rs.getString("renamed_file_name"));
				
				flist.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return flist;
	}

	public int updateBuy(Connection conn, Buy b) {
		int result = 0;
		String sql = prop.getProperty("updateBuy");
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, b.getBoardTitle());
			ps.setString(2, b.getBoardContent());
			ps.setString(3, b.getBoardDeal());
			ps.setString(4, b.getBoardCodeNo());
			ps.setString(5, b.getBoardNo());
			
			result = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}

	public List<Comment> commentList(Connection conn, String boardNo) {
		List<Comment> clist = new ArrayList<>();
		String sql = prop.getProperty("commentList");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, boardNo);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Comment c = new Comment();
				c.setCommentContent(rs.getString("comment_content"));
				c.setCommentNo(rs.getInt("comment_no"));
				c.setCommnetWriter(rs.getString("comment_writer"));
				c.setBoardNo(boardNo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		
		return clist;
	}

	public int deleteComment(Connection conn ,int commentNo) {
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

	public int selectUserPoint(Connection conn, String userId) {
		int point = 0;
		String sql = prop.getProperty("selectUserPoint");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				point = rs.getInt("point");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return point;
	}

	public int buying(Connection conn, int price, int point) {
		int result =0;
		String sql = prop.getProperty("buying");
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, point);
			ps.setInt(2, price);
			
			result = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}

}
