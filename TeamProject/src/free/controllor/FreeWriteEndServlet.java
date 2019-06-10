package free.controllor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

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
import free.model.service.FreeService;
import free.model.vo.Free;

/**
 * Servlet implementation class FreeWriteEndServlet
 */
@WebServlet("/free/freFormEnd")
public class FreeWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// !!!파일 저장 코드(아직 완성 안 됨. 파일 처리 상의 후 후속 작성 요망.)!!!
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "게시판 파일 업로드 오류");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
				   .forward(request, response);
			return;
		}
		// 저장경로, 파일 크게 제한, 서버용 리네이밍 파일명 방식 지정 
		String saveDirectory = getServletContext().getRealPath("/") + "upload/free";
		int maxPostSize = 1024 * 1024 * 30;
		FileRenamePolicy policy = new SellBarFileRenamePolicy();
		
		// 파일 업로드를 위해 MultipartRequest 객체를 생성해 위에서 지정한 방식 전달
		MultipartRequest multiReq = 
				new MultipartRequest(request, saveDirectory, maxPostSize, "UTF-8", policy);
		
		// 1. 파라미터 핸들링
		// 보드넘버는 시퀀스로 처리할것. String boardNo = multiReq.getParameter("boardNo");
		String boardTitle = multiReq.getParameter("boardTitle");
		String boardContent = multiReq.getParameter("boardContent");
		String boardWriter = multiReq.getParameter("boardWriter");
		String boardCodeNo=multiReq.getParameter("boardCodeNo");

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
		
		
		//사용자가 스크립트문으로 가지고 놀지 못하게 하기.
		boardContent=boardContent.replaceAll("<","&lt;").replaceAll(">", "&gt;");



		// 2. 업무 로직
		
		Free f = new Free();
		f.setBoardTitle(boardTitle);
		f.setBoardContent(boardContent);
		f.setBoardWriter(boardWriter);
		f.setBoardCodeNo(boardCodeNo);
		
		String boardNo = new FreeService().insertBoard(f);
		
		
		Free fResult=new FreeService().selectOneFree(boardNo); 
		
		if(fResult != null) {
			//이미지파일
			FileTable imgFile = new FileTable();
			if(imgFile!=null) {
				imgFile.setBoardNo(boardNo);
				imgFile.setOriginalFileName(imageOriginName);
				imgFile.setRenamedFileName(imageRenamedName);
				new FreeService().insertFileTable(imgFile);
			}
			
			//파일
			FileTable file=new FileTable();
			if(file!=null) {
				file.setBoardNo(boardNo);
				file.setOriginalFileName(fileOriginName);
				file.setRenamedFileName(fileRenamedName);
				new FreeService().insertFileTable(file);
			}
			
			
		}
		System.out.println("작성한 게시물"+fResult);
		 
		// 3. view단 처리
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/";
		if(boardNo!=null) {
			msg = "게시글 작성 완료.";
			loc = "/free/freeView?boardNo="+boardNo;
		}
		else {
			msg = "게시글 작성 실패";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
