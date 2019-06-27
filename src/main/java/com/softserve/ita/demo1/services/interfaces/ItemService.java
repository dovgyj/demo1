package com.softserve.ita.demo1.services.interfaces;

import com.softserve.ita.demo1.entities.Item;

import java.util.List;

public interface ItemService {
    Item getById(Integer id);
    void update(Item item);
    void add(Item item);
    void delete(Integer id);
    List<Item> getAll();
}
