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

@WebServlet(urlPatterns = "/admin/category/create")
public class CreateController extends HttpServlet {

    protected CategoryService categoryService;

    @Override
    public void init() throws ServletException {
        super.init();
        categoryService = new CategoryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/admin/category/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (name == null) {
            resp.setStatus(400);
        } else {
            Category category = new Category();
            category.setName(name);

            try {
                categoryService.add(category);
            } catch (DAOException e) {
                throw new ServletException(e.getMessage());
            }

            resp.sendRedirect("/admin/category/index");
        }


    }
}
