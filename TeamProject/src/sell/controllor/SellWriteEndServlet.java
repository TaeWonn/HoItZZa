package sell.controllor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import common.SellBarFileRenamePolicy;
import file.model.vo.FileTable;
import sell.model.service.SellService;
import sell.model.vo.Sell;

/**
 * Servlet implementation class SellWriteEndServlet
 */
@WebServlet("/sell/sellWriteEnd")
public class SellWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "게시판 파일업로드오류");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
					.forward(request, response);
			return;
		}
		String saveDirectory = getServletContext().getRealPath("/")+"upload/sell";
		
		int maxPostSize = 1024 * 1024 * 30;
		FileRenamePolicy policy 
			= new SellBarFileRenamePolicy();
		
		MultipartRequest multiReq = new MultipartRequest(request, saveDirectory,
				maxPostSize, "UTF-8", policy);
		
		
		
		String boardTitle = multiReq.getParameter("boardTitle");
		String boardContent = multiReq.getParameter("boardContent");
		String boardDeal = multiReq.getParameter("boardDeal");
		String boardCodeNo = multiReq.getParameter("boardCodeNo");
		String boardWriter = multiReq.getParameter("boardWriter");
		
		String originalFileName = multiReq.getOriginalFileName("upFile");
		String renamedFileName = multiReq.getFilesystemName("upFile");
		
		boardContent =boardContent.replaceAll("<", "&lt;")
								.replaceAll(">", "&gt;");
		
		Sell s = new Sell();
		s.setBoardTitle(boardTitle);
		s.setBoardContent(boardContent);
		s.setBoardDeal(boardDeal);
		s.setBoardCodeNo(boardCodeNo);
		s.setBoardWriter(boardWriter);
		
		int result = new SellService().insertSell(s);
		String boardNo = new SellService().selectOneBoardNo();
		
		FileTable t = new FileTable();
		t.setBoardNo(boardNo);
		t.setOriginalFileName(originalFileName);
		t.setRenamedFileName(renamedFileName);
		
		int res = new SellService().insertFileTable(t);
		
		String view ="";
		String msg = "";
		String loc = "";
		if(result> 0) {
			view ="/WEB-INF/views/sell/sellComplete.jsp";
		}else if(res == 0) {
			view = "/WEB-INF/views/common/msg.jsp";
			msg = "파일 업로딩 오류";
			loc = "/sell/sellList"; 
		} else {
			msg = "글 등록 실패";
			loc = "/sell/sellList";
			view = "/WEB-INF/views/common/msg.jsp";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
		}
		request.getRequestDispatcher(view)
				.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
