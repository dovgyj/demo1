package com.softserve.ita.demo1.db;

import com.softserve.ita.demo1.entities.User;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import static org.testng.Assert.*;

public class UserDAOImplTest {

    private UserDAO userDAO;

    @BeforeTest
    public void before(){
        this.userDAO = new UserDAOImpl();
        User user = new User();
        user.setName("test user");
        user.setEmail("test@gmail.com");
        user.setPassword("1234");

        userDAO.add(user);

    }

    @org.testng.annotations.Test
    public void testGetByEmail() {
        User user = this.userDAO.getByEmail("test@gmail.com");
        assertEquals("test@gmail.com",user.getEmail());
    }

    @AfterTest
    public void after(){
        this.userDAO.delete(this.userDAO.getByEmail("test@gmail.com").getId());
    }
}