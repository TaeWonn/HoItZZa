package index.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buy.model.vo.Buy;
import free.model.vo.Free;
import index.model.service.IndexService;
import sell.model.vo.Sell;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/views/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//업무로직
		//판매게시판
		List<Sell> sellList=new IndexService().selectSellBoardList();
		System.out.println(sellList);
		//구매게시판
		List<Buy> buyList=new IndexService().selectBuyBoardList();
		System.out.println(buyList);
		//잡담게시판
		List<Free> sudaList=new IndexService().selectSudaBoardList();
		System.out.println(sudaList);
		//연예/미디어 게시판
		List<Free> mediaList=new IndexService().selectMediaBoardList();
		System.out.println(mediaList);
		//유용한 생활지식 게시판
		List<Free> senseList=new IndexService().selectSenseBoardList();
		System.out.println(senseList);
		//나눔게시판
		List<Free> nanumList=new IndexService().selectNanumBoardList();
		System.out.println(nanumList);
		
		
		
		request.setAttribute("sellList", sellList);
		request.setAttribute("buyList", buyList);
		request.setAttribute("sudaList", sudaList);
		request.setAttribute("mediaList", mediaList);
		request.setAttribute("senseList", senseList);
		request.setAttribute("nanumList", nanumList);
		request.setAttribute("stop", "stop");
		
		request.getRequestDispatcher("/").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
