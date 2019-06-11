package opinion.controllor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import opinion.model.service.OpinionService;
import opinion.model.vo.Opinion;

/**
 * Servlet implementation class OpinionListServlet
 */
@WebServlet(urlPatterns="/opinion/opinionList",
				name="OpinionListServlet")
public class OpinionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		System.out.println(cPage+" : "+numPerPage);
		List<Opinion> oList = new OpinionService().selectAllOpinionList(cPage, numPerPage);
		List<Integer> waringCnt = new OpinionService().OpinionWarningCnt(oList);
		
		int totalContents = new OpinionService().selectOpinionCount();
		System.out.println(totalContents);
		int totalPage = (int)Math.ceil((double)totalContents/numPerPage);

		int pageBarSize = 5;
		int pageStart = ((cPage-1)/pageBarSize)*pageBarSize +1;
		int pageEnd = pageStart + pageBarSize -1;
		System.out.println(pageStart);
		
		int pageNo = pageStart;
		String pageBar = "";
		if(pageNo ==1) {
		}else {
			pageBar += "<a href='"+request.getContextPath()+"/opinion/opinionList?cPage="+(pageNo-1)+
					"&numPerPage="+numPerPage+"'>[이전]</a>";
		}
		
		while(pageNo <= pageEnd && pageNo <= totalPage) {
			System.out.println("while--------------");
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
		System.out.println(pageBar);
		
		request.setAttribute("cPage", cPage);
		request.setAttribute("numPerPage", numPerPage);
		request.setAttribute("PageBar", pageBar);
		request.setAttribute("oList", oList);
		request.setAttribute("warningCnt", waringCnt);
		request.getRequestDispatcher("/WEB-INF/views/opinion/opinionList.jsp")
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
