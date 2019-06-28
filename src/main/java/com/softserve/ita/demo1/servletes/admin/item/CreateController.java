package com.softserve.ita.demo1.servletes.admin.item;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.Category;
import com.softserve.ita.demo1.entities.Item;
import com.softserve.ita.demo1.services.impl.CategoryServiceImpl;
import com.softserve.ita.demo1.services.impl.ItemServiceImpl;
import com.softserve.ita.demo1.services.interfaces.CategoryService;
import com.softserve.ita.demo1.services.interfaces.ItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin/item/create")
public class CreateController extends HttpServlet {

    private CategoryService categoryService;

    private ItemService itemService;

    @Override
    public void init() throws ServletException {
        super.init();

        categoryService = new CategoryServiceImpl();
        itemService  = new ItemServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.getAll();
        req.setAttribute("categories", categories);

        req.getRequestDispatcher("/views/admin/item/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        if(title == null){
            throw new ServletException("title is null");
        }
        String description = req.getParameter("description");
        if(description == null){
            throw new ServletException("description is null");
        }

        String categoryIdString = req.getParameter("categories_id");
        if(categoryIdString == null){
            throw new ServletException("categories_id is null");
        }

        String priceString = req.getParameter("price");
        if(priceString == null){
            throw new ServletException("price is null");
        }

        Integer categoryId = null;
        Integer price = null;

        try {
            categoryId = Integer.valueOf(categoryIdString);
            price = Integer.valueOf(priceString);
        } catch (NumberFormatException e){
            throw new ServletException(e.getMessage());
        }


        Item item = new Item();
        item.setTitle(title);
        item.setDescription(description);
        item.setCategoriesId(categoryId);
        item.setPrice(price);

        try {
            itemService.add(item);
        } catch (DAOException | IllegalArgumentException e){
            throw new ServletException(e.getMessage());
        }

        resp.sendRedirect("/admin/item/index");


    }
}
