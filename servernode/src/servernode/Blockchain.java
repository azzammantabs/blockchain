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
import java.util.ArrayList;

public class Blockchain {
    private int index;
    private String data;
    private String timestamp;
    private String prevhash;
    private String hash;
    private String nounce;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getPrevhash() {
        return prevhash;
    }

    public void setPrevhash(String prevhash) {
        this.prevhash = prevhash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getNounce() {
        return nounce;
    }

    public void setNounce(String nounce) {
        this.nounce = nounce;
    }
    

    public void createGenesis() {
        this.data = "Genesis";
        this.timestamp = "0";
        this.index = 0;
        this.hash = "0";
        this.prevhash = "0";
        this.nounce = "0";
    }


}

