package servlets;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	public LoginServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		log(username);
		log(password);
		
		// truy van co so du lieu bang model user
		// 
		
		// cau hinh cookie (lam sau)
		//
		
		RequestDispatcher view = req.getRequestDispatcher("search-form.jsp");
		view.forward(req, resp);
		
	}
}
