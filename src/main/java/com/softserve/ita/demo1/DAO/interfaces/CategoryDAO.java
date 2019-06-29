package com.softserve.ita.demo1.DAO.interfaces;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.Category;

import java.util.List;

public interface CategoryDAO {

    Category getById(Integer id) throws DAOException;
    List<Category> getAll() throws DAOException;
    void add(Category category) throws DAOException;
    void update(Category category) throws DAOException;
    void delete(Integer id) throws DAOException;
    Category getByAlias(String alias) throws DAOException;

}
