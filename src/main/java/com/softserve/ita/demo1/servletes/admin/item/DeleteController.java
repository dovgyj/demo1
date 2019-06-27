package com.softserve.ita.demo1.servletes.admin.item;

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

@WebServlet(urlPatterns = "/admin/item/delete/*")
public class DeleteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemService service = new ItemServiceImpl();
        String path = req.getPathInfo();
        String id = path.split("/")[1];
        Integer itemId = null;

        try {
            itemId = Integer.valueOf(id);
            service.delete(itemId);
            resp.sendRedirect("/admin/item/index");
        } catch (NumberFormatException e){
            resp.setStatus(404);
        }
    }
}
