package opinion.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import comment.model.vo.Comment;
import opinion.model.dao.OpinionDAO;
import opinion.model.vo.Opinion;

public class OpinionService {
	public List<Opinion> selectAllOpinionList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Opinion> opinion = new OpinionDAO().selectAllOpinionList(conn, cPage, numPerPage); 
		close(conn);
		return opinion;
	}

	public int selectOpinionCount() {
		Connection conn  = getConnection();
		int count = new OpinionDAO().selectOpinionCount(conn);
		close(conn);
		return count;
	}

	public int insertBoard(Opinion o) {
		Connection conn = getConnection();
		int result = new OpinionDAO().insertBoard(conn, o);
		if(result>0) 
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int selectSeqOT() {
		Connection conn = getConnection();
		int seq = new OpinionDAO().selectSeqOT(conn);
		close(conn);
		return seq;
	}
	public int selectSeqOD() {
		Connection conn = getConnection();
		int seq = new OpinionDAO().selectSeqOD(conn);
		close(conn);
		return seq;
	}

	public Opinion selectOneBoard(String boardNo) {
		Connection conn = getConnection();
		Opinion o = new OpinionDAO().selectOneBoard(conn, boardNo);
		close(conn);
		return o;
	}

	public int selectWarningCnt(String boardWriter) {
		Connection conn = getConnection();
		int wCnt = new OpinionDAO().selectWarningCnt(conn, boardWriter);
		close(conn);
		return wCnt;
	}

	public List<Opinion> selectDeclarationList(int cPage, int numPerPage) {
		Connection conn = getConnection() ;
		List<Opinion> olist = new OpinionDAO().selectDeclarationList(conn,cPage,numPerPage);
		close(conn);
		return olist;
	}

	public List<Integer> OpinionWarningCnt(List<Opinion> oList) {
		Connection conn = getConnection();
		List<Integer> wCnt = new OpinionDAO().opinionWarningCnt(conn,oList);
		close(conn);
		return wCnt;
	}

	public int selectDeclarationCount() {
		Connection conn = getConnection();
		int cnt = new OpinionDAO().selectDeclarationCount(conn);
		close(conn);
		return cnt;
	}

	public int insertDeclaration(Opinion o) {
		Connection conn = getConnection();
		int result = new OpinionDAO().insertDeclaration(conn, o);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public void increaseReadCount(String boardNo) {
		Connection conn = getConnection();
		int result = new OpinionDAO().increaseReadCount(conn, boardNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
	}

	public List<Comment> commentList(String boardNo) {
		Connection conn = getConnection();
		List<Comment> list = new OpinionDAO().commentList(conn,boardNo);
		close(conn);
		return list;
	}
}
