package com.softserve.ita.demo1.servletes.admin.category;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService service = new CategoryServiceImpl();
        String path = req.getPathInfo();
        String id = path.split("/")[1];
        Integer categoryId = null;

        try {
            categoryId = Integer.valueOf(id);
            service.delete(categoryId);
            resp.sendRedirect("/admin/category/index");
        } catch (NumberFormatException e){
            resp.setStatus(404);
        }
    }
}
