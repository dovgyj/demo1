package com.softserve.ita.demo1.services.impl;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.DAO.impl.BlackListDAOImpl;
import com.softserve.ita.demo1.DAO.interfaces.BlackListDAO;
import com.softserve.ita.demo1.entities.BlackList;
import com.softserve.ita.demo1.services.interfaces.BlackListService;

public class BlackListServiceImpl implements BlackListService {

    private BlackListDAO blackListService;

    public BlackListServiceImpl(){
        blackListService = new BlackListDAOImpl();
    }

    @Override
    public void add(BlackList blackList) throws DAOException {
        if(blackList == null){
            throw new IllegalArgumentException("Black list is null");
        }
        blackListService.add(blackList);
    }

    @Override
    public void remove(Integer userId) throws DAOException {
        if(userId == null){
            throw new IllegalArgumentException("Id must be positive");
        }
        blackListService.remove(userId);
    }
}
