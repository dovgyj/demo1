package com.softserve.ita.demo1.servletes.admin.item;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.Category;
import com.softserve.ita.demo1.entities.Item;
import com.softserve.ita.demo1.services.impl.CategoryServiceImpl;
import com.softserve.ita.demo1.services.impl.ItemServiceImpl;
import com.softserve.ita.demo1.services.interfaces.CategoryService;
import com.softserve.ita.demo1.services.interfaces.ItemService;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;

@WebServlet(urlPatterns = "/admin/item/update/*")
@MultipartConfig
public class UpdateController extends HttpServlet {

    private CategoryService categoryService;
    private ItemService itemService;

    @Override
    public void init() throws ServletException {
        super.init();
        categoryService = new CategoryServiceImpl();
        itemService = new ItemServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Category> categories = categoryService.getAll();
            req.setAttribute("categories", categories);
        } catch (DAOException e) {
            throw new ServletException(e.getMessage());
        }

        ItemService itemService = new ItemServiceImpl();
        String path = req.getPathInfo();
        String id = path.split("/")[1];
        Integer itemId = null;

        try {
            itemId = Integer.valueOf(id);

            Item item = itemService.getById(itemId);
            if (item == null) {
                throw new NotFound();
            }
            req.setAttribute("item", item);
            req.getRequestDispatcher("/views/admin/item/edit.jsp").forward(req, resp);
        } catch (NumberFormatException | NotFound e) {
            resp.setStatus(404);
        } catch (DAOException e) {
            throw new ServletException(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String categoryIdString = req.getParameter("categories_id");
        String priceString = req.getParameter("price");
        String idString = req.getParameter("id");

        if (title == null || description == null || categoryIdString == null || priceString == null || idString == null) {
            resp.setStatus(400);
        } else {
            Integer categoryId = Integer.valueOf(categoryIdString);
            Integer price = Integer.valueOf(priceString);
            Integer id = Integer.valueOf(idString);

            try {
                Item item = itemService.getById(id);
                item.setPrice(price);
                item.setDescription(description);
                item.setTitle(title);
                item.setCategoriesId(categoryId);

                // obtains the upload file part in this multipart request
                Part filePart = req.getPart("img");
                if (filePart != null && filePart.getSize() != 0) {
                    InputStream imgStream =  filePart.getInputStream();
                    item.setImgInputStream(imgStream);
                }
                itemService.update(item);

                resp.sendRedirect("/admin/item/update/" + item.getId());
            } catch (DAOException e) {
                throw new ServletException(e.getMessage());
            } catch (NumberFormatException e) {
                resp.setStatus(400);
            }
        }

    }

}


