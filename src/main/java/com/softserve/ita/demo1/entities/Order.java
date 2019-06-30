package com.softserve.ita.demo1.entities;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.services.impl.UserServiceImpl;
import com.softserve.ita.demo1.services.interfaces.UserService;

import javax.servlet.ServletException;
import java.util.List;
import java.util.Objects;

public class Order {

    private Integer id;
    private Integer userId;
    private Integer totalPrice;
    private String createdAt;
    private String payedAt;

    private List<Item> itemList;

    private UserService userService;

    public Order() {
        userService = new UserServiceImpl();
    }

    public Order(User user, List<Item> itemList, Integer totalPrice) {
        this();
        this.userId = user.getId();
        this.itemList = itemList;
        this.totalPrice = totalPrice;
    }

    public User getUser() throws ServletException {
        try {
            return userService.getById(userId);
        } catch (DAOException e) {
            throw new ServletException(e.getMessage(), e);
        }
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItems(List<Item> itemList) {
        this.itemList = itemList;
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

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getPayedAt() {
        return payedAt;
    }

    public void setPayedAt(String payedAt) {
        this.payedAt = payedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", totalPrice=" + totalPrice +
                ", createdAt='" + createdAt + '\'' +
                ", payedAt='" + payedAt + '\'' +
                ", itemList=" + itemList +
                ", userService=" + userService +
                '}';
    }
}
