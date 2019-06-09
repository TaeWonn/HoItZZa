package opinion.controllor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import opinion.model.service.OpinionService;
import opinion.model.vo.*;

/**
 * Servlet implementation class DeclarationListServlet
 */
@WebServlet("/opinion/declarationList")
public class DeclarationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cPage = 1;
		int numPerPage =10;
		try {
			cPage = Integer.parseInt(request.getParameter("cpage"));
		} catch(NumberFormatException e) {
		}
		try {
			numPerPage = Integer.parseInt(request.getParameter("numPerpage"));
		} catch(NumberFormatException e) {
		}
		System.out.println(cPage+" : "+numPerPage);
		List<Opinion> olist = new OpinionService().selectDeclarationList(cPage,numPerPage);
		System.out.println("리스트"+olist);
		List<Integer> wCnt = new OpinionService().OpinionWarningCnt(olist);
		
		int totalContents = new OpinionService().selectDeclarationCount();
		int totalPage = (int)Math.ceil((double)totalContents/numPerPage);
		
		int pageBarSize = 5;
		int pageStart = ((cPage-1)/pageBarSize)*pageBarSize +1;
		int pageEnd = pageStart +pageBarSize -1;
		
		int pageNo = pageStart;
		String pageBar = "";
		
		if(pageNo ==1) {
		}else {
			pageBar += "<a href='"+request.getContextPath()+"/opinion/opinionList?cPage="+(pageNo-1)+
					"&numPerPage="+numPerPage+"'>[이전]</a>";
		}
		
		while(pageNo <= pageEnd && pageNo <= totalPage) {
			if(cPage == pageNo) {
				pageBar += "<span>"+pageNo+"</span>";
			}else {
				pageBar += "<a href='"+request.getContextPath()+"/opinion/opinionList?cPage="+pageNo+
						"&numPerPage="+numPerPage+"'>"+pageNo+"</a>";
			}
			pageNo ++;
		}
		if(pageNo > totalPage) {
		}else {
			pageBar += "<a href='"+request.getContextPath()+"/opinion/opinionLisr?cPage="+pageNo+
					"&numPerPage="+numPerPage+"'>[다음]</a>";
		}
		
		
		request.setAttribute("oList", olist);
		request.setAttribute("warningCnt", wCnt);
		request.setAttribute("cPage", cPage);
		request.setAttribute("numPerPage", numPerPage);
		request.setAttribute("pageBar", pageBar);
		
		request.getRequestDispatcher("/WEB-INF/views/opinion/declarationList.jsp")
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
