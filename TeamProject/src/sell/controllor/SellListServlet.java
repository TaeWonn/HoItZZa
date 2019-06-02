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
 * Servlet implementation class SellListServlet
 */
@WebServlet("/sell/sellList")
public class SellListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cPage =1 ;
		int numPerPage = 10;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch(NumberFormatException e) {
		}
		try {
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		} catch (NumberFormatException e) {
		}
		
		List<Sell> sell = new SellService().selectAllSellList();
		
		int totalContents = new SellService().selectSellCount();
		int totalPage = (int)Math.ceil((double)totalContents/numPerPage);
		
		
		int pageBarSize = 5;
		
		int pageStart = ((cPage-1)/pageBarSize)*pageBarSize +1;
		int pageEnd = pageStart+pageBarSize-1;
		System.out.println("totalContents =" + totalContents);
		System.out.println("totalPage = "+totalPage);
		System.out.println("page Start= "+pageStart);
		System.out.println("pageEnd = " + pageEnd);
		
		int pageNo = pageStart;
		
		String pageBar = "";
		
		if(pageNo ==1) {
			
		}else {
			pageBar += "<a href='"+request.getContextPath()+"/sell/sellList?cPage="+(pageNo-1)+
							"&numPerPage="+numPerPage+"'>[이전]</a>";
		}
		
		while(pageNo <= pageEnd && pageNo <= totalPage) {
			if(cPage == pageNo) {
				pageBar += "<span>"+pageNo+"</span>";
			}else {
				pageBar += "<a href='"+request.getContextPath()+"/sell/sellList?cPage="+pageNo+
							"&numPerPage="+numPerPage+"'>"+pageNo+"</a>";
			}
			pageNo ++;
			
		}
		
		if(pageNo > totalPage) {
			
		}else {
			pageBar += "<a href='"+request.getContextPath()+"/sell/sellList?cPage="+pageNo+
							"&numPerPage="+numPerPage+"'>[다음]</a>";
		}
		
		request.setAttribute("cPage", cPage);
		request.setAttribute("numPerPage", numPerPage);
		request.setAttribute("PageBar", pageBar);
		
		 System.out.println("sellListServlet-0----");
		
		request.setAttribute("sell", sell);
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
