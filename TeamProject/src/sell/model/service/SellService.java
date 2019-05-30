package sell.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import comment.model.vo.Comment;
import file.model.vo.FileTable;
import sell.model.dao.SellDAO;
import sell.model.vo.Sell;

public class SellService {

	public int selectSellCount() {
		Connection conn = getConnection();
		int count = new SellDAO().selectSellCount(conn);
		close(conn);
		return count;
	}

	public List<Sell> selectAllSellList() {
		Connection conn = getConnection();
		List<Sell> sell = new SellDAO().selectAllSellList(conn);
		close(conn);
		return sell;
	}

	public int insertSell(Sell s) {
		Connection conn = getConnection();
		int result = new SellDAO().insertSell(conn, s);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Sell selectOneSell(String boardNo) {
		Connection conn = getConnection();
		Sell s = new SellDAO().selectOneSell(conn, boardNo);
		close(conn);
		return s;
	}

	public String selectOneBoardNo() {
		Connection conn =getConnection();
		String boardNo = new SellDAO().selectOneBoardNo(conn);
		close(conn);
		return boardNo;
	}

	public int insertFileTable(FileTable t) {
		Connection conn = getConnection();
		int result = new SellDAO().insertFileTable(conn, t);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int updateSell(Sell s) {
		Connection conn = getConnection();
		int result = new SellDAO().updateSell(conn, s);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public List<FileTable> selectFiles(String boardNo) {
		Connection conn = getConnection();
		List<FileTable> ft = new SellDAO().selectFiles(conn, boardNo);
		close(conn);
		return ft;
	}

	public int warningCnt(String boardWriter) {
		Connection conn = getConnection();
		int warningCnt = new SellDAO().warningCnt(conn, boardWriter);
		close(conn);
		return warningCnt;
	}

	public int SellDelete(String boardNo) {
		Connection conn = getConnection();
		int result = new SellDAO().SellDelte(conn, boardNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int insertCommnet(Comment c) {
		Connection conn = getConnection();
		int result = new SellDAO().insertComment(conn, c);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

}
