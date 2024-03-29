package com.softserve.ita.demo1.DAO.interfaces;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.BlackList;

public interface BlackListDAO {

    void add(BlackList blackList) throws DAOException;
    void remove(Integer userId) throws DAOException;
}
