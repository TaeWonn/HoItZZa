package sell.controllor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import buy.model.service.BuyService;
import buy.model.vo.Buy;
import comment.model.vo.Comment;
import file.model.vo.FileTable;
import sell.model.service.SellService;
import sell.model.vo.Sell;

/**
 * Servlet implementation class SellViewServlet
 */
@WebServlet("/sell/sellView")
public class SellViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNo = request.getParameter("boardNo");
		
		Sell s = new SellService().selectOneSell(boardNo);
		//List<FileTable> ft = new SellService().selectFiles(boardNo);
		
		if(s == null) {
			request.setAttribute("msg", "게시글이 존재하지않습니다");
			request.setAttribute("loc", "/sell/sellList");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
				.forward(request, response);
			return;
		}
//		int warningCnt = new SellService().warningCnt(s.getBoardWriter());
		List<Comment> clist = new SellService().commentList(boardNo);
		
		Cookie[] cookies = request.getCookies();
		boolean hasRead = false;
		String boardCookieVal = "";
		//사이트 첫방문시 아무런 쿠키도 없으므로, cookies가 null
		//boardCookie = |2||3||100|
		if(cookies != null) {
			for(Cookie c: cookies) {
				String name = c.getName();
				String value = c.getValue();
				
				//boardCookie인 경우
				if("boardCookie".equals(name)) {
					boardCookieVal = value;
					
					if(value.contains("|"+boardNo+"|")) {
						hasRead = true;
						break;
					}
				}
			}
		}
		
		//쿠키에 읽은 값이 없는 경우
		if(!hasRead) {
			new SellService().increaseReadCount(boardNo);
			
			//쿠키생성
			Cookie boardCookie = new Cookie("boardCookie", boardCookieVal+"|"+boardNo+"|");
			boardCookie.setPath(request.getContextPath()+"/board/boardView");
//			boardCookie.setMaxAge();//생략시 영속하게됨.
			
			//응답객체 cookie 전송
			response.addCookie(boardCookie);
			
			System.out.println("boardCookie생성: "+boardCookie.getValue());
		}
		
		/////////////////////////////////////////////////////////////////////////////
		
		//이전글 
		Sell prev = new SellService().selectOneSellprev(boardNo.substring(0, 2)+(Integer.parseInt(boardNo.substring(2))-1));
		
		//다음글 가져오기
		Sell next = new SellService().selectOneSellnext(boardNo.substring(0, 2)+(Integer.parseInt(boardNo.substring(2))+1));
    	System.out.println(next);
		
    	
    	//다음글 이전글 없으면 없다고 출력해줌
		if(prev == null) {
			prev.setBoardTitle("이전글이 없습니다");
			request.setAttribute("prev", prev);
		}
		else 
		request.setAttribute("prev", prev);
		
		if(next == null) {
		next.setBoardTitle("다음글이 없습니다");
		request.setAttribute("next", next);
		}
		else 
		request.setAttribute("next", next);
		
		
		////////////////////////////////////////카테고리 한글변환
		
		String ca = new BoardService().selectcategoryname(s.getBoardCodeNo());
		s.setBoardCodeNo(ca);
		
		System.out.println("테스트"+clist);
		request.setAttribute("cList", clist);
//		request.setAttribute("warningCnt", warningCnt);
		request.setAttribute("sell", s);
		
//		request.setAttribute("files", ft);
		request.getRequestDispatcher("/WEB-INF/views/sell/sellView.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}