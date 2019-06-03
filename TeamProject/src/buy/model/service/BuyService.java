package buy.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import buy.model.dao.BuyDAO;
import buy.model.vo.Buy;
import comment.model.vo.Comment;
import file.model.vo.FileTable;
import sell.model.dao.SellDAO;
import sell.model.service.SellService;
import sell.model.vo.Sell;

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

	public String selectOneBoardNo() {
		Connection conn = getConnection();
		String boardNo = new BuyDAO().selectOneBoardNo(conn);
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

	public List<Buy> selectInterestBuyListByUser(String userId) {
		Connection conn = getConnection();
		List<Buy> interestBuyList = new BuyDAO().selectInterestBuyListByUser(conn, userId);
		close(conn);
		return interestBuyList;
	}

	public List<FileTable> selectFileList(String boardNo) {
		Connection conn = getConnection();
		List<FileTable> flist = new BuyDAO().selectFileList(conn, boardNo);
		close(conn);
		return flist;
	}

	public int updateBuy(Buy b) {
		Connection conn = getConnection();
		int result = new BuyDAO().updateBuy(conn, b);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public List<Comment> commentList(String boardNo) {
		Connection conn = getConnection();
		List<Comment> clist = new BuyDAO().commentList(conn, boardNo);
		close(conn);
		return clist;
	}

	public int deleteComment(int commentNo) {
		Connection conn = getConnection();
		int result = new BuyDAO().deleteComment(conn, commentNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int selectUserPoint(String userId) {
		Connection conn = getConnection();
		int point = new BuyDAO().selectUserPoint(conn, userId);
		close(conn);
		return point;
	}

	public int buying(int price, int point) {
		Connection conn = getConnection();
		int result = new BuyDAO().buying(conn, price, point);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

}
