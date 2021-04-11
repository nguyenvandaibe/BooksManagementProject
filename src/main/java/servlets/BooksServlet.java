package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;

import models.Book;

@SuppressWarnings("serial")
public class BooksServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String action = request.getParameter("action");

		try {
			Book book = (new Book()).getById(id);

			if (action != null) {
				switch (action) {
				case "edit": {
					// Hien thi form edit
					try {
						showEditForm(request, response, book);
					} catch (ClassNotFoundException | SQLException | NamingException | ServletException
							| IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				case "destroy": {
					// Hien thi form destroy
				}
				}
			}
		} catch (ClassNotFoundException | SQLException | NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String action = request.getParameter("action");
		try {
			Book book = (new Book()).getById(id);
			switch (action) {
			case "update": {
				if (update(request, response, book)) {
					Book updatedBook = (new Book()).getById(id);
					showEditForm(request, response, updatedBook);
				} else {
					log("false");
				}
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + action);
			}
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	/**
	 * @param request
	 * @param response
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws NamingException
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showEditForm(HttpServletRequest request, HttpServletResponse response, Book book)
			throws ClassNotFoundException, SQLException, NamingException, ServletException, IOException {
		request.setAttribute("book", book);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit-form.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @param request
	 * @param response
	 * @param book
	 * @throws SQLException 
	 * @throws NamingException 
	 * @throws ClassNotFoundException 
	 */
	private boolean update(HttpServletRequest request, HttpServletResponse response, Book book) throws ClassNotFoundException, NamingException, SQLException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String publisher = request.getParameter("publisher");
		Integer price = Integer.parseInt(request.getParameter("price"));
		return (new Book()).update(id, name, publisher, price);
	}
}
