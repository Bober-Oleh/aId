package tourServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultTourDAO;

public class UpdateTourServlet extends HttpServlet {

	private DefaultTourDAO tourDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// boolean updateTour(int idTour, double price);

		// RequestDispatcher requestDispatcher =
		// req.getRequestDispatcher("views/add.jsp");
		// requestDispatcher.forward(req, resp);

		int idTour = Integer.valueOf(req.getParameter("idTour"));
		double newPrice = Double.parseDouble(req.getParameter("price"));

		tourDao = DefaultTourDAO.getTourDaoInstance();

		boolean updateResult = tourDao.updateTour(idTour, newPrice);
		// boolean updateResult = false;

		PrintWriter writer = resp.getWriter();
		writer.println("Method PUT from UpdateTourServlet");
		writer.println("\n");
		writer.println("idTour=" + idTour);
		writer.println("\n");
		if (updateResult == true) {
			writer.println("tour with idTour=" + idTour + " has been updated successfully!");
		} else {
			writer.println("tour with idTour=" + idTour + " has NOT been updated!");
		}

	}
}