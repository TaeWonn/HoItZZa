package free.controllor;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FreeFileDownloadServlet
 */
@WebServlet("/free/fileDownload")
public class FreeFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("======<FreeFileDownloadServlet Start>======");
		// 1. 파라미터 핸들링
		String oName = request.getParameter("oName");
		String rName = request.getParameter("rName");
		
		// 2. 파일 전송
		String saveDir = getServletContext().getRealPath("/upload/free");
		String filePath = saveDir + File.separator + rName;
		
		// 파일입력스트림
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
		// 파일출력스트림
		
		// 3. view단 처리
		System.out.println("======<FreeFileDownloadServlet Over>======");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
