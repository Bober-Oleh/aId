package roleServlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import impl.DefaultRoleDAO;
import models.RoleData;

public class GetRoleByIdServlet extends HttpServlet {

	private DefaultRoleDAO roleDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// RequestDispatcher requestDispatcher =
		// req.getRequestDispatcher("views/add.jsp");
		// requestDispatcher.forward(req, resp);

		int idRole = Integer.valueOf(req.getParameter("idRole"));

		roleDao = DefaultRoleDAO.getRoleDaoInstance();
		RoleData roleById = roleDao.getRoleById(idRole);

		PrintWriter writer = resp.getWriter();
		// writer.println("Method GET from GetRoleByIdServlet");
		// writer.println("\n");
		// writer.println("idUser=" + idUser);
		// writer.println("\n");
		writer.println("role=" + roleById);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}