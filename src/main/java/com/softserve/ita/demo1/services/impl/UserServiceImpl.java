package com.softserve.ita.demo1.services.impl;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.DAO.interfaces.UserDAO;
import com.softserve.ita.demo1.DAO.impl.UserDAOImpl;
import com.softserve.ita.demo1.entities.User;
import com.softserve.ita.demo1.services.interfaces.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl() {
        userDAO = new UserDAOImpl();
    }

    @Override
    public User getById(Integer id) throws DAOException {

        if (id == null) {
            throw new IllegalArgumentException("Id must be positive");
        }

        return userDAO.getById(id);
    }

    @Override
    public List<User> getAllUsers() throws DAOException {
        return userDAO.getAllUsers();
    }

    @Override
    public void update(User user) throws DAOException {

        if (user == null) {
            throw new IllegalArgumentException("user cannot be null");
        }
        userDAO.update(user);
    }

    @Override
    public void add(User user) throws DAOException {

        if (user == null) {
            throw new IllegalArgumentException("user cannot be null");
        }

        userDAO.add(user);
    }

    @Override
    public void delete(Integer id) throws DAOException {

        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        userDAO.delete(id);
    }

    @Override
    public User getByEmail(String email) throws DAOException {

        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email must be present");
        }

        return userDAO.getByEmail(email);
    }
}
