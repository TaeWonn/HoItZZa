package user.controllor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buy.model.service.BuyService;
import buy.model.vo.Buy;
import sell.model.service.SellService;
import sell.model.vo.Sell;
import user.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class UserViewServlet
 */
@WebServlet("/user/uesrView")
public class UserViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.파라미터핸들링
		String userId = request.getParameter("userId");
		
		//2.업무로직
		User u = new UserService().selectOne(userId);
		List<Sell> interestSellListByUser = new SellService().selectInterestSellListByUser(userId);
		List<Buy> interestBuyListByUser = new BuyService().selectInterestBuyListByUser(userId);
		List<Sell> interestCategoryList1 = new SellService().selectInterestSellListByCategory(u.getInterest()[0]);
		List<Sell> interestCategoryList2 = new SellService().selectInterestSellListByCategory(u.getInterest()[1]);
		List<Sell> interestCategoryList3 = new SellService().selectInterestSellListByCategory(u.getInterest()[2]);
		
		//3.view단 처리  
		String view = "";
		String loc = "";
		String msg = "";
		if(u != null) {
			view = "/WEB-INF/views/user/userView.jsp";
			request.setAttribute("user", u);
			request.setAttribute("interestSellListByUser", interestSellListByUser);
			request.setAttribute("interestBuyListByUser", interestBuyListByUser);
			request.setAttribute("interestCategoryList1", interestCategoryList1);
			request.setAttribute("interestCategoryList2", interestCategoryList2);
			request.setAttribute("interestCategoryList3", interestCategoryList3);
		}
		else {
			view = "/WEB-INF/views/common/msg.jsp";
			msg = "해당 회원이 없습니다.";
			loc = "/";
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
