package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;

import models.Book;

@SuppressWarnings("serial")
public class BooksServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("id"));
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean result = false;
		try {
			result = (new Book()).update(Integer.parseInt(req.getParameter("id")), req.getParameter("name"),
					req.getParameter("publisher"), Integer.parseInt(req.getParameter("price")));
		} catch (NumberFormatException | ClassNotFoundException | NamingException | SQLException e) {
			e.printStackTrace();
		}

		// Neu update that bai
		if (!result) {
			log("Update failed !");
			return;
		}

		// Neu update thanh cong
		log("Update successful !");
		resp.sendRedirect("search-form.jsp");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean result = false;
		try {
			result = (new Book()).destroy(Integer.parseInt(req.getParameter("id")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Neu update that bai
		if (!result) {
			log("Update failed !");
			return;
		}

		// Neu update thanh cong
		log("Update successful !");
		resp.sendRedirect("search-form.jsp");
	}
}
