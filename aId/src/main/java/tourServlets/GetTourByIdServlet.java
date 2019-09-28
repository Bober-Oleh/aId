package tourServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultTourDAO;
import models.TourData;

public class GetTourByIdServlet extends HttpServlet {

	private DefaultTourDAO tourDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// RequestDispatcher requestDispatcher =
		// req.getRequestDispatcher("views/add.jsp");
		// requestDispatcher.forward(req, resp);

		int idTour = Integer.valueOf(req.getParameter("idTour"));

		tourDao = DefaultTourDAO.getTourDaoInstance();
		TourData tourById = tourDao.getTourById(idTour);

		PrintWriter writer = resp.getWriter();
		//writer.println("Method GET from GetTourByIdServlet");
		//writer.println("\n");
		//writer.println("idTour=" + idTour);
		//writer.println("\n");
		writer.println("tour=" + tourById);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}