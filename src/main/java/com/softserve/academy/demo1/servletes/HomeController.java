package com.softserve.academy.demo1.servletes;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class HomeController extends HttpServlet {

    protected void doGet(ServletRequest request, ServletResponse response) throws ServletException, IOException{
        RequestDispatcher rd = getServletContext().getRequestDispatcher("WEB_INF/index.jsp");
        rd.forward(request,response);
    }
}
