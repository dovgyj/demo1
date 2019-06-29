package com.softserve.ita.demo1.DAO.interfaces;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.User;

import java.util.List;

public interface UserDAO {

     User getById(Integer id) throws DAOException;
     void update(User user) throws DAOException;
     void add(User user) throws DAOException;
     void delete(Integer id) throws DAOException;
     User getByEmail(String email) throws DAOException;
     List<User> getAllUsers() throws DAOException;

}
