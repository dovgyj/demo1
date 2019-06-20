package com.softserve.ita.demo1.services;

import com.softserve.ita.demo1.entities.Auntification;

public interface AuntificationService {
     void delete(String selector) throws IllegalArgumentException;
     void add(Auntification auntification) throws IllegalArgumentException;
     Auntification getBySelector(String selector) throws IllegalArgumentException;
}
