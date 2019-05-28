package buy.controllor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buy.model.service.BuyService;
import buy.model.vo.Buy;

/**
 * Servlet implementation class BoardWriteEndServlet
 */
@WebServlet("/board/boardWriteEnd")
public class BoardWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		String boardWriter = request.getParameter("boardWriter");
		String boardDeal = request.getParameter("boardDeal");
		String boardCode = request.getParameter("boardCodeNo");
		
		Buy b = new Buy();
		b.setBoardTitle(boardTitle);
		b.setBoardContent(boardContent);
		b.setBoardWriter(boardWriter);
		b.setBoardCode(boardCode);
		
		int result = new BuyService().insertBoard(b);
		
		
		String view = "";
		String msg = "";
		String loc = "";
		if(result >0) {
			view ="/WEB-INF/views/buy/buycomplete.jsp";
		} else {
			view = "/WEB-INF/views/common/msg.jsp";
			msg = "글 등록중 오류 발생";
			loc = "/buy/buyList";
			request.setAttribute("msg",msg);
			request.setAttribute("loc", loc);
		}
		
		request.getRequestDispatcher(view)
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
