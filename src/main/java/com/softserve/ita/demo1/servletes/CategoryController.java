package com.softserve.ita.demo1.servletes;

import com.softserve.ita.demo1.entities.Category;
import com.softserve.ita.demo1.services.CategoryService;
import com.softserve.ita.demo1.services.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CategoryController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService service = new CategoryServiceImpl();
        String path = request.getPathInfo();
        String categoryAlias = path.split("/")[1];

        try{
            Category activeCategory = service.getByAlias(categoryAlias);
            request.setAttribute("activeCategory",activeCategory);
        }catch (Exception e){
            // redirect to 404
        }


        try {
            List<Category> categories = service.getAll();
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("/views/category.jsp").forward(request,response);
        } catch (Exception e){
            //  redirect to error page with e.getMessage()
        }

    }
}
