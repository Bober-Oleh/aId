package tourServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultTourDAO;
import models.TourData;

public class SaveTourServlet extends HttpServlet {

	private DefaultTourDAO tourDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		tourDao = DefaultTourDAO.getTourDaoInstance();
		TourData tourData = new TourData();

		String tname = req.getParameter("tname");
		tourData.setTitle(tname);
		tourDao.saveTour(tourData);

		PrintWriter writer = resp.getWriter();
		writer.println("Method POST from SaveTourServlet");

		// RequestDispatcher requestDispatcher =
		// req.getRequestDispatcher("views/add.jsp");
		// requestDispatcher.forward(req, resp);

		System.out.println("Post SaveTourServlet");

	}
}