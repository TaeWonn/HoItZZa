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

	public List<Message> selectMessageList(Connection conn, String userId) {
		List<Message>list=new ArrayList<>();
		ResultSet rset=null;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("selectMessageList");
		System.out.println("messageDAO : "+sql);
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
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
		System.out.println(list);
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

}