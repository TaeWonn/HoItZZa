package point.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import point.model.service.PointService;
import point.model.vo.Point;

/**
 * Servlet implementation class PointChargeEndServlet
 */
@WebServlet("/views/point/pointChargeEnd")
public class PointChargeEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파라미터 핸들링
		String chargeWriter = request.getParameter("userId");
		int chargeMoney = 0;
		try {
			chargeMoney = Integer.parseInt(request.getParameter("chargeMoney"));
		} catch(NumberFormatException e) {}
		
		Point p = new Point();
		p.setChargeWriter(chargeWriter);
		p.setChargeMoney(chargeMoney);
		
		// 2. 업무 로직
		int result = new PointService().chargePoint(p);
		
		// 3. view단 처리
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "";
		if(result>0) {
			msg = chargeMoney + "포인트를 충전했습니다!다시 로그인해 주세요!";
			loc = "/views/user/userLogout";
		}
		else {
			msg = "포인트 충전에 실패했습니다.";
			loc = "/views/point/pointCharge?userId="+chargeWriter;
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher(view)
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
