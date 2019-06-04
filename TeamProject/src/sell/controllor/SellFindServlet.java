package sell.controllor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sell.model.service.SellService;
import sell.model.vo.Sell;

/**
 * Servlet implementation class SellFindServlet
 */
@WebServlet("/sell/sellFind")
public class SellFindServlet extends HttpServlet {
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
		
		List<Sell> bList = new SellService().sellFind(searchType, searchKeyword,cPage,numPerPage);
		int totalContents = new SellService().sellFindContents(searchType, searchKeyword);
		int totalPage = (int)Math.ceil((double)totalContents/numPerPage);
		
		int pageBarSize = 5;
		int pageStart = ((cPage-1)/pageBarSize)*numPerPage +1;
		int pageEnd = pageStart + pageBarSize -1;
		int pageNo = pageStart;
		
		String pageBar = "";
		if(pageNo == 1) {
		}else {
			pageBar += "<a href='"+request.getContextPath()+"/sell/sellFind?cPage="+(pageNo-1)+"&numPerPage="
					+numPerPage+"&searchType="+searchType+"&searchKeyword="+searchKeyword+"'>[이전]</a>";
		}
		while(pageNo <= pageEnd && pageNo <= totalPage) {
			if(cPage == pageNo) {
				pageBar += "<span>"+pageNo+"</span>";
			}else {
				pageBar += "<a href='"+request.getContextPath()+"/sell/sellFind?cPage="+pageNo+"&numPerPage="+
						numPerPage+"&searchType="+searchType+"&searchKeyword="+searchKeyword+"'>"+pageNo
						+"</a>";
			}
			pageNo ++;
		}
		
		if(pageNo > totalPage) {
		}else {
			pageBar += "<a href='"+request.getContextPath()+"/sell/sellFind?cPage="+pageNo+"&numPerPage"
					+numPerPage+"&searchType="+searchType+"&searchKeyword="+searchKeyword+"'>[다음]</a>";
		}
		
		request.setAttribute("cPage",cPage );
		request.setAttribute("numPerPage", numPerPage);
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("sellList", bList);
		request.setAttribute("searchType", searchType);
		request.setAttribute("searchKeyword", searchKeyword);
		
		request.getRequestDispatcher("/WEB-INF/views/sell/sellList.jsp")
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
