package com.company;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Model> models;

    public static void main(String[] args) {
        // write your code here
        //initiate object
        Scanner input = new Scanner(System.in);
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("EyyyyMMddhhmmssa");
        models = new ArrayList<>();

        //initiate genesis
        Model genesis = new Model(0, "genesis", "0", "0", "0");
        models.add(genesis);

        //data 1
        int index1 = 100;
        String fill1 = "Azzam";
        String timest1 = sf.format(date);
        String hash1 = encrypt(String.valueOf(index1) + fill1 + timest1);
        Model data1 = new Model(index1, fill1, timest1, "0", hash1);
        models.add(data1);

        //data 2
        int index2 = 101;
        String fill2 = "Motion";
        String timest2 = sf.format(date);
        String hash2 = encrypt(String.valueOf(index2) + fill2 + timest2);
        Model data2 = new Model(index2, fill2, timest2, hash1, hash2);
        models.add(data2);

        //data 3
        int index3 = 102;
        String fill3 = "Abdullah";
        String timest3 = sf.format(date);
        String hash3 = encrypt(String.valueOf(index3) + fill3 + timest3);
        Model data3 = new Model(index3, fill3, timest3, hash2, hash3);
        models.add(data3);


        for (int i = 0; i < 3; i++) {
            System.out.println("Index " + (i+1) + " : " + models.get(i+1).getIndex());
            System.out.println("Data " + (i+1) + " : " + models.get(i+1).getData());
        }

    }


    public static String encrypt(String hash) {
        String hasencrypted = null;
        try {
            hasencrypted = toHexString(getSHA(hash));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hasencrypted;
    }

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash) {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }
}
