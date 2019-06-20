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

    private String generateRandomString(int n){
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    public String hashRememberMeToken(String token){
        return BCrypt.hashpw(token,BCrypt.gensalt());
    }

    public boolean checkRememberMeToken(String plainToken,String hashedToken){
        return  BCrypt.checkpw(plainToken, hashedToken);
    }
}
