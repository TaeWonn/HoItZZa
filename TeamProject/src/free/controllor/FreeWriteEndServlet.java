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
		
		//////////////////////테스트/////////////////////////////////
		
		ArrayList<String> filename = new ArrayList<String>();
		Enumeration<String> files=multiReq.getFileNames();
		while(files.hasMoreElements()){
			String name = files.nextElement();
			filename.add(multiReq.getFilesystemName(name));
			}
		System.out.println("확ㅇㅣㄴ"+filename);
		
		
		
		
		String originName=multiReq.getFilesystemName("imgFile[]");
		String originName2=multiReq.getFilesystemName("upFile[]");
		
		
		System.out.println("확인"+boardTitle);
		System.out.println("확인"+originName);
		System.out.println("확인"+originName2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		// 자유게시판이기 때문에 게시판 카테고리 분류, 거래방식이 들어가지 않는다. 
		// 우선 주석 처리 후, 상의 요망 요청.
//		String boardCodeNo = multiReq.getParameter("boardCodeNo");
//		String boardDeal = multiReq.getParameter("boardDeal");
		String renamedFileNameOld = multiReq.getParameter("renamedFileNameOld");
		int fileCount = Integer.parseInt(multiReq.getParameter("fileCount"));
		
		String fileName = multiReq.getOriginalFileName("upFile[]");
		String newFileName = multiReq.getFilesystemName("upFile[]");
		
		String delFile = multiReq.getParameter("delFile");
		File file = multiReq.getFile("upFile0");
		
		// 2. 업무 로직
		boardContent = boardContent.replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
		
		Free f = new Free();
		f.setBoardTitle(boardTitle);
		f.setBoardContent(boardContent);
		f.setBoardWriter(boardWriter);
		
		int result = new FreeService().insertBoard(f);
		String boardNo = "FC_"+ new FreeService().selectSeq();
		
		if(f != null) {
			FileTable t = new FileTable();
			t.setBoardNo(boardNo);
			t.setOriginalFileName(fileName);
			t.setRenamedFileName(newFileName);
			new FreeService().insertFileTable(t);
			for(int i=1 ; i<fileCount ; i++) {
				String fname = multiReq.getOriginalFileName("upFile"+i);
				String newfname = multiReq.getFilesystemName("upFile"+i);
				
				FileTable ft = new FileTable();
				ft.setBoardNo(boardNo);
				ft.setOriginalFileName(fname);
				ft.setRenamedFileName(newfname);
				new FreeService().insertFileTable(ft);
			}
		}
		
		// 3. view단 처리
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/";
		if(result>0) {
			msg = "게시글 작성 완료.";
			loc = "/free/freeView?boardNo"+f.getBoardNo();
			request.setAttribute("free", f);
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
