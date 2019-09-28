package userServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultUserDAO;
import models.UserData;

public class SaveUserServlet extends HttpServlet {

	private DefaultUserDAO userDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		userDao = DefaultUserDAO.getUserDaoInstance();
		UserData userData = new UserData();
		
		String fname = req.getParameter("fname");
		userData.setFirstName(fname);
		userDao.saveUser(userData);

		PrintWriter writer = resp.getWriter();
		writer.println("Method POST from SaveUserServlet");

		// RequestDispatcher requestDispatcher =
		// req.getRequestDispatcher("views/add.jsp");
		// requestDispatcher.forward(req, resp);

		System.out.println("Post SaveUserServlet");

	}
}