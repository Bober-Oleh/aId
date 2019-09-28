package userServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultUserDAO;

public class UpdateUserServlet extends HttpServlet {
    
    private DefaultUserDAO userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //boolean updateUser(int idUser, String email);
        
//      RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/add.jsp");
//      requestDispatcher.forward(req, resp);

      int idUser = Integer.valueOf(req.getParameter("idUser"));
      String newEmail = req.getParameter("email");
      
      userDao = DefaultUserDAO.getUserDaoInstance();
      
      boolean updateResult = userDao.updateUser(idUser,newEmail);
      //boolean updateResult = false;

      
      PrintWriter writer = resp.getWriter();
      writer.println("Method PUT from UpdateUserServlet");
      writer.println("\n");
      writer.println("idUser=" + idUser);
      writer.println("\n");
      if (updateResult == true) {
          writer.println("user with idUser=" + idUser + " has been updated successfully!");
      }else {
          writer.println("user with idUser=" + idUser + " has NOT been updated!");
      }
        
    }
}