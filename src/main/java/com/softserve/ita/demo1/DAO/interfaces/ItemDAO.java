package com.softserve.ita.demo1.DAO.interfaces;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.Item;

import java.util.List;

public interface ItemDAO {

    Item getById(Integer id) throws DAOException;
    void update(Item item) throws DAOException;
    void add(Item item) throws DAOException;
    void delete(Integer id) throws DAOException;
    List<Item> getAll() throws DAOException;
}
