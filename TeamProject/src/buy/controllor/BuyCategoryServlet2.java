package buy.controllor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buy.model.service.BuyService;

/**
 * Servlet implementation class JQueryAjaxAutoCompleteServlet
 */
@WebServlet("/buy/buycategory2")
public class BuyCategoryServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.encoding
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/csv; charset=UTF-8");
		//2.parameter
		String category2 = request.getParameter("category2");
		
		//3.업무로직
		List<String> nameList = null;
		String csv = "";

		if(!category2.trim().isEmpty()) {//공백은 넘어올수 있음. length가 0일때 true리턴함.
			nameList = new BuyService().selectCategoryNo(category2);
		
			if(!nameList.isEmpty()){
				for(int i=0; i< nameList.size(); i++){
					if(i!=0) csv += ",";
					csv +=  nameList.get(i);
				}
			}
		}
		System.out.println(csv);
		
		//4.view단처리
		//csv형태로 응답객체에 출력할 것.
		response.setContentType("text/csv; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.append(csv);

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
