package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;

/**
 * 페이징 레시피
 * 1.컨텐츠영역
 * cPage: 현재페이지
 * numPerPage: 한페이지당 출력할 컨텐츠수
 * 
 * startRowNum
 * endRowNum
 * 
 * 2.페이지바영역
 * totalContent: 전체컨텐츠수 
 * totalPage: 전체페이지수
 * pageBarSize: 페이지바에 표시할 페이지수
 * pageNo: 페이지번호
 * 
 * 
 */
@WebServlet("/board/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 파라미터값 변수에 담기
		int numPerPage = 5;//한페이지당 수
		int cPage = 1;//요청페이지
		try{
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch(NumberFormatException e){
		
		}
		//System.out.println("cPage="+cPage); 
		
		//2.업무로직처리
		//2.1 현재페이지의 회원구하기
		List<Board> list = new BoardService().selectBoardList(cPage, numPerPage);
		System.out.println("list="+list);
		
		//2.2 전체게시글수, 전체페이지수 구하기
		int totalBoardCount = new BoardService().selectBoardCount();
		//(공식2)전체페이지수 구하기
		int totalPage = (int)Math.ceil((double)totalBoardCount/numPerPage);
		System.out.println("totalBoardCount="+totalBoardCount+", totalPage="+totalPage);
		
		//2.3 페이지바구성
		String pageBar = "";	
		int pageBarSize = 5;
		//(공식3)시작페이지 번호 세팅
		//cPage=5,pageBarSize=5 -> 1
		//cPage=6,pageBarSize=5 -> 6
		int pageStart = ((cPage - 1)/pageBarSize) * pageBarSize +1;
		//종료페이지 번호 세팅
		int pageEnd = pageStart+pageBarSize-1;
		int pageNo = pageStart;
		
		System.out.println("pageStart["+pageNo+"] ~ pageEnd["+pageEnd+"]");
		
		//[이전] section
		if(pageNo == 1 ){
			//pageBar += "<span>[이전]</span>"; 
		}
		else {
			pageBar += "<a href='"+request.getContextPath()+"/board/boardList?cPage="+(pageNo-1)+"'>[이전]</a> ";
		}
			
		// pageNo section
		// 보통 !(빠져나가는 조건식)으로 많이 쓴다.
//				while(pageNo<=pageEnd && pageNo<=totalPage){
		while(!(pageNo>pageEnd || pageNo > totalPage)){
			
			if(cPage == pageNo ){
				pageBar += "<span class='cPage'>"+pageNo+"</span> ";
			} 
			else {
				pageBar += "<a href='"+request.getContextPath()+"/board/boardList?cPage="+pageNo+"'>"+pageNo+"</a> ";
			}
			pageNo++;
		}
		
		//[다음] section
		if(pageNo > totalPage){
			//pageBar += "<span>[다음]</span>";
		} else {
			pageBar += "<a href='"+request.getContextPath()+"/board/boardList?cPage="+pageNo+"'>[다음]</a>";
		}
		
		
		//4.뷰단 포워딩		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/WEB-INF/views/board/boardList.jsp");
		request.setAttribute("list",list);
		request.setAttribute("pageBar",pageBar);	
		//request.setAttribute("cPage",cPage);		
		reqDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
