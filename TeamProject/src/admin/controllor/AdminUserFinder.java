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
 * Servlet implementation class AdminUserFinder
 */
@WebServlet("/admin/userFinder")
public class AdminUserFinder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");
		int cPage = 1;
		int numPerPage = 10;
		
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch(NumberFormatException e) {
		}
		try {
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		} catch(NumberFormatException e) {
		}
		
		int totalContents = 0;
		List<User> userList = null;
		
		switch(searchType) {
		case "userId_find":
			userList = new AdminService().userIdFind(searchKeyword);
			totalContents = new AdminService().userIdCotents(searchKeyword);
			break;
		case "userName_find":
			userList = new AdminService().userNameFind(searchKeyword);
			totalContents = new AdminService().userNameCotents(searchKeyword);
			break;
		case "gender_find" :
			userList = new AdminService().genderFind(searchKeyword);
			totalContents = new AdminService().genderCotents(searchKeyword);
			break;
		}
		
		int totalPage = (int)Math.ceil((double)totalContents/numPerPage);
		
		int pageBarSize = 5;
		int pageStart = ((cPage-1)/pageBarSize)*numPerPage +1;
		int pageEnd = pageStart + pageBarSize -1;
		int pageNo = pageStart ;
		
		String pageBar = "";
		
		if(pageNo ==1) {
		}else {
			pageBar += "<a href='"+request.getContextPath()+"/admin/userFinder?cPage="+(pageNo-1)
					+"&numPerPage="+numPerPage+"&searchType="+searchType+"&searchKeyword"+searchKeyword
					+"'>[이전]</a>";
		}
		
		while(pageNo <= pageEnd && pageNo <= totalPage) {
			if(cPage == pageNo) {
				pageBar += "<span>"+pageNo+"</span>";
			}else {
				pageBar += "<a href='"+request.getContextPath()+"/admin/userFinder?cPage="+pageNo+"&numPerPage="+
						numPerPage+"&searchType="+searchType+"&searchKeyword="+searchKeyword+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		
		if(pageNo > totalPage) {
		}else {
			pageBar += "<a href='"+request.getContextPath()+"/admin/userFinder?cPage="+pageNo+"&numPerPage="
					+numPerPage+"&searchType="+searchType+"&searchKeyword="+searchKeyword+"'>[다음]</a>";
		}
		
		request.setAttribute("cPage",cPage );
		request.setAttribute("numPerPage", numPerPage);
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("userList", userList);
		request.setAttribute("searchType", searchType);
		request.setAttribute("searchKeyword", searchKeyword);
		
		request.getRequestDispatcher("/WEB-INF/views/admin/viewUserList.jsp")
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
