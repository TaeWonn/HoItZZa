package buy.controllor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		
		
		
		String boardTitle = multiReq.getParameter("boardTitle");
		String boardContent = multiReq.getParameter("boardContent");
		String boardWriter = multiReq.getParameter("boardWriter");
		String boardCodeNo = multiReq.getParameter("boardCodeNo");
		String boardDeal = multiReq.getParameter("boardDeal");
		
		int fileCount = 1;
		
		List<String> fileNameList = new ArrayList<>();
		List<String> fileNewNameList = new ArrayList<>();
		for(int i =0; i<fileCount; i++) {
			String fileName = multiReq.getOriginalFileName("upFile"+i);
			String newFileName = multiReq.getFilesystemName("upFile"+i);
			fileNameList.add(fileName);
			fileNewNameList.add(newFileName);
		}
		
		boardContent =boardContent.replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
		
		Buy b = new Buy();
		b.setBoardTitle(boardTitle);
		b.setBoardContent(boardContent);
		b.setBoardWriter(boardWriter);
		b.setBoardDeal(boardDeal);
		b.setBoardCodeNo(boardCodeNo); 
		
		int result = new BuyService().insertBoard(b);
		String boardNo = new BuyService().selectOneBoardNo();
		
		for(int i=0;i<fileCount;i++) {
			FileTable t = new FileTable();
			t.setBoardNo(boardNo);
			t.setOriginalFileName(fileNameList.get(i));
			t.setRenamedFileName(fileNewNameList.get(i));
			new SellService().insertFileTable(t);
		}
		
		String msg = "";
		String loc = "";
		if(result > 0) {
			msg = "게시글등록완료";
			loc = "/buy/buyView?boardNo="+boardNo;
		}else {
			msg = "변경중 오류 발생";
			loc = "/buy/buyList";
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
