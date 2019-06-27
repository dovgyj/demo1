package com.softserve.ita.demo1.servletes.admin.item;

import com.softserve.ita.demo1.entities.Category;
import com.softserve.ita.demo1.entities.Item;
import com.softserve.ita.demo1.services.impl.CategoryServiceImpl;
import com.softserve.ita.demo1.services.impl.ItemServiceImpl;
import com.softserve.ita.demo1.services.interfaces.CategoryService;
import com.softserve.ita.demo1.services.interfaces.ItemService;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin/item/update/*")
public class UpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> categories = categoryService.getAll();
        req.setAttribute("categories", categories);

        ItemService service = new ItemServiceImpl();
        String path = req.getPathInfo();
        String id = path.split("/")[1];
        Integer itemId = null;

        try {
            itemId = Integer.valueOf(id);
            Item item = service.getById(itemId);
            if(item == null){
                throw new NotFound();
            }
            req.setAttribute("item",item);
            req.getRequestDispatcher("/views/admin/item/edit.jsp").forward(req,resp);
        } catch (NumberFormatException | NotFound e){
            e.printStackTrace();
            resp.setStatus(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        Integer categoryId = Integer.valueOf(req.getParameter("categories_id"));
        Integer price = Integer.valueOf(req.getParameter("price"));

        Integer id = Integer.valueOf(req.getParameter("id"));

        ItemService service = new ItemServiceImpl();

        Item item = service.getById(id);

        item.setPrice(price);
        item.setDescription(description);
        item.setTitle(title);
        item.setCategoriesId(categoryId);

        service.update(item);

        resp.sendRedirect("/admin/item/update/" + item.getId());
    }
}
