package com.softserve.ita.demo1.util;

import org.mindrot.jbcrypt.BCrypt;

public class SecurityManager {

    public String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    public boolean checkPass(String plainPassword, String hashedPassword) {
        return  BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
