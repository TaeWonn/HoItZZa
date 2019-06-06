package free.controllor;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.model.vo.Comment;
import file.model.vo.FileTable;
import free.model.service.FreeService;
import free.model.vo.Free;

/**
 * Servlet implementation class FreeViewServlet
 */
@WebServlet("/free/freeView")
public class FreeViewServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파라미터 핸들링
		String boardNo = request.getParameter("boardNo");
		
		Free f = new FreeService().selectOneFree(boardNo);
		
		List<FileTable> ft = new FreeService().selectFiles(boardNo);
		
		if(f == null) {
			request.setAttribute("msg", "게시글이 존재하지않습니다");
			request.setAttribute("loc", "/sell/sellList");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
				.forward(request, response);
			return;
		}
		int warningCnt = new FreeService().warningCnt(f.getBoardWriter());
		
		List<Comment> clist = new FreeService().commentList(boardNo);
		
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
			new FreeService().increaseReadCount(boardNo);
			
			//쿠키생성
			Cookie boardCookie = new Cookie("boardCookie", boardCookieVal+"|"+boardNo+"|");
			boardCookie.setPath(request.getContextPath()+"/free/freeView");
//			boardCookie.setMaxAge();//생략시 영속하게됨.
			
			//응답객체 cookie 전송
			response.addCookie(boardCookie);
			
			System.out.println("boardCookie생성: "+boardCookie.getValue());
		}
		

		request.setAttribute("cList", clist);
		request.setAttribute("warningCnt", warningCnt);
		request.setAttribute("free", f);
		request.setAttribute("files", ft);
		request.getRequestDispatcher("/WEB-INF/views/free/freeView.jsp")
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
