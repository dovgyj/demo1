package com.softserve.ita.demo1.services.interfaces;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.Order;

import java.util.List;

public interface OrderService {
    void add(Order order) throws DAOException;
    List<Order> getAll() throws DAOException;
    Order getById(Integer id) throws DAOException;
    void delete(Integer id) throws DAOException;
}
