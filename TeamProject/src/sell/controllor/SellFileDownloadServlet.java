package sell.controllor;

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
 * Servlet implementation class SellFileDownloadServlet
 */
@WebServlet("/sell/fileDownload")
public class SellFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 핸들링
		String oName = request.getParameter("oName");
		String rName = request.getParameter("rName");
		
		System.out.println("oName = "+oName+ ", rName = "+ rName );
		
		// 파일전송
		String saveDirectory = getServletContext().getRealPath("/upload/sell");
		String filePath = saveDirectory+"/"+rName;
		//   '/' 대신 옛날에는 File.separtor 사용
		//   os마다 파일경로 구분자가 다르기때문에 
		//     유닉스, 리눅스, 맥 -> /
		//  window 경우는  \를 사용.
		
		// 파일 입력 스트림
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
		
		// 파일 출력 스트림 : 응답객체에 쓰기용
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
