package opinion.controllor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import opinion.model.service.OpinionService;
import opinion.model.vo.Opinion;

/**
 * Servlet implementation class OpinionViewServlet
 */
@WebServlet("/opinion/opinionView")
public class OpinionViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNo = request.getParameter("boardNo");
		
		Opinion o = new OpinionService().selectOneBoard(boardNo);
		
		if(o ==null) {
			request.setAttribute("msg", "게시글이 존재하지않습니다");
			request.setAttribute("loc", "/opinion/opinionList");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
			.forward(request, response);
			return;
		}
		int warningCnt = new OpinionService().selectWarningCnt(o.getBoardWriter());
		
		OpinionService os = new OpinionService();
		
		//사용자 읽음여부 쿠키검사
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
			os.increaseReadCount(boardNo);
			
			//쿠키생성
			Cookie boardCookie = new Cookie("boardCookie", boardCookieVal+"|"+boardNo+"|");
			boardCookie.setPath(request.getContextPath()+"/board/boardView");
//			boardCookie.setMaxAge();//생략시 영속하게됨.
			
			//응답객체 cookie 전송
			response.addCookie(boardCookie);
			
			System.out.println("boardCookie생성: "+boardCookie.getValue());
		}
		
		
		request.setAttribute("opinion", o);
		request.setAttribute("warningCnt", warningCnt);
		request.getRequestDispatcher("/WEB-INF/views/opinion/opinionView.jsp")
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
