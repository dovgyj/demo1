package com.softserve.ita.demo1.services.interfaces;

import com.softserve.ita.demo1.entities.User;

import java.util.List;

public interface UserService {
    User getById(Integer id);
    void update(User user);
    void add(User user);
    void delete(Integer id);
    User getByEmail(String email);
    List<User> getAllUsers();
}
