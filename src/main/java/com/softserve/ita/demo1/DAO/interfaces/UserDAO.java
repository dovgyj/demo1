package com.softserve.ita.demo1.DAO.interfaces;

import com.softserve.ita.demo1.entities.User;

public interface UserDAO {

     User getById(Integer id);
     void update(User user);
     void add(User user);
     void delete(Integer id);
     User getByEmail(String email);

}
