package com.softserve.ita.demo1.services;

import com.softserve.ita.demo1.db.AuntificationDAO;
import com.softserve.ita.demo1.db.AuntificationDAOImpl;
import com.softserve.ita.demo1.entities.Auntification;

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
