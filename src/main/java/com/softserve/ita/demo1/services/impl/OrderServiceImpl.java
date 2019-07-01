package com.softserve.ita.demo1.services.impl;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.DAO.impl.ItemDAOImpl;
import com.softserve.ita.demo1.DAO.impl.OrderDAOImpl;
import com.softserve.ita.demo1.DAO.interfaces.ItemDAO;
import com.softserve.ita.demo1.DAO.interfaces.OrderDAO;
import com.softserve.ita.demo1.entities.Order;
import com.softserve.ita.demo1.services.interfaces.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;

    public OrderServiceImpl() {
        orderDAO = new OrderDAOImpl();
    }

    @Override
    public void add(Order order) throws DAOException {
        if (order == null) {
            throw new IllegalArgumentException("order is null");
        }
        orderDAO.add(order);
    }

    @Override
    public List<Order> getAll() throws DAOException {
        return orderDAO.getAll();
    }

    @Override
    public Order getById(Integer id) throws DAOException {
        if (id == null) {
            throw new IllegalArgumentException("Id is null");
        }
        return orderDAO.getById(id);
    }

    @Override
    public void delete(Integer id) throws DAOException {
        if (id == null) {
            throw new IllegalArgumentException("Id is null");
        }
        orderDAO.delete(id);
    }
}
