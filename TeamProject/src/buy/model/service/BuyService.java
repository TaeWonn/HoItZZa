package buy.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import buy.model.dao.BuyDAO;
import buy.model.vo.Buy;
import comment.model.vo.Comment;
import file.model.vo.FileTable;

public class BuyService {

	public List<Buy> selectAllBuyList() {
		Connection conn = getConnection();
		List<Buy> buy = new BuyDAO().selectAllBuyList(conn);
		close(conn);
		return buy;
	}

	public int selectBuyCount() {
		Connection conn  = getConnection();
		int count = new BuyDAO().selectBuyCount(conn);
		close(conn);
		return count;
	}

	public int insertBoard(Buy b) {
		Connection conn = getConnection();
		int result = new BuyDAO().insertBoard(conn, b);
		close(conn);
		return result;
	}

	public Buy selectOneBuy(String boardNo) {
		Connection conn = getConnection();
		Buy b = new BuyDAO().selectOneBuy(conn, boardNo);
		close(conn);
		return b;
	}

	public String selectOneBoardNo(Buy b) {
		Connection conn = getConnection();
		String boardNo = new BuyDAO().selectOneBoardNo(conn, b);
		close(conn);
		return boardNo;
	}

	public int insertFileTable(FileTable t) {
		Connection conn = getConnection();
		int result = new BuyDAO().insertFileTable(conn ,t);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int warningCnt(String boardWriter) {
		Connection conn = getConnection();
		int warningCnt = new BuyDAO().warningCnt(conn, boardWriter);
		close(conn);
		return warningCnt;
	}

	public int buyDelete(String boardNo) {
		Connection conn = getConnection();
		int result = new BuyDAO().buyDelte(conn, boardNo);
		if( result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int insertComment(Comment c) {
		Connection conn = getConnection();
		int result = new BuyDAO().insertComment(conn, c);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

}
