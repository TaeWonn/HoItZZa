package free.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import buy.model.vo.Buy;
import comment.model.vo.Comment;
import file.model.vo.FileTable;
import free.model.dao.FreeDAO;
import free.model.vo.Free;

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

	public int insertBoard(Free f) {
		Connection conn = getConnection();
		int result = new FreeDAO().insertBoard(conn, f);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
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
}
