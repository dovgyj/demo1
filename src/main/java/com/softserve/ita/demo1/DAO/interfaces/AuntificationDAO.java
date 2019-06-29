package com.softserve.ita.demo1.DAO.interfaces;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.Auntification;

public interface AuntificationDAO {

    void delete(String selector) throws DAOException;
    void add(Auntification auntification) throws DAOException;
    Auntification getBySelector(String selector) throws DAOException;
}
