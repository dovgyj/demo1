package com.softserve.ita.demo1.util;

import java.util.regex.Pattern;

public class Validator {

    public boolean isValidEmail(String email){
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public boolean hasMinLength(Integer length, String str){
        if(str == null) return false;
        if(str.length() >= length){
            return true;
        }

        return false;
    }
}
