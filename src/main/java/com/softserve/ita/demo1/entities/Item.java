package com.softserve.ita.demo1.entities;

import java.util.Objects;

public class Item {

    private int id;
    private String title;
    private String description;
    private String alias;
    private int categoriesId;
    private String createdAt;

    public Item(String title, String description, int categoriesId, String createdAt) {
        this.title = title;
        this.description = description;
        this.categoriesId = categoriesId;
        this.createdAt = createdAt;
    }

    public Item(){

    }

    public int getId() {
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

    public int getCategoriesId() {
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
        return id == item.id &&
                categoriesId == item.categoriesId &&
                title.equals(item.title) &&
                Objects.equals(description, item.description) &&
                alias.equals(item.alias) &&
                Objects.equals(createdAt, item.createdAt);
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
