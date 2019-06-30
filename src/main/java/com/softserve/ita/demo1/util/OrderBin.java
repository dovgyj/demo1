package com.softserve.ita.demo1.util;

import com.softserve.ita.demo1.entities.Item;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderBin {

    private List<Item> itemList;
    private HttpSession session;

    public OrderBin(HttpSession session) {
        this.session = session;
        itemList = (List<Item>) session.getAttribute("itemsInBin");
        if (itemList == null) {
            itemList = new ArrayList<Item>();
            session.setAttribute("itemsInBin", itemList);
        }
    }

    public boolean isEmpty() {
        return itemList.isEmpty();
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    public void add(Item item) {
        itemList.add(item);
        session.setAttribute("itemsInBin", itemList);
    }

    public void remove(Item item) {
        itemList.remove(item);
        session.setAttribute("itemsInBin", itemList);
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void clear() {
        itemList = Collections.emptyList();
        session.removeAttribute("itemsInBin");
    }

    public int getTotalprice() {
        int totalPrice = 0;
        for (Item item : itemList) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public int count() {
        return itemList.size();
    }

    public boolean contains(Item item) {
        return itemList.contains(item);
    }
}
