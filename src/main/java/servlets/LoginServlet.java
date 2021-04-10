package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;

import models.User;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	public LoginServlet() throws NamingException {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		log(username);
		log(password);

		try {
			// truy van co so du lieu bang model user
			if ((new User()).login(username, password)) {
				// cau hinh cookie (lam sau)

				resp.sendRedirect("search-form.jsp");
			} else {
				log("Thong tin dang nhap khong dung");
				String url = "/login.jsp";
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
				requestDispatcher.forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
		}

	}
}
