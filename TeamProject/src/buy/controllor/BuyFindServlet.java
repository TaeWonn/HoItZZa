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
 * Servlet implementation class BuyFindServlet
 */
@WebServlet("/buy/buyFind")
public class BuyFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");
		
		int cPage = 1;
		int numPerPage =10;
		
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch(NumberFormatException e) {
		}
		try {
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		} catch(NumberFormatException e) {
		}
		
		List<Buy> bList = null;
		int totalContents = 1;
		switch(searchType) {
		case "buyTitle_find":
			bList = new BuyService().titleFind(searchKeyword,cPage, numPerPage);
			totalContents = new BuyService().titleCotents(searchKeyword);
			break;
		case "buyCotent_find":
			bList = new BuyService().contentFind(searchKeyword,cPage, numPerPage);
			totalContents = new BuyService().contentCotents(searchKeyword);
			break;
		case "buyWriter_find":
			bList = new BuyService().writerFind(searchKeyword,cPage, numPerPage);
			totalContents = new BuyService().writerCotents(searchKeyword);
			break;
		}
		
		int totalPage = (int)Math.ceil((double)totalContents/numPerPage);
		
		int pageBarSize = 5;
		int pageStart = ((cPage-1)/pageBarSize)*numPerPage +1;
		int pageEnd = pageStart + pageBarSize -1;
		int pageNo = pageStart;
		
		String pageBar = "";
		if(pageNo == 1) {
		}else {
			pageBar += "<a href='"+request.getContextPath()+"/buy/buyFind?cPage="+(pageNo-1)+"&numPerPage="
					+numPerPage+"&searchType="+searchType+"&searchKeyword="+searchKeyword+"'>[이전]</a>";
		}
		while(pageNo <= pageEnd && pageNo <= totalPage) {
			if(cPage == pageNo) {
				pageBar += "<span>"+pageNo+"</span>";
			}else {
				pageBar += "<a href='"+request.getContextPath()+"/buy/buyFind?cPage="+pageNo+"&numPerPage="+
						numPerPage+"&searchType="+searchType+"&searchKeyword="+searchKeyword+"'>"+pageNo
						+"</a>";
			}
			pageNo ++;
		}
		
		if(pageNo > totalPage) {
		}else {
			pageBar += "<a href='"+request.getContextPath()+"/buy/buyFind?cPage="+pageNo+"&numPerPage"
					+numPerPage+"&searchType="+searchType+"&searchKeyword="+searchKeyword+"'>[다음]</a>";
		}
		
		request.setAttribute("cPage",cPage );
		request.setAttribute("numPerPage", numPerPage);
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("buyList", bList);
		request.setAttribute("searchType", searchType);
		request.setAttribute("searchKeyword", searchKeyword);
		
		request.getRequestDispatcher("/WEB-INF/views/buy/buyList.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
