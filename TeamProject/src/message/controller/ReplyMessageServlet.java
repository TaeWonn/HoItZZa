package message.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WriteMessage
 */
@WebServlet("/views/message/messageReply")
public class ReplyMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String senderId=request.getParameter("senderId");
		String receiver=request.getParameter("recipient");
		System.out.println("보내는 이 : "+senderId);
		System.out.println("받는 이 : "+receiver);
		
		//보내는이, 받는이만 적어서 작성화면으로 전송
		request.setAttribute("senderId", senderId);
		request.setAttribute("receiver", receiver);
		request.getRequestDispatcher("/WEB-INF/views/message/messageWrite.jsp").forward(request, response);
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
