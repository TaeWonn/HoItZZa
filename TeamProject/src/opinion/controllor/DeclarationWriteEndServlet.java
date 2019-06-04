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
 * Servlet implementation class DeclarationWriteEndServlet
 */
@WebServlet("/opinion/declarationWriteEnd")
public class DeclarationWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardTitle = request.getParameter("boardTitle");
		String boardWriter = request.getParameter("boardWriter");
		String boardContent = request.getParameter("boardContent");
		
		Opinion o = new Opinion();
		o.setBoardTitle(boardTitle);
		o.setBoardContent(boardContent);
		o.setBoardWriter(boardWriter);
		
		int result = new OpinionService().insertDeclaration(o);
		
		String msg = "";
		String loc ="";
		if(result > 0) {
			msg ="글 등록 완료";
			loc ="/opinion/declarationList";
		}else {
			msg ="글등록실패";
			loc ="/opinion/declarationList";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
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
