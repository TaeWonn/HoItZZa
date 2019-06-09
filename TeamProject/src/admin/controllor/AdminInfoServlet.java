package admin.controllor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import board.model.vo.Board;

/**
 * Servlet implementation class AdminInfoServlet
 */
@WebServlet("/admin/adminInfo")
public class AdminInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//건의 게시판 리스트 5개만
		List<Board> suggestion=new AdminService().selectSuggestionBoardList();
		
		//신고게시판 리스트 5개만
		List<Board> report=new AdminService().selectReportBoardList();
		
		
		
		request.setAttribute("suggestion", suggestion);
		request.setAttribute("report", report);
		request.getRequestDispatcher("/WEB-INF/views/admin/adminInfo.jsp")
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
