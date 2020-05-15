/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servernode;

/**
 *
 * @author Abdullah Azzam
 */
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
    public int index;
    public String data;
    public String timestamp;
    public String prevHash;
    public String hash;
    public String nounce;

    public String getHash()
    {
        return this.hash = encrypt(String.valueOf(this.index) +this.data + this.timestamp + this.prevHash);
    }

    public static String getNounce(String hash, int lid) {
        nodeapi na = new nodeapi();
        String nounce = "";
        boolean status = false;
        while (status==false) {
            Block nb = na.getLastBlockN();
            nounce = encrypt(hash+nounce);
            if (nounce.charAt(0)=='1' && nounce.charAt(1)=='2' && nounce.charAt(2)=='3' && nounce.charAt(3)=='4' && nounce.charAt(4)=='5') {
                status = true;
            } else if (nb.index == lid+1) {
                status = true;
            }
        }
        return nounce;
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
