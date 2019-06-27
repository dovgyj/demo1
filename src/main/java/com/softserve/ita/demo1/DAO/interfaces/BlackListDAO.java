package com.softserve.ita.demo1.DAO.interfaces;

import com.softserve.ita.demo1.entities.BlackList;

public interface BlackListDAO {

    public void add(BlackList blackList);
    public void remove(Integer userId);
}
