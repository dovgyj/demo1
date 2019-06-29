package com.softserve.ita.demo1.services.impl;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.DAO.interfaces.CategoryDAO;
import com.softserve.ita.demo1.DAO.impl.CategoryDAOImpl;
import com.softserve.ita.demo1.entities.Category;
import com.softserve.ita.demo1.services.interfaces.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDAO categoryDAO;

    public CategoryServiceImpl() {
        this.categoryDAO = new CategoryDAOImpl();
    }

    @Override
    public Category getById(Integer id) throws DAOException {
        if (id == null) {
            throw new IllegalArgumentException("Id is null");
        }
        return categoryDAO.getById(id);
    }

    @Override
    public List<Category> getAll() throws DAOException {
        return categoryDAO.getAll();
    }

    @Override
    public void add(Category category) throws DAOException {
        if (category == null) {
            throw new IllegalArgumentException("Cannot add given category. Category cannot be null.");
        }
        categoryDAO.add(category);
    }

    @Override
    public void update(Category category) throws DAOException {
        if (category == null) {
            throw new IllegalArgumentException("Cannot update given category. Category cannot be null.");
        }
        categoryDAO.update(category);
    }

    @Override
    public void delete(Integer id) throws DAOException {
        if (id == null) {
            throw new IllegalArgumentException("Cannot delete given category. Id cannot be null.");
        }

        categoryDAO.delete(id);
    }

    public Category getByAlias(String alias) throws DAOException {
        if (alias == null) {
            throw new IllegalArgumentException("Cannot get category by alias. Alias cannot be null");
        }
        return categoryDAO.getByAlias(alias);
    }
}
