package opinion.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import opinion.model.dao.OpinionDAO;
import opinion.model.vo.Opinion;

public class OpinionService {
	public List<Opinion> selectAllOpinionList() {
		Connection conn = getConnection();
		List<Opinion> opinion = new OpinionDAO().selectAllOpinionList(conn);
		close(conn);
		return opinion;
	}

	public int selectBuyCount() {
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
}
