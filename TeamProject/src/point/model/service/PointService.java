package point.model.service;

import static common.JDBCTemplate.*;

import java.util.List;

import java.sql.Connection;

import point.model.dao.PointDAO;
import point.model.vo.Point;

public class PointService {

	public List<Point> selectChargeListById(String userId, int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Point> list = new PointDAO().selectChargeListById(conn, userId, cPage, numPerPage);
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

	public int selectTotalContent(String userId) {
		Connection conn=getConnection();
		int result=new PointDAO().selectTotalContent(conn,userId);
		close(conn);
		return result;
	}

}
