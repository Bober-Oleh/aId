package userServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultUserDAO;
import models.UserData;

public class GetAllUsersServlet extends HttpServlet {

	private DefaultUserDAO userDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		userDao = DefaultUserDAO.getUserDaoInstance();
		List<UserData> allUsers = userDao.getAllUsers();

		PrintWriter writer = resp.getWriter();
		writer.println("Method GET from GetAllUsersServlet");

		for (UserData user : allUsers) {
			writer.println("user=" + user);
		}
		// RequestDispatcher requestDispatcher =
		// req.getRequestDispatcher("views/add.jsp");
		// requestDispatcher.forward(req, resp);

		System.out.println("Get GetAllUsersServlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}