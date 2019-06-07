package buy.controllor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buy.model.service.BuyService;
import comment.model.vo.Comment;

/**
 * Servlet implementation class BuyCommnetServlet
 */
@WebServlet("/buy/buyComment")
public class BuyCommnetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNo = request.getParameter("boardNo");
		String commentWriter = request.getParameter("commentWriter");
		String commentContent = request.getParameter("commentContent");
		String commentNoRef = request.getParameter("commentNoRef");
		int commentLevel = Integer.parseInt(request.getParameter("commentLevel"));
		
		Comment c = new Comment(commentContent, boardNo, commentWriter, commentLevel, commentNoRef);
		int result = new BuyService().insertComment(c);
		
		String msg = "";
		if(result > 0) {
		} else {
			msg = "댓글 등록중 오류발생";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", "/buy/buyView?boardNo="+boardNo);
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
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
