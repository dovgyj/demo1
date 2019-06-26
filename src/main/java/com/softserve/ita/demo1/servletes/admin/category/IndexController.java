package com.softserve.ita.demo1.servletes.admin.category;

import com.softserve.ita.demo1.entities.Category;
import com.softserve.ita.demo1.services.CategoryService;
import com.softserve.ita.demo1.services.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin/category/index")
public class IndexController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService service = new CategoryServiceImpl();
        List<Category> categories = service.getAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/views/admin/category/index.jsp").forward(req, resp);
    }
}
