package touruserServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultTourUserDAO;
import models.TourUserData;

public class GetAllToursUsersServlet extends HttpServlet {

	private DefaultTourUserDAO touruserDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		touruserDao = DefaultTourUserDAO.getTourUserDaoInstance();
		List<TourUserData> allToursUsers = touruserDao.getAllToursUsers();

		PrintWriter writer = resp.getWriter();
		writer.println("Method GET from GetAllToursUsersServlet");

		for (TourUserData touruser : allToursUsers) {
			writer.println("touruser=" + touruser);
		}
		// RequestDispatcher requestDispatcher =
		// req.getRequestDispatcher("views/add.jsp");
		// requestDispatcher.forward(req, resp);

		System.out.println("Get GetAllToursUsersServlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}