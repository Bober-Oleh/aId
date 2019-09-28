package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import impl.DefaultUserDAO;
import models.UserData;

public class RegistrationServlet extends HttpServlet {
    
    private DefaultUserDAO userDao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/registration.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserData user = new UserData();
        
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setDateBirthday(request.getParameter("dateBirthday"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setIdRole(Integer.parseInt(request.getParameter("idRole")));
        user.setToursNumber(Integer.parseInt(request.getParameter("toursNumber")));
        
        userDao = DefaultUserDAO.getUserDaoInstance();
        userDao.saveUser(user);
        
        
        response.sendRedirect(getServletContext().getContextPath() + "/myaccount");
        
        
        
    }

}