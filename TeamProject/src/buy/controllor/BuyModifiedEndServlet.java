package buy.controllor;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import buy.model.service.BuyService;
import buy.model.vo.Buy;
import common.SellBarFileRenamePolicy;
import file.model.vo.FileTable;
import sell.model.service.SellService;
import sell.model.vo.Sell;

/**
 * Servlet implementation class BuyModifiedEndServlet
 */
@WebServlet("/buy/buyModifiedEnd")
public class BuyModifiedEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String boardNo = request.getParameter("boardNo");
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		String boardCodeNo = request.getParameter("boardCodeNo");
		String boardDeal = request.getParameter("boardDeal");
		
		Buy b = new Buy();
		b.setBoardNo(boardNo);
		b.setBoardTitle(boardTitle);
		b.setBoardContent(boardContent);
		b.setBoardDeal(boardDeal);
		b.setBoardCodeNo(boardCodeNo);
		
		int result = new BuyService().updateBuy(b);
		
		
		String msg = "";
		String loc = "";
		if(result > 0) {
			msg = "게시글변경완료";
			loc = "/buy/buyView?boardNo="+b.getBoardNo();
		}else {
			msg = "변경중 오류 발생";
			loc = "/";
		}
		
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
