package com.softserve.ita.demo1.servletes;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.Order;
import com.softserve.ita.demo1.services.impl.OrderServiceImpl;
import com.softserve.ita.demo1.services.interfaces.OrderService;
import com.softserve.ita.demo1.util.OrderBin;
import com.softserve.ita.demo1.util.security.AuthManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/order/make")
public class OrderController extends HttpServlet {

    private OrderService orderService;

    @Override
    public void init() throws ServletException {
        super.init();
        orderService = new OrderServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/orderdone.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderBin orderBin = (OrderBin) req.getAttribute("orderBin");
        AuthManager authManager = (AuthManager) req.getAttribute("Auth");

        Order order = new Order(authManager.getUser(), orderBin.getItemList(), orderBin.getTotalprice());

        try {
            orderService.add(order);
            req.setAttribute("order", order);
        } catch (DAOException e) {
            throw new ServletException(e.getMessage(), e);
        }

        orderBin.clear();

        req.getRequestDispatcher("/views/orderdone.jsp").forward(req, resp);
    }
}
