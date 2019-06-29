package com.softserve.ita.demo1.services.interfaces;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.Auntification;

public interface AuntificationService {
     void delete(String selector) throws IllegalArgumentException, DAOException;;
     void add(Auntification auntification) throws IllegalArgumentException, DAOException;
     Auntification getBySelector(String selector) throws IllegalArgumentException, DAOException;
}
