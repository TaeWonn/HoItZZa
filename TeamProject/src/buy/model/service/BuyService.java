package buy.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import buy.model.dao.BuyDAO;
import buy.model.vo.Buy;

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

}
