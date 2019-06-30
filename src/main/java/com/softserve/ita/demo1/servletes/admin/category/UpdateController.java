package com.softserve.ita.demo1.servletes.admin.category;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.Category;
import com.softserve.ita.demo1.services.interfaces.CategoryService;
import com.softserve.ita.demo1.services.impl.CategoryServiceImpl;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet(urlPatterns = "/admin/category/update/*")
public class UpdateController extends HttpServlet {

    private CategoryService categoryService;

    @Override
    public void init() throws ServletException {
        super.init();
        categoryService = new CategoryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        String id = path.split("/")[1];
        Integer categoryId = null;

        try {
            categoryId = Integer.valueOf(id);
            Category category = categoryService.getById(categoryId);
            if (category == null) {
                throw new NotFound();
            }
            req.setAttribute("category", category);
            req.getRequestDispatcher("/views/admin/category/edit.jsp").forward(req, resp);
        } catch (NumberFormatException | NotFound e) {
            resp.setStatus(404);
        } catch (DAOException e) {
            throw new ServletException(e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer id = Integer.valueOf(req.getParameter("id"));

        try {
            Category category = categoryService.getById(id);
            category.setName(name);
            categoryService.update(category);
            resp.sendRedirect("/admin/category/update/" + category.getId());
        } catch (DAOException e) {
            throw new ServletException(e.getMessage(), e);
        }

    }

}
