package com.softserve.ita.demo1.util;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidatorTest {

    protected Validator validator;

    @BeforeTest
    public void setUp(){
        validator = new Validator();
    }

    @Test
    public void testHasMinLength() {
        boolean rezault = validator.hasMinLength(6,"123456");
        assertTrue(rezault);

        boolean rezault2 = validator.hasMinLength(4,"123456");
        assertTrue(rezault2);

        boolean rezault3 = validator.hasMinLength(10,"1234");
        assertFalse(rezault3);
    }

    @Test
    public void testIsValidEmail(){
        boolean isValid = validator.isValidEmail("admin@gmail.com");
        assertTrue(isValid);

        boolean isValid2 = validator.isValidEmail("a.dovgyj@gmail.com");
        assertTrue(isValid2);

        boolean isValid3 = validator.isValidEmail("sfdsfdsfsdf");
        assertFalse(isValid3);
    }
}