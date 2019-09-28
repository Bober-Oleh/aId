package roleServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultRoleDAO;
import models.RoleData;

public class SaveRoleServlet extends HttpServlet {

	private DefaultRoleDAO roleDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		roleDao = DefaultRoleDAO.getRoleDaoInstance();
		RoleData roleData = new RoleData();
		
		String rname = req.getParameter("rname");
		roleData.setRoleName(rname);
		roleDao.saveRole(roleData);

		PrintWriter writer = resp.getWriter();
		writer.println("Method POST from SaveRoleServlet");

		// RequestDispatcher requestDispatcher =
		// req.getRequestDispatcher("views/add.jsp");
		// requestDispatcher.forward(req, resp);

		System.out.println("Post SaveRoleServlet");

	}
}