package message.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import message.model.service.MessageService;
import message.model.vo.Message;

/**
 * Servlet implementation class UserViewMessageList2
 */
@WebServlet("/views/message/myMessage2")
public class UserViewMessageList2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 핸들링
				String userId=request.getParameter("userId");
				String senRec=request.getParameter("senRec");
				System.out.println("서블렛 : "+userId+"< "+senRec);
				List<Message> messageList=new ArrayList<>();
				if(senRec.equals("receive")||senRec==null) {
					messageList=new MessageService().selectMessageList(userId);	
				}else {
					 messageList=new MessageService().selectMessageList2(userId);
				}
				
				
				
				String msg="";
				String loc="";
				String view="";
				if(messageList!=null) {
					view="/WEB-INF/views/message/message.jsp";
					
				}else {
					msg="받으신 쪽지가 없습니다.";
					loc="/";
					view="/WEB-INF/views/common/msg.jsp";
				}
				if(messageList!=null) {
				request.setAttribute("msgList", messageList);
				request.setAttribute("senRec", senRec);
				}else {
					request.setAttribute("msg", msg);
					request.setAttribute("loc", loc);
				}
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
