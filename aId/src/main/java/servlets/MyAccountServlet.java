package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultTourDAO;
import models.TourData;

public class MyAccountServlet extends HttpServlet {

    private DefaultTourDAO tourDao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        tourDao = DefaultTourDAO.getTourDaoInstance();
        List<TourData> tours = tourDao.getAllTours();

        request.setAttribute("tours", tours);
        request.getRequestDispatcher("WEB-INF/views/myaccount.jsp").forward(request, response);
    }

}