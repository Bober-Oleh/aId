package tourServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultTourDAO;

public class DeleteTourServlet extends HttpServlet {

	private DefaultTourDAO tourDao;

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

		int idTour = Integer.valueOf(req.getParameter("idTour"));

		tourDao = DefaultTourDAO.getTourDaoInstance();
		boolean deleteResult = tourDao.deleteTour(idTour);
		// boolean deleteResult = false;

		PrintWriter writer = resp.getWriter();
		writer.println("Method DELETE from DeleteTourServlet");
		writer.println("\n");
		writer.println("idTour=" + idTour);
		writer.println("\n");
		if (deleteResult == true) {
			writer.println("tour with idTour=" + idTour + " has been deleted successfully!");
			deleteResult = false;
		} else {
			writer.println("tour with idTour=" + idTour + " has NOT been deleted!");
		}

	}

}