package user.controllor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.vo.Board;
import buy.model.service.BuyService;
import buy.model.vo.Buy;
import sell.model.service.SellService;
import sell.model.vo.Sell;
import user.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class UserViewServlet
 */
@WebServlet("/views/user/userInfo")
public class UserViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.파라미터핸들링
		String userId = request.getParameter("userId");
		int numPerPage = 14;
		int cPage = 1;
		
		try {
			cPage = Integer.parseInt(request.getParameter("userId"));
		} catch (NumberFormatException e) { }
		System.out.println("cPage@Servlet="+cPage);
		
		//2.업무로직
		User u = new UserService().selectOne(userId);

		String view = "";
		String loc = "";
		String msg = "";
		if(u == null) {
			view = "/WEB-INF/views/common/msg.jsp";
			msg = "해당 회원이 없습니다.";
			loc = "/";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
		}
		else {
			// 이용자가 있는 경우에는 메세지 페이지를 거치지 않고
			// 바로 개인정보 페이지로 이동한다.
			view = "/WEB-INF/views/user/userInfo.jsp";
			
			// 이용자가 있을 경우에만 개인화 리스트를 받아온다.
//			List<Sell> interestSellListByUser = new SellService().selectInterestSellListByUser(userId);
//			List<Buy> interestBuyListByUser = new BuyService().selectInterestBuyListByUser(userId);
//			List<Sell> interestCategoryList1 = new SellService().selectInterestSellListByCategory(u.getInterest()[0]);
//			List<Sell> interestCategoryList2 = new SellService().selectInterestSellListByCategory(u.getInterest()[1]);
//			List<Sell> interestCategoryList3 = new SellService().selectInterestSellListByCategory(u.getInterest()[2]);
//			
			// 관심글을 판매/구매 게시판 별로 받아와서 부모 클래스인 Board객체의 리스트로 합친다.
			List<Board> list = new ArrayList<>();
//			list.add((Board)interestSellListByUser);
//			list.add((Board)interestBuyListByUser);
			
			// 전체 게시글 수, 전체 페이지 수 구하기
			int totalCnt = list.size();
			int totalPage = (int)Math.ceil((double)totalCnt/numPerPage);

			// 페이지바 구성
			String pageBar = "";
			int pageBarSize = 5;
			
			// 시작페이지 번호 세팅
			int pageStart = ((cPage-1)/pageBarSize) * pageBarSize + 1;
			
			// 종료페이지 번호 세팅
			int pageEnd = pageStart + pageBarSize - 1;
			int pageNo = pageStart;
			
			// [prev] section
			if(pageNo == 1)
				pageBar += "<span>[prev]</span>";
			else {
				pageBar += "<a href'"+request.getContextPath()
							+  "/views/user/userInfo?scPage="+pageNo+"'>"
							+  pageNo + "</a>";
			}
			
			// pageNo section
			while(pageNo <= pageEnd && pageNo<=totalPage) {
				while(!(pageNo>pageEnd || pageNo>totalPage)) {
					if(cPage == pageNo) 
						pageBar += "<span class='scPage'>"+pageNo+"</span>";
					else {
						pageBar += "<a href'"+request.getContextPath()
									+  "/views/user/userInfo?scPage="+pageNo+"'>"
									+  pageNo + "</a>";
					}
					
					pageNo++;
				}
			}
			
			// [next] section
			if(pageNo>totalPage) 
				pageBar += "<span>[next]</span>";
			else {
				pageBar += "<a href'"+request.getContextPath()
							+  "/views/user/userInfo?scPage="+pageNo+"'>"
							+  pageNo + "</a>";
			}
			String [] addrArr = u.getAddr().split(",");
			if(addrArr.length > 2) {
				msg += "</br> 주소 정보에 오류가 있습니다.";
			}
			System.out.println("서블릿"+u);
			request.setAttribute("user", u);
			request.setAttribute("pageBar", pageBar);
//			request.setAttribute("interestBoardList", list);
//			request.setAttribute("firstInterestList", interestCategoryList1);
//			request.setAttribute("secondInterestList", interestCategoryList2);
//			request.setAttribute("thirdInterestList", interestCategoryList3);
		}
		System.out.println("서블릿"+u);		//3.view단 처리  		
		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}