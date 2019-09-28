package roleServlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import impl.DefaultRoleDAO;

public class UpdateRoleServlet extends HttpServlet {

	private DefaultRoleDAO roleDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// boolean updateRole(int idRole, String discount);

		// RequestDispatcher requestDispatcher =
		// req.getRequestDispatcher("views/add.jsp");
		// requestDispatcher.forward(req, resp);

		int idRole = Integer.valueOf(req.getParameter("idRole"));
		String newDiscount = req.getParameter("discount");

		roleDao = DefaultRoleDAO.getRoleDaoInstance();

		boolean updateResult = roleDao.updateRole(idRole, newDiscount);
		// boolean updateResult = false;

		PrintWriter writer = resp.getWriter();
		writer.println("Method PUT from UpdateRoleServlet");
		writer.println("\n");
		writer.println("idRole=" + idRole);
		writer.println("\n");
		if (updateResult == true) {
			writer.println("role with idRole=" + idRole + " has been updated successfully!");
		} else {
			writer.println("role with idRole=" + idRole + " has NOT been updated!");
		}

	}
}