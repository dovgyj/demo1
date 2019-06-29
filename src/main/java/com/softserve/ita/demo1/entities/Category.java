package com.softserve.ita.demo1.entities;

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
