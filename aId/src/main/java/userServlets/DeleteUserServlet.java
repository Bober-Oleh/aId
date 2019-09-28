package userServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultUserDAO;

public class DeleteUserServlet extends HttpServlet {

	private DefaultUserDAO userDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// RequestDispatcher requestDispatcher =
		// req.getRequestDispatcher("views/add.jsp");
		// requestDispatcher.forward(req, resp);

		int idUser = Integer.valueOf(req.getParameter("idUser"));

		userDao = DefaultUserDAO.getUserDaoInstance();
		boolean deleteResult = userDao.deleteUser(idUser);
		// boolean deleteResult = false;

		PrintWriter writer = resp.getWriter();
		writer.println("Method DELETE from DeleteUserServlet");
		writer.println("\n");
		writer.println("idUser=" + idUser);
		writer.println("\n");
		if (deleteResult == true) {
			writer.println("user with idUser=" + idUser + " has been deleted successfully!");
			deleteResult = false;
		} else {
			writer.println("user with idUser=" + idUser + " has NOT been deleted!");
		}

	}

}
