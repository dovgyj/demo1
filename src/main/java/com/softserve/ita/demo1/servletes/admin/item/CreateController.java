package com.softserve.ita.demo1.servletes.admin.item;

import com.softserve.ita.demo1.entities.Category;
import com.softserve.ita.demo1.entities.Item;
import com.softserve.ita.demo1.services.impl.CategoryServiceImpl;
import com.softserve.ita.demo1.services.interfaces.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin/item/create")
public class CreateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService service = new CategoryServiceImpl();
        List<Category> categories = service.getAll();
        req.setAttribute("categories", categories);

        req.getRequestDispatcher("/views/admin/item/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //
    }
}
