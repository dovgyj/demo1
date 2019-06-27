package com.softserve.ita.demo1.DAO.interfaces;

import com.softserve.ita.demo1.entities.Auntification;

public interface AuntificationDAO {

    void delete(String selector);
    void add(Auntification auntification);
    Auntification getBySelector(String selector);
}
