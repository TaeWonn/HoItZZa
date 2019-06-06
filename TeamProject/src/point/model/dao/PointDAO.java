package point.model.dao;

import static common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import point.model.vo.Point;

public class PointDAO {
	
	private Properties prop = new Properties();
	
	public PointDAO() {
		String filePath = getClass().getResource("/sql/point/point-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Point> selectChargeListById(Connection conn, String userId, int cPage, int numPerPage) {
		List<Point> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectChargeListById");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, (cPage-1)*numPerPage+1);
			ps.setInt(3, cPage*numPerPage);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Point p = new Point();
				p.setChargeNo(rs.getInt("charge_no"));
				p.setChargeWriter(rs.getString("charge_writer"));
				p.setChargeMoney(rs.getInt("charge_money"));
				p.setChargeDate(rs.getDate("charge_date"));
				
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return list;
	}

	public int chargePoint(Connection conn, Point p) {
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("chargePoint");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, p.getChargeWriter());
			ps.setInt(2, p.getChargeMoney());
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}

	public int selectTotalContent(Connection conn, String userId) {
		int result=0;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("selectTotalContent");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rset=pstmt.executeQuery();
			if(rset.next()) {
				result=rset.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("totalContent@DAO ="+result);
		return result;
	}
}
