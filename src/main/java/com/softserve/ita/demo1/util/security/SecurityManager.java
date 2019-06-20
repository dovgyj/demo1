package com.softserve.ita.demo1.util.security;

import org.mindrot.jbcrypt.BCrypt;

import java.nio.charset.Charset;
import java.util.Random;

public class SecurityManager {

    public String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    public boolean checkPass(String plainPassword, String hashedPassword) {
        return  BCrypt.checkpw(plainPassword, hashedPassword);
    }

    public String generateRememberMeToken(){
        return this.generateRandomString(20);
    }

    public String generateSelector(){
        return this.generateRandomString(100);
    }

    private String generateRandomString(int length){
        byte[] array = new byte[length];
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        return generatedString;
    }

    public String hashRememberMeToken(String token){
        return BCrypt.hashpw(token,BCrypt.gensalt());
    }

    public boolean checkRememberMeToken(String plainToken,String hashedToken){
        return  BCrypt.checkpw(plainToken, hashedToken);
    }
}
