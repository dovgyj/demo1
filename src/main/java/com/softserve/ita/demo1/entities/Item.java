package com.softserve.ita.demo1.entities;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.services.interfaces.CategoryService;
import com.softserve.ita.demo1.services.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import java.io.InputStream;
import java.util.Objects;

public class Item {

    private Integer id;
    private String title;
    private String description;
    private String alias;
    private Integer categoriesId;
    private String createdAt;
    private Integer price;
    private String img;

    public Item() {

    }

    public Category getCategory() throws ServletException {
        CategoryService categoryService = new CategoryServiceImpl();
        try {
            return categoryService.getById(categoriesId);
        } catch (DAOException e) {
            throw new ServletException(e.getMessage());
        }

    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAlias() {
        return alias;
    }

    public Integer getCategoriesId() {
        return categoriesId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setCategoriesId(int categoriesId) {
        this.categoriesId = categoriesId;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, alias, categoriesId, createdAt);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", alias='" + alias + '\'' +
                ", categoriesId=" + categoriesId +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
