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

public class CategoryCurrentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService service = new CategoryServiceImpl();

        try {
            List<Category> categories = service.getByAlias("pc");
            req.setAttribute("categories", categories);
            req.setAttribute("alias", "pc");
            req.getRequestDispatcher("/views/category.jsp").forward(req,resp);
        } catch (Exception e){
            //  redirect to error page with e.getMessage()
        }
    }
}
