package sell.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import board.model.service.BoardService;
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

	public List<Sell> selectAllSellList(Connection conn,int cPage, int numPerPage) {
		List<Sell> sell = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectAllSellList");
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (cPage-1)*numPerPage +1);
			ps.setInt(2, cPage*numPerPage);
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
				
				/////////////////////////////////////////////////////////////////////////
				
				String ca = new BoardService().selectcategoryname(s.getBoardCodeNo());
				s.setBoardCodeNo(ca);
				
				///////////////////////////////////////////////////////////////////////////
				
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
		System.out.println(sql);
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
				s.setBoardDate(rs.getDate("board_date"));
				s.setBoardCodeNo(rs.getString("board_code_No"));
				s.setBoardNo(rs.getString("board_no"));
				s.setBoardReadCounter(rs.getInt("board_read_count"));
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
		System.out.println("쿼리문"+sql);
		Statement ps = null;
		ResultSet rs= null;
		try {
			ps = conn.createStatement();
			rs = ps.executeQuery(sql);
			if(rs.next()) {
				boardNo = "S_"+rs.getInt("board_No");
				System.out.println("처리여부"+boardNo);
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
		System.out.println("파일 데이터 삽입 : "+result);
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
				FileTable t = new FileTable();
				t.setBoardNo(rs.getString("board_no"));
				t.setOriginalFileName(rs.getString("original_filename"));
				t.setRenamedFileName(rs.getString("renamed_filename"));
				
				ft.add(t);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return ft;
	}
	
	public FileTable selectFile(Connection conn, String boardNo) {
		FileTable f = new FileTable();
		String sql = prop.getProperty("selectFiles");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, boardNo);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				f.setBoardNo(rs.getString("board_no"));
				f.setOriginalFileName(rs.getString("original_filename"));
				f.setRenamedFileName(rs.getString("renamed_filename"));
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return f;
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
			System.out.println("다오:"+c.getCommentNoRef());
			ps.setString(1, c.getBoardNo());
			ps.setString(2, c.getCommentContent());
			ps.setString(3, c.getCommnetWriter());
			ps.setInt(4, c.getCommentLevel());
			ps.setString(5, c.getCommentNoRef().equals("0")? null : c.getCommentNoRef());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}
	public List<String> interestSellBoardNoByUser(Connection conn, String userId) {
		List<String> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("interestSellBoardNoByUser");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String s="";
				s=rs.getString("interest_board_no");
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
			ps.setString(1,interest);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Sell s = new Sell();
				s.setBoardNo(rs.getString("board_no"));
				s.setBoardCodeNo(rs.getString("board_code_no"));
				s.setBoardTitle(rs.getString("board_title"));
				s.setBoardContent("board_content");
				s.setBoardDeal(rs.getString("board_deal"));
				s.setBoardWriter(rs.getString("board_writer"));
				s.setBoardReadCounter(rs.getInt("board_read_count"));
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
				c.setCommentNo(rs.getString("comment_no"));
				c.setCommentContent(rs.getString("comment_content"));//컬럼명이 잘못되어 있어서 수정
				c.setCommnetWriter(rs.getString("comment_writer"));
				c.setCommentLevel(rs.getInt("comment_level"));
				c.setCommentDate(rs.getDate("comment_date"));
				c.setCommentNoRef(rs.getString("comment_no_ref"));
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

	public int deleteComment(Connection conn, String commentNo) {
		int result =0;
		String sql = prop.getProperty("deleteComment");
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, commentNo);
			
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

	public int increaseReadCount(Connection conn, String boardNo) {
		int result = 0;
		String sql = prop.getProperty("increaseReadCount");
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, boardNo);
			result = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}

	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	//카테고리검색
	
	public List<Sell> selectsearchList(Connection conn, int cPage, int numPerPage, String search_category,
			String search_key) {
		
		
		List<Sell> sell = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		System.out.println("다오 들옴0"+search_category);
		System.out.println("다오 들옴0"+'%'+search_key+'%');
		
		String sql = prop.getProperty("selectAllSellList");
		sql+=("and("+search_category+" like '%"+search_key+"%')");
		
		System.out.println("쿼리다"+sql);
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (cPage-1)*numPerPage +1);
			ps.setInt(2, cPage*numPerPage);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Sell s = new Sell();
				s.setBoardNo(rs.getString("board_no"));
				s.setBoardTitle(rs.getString("board_title"));
				s.setBoardContent(rs.getString("board_content"));
				s.setBoardCodeNo(rs.getString("board_code_no"));
				s.setBoardDate(rs.getDate("board_date"));
				s.setBoardDeal(rs.getString("board_deal"));
				s.setBoardReadCounter(rs.getInt("board_read_count"));
				s.setBoardWriter(rs.getString("board_writer"));
				
				///////////////////////////////////////////////////////////////////////////
				
				String ca = new BoardService().selectcategoryname(s.getBoardCodeNo());
				s.setBoardCodeNo(ca);
				
				////////////////////////////////////////////////////////////////////////////
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

	public int selectSellCount_search(Connection conn, String search_category, String search_key) {
		int count = 0;
	    String sql = prop.getProperty("selectSellCount_search");
	    PreparedStatement ps = null;
	    ResultSet rs  = null;
	    sql+=(" "+search_category+" like '%"+search_key+"%'");
	    
	    System.out.println("숫자쿼리"+sql);
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

	public Sell selectOneSellprev(Connection conn, String boardNo) {
		String sql = prop.getProperty("selectOneSellprev");
		System.out.println("셀 다오 : "+boardNo.substring(2));
		Sell b = new Sell();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, boardNo.substring(2));
			
			rs= ps.executeQuery();
			if(rs.next()) {
				
				b.setBoardNo(rs.getString("board_no"));
				b.setBoardTitle(rs.getString("board_title"));
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return b;
	}

	public Sell selectOneSellnext(Connection conn, String boardNo) {
		String sql = prop.getProperty("selectOneSellnext");
		Sell b = new Sell();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, boardNo.substring(2));
			
			rs= ps.executeQuery();
			if(rs.next()) {
				
				b.setBoardNo(rs.getString("board_no"));
				b.setBoardTitle(rs.getString("board_title"));
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return b;
	}

	public String selectSubjectCode(Connection conn, String string) {
		String str="";
		PreparedStatement pstmt=null;
		ResultSet rset= null;
		String sql=prop.getProperty("selectSubjectCode");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, string);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				str=rset.getString("subject_no");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	public int selectBoardNo(Connection conn) {
		System.out.println("보드넘버 가져오기");
		int result=0;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("selectBoardNo");
		System.out.println(sql);
		try {
			pstmt=conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				result=rset.getInt("board_no");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("다오 : 보드넘버가져오기"+result);
		return result;
	}

	public String selectWarningReason(Connection conn, String boardWriter) {
		String result="";
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("selectWarningReason");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, boardWriter);
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				result+=rset.getString("reason")+"/ ";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}
	
	

}