package free.controllor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.model.vo.Comment;
import free.model.service.FreeService;

/**
 * Servlet implementation class MediaCommentServlet
 */
@WebServlet("/free/mediaComment")
public class MediaCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNo = request.getParameter("boardNo");
		String commentWriter = request.getParameter("commentWriter");
		String commentContent = request.getParameter("commentContent");
		int commentLevel = Integer.parseInt(request.getParameter("commentLevel"));
		String commentNoRef = request.getParameter("commentNoRef");
		
		
		Comment c = new Comment(commentContent, boardNo, commentWriter, commentLevel, commentNoRef);
		System.out.println(c);
		
		int result = new FreeService().insertMediaComment(c);
		
		
		String msg = null;
		if(result > 0) {
		}else {
			msg = "댓글 오류 발생";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", "/free/freeView?boardNo="+boardNo);
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
