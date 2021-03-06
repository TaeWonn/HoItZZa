package free.model.service;

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
import free.model.dao.FreeDAO;
import free.model.vo.Free;
import sell.model.dao.SellDAO;
import sell.model.vo.Sell;

public class FreeService {
	public List<Free> selectAllFreeList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Free> free = new FreeDAO().selectAllFreeList(conn, cPage, numPerPage);
		close(conn);
		return free;
	}

	public int selectBuyCount() {
		Connection conn  = getConnection();
		int count = new FreeDAO().selectFreeCount(conn);
		close(conn);
		return count;
	}

	public String insertBoard(Free f) {
		Connection conn = getConnection();
		int result=0;
		int boardNo=0;
		
		if(f.getBoardCodeNo().equals("FC_")) {
			result=new FreeDAO().insertFreeBoardFC(conn,f);
			boardNo=new FreeDAO().selectBoardNoFC(conn);
		}else if(f.getBoardCodeNo().equals("FU_")) {
			result=new FreeDAO().insertFreeBoardFU(conn,f);
			boardNo=new FreeDAO().selectBoardNoFU(conn);
			
		}else if(f.getBoardCodeNo().equals("FE_")) {
			result=new FreeDAO().insertFreeBoardFE(conn,f);
			boardNo=new FreeDAO().selectBoardNoFE(conn);
		}
		else if(f.getBoardCodeNo().equals("FS_")) {
			result=new FreeDAO().insertFreeBoardFS(conn,f);
			boardNo=new FreeDAO().selectBoardNoFS(conn);
		}
		if(result>0) {
			commit(conn);
		}else
			rollback(conn);
		
		String boardNoresult=f.getBoardCodeNo()+boardNo;
		
		close(conn);
		return boardNoresult;
	}

	public int selectFreeCount() {
		Connection conn = getConnection();
		int count = new FreeDAO().selectFreeCount(conn);
		close(conn);
		return count;
	}

	public int insertFileTable(FileTable t) {
		Connection conn = getConnection();
		int result = new FreeDAO().insertFileTable(conn, t);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int freeDelete(String boardNo) {
		Connection conn = getConnection();
		int result = new FreeDAO().freeDelete(conn, boardNo);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public Free selectOneFree(String boardNo) {
		Connection conn = getConnection();
		Free f = new FreeDAO().selectOneFree(conn, boardNo);
		close(conn);
		return f;
	}
 
	public List<FileTable> selectFiles(String boardNo) {
		Connection conn = getConnection();
		List<FileTable> ft = new FreeDAO().selectFiles(conn, boardNo);
		close(conn);
		return ft;
	}

	public int warningCnt(String boardWriter) {
		Connection conn = getConnection();
		int warningCnt = new FreeDAO().warningCnt(conn, boardWriter);
		close(conn);
		return warningCnt;
	}

	public List<Comment> commentList(String boardNo) {
		Connection conn = getConnection();
		List<Comment> clist = new FreeDAO().commentList(conn, boardNo);
		close(conn);
		return clist;
	}

	public void increaseReadCount(String boardNo) {
		Connection conn = getConnection();
		int result = new FreeDAO().increaseReadCount(conn, boardNo);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
	}

	public List<Free> selectAllSenseList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Free> sense = new FreeDAO().selectAllSenseList(conn, cPage, numPerPage);
		close(conn);
		return sense;
	}

	public int selectSenseCount() {
		Connection conn=getConnection();
		int count=new FreeDAO().selectSenseCount(conn);
		return count;
	}

	public List<Free> selectAllEnterList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Free> free = new FreeDAO().selectAllEnterList(conn, cPage, numPerPage);
		close(conn);
		return free;
	}

	public int selectEnterCount() {
		Connection conn=getConnection();
		int count=new FreeDAO().selectEnterCount(conn);
		return count;
	}

	public List<Free> selectAllDevideList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Free> free = new FreeDAO().selectAllDevideList(conn, cPage, numPerPage);
		close(conn);
		return free;
	}

	public int selectDevideCount() {
		Connection conn=getConnection();
		int count=new FreeDAO().selectDevideCount(conn);
		return count;
	}

	public int selectSeq() {
		Connection conn = getConnection();
		int seq = new FreeDAO().selectSeq(conn);
		close(conn);
		return seq;
	}

	public int insertJabdamCommnet(Comment c) {
		Connection conn = getConnection();
		int result = new FreeDAO().insertJabdamCommnet(conn, c);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int insertSenseComment(Comment c) {
		Connection conn = getConnection();
		int result = new FreeDAO().insertSenseComment(conn, c);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int insertMediaComment(Comment c) {
		Connection conn = getConnection();
		int result = new FreeDAO().insertMediaComment(conn, c);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int insertNanumComment(Comment c) {
		Connection conn = getConnection();
		int result = new FreeDAO().insertNanumComment(conn, c);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int deleteComment(String commentNo) {
		Connection conn = getConnection();
		int result = new FreeDAO().deleteComment(conn, commentNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public Free selectOnePrev(String string) {
		Connection conn = getConnection();
		Free b = new FreeDAO().selectOnePrev(conn, string);
		close(conn);
		return b;
	}

	public Free selectOneNext(String string) {
		Connection conn = getConnection();
		Free b = new FreeDAO().selectOneNext(conn, string);
		close(conn);
		return b;
	}

	public List<Free> selectSearch(String searchType, String keyword, String code) {
		Connection conn=getConnection();
		List<Free> list=new FreeDAO().selectSearch(searchType,keyword,conn,code);
		close(conn);
		return list;
	}



}
