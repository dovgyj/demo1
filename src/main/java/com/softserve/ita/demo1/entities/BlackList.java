package com.softserve.ita.demo1.entities;

import java.util.Objects;

public class BlackList {

    private Integer id;
    private Integer userId;

    public BlackList(){

    }

    public BlackList(Integer userId){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlackList blackList = (BlackList) o;
        return id.equals(blackList.id) &&
                userId.equals(blackList.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId);
    }
}
