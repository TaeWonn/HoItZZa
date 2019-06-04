package opinion.controllor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import opinion.model.service.OpinionService;
import opinion.model.vo.Opinion;

/**
 * Servlet implementation class DeclarationViewServlet
 */
@WebServlet("/opinion/declaration")
public class DeclarationViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNo = request.getParameter("boardNo");
		
		Opinion o = new OpinionService().selectOneBoard(boardNo);
		
		if(o == null) {
			request.setAttribute("msg", "게시글이 존재하지않습니다");
			request.setAttribute("loc", "/opinion/declarationList");
			request.getRequestDispatcher("/WEV-INF/views/common/msg.jsp")
					.forward(request, response);
			return;
		}
		
		request.setAttribute("declaration", o);
		request.getRequestDispatcher("/WEB-INF/views/opinion/declarationView.jsp")
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
