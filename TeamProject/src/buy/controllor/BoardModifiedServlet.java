package buy.controllor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import buy.model.service.BuyService;
import buy.model.vo.Buy;
import user.model.vo.User;

/**
 * Servlet implementation class BoardModifiedServlet
 */
@WebServlet("/buy/buyModified")
public class BoardModifiedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNo = request.getParameter("boardNo");
		
		Buy b = new BuyService().selectOneBuy(boardNo);
		HttpSession session = request.getSession();
		User userLoggedIn = (User)session.getAttribute("userLoggedIn");
		String userId = request.getParameter("userId");
		if(userLoggedIn == null || 
				!userId.equals(b.getBoardWriter()) ||
				!userId.equals("admin")) {
			request.setAttribute("msg", "작성자만 수정할수있습니다");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
				.forward(request, response);
			return;
		}
			
		
		
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
