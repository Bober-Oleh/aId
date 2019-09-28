package tourServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultTourDAO;
import models.TourData;

public class GetAllToursServlet extends HttpServlet {


	private DefaultTourDAO tourDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		tourDao = DefaultTourDAO.getTourDaoInstance();
		List<TourData> allTours = tourDao.getAllTours();

		PrintWriter writer = resp.getWriter();
		writer.println("Method GET from GetAllToursServlet");

		for (TourData tour : allTours) {
			writer.println("tour=" + tour);
		}
		// RequestDispatcher requestDispatcher =
		// req.getRequestDispatcher("views/add.jsp");
		// requestDispatcher.forward(req, resp);

		System.out.println("Get GetAllToursServlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}