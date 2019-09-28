package touruserServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultTourUserDAO;
import models.TourUserData;

public class GetTourUserByTourIdAndByUserIdServlet extends HttpServlet {

	private DefaultTourUserDAO touruserDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// RequestDispatcher requestDispatcher =
		// req.getRequestDispatcher("views/add.jsp");
		// requestDispatcher.forward(req, resp);
		int idTour = Integer.valueOf(req.getParameter("idTour"));
		int idUser = Integer.valueOf(req.getParameter("idUser"));

		touruserDao = DefaultTourUserDAO.getTourUserDaoInstance();
		TourUserData touruserById = touruserDao.getTourUserByIdTourAndByIdUser(idTour, idUser);

		PrintWriter writer = resp.getWriter();
		// writer.println("Method GET from GetTourUserByIdServlet");
		// writer.println("\n");
		// writer.println("idUser=" + idUser);
		// writer.println("\n");
		writer.println("touruser=" + touruserById);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}