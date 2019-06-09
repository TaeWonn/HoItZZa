package admin.controllor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;

/**
 * Servlet implementation class AdminInsertBlackUser
 */
@WebServlet("/admin/insertBlackList")
public class AdminInsertBlackUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		String reason=new AdminService().selectBlackUserReason(userId);
		
		int result=new AdminService().insertBlackUser(userId,reason);
		
		String msg="";
		String loc="/admin/adminList";
		String view="/WEB-INF/views/common/msg.jsp";
		if(result>0) {
			msg="블랙리스트에 추가되었습니다.";
		}else {
			msg="블랙리스트 추가에 실패했습니다. 담당자에게 문의주세요";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
