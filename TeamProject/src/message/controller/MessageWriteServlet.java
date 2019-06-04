package message.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import message.model.service.MessageService;

/**
 * Servlet implementation class MessageWriteServlet
 */
@WebServlet("/views/message/messageWrite")
public class MessageWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 핸들링
		String sender=request.getParameter("sender");
		String receiver=request.getParameter("recipient");
		String content=request.getParameter("content");
		
		//쪽지 보내기(테이블에 insert)
		int result=new MessageService().writeMessage(sender,receiver,content);
		
		String msg="";
		String loc="/views/message/myMessage?userId="+sender;
		String view="/WEB-INF/views/common/msg.jsp";
		if(result>0) {
			msg="메시지가 전송되었습니다.";
			
		}else {
			msg="메세지 전송에 실패하였습니다.다시 시도해 주세요";
		}
		request.setAttribute("loc", loc);
		request.setAttribute("msg", msg);
		request.getRequestDispatcher(view).forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
