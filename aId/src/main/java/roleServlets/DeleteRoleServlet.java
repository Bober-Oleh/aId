package roleServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultRoleDAO;

public class DeleteRoleServlet extends HttpServlet {

	private DefaultRoleDAO roleDao;

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

		int idRole = Integer.valueOf(req.getParameter("idRole"));

		roleDao = DefaultRoleDAO.getRoleDaoInstance();
		boolean deleteResult = roleDao.deleteRole(idRole);
		// boolean deleteResult = false;

		PrintWriter writer = resp.getWriter();
		writer.println("Method DELETE from DeleteRoleServlet");
		writer.println("\n");
		writer.println("idUser=" + idRole);
		writer.println("\n");
		if (deleteResult == true) {
			writer.println("role with idRole=" + idRole + " has been deleted successfully!");
			deleteResult = false;
		} else {
			writer.println("role with idRole=" + idRole + " has NOT been deleted!");
		}

	}

}