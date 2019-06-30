package com.softserve.ita.demo1.entities;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.services.impl.CategoryServiceImpl;
import com.softserve.ita.demo1.services.impl.ItemServiceImpl;
import com.softserve.ita.demo1.services.interfaces.CategoryService;
import com.softserve.ita.demo1.services.interfaces.ItemService;

import javax.servlet.ServletException;
import java.util.List;
import java.util.Objects;

public class Category {

    private Integer id;
    private String name;
    private String alias;

    public Category(String name) {
        this.name = name;
    }

    public Category(){

    }

    public List<Item> getItems() throws ServletException {
        ItemService itemService = new ItemServiceImpl();
        try {
            return itemService.getByCategoryId(id);
        } catch (DAOException e) {
            throw new ServletException(e.getMessage());
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
        String alias = name.replaceAll("[\\s]+","-");
        setAlias(alias);
    }

    public String getUrl(){
        return "/category/" + alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id &&
                name.equals(category.name) &&
                alias.equals(category.alias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, alias);
    }

}
