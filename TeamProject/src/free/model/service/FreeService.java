package free.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import buy.model.vo.Buy;
import file.model.vo.FileTable;
import free.model.dao.FreeDAO;
import free.model.vo.Free;

public class FreeService {
	public List<Free> selectAllFreeList() {
		Connection conn = getConnection();
		List<Free> free = new FreeDAO().selectAllFreeList(conn);
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
}
