package message.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static common.JDBCTemplate.*;

import message.model.vo.Message;

public class MessageDAO {
	Properties prop=new Properties();
	
	public MessageDAO() {
		String filePath = getClass().getResource("/sql/message/message.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public List<Message> selectMessageList(Connection conn, String userId, int cPage, int numPerPage) {
		List<Message>list=new ArrayList<>();
		ResultSet rset=null;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("selectMessageList");
		System.out.println("messageDAO : "+sql);
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, cPage);
			pstmt.setInt(3, numPerPage);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				Message m =new Message();
				m.setMessageNo(rset.getInt("msg_no"));
				m.setSender(rset.getString("sender"));
				m.setRecipient(rset.getString("reci1pient"));
				m.setContent(rset.getString("content"));
				m.setNoteDate(rset.getDate("note_date"));
				m.setNoteDel(rset.getString("note_del"));
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int deleteMsg(Connection conn, int msgNo) {
		int result=0;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("deleteMsg");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, msgNo);
			result=pstmt.executeUpdate();
			
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int writeMessage(Connection conn, String sender, String receiver, String content) {
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("writeMessage");
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, sender);
			pstmt.setString(2, receiver);
			pstmt.setString(3, content);
			
			result=pstmt.executeUpdate();
			if(result>0) {
				commit(conn);
			}else rollback(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println("MessageWriteDAO@result = "+result);
		return result;
	}

	public List<Message> selectMessageList2(Connection conn, String userId, int cPage, int numPerPage) {
		List<Message>list=new ArrayList<>();
		ResultSet rset=null;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("selectMessageList2");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, cPage);
			pstmt.setInt(3, numPerPage);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				Message m =new Message();
				m.setMessageNo(rset.getInt("msg_no"));
				m.setSender(rset.getString("sender"));
				m.setRecipient(rset.getString("reci1pient"));
				m.setContent(rset.getString("content"));
				m.setNoteDate(rset.getDate("note_date"));
				m.setNoteDel(rset.getString("note_del"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public List<Message> selectMsgByIdForSend(Connection conn, String userId, String searchKeyword) {
		List<Message>list=new ArrayList<>();
		ResultSet rset=null;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("selectMsgByIdForSend");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, searchKeyword);
			pstmt.setInt(3, cPage);
			pstmt.setInt(4, numPerPage);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				Message m =new Message();
				m.setMessageNo(rset.getInt("msg_no"));
				m.setSender(rset.getString("sender"));
				m.setRecipient(rset.getString("reci1pient"));
				m.setContent(rset.getString("content"));
				m.setNoteDate(rset.getDate("note_date"));
				m.setNoteDel(rset.getString("note_del"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public List<Message> selectMsgByContentForSend(Connection conn, String userId, String searchKeyword) {
		List<Message>list=new ArrayList<>();
		ResultSet rset=null;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("selectMsgByContentForSend");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, "%"+searchKeyword+"%");
			pstmt.setInt(3, cPage);
			pstmt.setInt(4, numPerPage);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				Message m =new Message();
				m.setMessageNo(rset.getInt("msg_no"));
				m.setSender(rset.getString("sender"));
				m.setRecipient(rset.getString("reci1pient"));
				m.setContent(rset.getString("content"));
				m.setNoteDate(rset.getDate("note_date"));
				m.setNoteDel(rset.getString("note_del"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public List<Message> selectMsgByIdForReceive(Connection conn, String userId, String searchKeyword) {
		List<Message>list=new ArrayList<>();
		ResultSet rset=null;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("selectMsgByIdForReceive");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, searchKeyword);
			pstmt.setInt(3, cPage);
			pstmt.setInt(4, numPerPage);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				Message m =new Message();
				m.setMessageNo(rset.getInt("msg_no"));
				m.setSender(rset.getString("sender"));
				m.setRecipient(rset.getString("reci1pient"));
				m.setContent(rset.getString("content"));
				m.setNoteDate(rset.getDate("note_date"));
				m.setNoteDel(rset.getString("note_del"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public List<Message> selectMsgByContentForReceive(Connection conn, String userId, String searchKeyword) {
		List<Message>list=new ArrayList<>();
		ResultSet rset=null;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("selectMsgByContentForReceive");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, "%"+searchKeyword+"%");
			pstmt.setInt(3, cPage);
			pstmt.setInt(4, numPerPage);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				Message m =new Message();
				m.setMessageNo(rset.getInt("msg_no"));
				m.setSender(rset.getString("sender"));
				m.setRecipient(rset.getString("reci1pient"));
				m.setContent(rset.getString("content"));
				m.setNoteDate(rset.getDate("note_date"));
				m.setNoteDel(rset.getString("note_del"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public Message selectMessage(Connection conn, int msgNo) {
		Message m=new Message();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("selectMessage");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, msgNo);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				m.setMessageNo(rset.getInt("msg_no"));
				m.setSender(rset.getString("sender"));
				m.setRecipient(rset.getString("reci1pient"));
				m.setContent(rset.getString("content"));
				m.setNoteDate(rset.getDate("note_date"));
				m.setNoteDel(rset.getString("note_del"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return m;
	}

	public int selectTotalMessageReceiver(String userId, Connection conn) {
		int result=0;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("selectTotalMessageReceiver");
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
		return result;
	}

	public int selectTotalMessagSender(String userId, Connection conn) {
		int result=0;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("selectTotalMessagSender");
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
		return result;
	}

}
