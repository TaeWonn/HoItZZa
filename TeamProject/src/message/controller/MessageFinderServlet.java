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
		System.out.println("뭐 검색했냐"+senRec+"/"+searchType);
		List<Message> list=new ArrayList<>();
		int numPerPage = 11;
		int cPage = 1;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {}
		
		try {
			numPerPage=Integer.parseInt(request.getParameter("numPerPage"));
		}catch(NumberFormatException e) {}
		
		System.out.println("cPage & numPerPage = "+cPage+","+numPerPage);
		int totalContents=0;
		
		
		//업무로직
		//보낸 메시지함에서 검색할때
		if(senRec.equals("send")) {
			//받은사람 아이디로 검색할 경우
			if(searchType.equals("userId")) {
				list=new MessageService().selectMsgByIdForSend(userId,searchKeyword,cPage,numPerPage);
				totalContents=new MessageService().selectMsgByIdForSendTotal(userId,searchKeyword);
				
			}else {
				//내용으로 검색한 경우
				list=new MessageService().selectMsgByContentForSend(userId,searchKeyword,cPage,numPerPage);
				totalContents=new MessageService().selectMsgByContentForSendTotal(userId,searchKeyword);
			}
		}else {
			//받은 메시지함에서 검색할때
			//보낸사람 아이디로 검색한 경우
			if(searchType.equals("userId")) {
				 list=new MessageService().selectMsgByIdForReceive(userId,searchKeyword,cPage,numPerPage);
				 totalContents=new MessageService().selectMsgByIdForReceiveTotal(userId,searchKeyword);
			}else {
				//내용으로 검색한 경우
				list=new MessageService().selectMsgByContentForReceive(userId,searchKeyword,cPage,numPerPage);
				 totalContents=new MessageService().selectMsgByContentForReceiveTotal(userId,searchKeyword);
			}
		}
		System.out.println("토탈 컨텐츠 : "+totalContents);
		
		int totalPage = (int)Math.ceil((double)totalContents/numPerPage);
		
		// 페이지바 구성
		String pageBar = "";
		int pageBarSize = 5;
		// 시작페이지 번호 세팅
		int pageStart = ((cPage-1)/pageBarSize)*pageBarSize+1;
		// 종료페이지 번호 세팅
		int pageEnd = pageStart + pageBarSize-1;
		int pageNo = pageStart;
		System.out.println(pageNo+"은 뭐시냐(페이지넘_)");
		
		System.out.println("pageStart["+pageNo+"] ~ pageEnd["+pageEnd+"]");
		
		// section [prev]
		if(pageNo == 1) {}
		else {
			pageBar += "<a href='"+request.getContextPath()+"/views/message/myMessage?userId="+userId
					+ "&cPage=" + (pageNo-1) + "'>[이전]</a>";
		}
		System.out.println("pageNo :"+pageNo+", pageend : "+pageEnd+", totalPage :"+totalPage);
		// pageNo section
		// pageNo<=pageEnd && pageNo<=totalPage
		while(/*!(pageNo>pageEnd || pageNo > totalPage)*/pageNo<=pageEnd && pageNo<=totalPage) {
			if(cPage == pageNo) {
				pageBar += "<span class='cPage'>" + pageNo + "</span>";
			}
			else {
				pageBar += "<a href='"+request.getContextPath()+"/views/message/myMessage?userId="+userId
						+ "&cPage=" + pageNo + "'>"+pageNo+"</a>";
			}
			
			pageNo++;
		}
		
		// section [next]
		if(pageNo>totalPage) {}
		else {
			pageBar += "<a href='"+request.getContextPath()+"/views/message/myMessage?userId="+userId
					+ "&cPage="+pageNo+ "'>[다음]</a>";
		}
		
		
		
		String view="/WEB-INF/views/common/msg.jsp";
		String msg=null;
		String loc="/views/message/myMessage?userId="+userId;
		System.out.println("리스느"+list);
		System.out.println("페이;지바: "+pageBar);

			
		
		
		if(list!=null) {
			view="/WEB-INF/views/message/message.jsp";
			request.setAttribute("msgList", list);
			request.setAttribute("searchType", searchType);
			request.setAttribute("searchKeyword", searchKeyword);
			request.setAttribute("senRec", senRec);
			request.setAttribute("pageBar", pageBar);
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
