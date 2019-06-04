package sell.controllor;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import common.SellBarFileRenamePolicy;
import file.model.vo.FileTable;
import sell.model.service.SellService;
import sell.model.vo.Sell;
import user.model.vo.User;

/**
 * Servlet implementation class SellModifiedServlet
 */
@WebServlet("/sell/sellModifiedEnd")
public class SellModifiedEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNo = request.getParameter("boardNo");
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		String boardCodeNo = request.getParameter("boardCodeNo");
		String boardDeal = request.getParameter("boardDeal");
		
		Sell s = new Sell();
		s.setBoardNo(boardNo);
		s.setBoardTitle(boardTitle);
		s.setBoardContent(boardContent);
		s.setBoardDeal(boardDeal);
		s.setBoardCodeNo(boardCodeNo);
		
		int result = new SellService().updateSell(s);
		
		String msg = "";
		String loc = "";
		if(result > 0) {
			msg = "게시글변경완료";
			loc = "/sell/sellView?boardNo="+s.getBoardNo();
		}else {
			msg = "변경중 오류 발생";
			loc = "/";
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
