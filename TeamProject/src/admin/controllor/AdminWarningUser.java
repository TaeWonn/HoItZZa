package admin.controllor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;

/**
 * Servlet implementation class AdminWarningUser
 */
@WebServlet("/admin/warningUser")
public class AdminWarningUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 핸들링
		String userId=request.getParameter("userId");
		String reason=request.getParameter("reason");
		System.out.println("서블렛 들어옴");
		System.out.println(userId);
		System.out.println(reason);
		String[] reasonArr = null;
		if(reason!=null) {
		reasonArr=reason.split(",");
		}
		int result=0;
		 //D_A : 욕설 / D_S : 사기 / D_M : 비매너 / D_P : 음란물 관련 게시 / D_R : 허위신고
		if(reasonArr[0].equals("D_A")) {
			result=new AdminService().warningUserCodeD_A(userId,reasonArr);
		}else if(reasonArr[0].equals("D_S")) {
			result=new AdminService().warningUserCodeD_S(userId,reasonArr);
		}else if(reasonArr[0].equals("D_M")) {
			result=new AdminService().warningUserCodeD_M(userId,reasonArr);
		}else if(reasonArr[0].equals("D_P")) {
			result=new AdminService().warningUserCodeD_P(userId,reasonArr);			
		}else if(reasonArr[0].equals("D_R")) {
			result=new AdminService().warningUserCodeD_R(userId,reasonArr);			
			
		}
		else {
			String msg="잘못된 코드를 입력하셨습니다.";
			String loc="/admin/adminList";
			String view="/WEB-INF/views/common/msg.jsp";
			request.setAttribute("loc", loc);
			request.setAttribute("msg", msg);
			
			request.getRequestDispatcher(view).forward(request, response);
		}
		
		
		int countWarning=new AdminService().warningCount(userId);
		
		String msg="";
		String loc="/admin/adminList";
		String view="/WEB-INF/views/common/msg.jsp";
		if(result>0) {
			msg="경고처리완료.이 유저의 현재 경고 횟수는 "+countWarning+"회 입니다.";
		}else {
			msg="경고처리 실패, 담당자에게  확인하여 주세요.";
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
