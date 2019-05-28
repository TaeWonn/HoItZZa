package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import board.model.service.BoardService;
import board.model.vo.Board;
import common.HelloMVCFileRenamePolicy;

/**
 * Servlet implementation class BoardFormEndServlet
 */
@WebServlet("/board/boardFormEnd")
public class BoardFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//enctype=multipart/form-data로 전송여부확인
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "게시판 파일 업로드 오류:관리자에게 문의하세요");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
				   .forward(request, response);
			return;
		}
		
		//MultipartRequest객체 생성준비
//		public MultipartRequest(HttpServletRequest request,
//                String saveDirectory,
//                int maxPostSize,
//                String encoding,
//                FileRenamePolicy policy) 
		//a.파일저장경로
		String saveDirectory = getServletContext().getRealPath("/")+"upload/board";
		System.out.println("saveDirectory="+saveDirectory);
		
		//b.파일최대용량: 10mb
		//파일최대용량을 넘어서면, IOException을 던진다.
		int maxPostSize = 1024*1024*10;
		
		//c.FileRenamePolicy객체 생성
		FileRenamePolicy policy
			= new HelloMVCFileRenamePolicy();

		//MultipartRequest객체 생성
		MultipartRequest multiReq = new MultipartRequest(request, 
														 saveDirectory, 
														 maxPostSize, 
														 "UTF-8", 
														 policy);

		//1.파라미터 핸들링
		//MultipartRequest를 생성후에는 HttpServletRequest객체에서는
		//파라미터값을 가져올 수 없다.
		String boardTitle = multiReq.getParameter("boardTitle");
		String boardWriter = multiReq.getParameter("boardWriter");
		String boardContent = multiReq.getParameter("boardContent");
		String renamedFileName = multiReq.getFilesystemName("upFile");
		String originalFileName = multiReq.getOriginalFileName("upFile");
		
		//xss공격대비 태그문자를 &문자로 치환하기
		boardContent = boardContent.replaceAll("<", "&lt;")
								   .replaceAll(">", "&gt;");
		
		Board b = new Board();
		b.setBoardTitle(boardTitle);
		b.setBoardWriter(boardWriter);
		b.setBoardContent(boardContent);
		b.setRenamedFileName(renamedFileName);
		b.setOriginalFileName(originalFileName);
		
		//2.업무로직
		int result = new BoardService().insertBoard(b);
		
		String msg = "";
		String loc = "/board/boardList";

		if(result>0) {
			msg = "게시글 등록성공!";
			//성공한 경우, result변수에 새로 등록된 글번호를 가져옴.
			loc = "/board/boardView?boardNo="+result;
		}
		else {
			msg = "게시글 등록실패!";
		}
		
		//3.view단 처리
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
