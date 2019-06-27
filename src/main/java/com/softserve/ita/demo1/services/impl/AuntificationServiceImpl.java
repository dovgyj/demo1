package com.softserve.ita.demo1.services.impl;

import com.softserve.ita.demo1.DAO.interfaces.AuntificationDAO;
import com.softserve.ita.demo1.DAO.impl.AuntificationDAOImpl;
import com.softserve.ita.demo1.entities.Auntification;
import com.softserve.ita.demo1.services.interfaces.AuntificationService;

public class AuntificationServiceImpl implements AuntificationService {

    private AuntificationDAO auntificationDAO;

    public AuntificationServiceImpl(){
        this.auntificationDAO = new AuntificationDAOImpl();
    }

    @Override
    public void delete(String selector) throws IllegalArgumentException {
        if(selector == null || selector.isEmpty()){
            throw new IllegalArgumentException("Selector must not be null or empty string");
        }
        auntificationDAO.delete(selector);
    }

    @Override
    public void add(Auntification auntification) throws IllegalArgumentException {
        if(auntification == null){
            throw new IllegalArgumentException("Auntification must not be null");
        }
        auntificationDAO.add(auntification);
    }

    @Override
    public Auntification getBySelector(String selector)throws IllegalArgumentException {
        if(selector == null || selector.isEmpty()){
            throw new IllegalArgumentException("Selector must not be null or empty string");
        }
        return auntificationDAO.getBySelector(selector);
    }
}
