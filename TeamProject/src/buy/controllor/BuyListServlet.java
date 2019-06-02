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

/**
 * Servlet implementation class BuyListServlet
 */
@WebServlet("/buy/buyList")
public class BuyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cPage =1;
		int numPerPage =10;
		try {
			cPage =Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
		}
		try {
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		} catch (NumberFormatException e) {
		}
		
		List<Buy> buy = new BuyService().selectAllBuyList();
		
		int totalContents = new BuyService().selectBuyCount();
		
		int totalPage = (int)Math.ceil((double)totalContents/numPerPage);
		
		int pageBarSize = 10;
		
		int pageStart = ((cPage-1)/pageBarSize)*pageBarSize +1;
		int pageEnd = pageStart +(pageBarSize-1);
		
		int pageNo = pageStart ;
		
		String pageBar = "";
		if(pageNo==1) {
			
		}else {
			pageBar += "<a href='"+request.getContextPath()+"/buy/buyList?cPage="+(pageNo-1)+
							"&numPerPage="+numPerPage+"'>[이전]</a>";
		}
		while(pageNo <= pageEnd && pageNo <= totalPage) {
			if(cPage == pageNo) {
				pageBar += "<span>"+pageNo+"</span>";
			} else {
				pageBar += "<a href='"+request.getContextPath()+"/buy/buyList?cPage="+pageNo+
							"&numPerPage="+numPerPage+"'>"+pageNo+"</a>";
			}
			pageNo ++;
		}
		
		if(pageNo > totalPage) {
			
		}else {
			pageBar += "<a href='"+request.getContextPath()+"/buy/buyList?cPage="+pageNo+
						"&numPerPage="+numPerPage+"'>[다음]</a>";
		}
		
		request.setAttribute("cPage", cPage);
		request.setAttribute("numPerPage", numPerPage);
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("buy", buy);
		
		
		
		request.getRequestDispatcher("/WEB-INF/views/buy/buyList.jsp")
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
