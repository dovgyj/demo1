package com.softserve.ita.demo1.services.impl;

import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.DAO.impl.ItemDAOImpl;
import com.softserve.ita.demo1.DAO.interfaces.ItemDAO;
import com.softserve.ita.demo1.entities.Item;
import com.softserve.ita.demo1.services.interfaces.ItemService;

import java.util.List;

public class ItemServiceImpl implements ItemService {

    private ItemDAO itemDAO;

    public ItemServiceImpl(){
        itemDAO = new ItemDAOImpl();
    }

    @Override
    public Item getById(Integer id) throws DAOException{
        if(id <= 0){
            throw new IllegalArgumentException("Id must be positive");
        }
        return itemDAO.getById(id);
    }

    @Override
    public void update(Item item) throws DAOException{
        if(item == null){
            throw new IllegalArgumentException("Item is null");
        }
        itemDAO.update(item);
    }

    @Override
    public void add(Item item) throws DAOException{
        if(item == null){
            throw new IllegalArgumentException("Item is null");
        }

        itemDAO.add(item);

    }

    @Override
    public void delete(Integer id) throws DAOException{
        if(id <= 0){
            throw new IllegalArgumentException("Id must be positive");
        }
        itemDAO.delete(id);
    }

    @Override
    public List<Item> getAll() throws DAOException{
        return itemDAO.getAll();
    }
}
