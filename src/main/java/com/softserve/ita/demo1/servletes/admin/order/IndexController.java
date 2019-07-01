package com.softserve.ita.demo1.servletes.admin.order;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.Order;
import com.softserve.ita.demo1.services.impl.OrderServiceImpl;
import com.softserve.ita.demo1.services.interfaces.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin/order/index")
public class IndexController extends HttpServlet {

    private OrderService orderService;

    @Override
    public void init() throws ServletException {
        super.init();
        orderService = new OrderServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Order> orderList = orderService.getAll();
            req.setAttribute("orders", orderList);
            req.getRequestDispatcher("/views/admin/order/index.jsp").forward(req, resp);
        } catch (DAOException e) {
            throw new ServletException(e.getMessage(), e);
        }
    }
}
