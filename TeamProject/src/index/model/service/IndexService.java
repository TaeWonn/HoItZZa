package index.model.service;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import buy.model.vo.Buy;
import free.model.vo.Free;
import index.model.dao.IndexDAO;
import sell.model.vo.Sell;
import user.model.vo.User;
public class IndexService {
	
	public IndexService() {}

	public List<Sell> selectSellBoardList() {
		Connection conn=getConnection();
		List<Sell>list=new IndexDAO().selectSellBoardList(conn);
		close(conn);
		return list;
	}

	public List<Buy> selectBuyBoardList() {
		Connection conn=getConnection();
		List<Buy>list=new IndexDAO().selectBuyBoardList(conn);
		close(conn);
		return list;
	}

	public List<Free> selectSudaBoardList() {
		Connection conn=getConnection();
		List<Free>fList1=new IndexDAO().selectSudaBoardList(conn);
		close(conn);
		return fList1;
	}

	public List<Free> selectMediaBoardList() {
		Connection conn=getConnection();
		List<Free>fList2=new IndexDAO().selectMediaBoardList(conn);
		close(conn);
		return fList2;
	}

	public List<Free> selectSenseBoardList() {
		Connection conn=getConnection();
		List<Free>fList=new IndexDAO().selectSenseBoardList(conn);
		close(conn);
		return fList;
	}

	public List<Free> selectNanumBoardList() {
		Connection conn=getConnection();
		List<Free>fList=new IndexDAO().selectNanumBoardList(conn);
		close(conn);
		return fList;
	}

	public User selectUser(String userId) {
		Connection conn=getConnection();
		User user=new IndexDAO().selectUser(conn,userId);
		close(conn);
		return user;
	}
	
	

}
