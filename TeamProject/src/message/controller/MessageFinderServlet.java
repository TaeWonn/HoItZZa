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
 * Servlet implementation class MessageFinderServlet
 */
@WebServlet("/views/message/messageFinder")
public class MessageFinderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 핸들링
		String searchType=request.getParameter("searchType");
		String searchKeyword=request.getParameter("searchKeyword");
		String userId=request.getParameter("userId");
		String senRec=request.getParameter("senRec");
		List<Message> list=new ArrayList<>();
	
		
		//업무로직
		//보낸 메시지함에서 검색할때
		if(senRec.equals("send")) {
			//받는사람 아이디로 검색할 경우
			if(searchType.equals("userId")) {
				System.out.println("받는사람 아이디지");
				list=new MessageService().selectMsgByIdForSend(userId,searchKeyword);
			}else {
				//내용으로 검색한 경우
				System.out.println("받는사람 내용");
				list=new MessageService().selectMsgByContentForSend(userId,searchKeyword);
			}
		}else {
			//받은 메시지함에서 검색할때
			//보낸사람 아이디로 검색한 경우
			if(searchType.equals("userId")) {
				 list=new MessageService().selectMsgByIdForReceive(userId,searchKeyword);
				
			}else {
				//내용으로 검색한 경우
				list=new MessageService().selectMsgByContentForReceive(userId,searchKeyword);
			}
		}
		
		String view="/WEB-INF/views/common/msg.jsp";
		String msg=null;
		String loc="/views/message/myMessage?userId="+userId;

			
		
		
		if(list!=null) {
			view="/views/message/myMessage?userId="+userId;
			request.setAttribute("msgList", list);
			request.setAttribute("searchType", searchType);
			request.setAttribute("searchKeyword", searchKeyword);
			request.setAttribute("senRec", senRec);
		}else {
			msg="조회에 실패하였습니다. 관리자에게 문의주세요";
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
