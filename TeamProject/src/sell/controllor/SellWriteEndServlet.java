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
import free.model.service.FreeService;
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
		String boardCodeNo = multiReq.getParameter("boardCodeNo");
		
		String fileOriginName= multiReq.getOriginalFileName("upFile");
		String fileRenamedName= multiReq.getFilesystemName("upFile");
		
		String imageOriginName=multiReq.getOriginalFileName("imgFile");
		String imageRenamedName=multiReq.getFilesystemName("imgFile");
		
		System.out.println("넘어온 값 전체확인");
		System.out.println(boardTitle+"제목");
		System.out.println(boardContent+"내용");
		System.out.println(boardWriter+"작성자");
		System.out.println(boardCodeNo+"게시글코드");
		System.out.println(imageOriginName+"이미지 오리지날네임");
		System.out.println(imageRenamedName+"이미지 바뀐네임");
		System.out.println(fileOriginName+"파일 오리지날네임");
		System.out.println(fileRenamedName+"파일 바뀐네임");

		
		boardContent =boardContent.replaceAll("<", "&lt;")
								.replaceAll(">", "&gt;");
		
		Sell s = new Sell();
		s.setBoardTitle(boardTitle);
		s.setBoardContent(boardContent);
		s.setBoardDeal(boardDeal);
		s.setBoardCodeNo(boardCodeNo);
		s.setBoardWriter(boardWriter);
		
		String boardNo  = new SellService().insertSell(s);
		System.out.println("보드넘버 확인"+boardNo);
		Sell sell=new SellService().selectOneSell(boardNo);
		
		if(sell != null) {
			//이미지파일
			FileTable imgFile = new FileTable();
			
				imgFile.setBoardNo(boardNo);
				imgFile.setOriginalFileName(imageOriginName);
				imgFile.setRenamedFileName(imageRenamedName);
				new SellService().insertFileTable(imgFile);
		}
			
			//파일
		if(sell != null) {
		FileTable file=new FileTable();
		
			file.setBoardNo(boardNo);
			file.setOriginalFileName(fileOriginName);
			file.setRenamedFileName(fileRenamedName);
			new SellService().insertFileTable(file);
		}
			
		System.out.println("작성한 게시물"+sell);
		
		
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "";
		if(boardNo!=null) {
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
