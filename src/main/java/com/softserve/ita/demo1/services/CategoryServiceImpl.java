package com.softserve.ita.demo1.services;

import com.softserve.ita.demo1.db.CategoryDAO;
import com.softserve.ita.demo1.db.CategoryDAOImpl;
import com.softserve.ita.demo1.entities.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDAO categoryDAO;

    public CategoryServiceImpl() {
        this.categoryDAO = new CategoryDAOImpl();
    }

    @Override
    public Category getById(Integer id) {
        try {
            return categoryDAO.getById(id);
        } catch (Exception e) {
            throw new IllegalArgumentException("Id does not exist.");
        }
    }

    @Override
    public List<Category> getAll() {
        return categoryDAO.getAll();
    }

    @Override
    public void add(Category category) {
        if (category != null) {
            try {
                categoryDAO.add(category);
            } catch (Exception e) {
                throw new IllegalArgumentException("Cannot add given category. Unknown error.");
            }
        } else {
            throw new IllegalArgumentException("Cannot add given category. Category cannot be null.");
        }
    }

    @Override
    public void update(Category category) {
        if (category != null) {
            try {
                categoryDAO.update(category);
            } catch (Exception e) {
                throw new IllegalArgumentException("Cannot update given category. Unknown error.");
            }
        } else {
            throw new IllegalArgumentException("Cannot update given category. Category cannot be null.");
        }
    }

    @Override
    public void delete(Integer id) {
        if (id != null) {
            try {
                categoryDAO.delete(id);
            } catch (Exception e) {
                throw new IllegalArgumentException("Cannot delete given category. Unknown error.");
            }
        } else {
            throw new IllegalArgumentException("Cannot delete given category. Id cannot be null.");
        }
    }

    public Category getByAlias(String alias) {
        if(alias != null){
            try {
                return categoryDAO.getByAlias(alias);
            } catch (Exception e){
                throw new IllegalArgumentException("Cannot get category by alias. Unknown error");
            }
        }else{
            throw new IllegalArgumentException("Cannot get category by alias. Alias cannot be null");
        }
    }
}
