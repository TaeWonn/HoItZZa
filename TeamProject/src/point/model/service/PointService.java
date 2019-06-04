package point.model.service;

import static common.JDBCTemplate.*;

import java.util.List;

import java.sql.Connection;

import point.model.dao.PointDAO;
import point.model.vo.Point;

public class PointService {

	public List<Point> selectChargeListById(String userId) {
		Connection conn = getConnection();
		List<Point> list = new PointDAO().selectChargeListById(conn, userId);
		close(conn);
		return list;
	}

	public int chargePoint(Point p) {
		Connection conn = getConnection();
		int result = new PointDAO().chargePoint(conn, p);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

}
