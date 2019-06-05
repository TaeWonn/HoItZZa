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
		System.out.println("======<PointChargeServlet Start>======");
		// 1. 파라미터 핸들링
		String userId = request.getParameter("userId");
		
		int numPerPage = 7;
		int cPage = 1;
		
		// 2. 업무 로직
		// 현재 페이지의 충전 내역
		List<Point> list = new PointService().selectChargeListById(userId);
		System.out.println("list="+list+", list.size="+list.size());
		
		// 전체 페이지수 구하기
		int totalContents = list.size();
		int totalPage = (int)Math.ceil((double)totalContents/numPerPage);
		
		// 페이지바 구성
		String pageBar = "";
		int pageBarSize = 5;
		// 시작페이지 번호 세팅
		int pageStart = ((cPage-1)/pageBarSize)*pageBarSize+1;
		// 종료페이지 번호 세팅
		int pageEnd = pageStart + (pageBarSize-1);
		int pageNo = pageStart;
		
		System.out.println("pageStart["+pageNo+"] ~ pageEnd["+pageEnd+"]");
		
		// section [prev]
		if(pageNo == 1) {}
		else {
			pageBar += "<a href='"+request.getContextPath()+"/views/point/pointCharge?userId="+userId
					+ "&cPage=" + (pageNo-1) + "'>[이전]</a>";
		}
		
		// pageNo section
		// pageNo<=pageEnd && pageNo<=totalPage
		while(!(pageNo>pageEnd || pageNo > totalPage)) {
			if(cPage == pageNo)
				pageBar += "<span>" + pageNo + "</span>";
			else {
				pageBar += "<a href='"+request.getContextPath()+"/views/point/pointCharge?userId="+userId
						+ "&cPage=" + pageNo + "'>"+pageNo+"</a>";
			}
			
			pageNo++;
		}
		
		// section [next]
		if(pageNo>totalPage) {}
		else {
			pageBar += "<a href='"+request.getContextPath()+"/views/point/pointCharge?userId="+userId
					+ "&cPage="+pageNo+ "'>[다음]</a>";
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
			request.setAttribute("list", list);
		}
		
		request.getRequestDispatcher(view)
			   .forward(request, response);
		System.out.println("======<PointChargeServlet Over>======");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
