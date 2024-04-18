package com.examples.examplesserver.utils;

import com.examples.examplesserver.entity.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {


    public static void encrypt(User user) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            String encryptedUsername = encryptString(user.getUsername(), messageDigest);
            String encryptedPassword = encryptString(user.getPassword(), messageDigest);

            user.setUsername(encryptedUsername);
            user.setPassword(encryptedPassword);
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String encryptString(String input, MessageDigest messageDigest) {
        byte[] hash =messageDigest.digest(input.getBytes());

        StringBuffer hexString =new StringBuffer();
        for(byte b : hash) {
            String hex =Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
