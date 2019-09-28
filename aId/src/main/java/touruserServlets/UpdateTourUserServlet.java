package touruserServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultTourUserDAO;

public class UpdateTourUserServlet extends HttpServlet {

	private DefaultTourUserDAO touruserDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// boolean updateTourUser(int idTour,int idUser, int idTour,int idUser);

		// RequestDispatcher requestDispatcher =
		// req.getRequestDispatcher("views/add.jsp");
		// requestDispatcher.forward(req, resp);

		int idTour = Integer.parseInt(req.getParameter("idTour"));
		int idUser = Integer.parseInt(req.getParameter("idUser"));
		int newIdTour = Integer.parseInt(req.getParameter("idTour"));
		int newIdUser = Integer.parseInt(req.getParameter("idUser"));

		touruserDao = DefaultTourUserDAO.getTourUserDaoInstance();

		boolean updateResult = touruserDao.updateTourUser( idTour, idUser,  idTour, idUser);
		
		// boolean updateResult = false;

		PrintWriter writer = resp.getWriter();
		writer.println("Method PUT from UpdateTourUserServlet");
		writer.println("\n");
		writer.println("idTour=" + idTour);
		writer.print("idUser=" + idUser);
		writer.println("\n");
		if (updateResult == true) {
			writer.println("touruser with idTour and idUser=" + idTour + idUser + " has been updated successfully!");
		} else {
			writer.println("touruser with idTour and idUser=" + idTour + idUser + " has NOT been updated!");
		}

	}
}