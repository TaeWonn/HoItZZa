package free.controllor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.model.service.FreeService;
import free.model.vo.Free;

/**
 * Servlet implementation class DivideListServlet
 */
@WebServlet("/free/divideList")
public class DivideListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("======<divideListServlet Start>======");
		int cPage = 1;
		int numPerPage = 10;
		
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {}
		
		List<Free> free = new FreeService().selectAllDevideList(cPage, numPerPage);
		
		int totalContents = new FreeService().selectDevideCount();
		int totalPage = (int)Math.ceil((double)totalContents/numPerPage);
		int pageBarSize = 10;
		int pageStart = ((cPage-1)/pageBarSize)*pageBarSize + 1;
		int pageEnd = pageStart + (pageBarSize-1);
		int pageNo = pageStart;
		
		String pageBar = "";
		
		// section [prev]
		if(pageNo == 1) {}
		else {
			pageBar += "<a href='"+request.getContextPath()+"/free/freeList?cPage="+(pageNo-1)+
					"&numPerPage="+numPerPage+"'>[이전]</a>";
		}
		
		// pageNo section
		while(pageNo <= pageEnd && pageNo <= totalPage) {
			if(cPage == pageNo)
				pageBar += "<span='cPage'>"+pageNo+"</span> ";
			else {
				pageBar += "<a href='"+request.getContextPath()+"/free/freeList?cPage="+pageNo+
						"&numPerPage="+numPerPage+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		
		// section [next]
		if(pageNo > totalPage) {}
		else {
			pageBar += "<a href='"+request.getContextPath()+"/free/freeList?cPage="+pageNo+
					"&numPerPage="+numPerPage+"'>[다음]</a>";
		}
		
		request.setAttribute("cPage", cPage);
		request.setAttribute("numPerPage", numPerPage);
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("divideList", free);
		request.setAttribute("backList", "/divideList");
		
		request.getRequestDispatcher("/WEB-INF/views/free/divideList.jsp").forward(request, response);
		System.out.println("======<divideListServlet Over>======");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
