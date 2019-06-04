package point.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import point.model.service.PointService;
import point.model.vo.Point;
import user.model.vo.User;

/**
 * Servlet implementation class PointChargeServlet
 */
@WebServlet("/views/point/pointCharge")
public class PointChargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파라미터 핸들링
		String userId = request.getParameter("userId");
		
		int cPage = 1;
		int numPerPage = 7;
		
		// 2. 업무 로직
		List<Point> list = new PointService().selectChargeListById(userId);
		
		int totalContents = list.size();
		int totalPage = (int)Math.ceil((double)totalContents/numPerPage);
		int pageBarSize = 10;
		int pageStart = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageStart + (pageBarSize-1);
		int pageNo = pageStart;
		
		String pageBar = "";
		
		// section [prev]
		if(pageNo == 1) {}
		else {
			pageBar += "<a href='"+request.getContextPath()+"/views/point/pointCharge?userId="+userId
					+ "&cPage="+(pageNo-1)
					+ "&numPerPage="+numPerPage+"'>[이전]</a>";
		}
		
		// pageNo section
		while(pageNo <= pageEnd && pageNo <= totalPage) {
			pageBar += "<a href='"+request.getContextPath()+"/views/point/pointCharge?userId="+userId
					+ "cPage="+(pageNo-1)
					+ "&numPerPage="+numPerPage+"'>[이전]</a>";
		}
		
		// section [next]
		if(pageNo>totalPage) {}
		else {
			pageBar += "<a href='"+request.getContextPath()+"/views/point/pointCharge?userId="+userId
					+ "cPage="+pageNo
					+ "&numPerPage="+numPerPage+"'>[다음]</a>";
		}
		// 3. view단 처리
		String view = "";
		String msg = "";
		String loc = "";
		if(userId==null && "".equals(userId)) {
			view = "/WEB-INF/views/common/msg.jsp";
			msg = "회원 아이디를 찾을 수 없습니다.";
			loc = "/";
			
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
		}
		else {
			view = "/WEB-INF/views/point/pointCharge.jsp";
			request.setAttribute("cPage", cPage);
			request.setAttribute("numPerPage", numPerPage);
			request.setAttribute("pageBar", pageBar);
			request.setAttribute("chargeList", list);
		}
		
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
