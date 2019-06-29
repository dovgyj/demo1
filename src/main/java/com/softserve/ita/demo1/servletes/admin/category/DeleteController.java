package com.softserve.ita.demo1.servletes.admin.category;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.services.interfaces.CategoryService;
import com.softserve.ita.demo1.services.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/category/delete/*")
public class DeleteController extends HttpServlet {

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
            categoryService.delete(categoryId);
            resp.sendRedirect("/admin/category/index");
        } catch (NumberFormatException e){
            resp.setStatus(404);
        } catch (DAOException e) {
            throw new ServletException(e.getMessage());
        }
    }
}
