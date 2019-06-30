package com.softserve.ita.demo1.servletes;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.Category;
import com.softserve.ita.demo1.entities.Item;
import com.softserve.ita.demo1.services.impl.ItemServiceImpl;
import com.softserve.ita.demo1.services.interfaces.CategoryService;
import com.softserve.ita.demo1.services.impl.CategoryServiceImpl;
import com.softserve.ita.demo1.services.interfaces.ItemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Index", urlPatterns = "")
public class HomeController extends HttpServlet {

    private CategoryService categoryService;
    private ItemService itemService;

    @Override
    public void init() throws ServletException {
        super.init();
        categoryService = new CategoryServiceImpl();
        itemService = new ItemServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Category> categories = categoryService.getAll();
            request.setAttribute("categories", categories);
            List<Item> itemList = itemService.getAll();
            request.setAttribute("items",itemList);
            request.getRequestDispatcher("/views/index.jsp").forward(request, response);
        } catch (DAOException e) {
            throw new ServletException(e.getMessage());
        }

    }
}
