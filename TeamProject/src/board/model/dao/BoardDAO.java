package board.model.dao;

import static common.JDBCTemplate.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import board.model.vo.Board;
import board.model.vo.BoardComment;

public class BoardDAO {
	private Properties prop = new Properties();
	
	public BoardDAO() {
		try {
			//클래스객체 위치찾기 : 절대경로를 반환한다. 
			// "/" : 루트디렉토리를 절대경로로 URL객체로 반환한다.
			// "./" : 현재디렉토리를 절대경로로 URL객체로 반환한다.
			// "./query.properties : 현재경로의 query.properties파일의 경로를 URL객체로 반환함.
			String fileName = BoardDAO.class.getResource("/sql/board/board-query.properties").getPath();
			prop.load(new FileReader(fileName));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public int selectBoardCount(Connection conn) {
		PreparedStatement pstmt = null;
		int totalMember = 0;
		ResultSet rset = null;
		String query = prop.getProperty("selectBoardCount");
		
		try{
			//미완성쿼리문을 가지고 객체생성. 
			pstmt = conn.prepareStatement(query);
			
			//쿼리문실행
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				totalMember = rset.getInt("cnt");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return totalMember;
	}

	public List<Board> selectBoardList(Connection conn, int cPage, int numPerPage) {
		List<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectBoardList");
		
		try{
			//미완성쿼리문을 가지고 객체생성. 
			pstmt = conn.prepareStatement(query);
			
			//시작 rownum과 마지막 rownum 구하는 공식
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			
			//쿼리문실행
			//완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				Board b = new Board();
				//컬럼명은 대소문자 구분이 없다.
				b.setBoardNo(rset.getString("board_no"));
				b.setBoardTitle(rset.getString("board_title"));
				b.setBoardContent(rset.getString("board_content"));
				b.setBoardDeal(rset.getString("board_deal"));
				b.setBoardWriter(rset.getString("board_writer"));
				b.setBoardCodeNo(rset.getString("board_cone_no"));
				b.setBoardReadCounter(rset.getInt("board_read_counter"));
				b.setBoardDate(rset.getDate("board_date"));
				
				list.add(b);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}
	
	public int insertBoard(Connection conn, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertBoard"); 
		
//		private String boardNo;
//		private String boardCodeNo;
//		private String boardCode;
//		private String boardTitle;
//		private String boardWriter;
//		private String boardContent;
//		private String boardDeal;
//		private int boardReadCounter;
//		private Date boardDate;
		
		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			// 받아오는 정보: 품목분류코드, 품목분류명, 글제목, 작성자, 글내용, 거래방식 
			// 품목을 분류명으로 받아오다보니 DB와 연결하여 품목코드를 설정하는 방법이 필요
			pstmt.setString(1, b.getBoardCodeNo());
			pstmt.setString(3, b.getBoardTitle());
			pstmt.setString(4, b.getBoardWriter());
			pstmt.setString(5, b.getBoardContent());
			pstmt.setString(6, b.getBoardDeal());

			// 여러개의 파일을 저장할 코드 작성하기
			// DB를 이용하여 파일에 게시판 번호와 함께 저장
			
			//쿼리문실행 : 완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			//DML은 executeUpdate()
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectLastSeq(Connection conn) {
		int boardNo = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectLastSeq");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				boardNo = rset.getInt("boardno");
			}
			
			System.out.println("boardNo@dao="+boardNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		
		
		return boardNo;
	}
	
	public Board selectOne(Connection conn, int board_no) {
		Board board = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectOne");
		try{
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성
			pstmt.setInt(1, board_no);
			//쿼리문실행
			//완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				board = new Board();
//				board.setBoardNo(rset.getInt("board_no"));
//				board.setBoardTitle(rset.getString("board_title"));
//				board.setBoardWriter(rset.getString("board_writer"));
//				board.setBoardContent(rset.getString("board_content"));
//				board.setBoardDate(rset.getDate("board_date"));
//				board.setOriginalFileName(rset.getString("board_original_filename"));
//				board.setRenamedFileName(rset.getString("board_renamed_filename"));
//				board.setReadCount(rset.getInt("board_readcount"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return board;
	}

	public int increaseReadCount(Connection conn, int boardNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseReadCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteBoard(Connection conn, int boardNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateBoard(Connection conn, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updateBoard"); 
		
		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성
//			pstmt.setString(1, b.getBoardTitle());
//			pstmt.setString(2, b.getBoardContent());
//			pstmt.setString(3, b.getOriginalFileName());
//			pstmt.setString(4, b.getRenamedFileName());
//			pstmt.setInt(5, b.getBoardNo());
			
			//쿼리문실행 : 완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			//DML은 executeUpdate()
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertBoardComment(Connection conn, BoardComment bc) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertBoardComment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			//미완성쿼리 완성
//			pstmt.setInt(1, bc.getBoardCommentLevel());
//			pstmt.setString(2, bc.getBoardCommentWriter());
//			pstmt.setString(3, bc.getBoardCommentContent());
//			pstmt.setInt(4, bc.getBoardRef());
			
			//db의 board_comment_ref는 number이고, 
			//db number타입은 null값을 허용한다.
			//현재 board_comment_ref는 board_comment_no를 참조하고 있음.
			//board_comment_no의 0값은 존재하지 않는다.
//			pstmt.setString(5, bc.getBoardCommentRef()==0?null:String.valueOf(bc.getBoardCommentRef()));
			
			//쿼리실행
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally  {
			close(pstmt);
		}
		return result;
	}

	public List<BoardComment> selectBoardComment(Connection conn, int boardNo) {
		List<BoardComment> commentList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCommentList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				BoardComment bc = new BoardComment();
//				bc.setBoardCommentNo(rset.getInt("board_comment_no"));
//				bc.setBoardCommentLevel(rset.getInt("board_comment_level"));
//				bc.setBoardCommentWriter(rset.getString("board_comment_writer"));
//				bc.setBoardCommentContent(rset.getString("board_comment_content"));
//				bc.setBoardRef(rset.getInt("board_ref"));
//				bc.setBoardCommentRef(rset.getInt("board_comment_ref"));
//				bc.setBoardCommentDate(rset.getDate("board_comment_date"));
				commentList.add(bc);
			}
			
//			System.out.println("commentList@dao="+commentList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return commentList;
	}

	public int deleteBoardComment(Connection conn, int boardCommentNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteBoardComment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardCommentNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	////////////////////////////////////////////////////////////////
	
	public String selectcategoryname(Connection conn, String boardCodeNo) {
		String categoryname = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectcategoryname");
		try{
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성
			pstmt.setString(1, boardCodeNo);
			//쿼리문실행
			//완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				categoryname = rset.getString("subject_name");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return categoryname;
	}
}
