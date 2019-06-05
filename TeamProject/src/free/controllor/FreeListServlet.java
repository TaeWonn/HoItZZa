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
 * Servlet implementation class FreeListServlet
 */
@WebServlet("/free/freeList")
public class FreeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("======<FreeListServlet Start>======");
		int cPage = 1;
		int numPerPage = 10;
		
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {}
		
		List<Free> free = new FreeService().selectAllFreeList(cPage, numPerPage);
		
		int totalContents = new FreeService().selectFreeCount();
		int totalPage = (int)Math.ceil((double)totalContents/numPerPage);
		int pageBarSize = 5;
		int pageStart = ((cPage-1)/pageBarSize)*pageBarSize + 1;
		int pageEnd = pageStart + (pageBarSize-1);
		int pageNo = pageStart;
		
		System.out.println("pageStart["+pageNo+"] ~ pageEnd["+pageEnd+"]");
		
		String pageBar = "";
		
		// section [prev]
		if(!(pageNo == 1)) {
			pageBar += "<a href='"+request.getContextPath()+"/free/freeList?cPage="+(pageNo-1)+"'>[이전]</a>";
		}
		
		// pageNo section
		while(!(pageNo>pageEnd || pageNo > totalPage)) {
			if(cPage == pageNo)
				pageBar += "<span class='cPage'>"+pageNo+"</span> ";
			else {
				pageBar += "<a href='"+request.getContextPath()+"/free/freeList?cPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		
		// section [next]
		if(!(pageNo > totalPage)) {
			pageBar += "<a href='"+request.getContextPath()+"/free/freeList?cPage="+pageNo+"'>[다음]</a>";
		}
		
		request.setAttribute("cPage", cPage);
		request.setAttribute("numPerPage", numPerPage);
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("free", free);
		
		request.getRequestDispatcher("/WEB-INF/views/free/freeList.jsp").forward(request, response);
		System.out.println("======<FreeListServlet Over>======");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
