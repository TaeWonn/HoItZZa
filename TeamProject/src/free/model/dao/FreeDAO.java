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

import comment.model.vo.Comment;
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
		System.out.println(free);
		return free;
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

	public Free selectOneFree(Connection conn, String boardNo) {
		Free f = new Free();
		String sql = prop.getProperty("selectOneFree");
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, boardNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				f.setBoardNo(rs.getString("board_no"));
				f.setBoardWriter(rs.getString("board_writer"));
				f.setBoardContent(rs.getString("board_content")); 
				f.setBoardTitle(rs.getString("board_title"));
				f.setBoardDate(rs.getDate("board_date"));
				f.setBoardReadCounter(rs.getInt("board_read_count"));
			}  
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		
		return f;
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
				f.setOriginalFileName(rs.getString("original_filename"));
				f.setRenamedFileName(rs.getString("renamed_filename"));
				ft.add(f);
			}
		} catch (SQLException e) {
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
			
			if(rs.next()) 
				warningCnt = rs.getInt("warningCnt");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return warningCnt;
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
				c.setCommentNo(rs.getString("comment_no"));
				c.setCommentContent(rs.getString("comment_content"));//컬럼명이 잘못되어 있어서 수정
				c.setCommnetWriter(rs.getString("comment_writer"));
				c.setCommentLevel(rs.getInt("comment_level"));
				c.setCommentDate(rs.getDate("comment_date"));
				c.setCommentNoRef(rs.getString("comment_no_ref"));
				c.setBoardNo(boardNo);
				clist.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		System.out.println(clist);
		return clist;
	}

	public int increaseReadCount(Connection conn, String boardNo) {
		int result = 0;
		String sql = prop.getProperty("increaseReadCount");
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
		System.out.println("조회수 증가여부 :"+result);
		return result;
	}

	public List<Free> selectAllSenseList(Connection conn, int cPage, int numPerPage) {
		List<Free> sense = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectAllSenceList");
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
				
				sense.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return sense;
	}

	public int selectSenseCount(Connection conn) {
		int count = 0;
	    String sql = prop.getProperty("selectSenseCount");
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

	public List<Free> selectAllEnterList(Connection conn, int cPage, int numPerPage) {
		List<Free> free = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectAllEnterList");
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
		return free;
	}

	public int selectEnterCount(Connection conn) {
		int count = 0;
	    String sql = prop.getProperty("selectEnterCount");
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

	public List<Free> selectAllDevideList(Connection conn, int cPage, int numPerPage) {
		List<Free> free = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectAllDevideList");
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
		return free;
	}

	public int selectDevideCount(Connection conn) {
		int count = 0;
	    String sql = prop.getProperty("selectDevideCount");
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

	public int selectSeq(Connection conn) {
		int seq = 0;
		String sql = prop.getProperty("selectSeq");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			if(rs.next())
				seq = rs.getInt("seq");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps); 
		}
		return seq;
	}

	public int insertJabdamCommnet(Connection conn, Comment c) {
		int result = 0;
		String sql = prop.getProperty("insertJabdamComment");
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
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
	public int insertSenseComment(Connection conn, Comment c) {
		int result = 0;
		String sql = prop.getProperty("insertSenseComment");
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
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
	public int insertMediaComment(Connection conn, Comment c) {
		int result = 0;
		String sql = prop.getProperty("insertMediaComment");
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
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
	public int insertNanumComment(Connection conn, Comment c) {
		int result = 0;
		String sql = prop.getProperty("insertNanumComment");
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
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

	public int insertFreeBoardFC(Connection conn, Free f) {
		int result=0;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("insertFreeBoardFC");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, f.getBoardCodeNo());
			pstmt.setString(2, f.getBoardTitle());
			pstmt.setString(3, f.getBoardContent());
			pstmt.setString(4, f.getBoardWriter());
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println(result+"다오 프리보드 인설트 확인");
		return result;
	}
  
	public int insertFreeBoardFU(Connection conn, Free f) {
			int result=0;
			PreparedStatement pstmt=null;
			String sql=prop.getProperty("insertFreeBoardFU");
			
			try {
				pstmt=conn.prepareStatement(sql);
				
				pstmt.setString(1, f.getBoardCodeNo());
				pstmt.setString(2, f.getBoardTitle());
				pstmt.setString(3, f.getBoardContent());
				pstmt.setString(4, f.getBoardWriter());
				result=pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
	}

	public int insertFreeBoardFE(Connection conn, Free f) {
		int result=0;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("insertFreeBoardFE");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, f.getBoardCodeNo());
			pstmt.setString(2, f.getBoardTitle());
			pstmt.setString(3, f.getBoardContent());
			pstmt.setString(4, f.getBoardWriter());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int insertFreeBoardFS(Connection conn, Free f) {
		int result=0;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("insertFreeBoardFS");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, f.getBoardCodeNo());
			pstmt.setString(2, f.getBoardTitle());
			pstmt.setString(3, f.getBoardContent());
			pstmt.setString(4, f.getBoardWriter());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int selectBoardNoFC(Connection conn) {
		int result=0;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("selectBoardNoFC");
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
		return result;
	}

	public int selectBoardNoFU(Connection conn) {
		int result=0;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("selectBoardNoFU");
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
		return result;
	}

	public int selectBoardNoFE(Connection conn) {
		int result=0;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("selectBoardNoFE");
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
		return result;
	}

	public int selectBoardNoFS(Connection conn) {
		int result=0;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("selectBoardNoFS");
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
		return result;
	}

	
}