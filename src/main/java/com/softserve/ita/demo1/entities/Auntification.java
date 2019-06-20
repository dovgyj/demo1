package com.softserve.ita.demo1.entities;

import java.util.Objects;

public class Auntification {

    private Integer id;
    private Integer userId;
    private String selector;
    private String validator;

    public Auntification(){

    }

    public Auntification(Integer userId){
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

    public String getValidator() {
        return validator;
    }

    public void setValidator(String validator) {
        this.validator = validator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auntification that = (Auntification) o;
        return userId.equals(that.userId) &&
                selector.equals(that.selector) &&
                validator.equals(that.validator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, selector, validator);
    }
}
