package com.softserve.ita.demo1.servletes;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.Category;
import com.softserve.ita.demo1.entities.Item;
import com.softserve.ita.demo1.services.impl.CategoryServiceImpl;
import com.softserve.ita.demo1.services.impl.ItemServiceImpl;
import com.softserve.ita.demo1.services.interfaces.CategoryService;
import com.softserve.ita.demo1.services.interfaces.ItemService;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ItemController extends HttpServlet {

    private ItemService itemService;
    private CategoryService categoryServicee;

    @Override
    public void init() throws ServletException {
        super.init();
        itemService = new ItemServiceImpl();
        categoryServicee = new CategoryServiceImpl();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        Integer itemId = null;
        try {
            String id = path.split("/")[1];
            itemId = Integer.valueOf(id);

            Item item = itemService.getById(itemId);
            if (item == null) {
                throw new NotFound();
            }
            request.setAttribute("item", item);

            List<Category> categoryList = categoryServicee.getAll();
            request.setAttribute("categories", categoryList);
            RequestDispatcher rd = request.getRequestDispatcher("/views/item.jsp");
            rd.forward(request, response);

        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            response.setStatus(400);
        } catch (DAOException  e) {
            throw new ServletException(e.getMessage(), e);
        } catch (NotFound e) {
            response.setStatus(404);
        }
    }
}
