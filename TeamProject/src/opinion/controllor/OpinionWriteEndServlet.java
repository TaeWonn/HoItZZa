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
 * Servlet implementation class OpinionWriteEndServlet
 */
@WebServlet("/opinion/opinionWriteEnd")
public class OpinionWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		String boardWriter = request.getParameter("boardWriter");
		
		Opinion o = new Opinion();
		o.setBoardTitle(boardTitle);
		o.setBoardContent(boardContent);
		o.setBoardWriter(boardWriter);
		
		int result = new OpinionService().insertBoard(o);
		String boardNo = "OT_"+ new OpinionService().selectSeqCurr();
		
		String msg = "";
		String loc = "";
		if(result>0) {
			msg = "글 등록 완료";
			loc = "/opinion/opinionView?boardNo=";
		}else {
			msg ="";
			loc ="/";
		}
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
