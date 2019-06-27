package com.softserve.ita.demo1.DAO.impl;

import com.softserve.ita.demo1.DAO.interfaces.BlackListDAO;
import com.softserve.ita.demo1.entities.BlackList;

public class BlackListDAOImpl implements BlackListDAO {
    @Override
    public void add(BlackList blackList) {
        String query = "INSERT INTO blacklist(user_id) VALUES (?)";

        
    }

    @Override
    public void remove(Integer userId) {

    }
}
