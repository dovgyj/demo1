package com.softserve.ita.demo1.servletes;

import com.softserve.ita.demo1.entities.Category;
import com.softserve.ita.demo1.services.CategoryService;
import com.softserve.ita.demo1.services.CategoryServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

@WebServlet(name="Index",urlPatterns = "")
public class HomeController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        CategoryService service = new CategoryServiceImpl();

        try {
            List<Category> categories = service.getAll();
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("/views/index.jsp").forward(request,response);
        } catch (Exception e){
            getServletContext().getRequestDispatcher("/views/error.jsp").forward(request,response);
        }

    }
}
