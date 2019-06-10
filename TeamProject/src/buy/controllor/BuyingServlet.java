package buy.controllor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buy.model.service.BuyService;

/**
 * Servlet implementation class BuyingServlet
 */
@WebServlet(urlPatterns="/buy/buying",
			name="BuyingServlet")
public class BuyingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNo = request.getParameter("boardNo");
		String userId = request.getParameter("userId");
		int price = Integer.parseInt(request.getParameter("price"));
		
		int point = new BuyService().selectUserPoint(userId);
		
		if(price > point) {
			request.setAttribute("msg", "포인트가 부족합니다");
			request.setAttribute("loc", "/buy/buyView?boardNo="+boardNo);
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
					.forward(request, response);
			return;
		}
		
		int result = new BuyService().buying(price, point, userId);
		
		String msg = "";
		if(result > 0) {
			msg = "구매 완료";
		} else {
			msg = "구매 중 오류 발생";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", "/");
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
