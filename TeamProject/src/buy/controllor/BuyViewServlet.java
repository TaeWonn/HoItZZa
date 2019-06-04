package buy.controllor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buy.model.service.BuyService;
import buy.model.vo.Buy;
import comment.model.vo.Comment;

/**
 * Servlet implementation class BuyViewServlet
 */
@WebServlet("/buy/buyView")
public class BuyViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNo = request.getParameter("boardNo");
		
		Buy b = new BuyService().selectOneBuy(boardNo);
		
		if(b == null) {
			request.setAttribute("msg", "게시글이 존재하지않습니다");
			request.setAttribute("loc", "/buy/buyList");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
					.forward(request, response);
			return;
		}
		//경고회수 가져오기
		int warningCnt = new BuyService().warningCnt(b.getBoardWriter());
		
		
		List<Comment> clist = new BuyService().commentList(boardNo);
		
		request.setAttribute("cList", clist);
		request.setAttribute("warningCnt", warningCnt);
		request.setAttribute("buy", b);
		request.getRequestDispatcher("/WEB-INF/views/buy/buyView.jsp")
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
