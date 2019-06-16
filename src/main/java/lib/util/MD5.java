package lib.util;

import java.security.*;
import java.math.*;

public class MD5 {
    public static String encode(String string) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(string.getBytes(), 0, string.length());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}