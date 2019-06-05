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
				List<Message> messageList=new ArrayList<>();
				int numPerPage = 11;
				int cPage = 1;
				
				try {
					cPage = Integer.parseInt(request.getParameter("cPage"));
				} catch (NumberFormatException e) {}
				
				try {
					numPerPage=Integer.parseInt(request.getParameter("numPerPage"));
				}catch(NumberFormatException e) {}
				
				int totalContents=0;
				// 2. 업무 로직
				if(senRec.equals("receive")||senRec==null) {
					messageList=new MessageService().selectMessageList(userId,cPage,numPerPage);
					totalContents=new MessageService().selectTotalMessageReceiver(userId);
				}else {
					 messageList=new MessageService().selectMessageList2(userId,cPage,numPerPage);
					 totalContents=new MessageService().selectTotalMessagSender(userId);
				}
				
				System.out.println("토탈 컨텐츠 수"+totalContents);
				int totalPage = (int)Math.ceil((double)totalContents/numPerPage);
				
				// 페이지바 구성
				String pageBar = "";
				int pageBarSize = 5;
				// 시작페이지 번호 세팅
				int pageStart = ((cPage-1)/pageBarSize)*pageBarSize+1;
				// 종료페이지 번호 세팅
				int pageEnd = pageStart + pageBarSize-1;
				int pageNo = pageStart;
				
				System.out.println("pageStart["+pageNo+"] ~ pageEnd["+pageEnd+"]");
				
				// section [prev]
				if(pageNo == 1) {}
				else {
					pageBar += "<a href='"+request.getContextPath()+"/views/point/pointCharge?userId="+userId
							+ "&cPage=" + (pageNo-1) + "'>[이전]</a>";
				}
				// pageNo section
				// pageNo<=pageEnd && pageNo<=totalPage
				while(/*!(pageNo>pageEnd || pageNo > totalPage)*/pageNo<=pageEnd && pageNo<=totalPage) {
					if(cPage == pageNo) {
						pageBar += "<span class='cPage'>" + pageNo + "</span>";
					}
					else {
						pageBar += "<a href='"+request.getContextPath()+"/views/point/pointCharge?userId="+userId
								+ "&cPage=" + pageNo + "'>"+pageNo+"</a>";
					}
					
					pageNo++;
				}
				
				// section [next]
				if(pageNo>totalPage) {}
				else {
					pageBar += "<a href='"+request.getContextPath()+"/views/point/pointCharge?userId="+userId
							+ "&cPage="+pageNo+ "'>[다음]</a>";
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
