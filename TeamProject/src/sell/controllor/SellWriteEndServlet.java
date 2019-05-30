package sell.controllor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sell.model.service.SellService;
import sell.model.vo.Sell;

/**
 * Servlet implementation class SellWriteEndServlet
 */
@WebServlet("/sell/sellWriteEnd")
public class SellWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		String boardDeal = request.getParameter("boardDeal");
		String boardCode = request.getParameter("boardCodeNo");
		
		Sell s = new Sell();
		s.setBoardTitle(boardTitle);
		s.setBoardContent(boardContent);
		s.setBoardDeal(boardDeal);
		s.setBoardCodeNo(boardCode);
		
		int result = new SellService().insertSell(s);
		
		String view ="";
		if(result> 0) {
			view ="/WEB-INF/views/sell/sellComplete.jsp";
		} else {
			view = "/WEB-INF/views/common/msg.jsp";
			String msg = "글 등록 실패";
			String loc = "/sell/sellList";
			request.setAttribute("msg", msg);
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
