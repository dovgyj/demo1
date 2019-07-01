package com.softserve.ita.demo1.servletes.admin.category;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.Category;
import com.softserve.ita.demo1.services.interfaces.CategoryService;
import com.softserve.ita.demo1.services.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin/category/index")
public class IndexController extends HttpServlet {

    private CategoryService categoryService;

    @Override
    public void init() throws ServletException {
        super.init();
        categoryService = new CategoryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Category> categories = categoryService.getAll();
            req.setAttribute("categories", categories);
        } catch (DAOException e) {
            throw new ServletException(e.getMessage());
        }

        req.getRequestDispatcher("/views/admin/category/index.jsp").forward(req, resp);
    }
}
