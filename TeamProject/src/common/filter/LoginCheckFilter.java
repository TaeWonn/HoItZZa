package common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import user.model.vo.User;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter(servletNames = { "BoardModifiedServlet" ,
					"BoardCommentDeleteServlet",
					"BoardInterestCheckServlet",
					"BoardIntersetDeleteServlet",
					"BoardIntersetServlet",
					"BoardWriteServlet",
					"BuyingServlet",
					"OpinionWriteServlet",
					"FreeWriteServlet",
					"DeclarationWriteServlet",
					"SellModifiedServlet",
					"SellWriteServlet",
					"DeclarationListServlet",
					"OpinionListServlet"
					})
public class LoginCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hreq = (HttpServletRequest)request;
		HttpSession session = hreq.getSession();
		User userLoggedIn = (User)session.getAttribute("userLoggedIn");
		
		if(userLoggedIn == null || userLoggedIn.getUserId()== null) {
			request.setAttribute("msg", "로그인 후 이용 가능합니다");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
					.forward(request, response);
			return;
		}
		
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
