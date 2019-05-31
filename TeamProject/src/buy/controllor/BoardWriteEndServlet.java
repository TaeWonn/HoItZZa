package buy.controllor;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import buy.model.service.BuyService;
import buy.model.vo.Buy;
import common.SellBarFileRenamePolicy;
import file.model.vo.FileTable;
import sell.model.service.SellService;
import sell.model.vo.Sell;

/**
 * Servlet implementation class BoardWriteEndServlet
 */
@WebServlet("/board/boardWriteEnd")
public class BoardWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "게시판 파일업로드 오류");
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
		
		
		
		String boardNo = multiReq.getParameter("boardNo");
		String boardTitle = multiReq.getParameter("boardTitle");
		String boardContent = multiReq.getParameter("boardContent");
		String boardWriter = multiReq.getParameter("boardWriter");
		String boardCodeNo = multiReq.getParameter("boardCodeNo");
		String boardDeal = multiReq.getParameter("boardDeal");
		String renamedFileNameOld = multiReq.getParameter("renamedFileNameOld");
		int fileCount = Integer.parseInt(multiReq.getParameter("fileCount"));
		
		String fileName = multiReq.getOriginalFileName("upFile0");
		String newFileName = multiReq.getFilesystemName("upFile0");
		
		
		String delFile = multiReq.getParameter("delFile");
		File f = multiReq.getFile("upFile0");
		
		boardContent =boardContent.replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
		
		Sell s = new Sell();
		s.setBoardNo(boardNo);
		s.setBoardTitle(boardTitle);
		s.setBoardContent(boardContent);
		s.setBoardDeal(boardDeal);
		s.setBoardCodeNo(boardCodeNo);
		
		int result = new SellService().updateSell(s);
		
		if(f != null) {
			FileTable t = new FileTable();
			t.setBoardNo(boardNo);
			t.setOriginalFileName(fileName);
			t.setRenamedFileName(newFileName);
			new SellService().insertFileTable(t);
			for(int i=1; i<fileCount;i++) {
				String fname = multiReq.getOriginalFileName("upFile"+i);
				String newfname = multiReq.getFilesystemName("upFile"+i);
				
				FileTable ft = new FileTable();
				t.setBoardNo(boardNo);
				t.setOriginalFileName(fname);
				t.setRenamedFileName(newfname);
				new SellService().insertFileTable(ft);
				
			}
		}
		if(delFile != null) {
			boolean bool = new File(saveDirectory+"/"+renamedFileNameOld).delete();
		}
		
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
		
		
		request.setAttribute("sell", s);
		request.getRequestDispatcher("/WEB-INF/views/sell/sellModified.jsp")
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
