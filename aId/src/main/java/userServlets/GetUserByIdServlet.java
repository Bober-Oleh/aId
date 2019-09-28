package userServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultUserDAO;
import models.UserData;

public class GetUserByIdServlet extends HttpServlet {

	private DefaultUserDAO userDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// RequestDispatcher requestDispatcher =
		// req.getRequestDispatcher("views/add.jsp");
		// requestDispatcher.forward(req, resp);

		int idUser = Integer.valueOf(req.getParameter("idUser"));

		userDao = DefaultUserDAO.getUserDaoInstance();
		UserData userById = userDao.getUserById(idUser);

		PrintWriter writer = resp.getWriter();
		//writer.println("Method GET from GetUserByIdServlet");
		//writer.println("\n");
		//writer.println("idUser=" + idUser);
		//writer.println("\n");
		writer.println("user=" + userById);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}