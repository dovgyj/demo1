package com.softserve.ita.demo1.DAO.interfaces;

import com.softserve.ita.demo1.entities.Category;

import java.util.List;

public interface CategoryDAO {

    Category getById(Integer id);
    List<Category> getAll();
    void add(Category category);
    void update(Category category);
    void delete(Integer id);
    Category getByAlias(String alias);

}
