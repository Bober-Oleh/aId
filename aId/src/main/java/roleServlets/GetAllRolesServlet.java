package roleServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultRoleDAO;
import models.RoleData;

public class GetAllRolesServlet extends HttpServlet {

	private DefaultRoleDAO roleDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		roleDao = DefaultRoleDAO.getRoleDaoInstance();
		List<RoleData> allRoles = roleDao.getAllRoles();

		PrintWriter writer = resp.getWriter();
		writer.println("Method GET from GetAllRolesServlet");

		for (RoleData role : allRoles) {
			writer.println("role=" + role);
		}
		// RequestDispatcher requestDispatcher =
		// req.getRequestDispatcher("views/add.jsp");
		// requestDispatcher.forward(req, resp);

		System.out.println("Get GetAllRolesServlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}