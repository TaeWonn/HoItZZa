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
		String filePath = getClass().getResource("/sql/opinion/opinion-query.properties").getPath();
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

	public List<Opinion> selectAllOpinionList(Connection conn, int cPage, int numPerPage) {
		List<Opinion> opinion = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectAllOpinionList");
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (cPage-1)*numPerPage+1);
			ps.setInt(2, cPage * numPerPage);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Opinion o = new Opinion();
				o.setBoardNo(rs.getString("board_no"));
				o.setBoardTitle(rs.getString("board_title"));
				o.setBoardContent(rs.getString("board_content"));
				o.setBoardDate(rs.getDate("board_date"));
				o.setBoardReadCount(rs.getInt("board_read_count"));
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
			ps.setString(2, o.getBoardContent());
			ps.setString(3, o.getBoardWriter());
			
			result =ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}

	public int selectSeqOT(Connection conn) {
		int seq = 0;
		String sql = prop.getProperty("selectSeqOT");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next())
				seq = rs.getInt("seq");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return seq;
	}
	public int selectSeqOD(Connection conn) {
		int seq = 0;
		String sql = prop.getProperty("selectSeqOD");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next())
				seq = rs.getInt("seq");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return seq;
	}
	public Opinion selectOneBoard(Connection conn, String boardNo) {
		Opinion o = null;
		String sql = prop.getProperty("selectOneBoard");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, boardNo);
			rs= ps.executeQuery();
			if(rs.next()) {
				o = new Opinion();
				o.setBoardNo(boardNo);
				o.setBoardTitle(rs.getString("board_title"));
				o.setBoardWriter(rs.getString("board_writer"));
				o.setBoardContent(rs.getString("board_content"));
				o.setBoardDate(rs.getDate("board_date"));
				o.setBoardReadCount(rs.getInt("board_read_count"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return o;
	}

	public int selectWarningCnt(Connection conn, String boardWriter) {
		int wCnt = 0;
		String sql = prop.getProperty("selectWarningCnt");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, boardWriter);
			
			rs= ps.executeQuery();
			if(rs.next())
				wCnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return wCnt;
	}

	public List<Opinion> selectDeclarationList(Connection conn, int cPage, int numPerPage) {
		List<Opinion> olist = new ArrayList<>();
		String sql = prop.getProperty("selectDeclarationList");
		PreparedStatement ps = null;
		ResultSet rs= null;
		try {
			ps= conn.prepareStatement(sql);
			ps.setInt(1, (cPage-1)*numPerPage +1);
			ps.setInt(2, cPage* numPerPage);
			
			rs =ps.executeQuery();
			while(rs.next()) {
				Opinion o =new Opinion();
				o.setBoardNo(rs.getString("board_no"));
				o.setBoardTitle(rs.getString("board_title"));
				o.setBoardWriter(rs.getString("board_writer"));
				o.setBoardContent(rs.getString("board_content"));
				o.setBoardDate(rs.getDate("board_date"));
				o.setBoardReadCount(rs.getInt("board_read_count"));
				
				olist.add(o);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return olist;
	}

	public List<Integer> opinionWarningCnt(Connection conn, List<Opinion> oList) {
		List<Integer> wCnt = new ArrayList<>();
		String sql = prop.getProperty("opinionWarningCnt");
		PreparedStatement ps = null;
		ResultSet rs= null;
		try {
			ps = conn.prepareStatement(sql);
			for(int i= 0 ;i<oList.size();i++) {
				ps.setString(1, oList.get(i).getBoardWriter());
				
				rs= ps.executeQuery();
				if(rs.next())
					wCnt.add(rs.getInt("cnt"));
			}
		} catch(Exception e) {
			e.printStackTrace();
 		} finally {
 			close(rs);
 			close(ps);
 		} 
		return wCnt;
	}

	public int selectDeclarationCount(Connection conn) {
		int cnt =0;
		String sql = prop.getProperty("selectDeclarationCount");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps =conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next())
				cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			 close(rs);
			 close(ps);
		}
		return cnt;
	}

	public int insertDeclaration(Connection conn, Opinion o) {
		int result = 0;
		String sql = prop.getProperty("insertDeclaration");
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, o.getBoardTitle());
			ps.setString(2, o.getBoardContent());
			ps.setString(3, o.getBoardWriter());
			
			result = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}

	public int increaseReadCount(Connection conn, String boardNo) {
		int result =0;
		String sql = prop.getProperty("increaseReadCount");
		PreparedStatement ps = null;
		try {
			ps =conn.prepareStatement(sql);
			
			ps.setString(1, boardNo);
			result =ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}
}
