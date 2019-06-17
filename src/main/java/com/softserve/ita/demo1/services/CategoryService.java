package com.softserve.ita.demo1.services;

import com.softserve.ita.demo1.entities.Category;

import java.util.List;

public interface CategoryService {

    Category getById(Integer id) throws IllegalArgumentException;
    List<Category> getAll();
    void add(Category category) throws IllegalArgumentException;
    void update(Category category) throws IllegalArgumentException;
    void delete(Integer id) throws IllegalArgumentException;
    Category getByAlias(String alias) throws IllegalArgumentException;


}
