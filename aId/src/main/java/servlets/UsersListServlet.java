package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultTourDAO;
import impl.DefaultUserDAO;
import models.TourData;
import models.UserData;

public class UsersListServlet extends HttpServlet {

    private DefaultUserDAO userDao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        userDao = DefaultUserDAO.getUserDaoInstance();
        List<UserData> users = userDao.getAllUsers();

        request.setAttribute("users", users);
        request.getRequestDispatcher("WEB-INF/views/usersList.jsp").forward(request, response);
    }

}