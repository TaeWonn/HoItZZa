package free.controllor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
		ServletOutputStream sos = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(sos);
		
		// 파일명 인코딩처리(한글깨짐방지)
		String resFileName = "";
		boolean isMSIE = request.getHeader("user-agent").indexOf("MSIE") != -1
					|| request.getHeader("user-agent").indexOf("Trident") != -1;
		if(isMSIE) {
			resFileName = URLEncoder.encode(oName, "UTF-8");
			// 공백을 +로 치환 -> %20
			resFileName = resFileName.replaceAll("\\+", "%20");
		}
		
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
