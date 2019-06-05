package sell.controllor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import com.sun.xml.internal.messaging.saaj.soap.MultipartDataContentHandler;

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
		String boardWriter = multiReq.getParameter("boardWriter");
		String category1 = multiReq.getParameter("category1");
		String category2 = multiReq.getParameter("category2");
		String boardCodeNo = "";
		
		if(category2.equals(""))
			boardCodeNo=category1;
		else boardCodeNo=category2;
		
		
		
		File f = multiReq.getFile("upFile");
		
		
		System.out.println("제목"+boardTitle);
		System.out.println("내용"+boardContent);
		System.out.println("거래방식"+boardDeal);
		System.out.println("카테1"+category1);
		System.out.println("카테2"+category2);
		System.out.println("코드"+boardCodeNo);
		System.out.println("작성자"+boardWriter);
		
		System.out.println("이미지 파일 네임 확인 "+multiReq.getOriginalFileName("upFile1"));
		System.out.println("첨부파일 네임 확인 "+multiReq.getOriginalFileName("upFile"));
		int fileCount = 1;
		
		List<String> fileNameList = new ArrayList<>();
		List<String> newFileNameList = new ArrayList<>();
		
		for(int i=0;i<fileCount;i++) {
			String fileName = multiReq.getOriginalFileName("upFile"+i);
			String newFileName = multiReq.getFilesystemName("upFile"+i);
			fileNameList.add(fileName);
			newFileNameList.add(newFileName);
		}
		
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
		
		
		for(int i =0;i<fileCount;i++) {
			FileTable t = new FileTable();
			t.setBoardNo(boardNo);
			t.setOriginalFileName(fileNameList.get(i));
			t.setRenamedFileName(newFileNameList.get(i));
			
			new SellService().insertFileTable(t);
		}
		
		
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "";
		if(result> 0) {
			msg ="글 등록완료";
			loc ="/sell/sellView?boardNo="+boardNo;
		}else {
			msg = "글 등록 실패";
			loc = "/sell/sellList";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
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
