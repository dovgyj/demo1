package com.softserve.ita.demo1.servletes.admin.item;

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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemService itemService = new ItemServiceImpl();
        List<Item> itemList = itemService.getAll();
        req.setAttribute("items", itemList);
        req.getRequestDispatcher("/views/admin/item/index.jsp").forward(req, resp);
    }
}
