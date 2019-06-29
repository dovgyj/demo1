package com.softserve.ita.demo1.servletes.admin.item;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.Item;
import com.softserve.ita.demo1.services.impl.ItemServiceImpl;
import com.softserve.ita.demo1.services.interfaces.ItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin/item/index")
public class IndexController extends HttpServlet {

    private ItemService itemService;

    @Override
    public void init() throws ServletException {
        itemService = new ItemServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> itemList = null;
        try {
            itemList = itemService.getAll();
        } catch (DAOException e) {
            throw new ServletException(e.getMessage());
        }
        req.setAttribute("items", itemList);
        req.getRequestDispatcher("/views/admin/item/index.jsp").forward(req, resp);
    }
}
