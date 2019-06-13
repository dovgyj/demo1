package com.softserve.ita.demo1.servletes;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CategoryController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String pathInfo = request.getPathInfo();
        String[] pathParts = pathInfo.split("/");
        String categoryName = pathParts[1];

        String[] categories = {"Tablets","Mobile-phones","Laptops","Headphones"};
        request.setAttribute("categoryName",categoryName);
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("/views/category.jsp").forward(request,response);

    }
}
