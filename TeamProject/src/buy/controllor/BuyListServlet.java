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
		
		String search_category = request.getParameter("search_category");
		String search_key = request.getParameter("search_key");
		
		
		int cPage =1;
		int numPerPage =10;
		try {
			String c = request.getParameter("cPage");
			System.out.println("String c = "+c);
			cPage =Integer.parseInt(c);
		} catch (NumberFormatException e) {
			System.out.println("catch cPage = "+cPage);
		}
		try {
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		} catch (NumberFormatException e) {
			System.out.println("numPerPage");
		}
		
		
		List<Buy> buy=null;
		//검색조건이 있을경우 
		/////////////////////////////////////////////////////////////////////////
		
		int totalContents = new BuyService().selectBuyCount();
		
		if(search_category!=null&&search_key!=null) {
			buy = new BuyService().selectsearchList(cPage, numPerPage,search_category,search_key);
			
			//토탈페이지 변경해줌 
			totalContents = new BuyService().selectBuyCount_search(search_category,search_key);
		}
		
		//없을경우
		//////////////////////////////////////////////////////////////
		else { 
			 buy = new BuyService().selectAllBuyList(cPage, numPerPage);
		}
		
		List<Integer> warningCntList = new BuyService().warningCntList(buy);
		
		
		
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
		
		
		request.setAttribute("warningCntList", warningCntList);
		
		
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
