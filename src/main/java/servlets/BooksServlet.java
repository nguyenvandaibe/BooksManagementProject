package servlets;

import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class BooksServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("id"));
	}
}
