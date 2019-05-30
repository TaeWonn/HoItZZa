package sell.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

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

	public List<Sell> selectInterestSellListByUser(String userId) {
		Connection conn = getConnection();
		List<Sell> interestSellList = new SellDAO().selectInterestSellListByUser(conn, userId);
		close(conn);
		return null;
	}

}
