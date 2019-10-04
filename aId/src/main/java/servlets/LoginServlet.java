package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import impl.DefaultUserDAO;
import models.UserData;

public class LoginServlet extends HttpServlet {

	public DefaultUserDAO userDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");

		userDao = DefaultUserDAO.getUserDaoInstance();
		List<UserData> allUsers = userDao.getAllUsers();

		boolean isUserRegistered = false;
		boolean isUserAdmin = false;

		for (UserData user : allUsers) {
			if (user.getEmail().equals(String.valueOf(userEmail))) {
				isUserRegistered = true;
				if (user.getIdRole() == 5) {
					isUserAdmin = true;
				}
				break;
			}
		}

		// if (userEmail.equals("asd@asd")) {

		if (isUserRegistered == true) {
//			isUserRegistered = false;
			UserData userData = new UserData();
//			userData.setIdRole(5);// 5 - admin; else - guest
			HttpSession session = request.getSession();
			session.setAttribute("userEmail", userEmail);
			session.setAttribute("loggedInUser", userData);
			response.sendRedirect(getServletContext().getContextPath() + "/myaccount");
		} else {
			request.setAttribute("errorMessage", "incorrect email");
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
		}

	}

}