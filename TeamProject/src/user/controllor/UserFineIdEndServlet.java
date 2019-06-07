package user.controllor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserFineIdEndServlet
 */
@WebServlet("/views/user/findIdEnd")
public class UserFineIdEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//유저가 있는지 확인 후에 해당 유저의 아이디값을 findId.jsp 로 보내준다.
		String userId=request.getParameter("userId");
		System.out.println("아이디찾기 END Servlet"+userId);
		
		request.setAttribute("userId", userId);
		request.getRequestDispatcher("/WEB-INF/views/user/findId.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
