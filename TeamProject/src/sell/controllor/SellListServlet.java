package sell.controllor;

import java.io.IOException;
import java.util.ArrayList;
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
		
		String search_category = request.getParameter("search_category");
		String search_key = request.getParameter("search_key");
		
		
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
		
		List<Sell> sellList=null;
		
		int totalContents = new SellService().selectSellCount();
		
		if(search_category!=null&&search_key!=null) {
			sellList = new SellService().selectsearchList(cPage, numPerPage,search_category,search_key);
			
			//토탈페이지 변경해줌 
			totalContents = new SellService().selectSellCount_search(search_category,search_key);
		}
		
		//없을경우
		//////////////////////////////////////////////////////////////
		else { 
			sellList = new SellService().selectAllSellList(cPage, numPerPage);
		}

		
		//경고 횟수 가져오기
		List<Integer> warningCntList = new SellService().warningListCnt(sellList);
		
		
		int totalPage = (int)Math.ceil((double)totalContents/numPerPage);
		
		
		int pageBarSize = 5;
		
		int pageStart = ((cPage-1)/pageBarSize)*pageBarSize +1;
		int pageEnd = pageStart+pageBarSize-1;
		
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
		System.out.println(pageBar);
		List<Integer> warningCnt=new ArrayList<>();
		for(int i=0;i<sellList.size();i++) {
			int c= new SellService().warningCnt(sellList.get(i).getBoardWriter());
			warningCnt.add(c);
		}
		
		request.setAttribute("cPage", cPage);
		request.setAttribute("numPerPage", numPerPage);
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("sellList", sellList);
		request.setAttribute("warningCntList", warningCntList);
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
