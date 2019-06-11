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

		//파일명 인코딩 처리(한글 꺠짐 방지)
		String resFileName = "";
		boolean isMSIE = request.getHeader("user-agent").indexOf("MSIE") != -1
							|| request.getHeader("user-agent").indexOf("Trident") != -1;
		System.out.println("user-agent = "+request.getHeader("user-agent"));
		//msie 인경우
		if(isMSIE) {
			resFileName = URLEncoder.encode(oName, "UTF-8");  //유니코드문자로 변환
			//공백을 + 로 치환 => %20
			System.out.println("공백이 있는 파일명 (+여부 확인) = "+resFileName);
			resFileName = resFileName.replace("\\+", "%20");
		//그 외 브라우저
		}else {
			resFileName = new String(oName.getBytes("UTF-8"),"ISO-8859-1");
		}
		System.out.println("resFileName = "+resFileName);
		
		//response 객체 헤더작성
		//application/octet-stream : 이진데이터(파일)을 전송할떄 사용하는 MIME타입
		response.setContentType("application/octet-stream");
		response.setHeader("content-disposition", "attachment;fileName="+resFileName);
		
		//파일쓰기
		int read = -1;
		while((read=bis.read()) != -1) {
			bos.write(read);
		}
		
		bos.close();
		bis.close();
		
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
