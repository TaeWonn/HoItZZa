package admin.controllor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import user.model.vo.User;

/**
 * Servlet implementation class AdminListServlet
 */
@WebServlet("/admin/adminList")
public class AdminListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cPage =1 ;
		int numPerPage = 10;
		
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
		}
		try {
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
 		} catch (NumberFormatException e) {
 		}
		
		//content area
		List<User> userList = new AdminService().AllUser(cPage, numPerPage);
		
		//page bar area
		int totalContents = new AdminService().selectUserCount();
		
		int pageBarSize = 10;
		//전체페이지수
		int totalPage = (int)Math.ceil((double)totalContents/numPerPage);
		
		int pageStart = ((cPage-1)/pageBarSize)*pageBarSize +1;
		int pageEnd = pageStart +(pageBarSize-1);
		
		int pageNo = pageStart;
		
		String pageBar = "";
		//[이전]
		if(pageNo == 1) {
			
		}else {
			pageBar += "<a href='"+request.getContextPath()+"/admin/adminList?cPage="+(pageNo-1)+
								"&numPerPage="+numPerPage+"'>[이전]</a>";
		}
		
		//[pageNo]
		while(pageNo <= pageEnd && pageNo <=totalPage) {
			if(cPage == pageNo) {
				pageBar += "<span>"+pageNo+"</span>";
			}else {
				pageBar += "<a href='"+request.getContextPath()+"/admin/adminList?cPage="+pageNo+
								"&numPerPage="+numPerPage+"'>"+pageNo+"</a>";
			}
			pageNo ++;
		}
		
		if(pageNo > totalPage) {
			
		}else {
			pageBar += "<a href='"+request.getContextPath()+"/admin/adminList?cPage"+pageNo
							+"&numPerPage="+numPerPage+"'>[다음]</a>";
		}
		
		request.setAttribute("cPge", cPage);
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("numPerPage", numPerPage);
		
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/WEB-INF/views/admin/adminList.jsp")
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
