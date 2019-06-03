package message.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import message.model.service.MessageService;

/**
 * Servlet implementation class MessageDelete
 */
@WebServlet("/views/message/messageDelete")
public class MessageDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 핸들링
		int msgNo=Integer.parseInt(request.getParameter("msgNo"));
		String userId=request.getParameter("userId");
		
		//업무로직
		//결과값 받아오기
		int result=new MessageService().deleteMsg(msgNo);
		
		
		
		String view="/WEB-INF/views/common/msg.jsp";
		String loc="/views/message/myMessage?userId="+userId;
		String msg="";
		if(result>0) {
			msg="삭제되었습니다.";
		}else {
			msg="삭제에 실패했습니다.";
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
