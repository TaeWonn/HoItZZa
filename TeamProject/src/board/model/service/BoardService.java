package board.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import board.model.dao.BoardDAO;
import board.model.vo.Board;
import board.model.vo.BoardComment;

public class BoardService {

	public int selectBoardCount() {
		Connection conn = getConnection();
		int totalBoardCount = new BoardDAO().selectBoardCount(conn);
		close(conn);
		return totalBoardCount;
	}

	public List<Board> selectBoardList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Board> list= new BoardDAO().selectBoardList(conn, cPage, numPerPage);
		close(conn);
		return list;
	}
	
	public int insertBoard(Board b) {
		Connection conn = getConnection();
		int result = new BoardDAO().insertBoard(conn, b);
		if(result>0) {
			commit(conn);
			result = new BoardDAO().selectLastSeq(conn);
		}	
		else 
			rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	public Board selectOne(int board_no) {
		Connection conn = getConnection();
		Board board = new BoardDAO().selectOne(conn, board_no);
		close(conn);
		return board;
	}

	public int increaseReadCount(int boardNo) {
		Connection conn = getConnection();
		int result = new BoardDAO().increaseReadCount(conn, boardNo);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
		return result;
	}

	public int deleteBoard(int boardNo) {
		Connection conn = getConnection();
		int result = new BoardDAO().deleteBoard(conn, boardNo);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
		return result;
	}
	
	public int updateBoard(Board b) {
		Connection conn = getConnection();
		int result = new BoardDAO().updateBoard(conn, b);
		if(result>0){
			commit(conn);
		}
		else 
			rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int insertBoardComment(BoardComment bc) {
		Connection conn = getConnection();
		int result = new BoardDAO().insertBoardComment(conn, bc);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		close(conn);
		return result;
	}

	public List<BoardComment> selectBoardComment(int boardNo) {
		Connection conn = getConnection();
		List<BoardComment> commentList 
			= new BoardDAO().selectBoardComment(conn, boardNo);
		close(conn);
		return commentList;
	}

	public int deleteBoardComment(int boardCommentNo) {
		Connection conn = getConnection();
		int result = new BoardDAO().deleteBoardComment(conn, boardCommentNo);
		if(result>0) 
			commit(conn);
		else 
			rollback(conn);
		return result;
	}
}
