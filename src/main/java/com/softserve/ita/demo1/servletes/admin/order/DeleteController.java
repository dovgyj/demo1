package com.softserve.ita.demo1.servletes.admin.order;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.services.impl.OrderServiceImpl;
import com.softserve.ita.demo1.services.interfaces.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/order/delete/*")
public class DeleteController extends HttpServlet {

    private OrderService orderService;

    @Override
    public void init() throws ServletException {
        super.init();
        orderService = new OrderServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        String id = path.split("/")[1];
        Integer orderId = null;

        try {
            orderId = Integer.valueOf(id);
            orderService.delete(orderId);
            resp.sendRedirect("/admin/order/index");
        } catch (IllegalArgumentException e) {
            resp.setStatus(404);
        } catch (DAOException e) {
            throw new ServletException(e.getMessage());
        }
    }
}
