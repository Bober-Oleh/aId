package touruserServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultTourUserDAO;

public class DeleteTourUserServlet extends HttpServlet {

	private DefaultTourUserDAO touruserDao;

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
		int idUser = Integer.valueOf(req.getParameter("idUser"));

		touruserDao = DefaultTourUserDAO.getTourUserDaoInstance();
		boolean deleteResult = touruserDao.deleteTourUser(idTour, idUser);
		// boolean deleteResult = false;

		PrintWriter writer = resp.getWriter();
		writer.println("Method DELETE from DeleteUserServlet");
		writer.println("\n");
		writer.println("idTour=" + idTour);
		writer.print("idUser=" + idUser);
		writer.println("\n");
		if (deleteResult == true) {
			writer.println("touruser with idTour= and idUser=" + idTour + idUser + " has been deleted successfully!");
			deleteResult = false;
		} else {
			writer.println("touruser with idTour= and idUser=" + idTour + idUser + " has NOT been deleted!");
		}

	}

}
