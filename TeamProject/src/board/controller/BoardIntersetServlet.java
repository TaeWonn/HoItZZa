package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;

/**
 * Servlet implementation class BuyIntersetServlet
 */
@WebServlet("/board/boardinterest")
public class BoardIntersetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("드롸지나");
		
		//1.encoding
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/csv; charset=UTF-8");
		//2.parameter
		String userId = request.getParameter("userId");
		String boardNo = request.getParameter("boardNo");
		System.out.println(userId);
		System.out.println(boardNo);
		
		//3.업무로직 	
		String csv = "";

		if(!userId.trim().isEmpty()&&!boardNo.trim().isEmpty()) {//공백은 넘어올수 있음. length가 0일때 true리턴함.
			int result = new BoardService().interestAdd(userId,boardNo);
		
			if(result==1)csv="성공";
		}
		System.out.println(csv);
		
		//4.view단처리
		//csv형태로 응답객체에 출력할 것.
		response.setContentType("text/csv; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.append(csv);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
