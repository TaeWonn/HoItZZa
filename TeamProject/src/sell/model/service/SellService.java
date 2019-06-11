package sell.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import buy.model.dao.BuyDAO;
import buy.model.vo.Buy;
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

	public List<Sell> selectAllSellList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Sell> sell = new SellDAO().selectAllSellList(conn, cPage, numPerPage);
		close(conn);
		return sell;
	}

	public String insertSell(Sell s) {
		Connection conn = getConnection();

		
		int result = new SellDAO().insertSell(conn, s);
		int boardNo=new SellDAO().selectBoardNo(conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		System.out.println("서비스단2 : "+boardNo);
		String boardNoresult="S_"+boardNo;
		close(conn);
		return boardNoresult;
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
	
	public List<String> interestSellBoardNoByUser(String userId) {
		Connection conn = getConnection();
		List<String> list = new SellDAO().interestSellBoardNoByUser(conn, userId);
		close(conn);
		return list;
	}

	public List<Sell> selectInterestSellListByCategory(String interest) {
		Connection conn = getConnection();
		List<Sell> list = new SellDAO().selectInterestSellListByCategory(conn, interest);
		return list;
	}

	public List<Comment> commentList(String boardNo) {
		Connection conn = getConnection();
		List<Comment> clist = new SellDAO().commentList(conn, boardNo);
		close(conn);
		return clist;
	}

	public int deleteComment(String commentNo) {
		Connection conn = getConnection();
		int result = new SellDAO().deleteComment(conn, commentNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public List<Integer> warningListCnt(List<Sell> sell) {
		Connection conn = getConnection();
		List<Integer> listCnt = new SellDAO().warningListCnt(conn, sell); 
		close(conn);
		return listCnt;
	}

	public List<Sell> sellFind(String searchType, String searchKeyword, int cPage, int numPerPage) {
		Connection conn =getConnection();
		List<Sell> sList = new SellDAO().sellFind(conn, searchType, searchKeyword, cPage, numPerPage);
		close(conn);
		return sList;
	}

	public int sellFindContents(String searchType, String searchKeyword) {
		Connection conn = getConnection();
		int count = new SellDAO().findContents(conn, searchType, searchKeyword);
		close(conn);
		return count;
	}

	public void increaseReadCount(String boardNo) {
		Connection conn = getConnection();
		int result = new SellDAO().increaseReadCount(conn, boardNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
	}

	public List<Sell> selectsearchList(int cPage, int numPerPage, String search_category, String search_key) {
		Connection conn = getConnection();
		List<Sell> sell = new SellDAO().selectsearchList(conn, cPage, numPerPage,search_category,search_key);
		close(conn);
		return sell;
	}

	public int selectSellCount_search(String search_category, String search_key) {
		Connection conn  = getConnection();
		int count = new SellDAO().selectSellCount_search(conn,search_category,search_key);
		close(conn);
		return count;
	}

	public Sell selectOneSellprev(String boardNo) {
		Connection conn = getConnection();
		Sell b = new SellDAO().selectOneSellprev(conn, boardNo);
		close(conn);
		return b;
	}

	public Sell selectOneSellnext(String boardNo) {
		Connection conn = getConnection();
		Sell b = new SellDAO().selectOneSellnext(conn, boardNo);
		close(conn);
		return b;
	}

	public String selectSubjectCode(String string) {
		Connection conn = getConnection();
		String str = new SellDAO().selectSubjectCode(conn, string);
		close(conn);
		return str;
	}

}
