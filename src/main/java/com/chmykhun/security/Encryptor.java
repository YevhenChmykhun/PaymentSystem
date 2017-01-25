package com.chmykhun.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {

    private static final String MD5 = "MD5";

    public static String encrypt(String string) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(MD5);
            messageDigest.update(string.getBytes(), 0, string.length());
        } catch (NoSuchAlgorithmException e) {
/*            log.error("Algorithm wasn't recognized.", e);*/
        }
        return new BigInteger(1, messageDigest.digest()).toString(16);
    }


}
