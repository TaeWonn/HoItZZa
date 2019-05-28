package board.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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
 * Servlet implementation class BoardFileDownloadServlet
 */
@WebServlet("/board/boardFileDownload")
public class BoardFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.파라미터 핸들링
		String oName = request.getParameter("oName");
		String rName = request.getParameter("rName");
		
		System.out.println("oName="+oName+", rName="+rName);
		
		//2.파일 전송
		String saveDirectory = getServletContext().getRealPath("/upload/board");
		String filePath = saveDirectory+"/"+rName;
		//String filePath = saveDirectory+File.separator+rName;
		//os마다 파일경로구분자가 다르기때문에 
		//유닉스, 리눅스, 맥 -> /
		//windows 경우는 \ 를 사용.
		//파일입력스트림
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
		//파일출력스트림: 응답객체에 쓰기용
		ServletOutputStream sos = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(sos);
		
		
		//파일명 인코딩처리(한글깨짐방지)
		String resFileName = "";
		boolean isMSIE = request.getHeader("user-agent").indexOf("MSIE") != -1
					|| request.getHeader("user-agent").indexOf("Trident") != -1;
		System.out.println("user-agent="+request.getHeader("user-agent"));
		//msie인 경우
		if(isMSIE) {
			resFileName = URLEncoder.encode(oName, "UTF-8");//유니코드문자변환
			//공백을 +로 치환 => %20
			System.out.println("공백이 있는 파일명(+여부 확인)="+resFileName);
			resFileName = resFileName.replaceAll("\\+", "%20");
		}
		//그 외브라우져인경우
		else {
			resFileName = new String(oName.getBytes("UTF-8"),"ISO-8859-1");
		}

		System.out.println("resFileName="+resFileName);
		
		//response객체 헤더작성
		//application/octet-stream: 이진데이터(파일)을 전송할때 사용하는 MIME타입
		response.setContentType("application/octet-stream");
		response.setHeader("content-disposition", "attachment;fileName="+resFileName);
		
		//파일쓰기
		int read = -1;
		while((read=bis.read()) != -1) {
			bos.write(read);
		}
		
		bos.close();
		bis.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
