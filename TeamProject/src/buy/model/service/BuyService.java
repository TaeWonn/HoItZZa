package buy.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

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

	public int buying(int price, int point, String userId) {
		Connection conn = getConnection();
		int result = new BuyDAO().buying(conn, price, point, userId);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public List<Integer> warningCntList(List<Buy> buy) {
		Connection conn = getConnection();
		List<Integer> wList = new BuyDAO().warningCntList(conn, buy);
		close(conn);
		return wList;
	}

	public List<Buy> titleFind(String searchKeyword,int cPage,int numPerPage) {
		Connection conn = getConnection();
		List<Buy> bList = new BuyDAO().titleFind(conn,searchKeyword,cPage, numPerPage);
		close(conn);
		return bList;
	}

	public List<Buy> contentFind(String searchKeyword,int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Buy> bList = new BuyDAO().contentFind(conn, searchKeyword,cPage, numPerPage);
		close(conn);
		return bList;
	}

	public List<Buy> writerFind(String searchKeyword,int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Buy> bList = new BuyDAO().writerFind(conn, searchKeyword,cPage, numPerPage);
		close(conn);
		return bList;
	}

	public int titleCotents(String searchKeyword) {
		Connection conn = getConnection();
		int cnt = new BuyDAO().titleCotents(conn, searchKeyword);
		close(conn);
		return cnt;
	}

	public int contentCotents(String searchKeyword) {
		Connection conn = getConnection();
		int cnt = new BuyDAO().contentCotents(conn, searchKeyword);
		close(conn);
		return cnt;
	}

	public int writerCotents(String searchKeyword) {
		Connection conn = getConnection();
		int cnt = new BuyDAO().writerCotents(conn, searchKeyword);
		close(conn);
		return cnt;
	}

	///////////////////////////////////////////////////////////////
	
	
	public List<String> selectCategory(String category1) {
		Connection conn = getConnection();
		List<String> list = new BuyDAO().selectCategory(conn, category1);
		close(conn);
		
		return list;
	}

	public List<String> selectCategoryNo(String category2) {
		Connection conn = getConnection();
		List<String> list = new BuyDAO().selectCategoryNo(conn, category2);
		close(conn);
		
		return list;
	}
	
	//////////////////////////////////////////////////////////
	
	public List<String> selectCategoryName(String category2) {
		Connection conn = getConnection();
		List<String> list = new BuyDAO().selectCategoryName(conn, category2);
		close(conn);
		
		return list;
	}

}
