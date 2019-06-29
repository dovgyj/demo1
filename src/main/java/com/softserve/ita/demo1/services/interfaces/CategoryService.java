package com.softserve.ita.demo1.services.interfaces;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.Category;

import java.util.List;

public interface CategoryService {

    Category getById(Integer id) throws IllegalArgumentException, DAOException;
    List<Category> getAll() throws DAOException;
    void add(Category category) throws IllegalArgumentException, DAOException;
    void update(Category category) throws IllegalArgumentException, DAOException;
    void delete(Integer id) throws IllegalArgumentException, DAOException;
    Category getByAlias(String alias) throws IllegalArgumentException, DAOException;


}
