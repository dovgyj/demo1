package com.softserve.ita.demo1.servletes;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.Item;
import com.softserve.ita.demo1.services.impl.ItemServiceImpl;
import com.softserve.ita.demo1.services.interfaces.ItemService;
import com.softserve.ita.demo1.util.OrderBin;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/bin/remove/*")
public class BinDeleteController extends HttpServlet {

    private ItemService itemService;

    @Override
    public void init() throws ServletException {
        super.init();
        itemService = new ItemServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        try {
            String id = path.split("/")[1];
            Integer itemId = Integer.valueOf(id);
            Item item = itemService.getById(itemId);
            if (item == null) {
                throw new NotFound();
            }
            OrderBin orderBin = (OrderBin) req.getAttribute("orderBin");
            orderBin.remove(item);
            resp.sendRedirect("/bin");
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException | NotFound e) {
            resp.setStatus(404);
        } catch (DAOException e) {
            throw new ServletException(e.getMessage(), e);
        }
    }
}
