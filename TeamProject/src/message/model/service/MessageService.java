package message.model.service;

import java.sql.Connection;
import java.util.List;

import message.model.dao.MessageDAO;
import message.model.vo.Message;
import static common.JDBCTemplate.*;

public class MessageService {
	
	public MessageService() {}

	public List<Message> selectMessageList(String userId) {
		Connection conn=getConnection();
		List<Message> list=new MessageDAO().selectMessageList(conn,userId);
		close(conn);
		return list;
	}

	public int deleteMsg(int msgNo) {
		Connection conn=getConnection();
		int result=new MessageDAO().deleteMsg(conn,msgNo);
		close(conn);
		return result;
	}

}
