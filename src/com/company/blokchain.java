package com.company;

public class blokchain {
    private int index;
    private String data;
    private String timestamp;
    private String prevhash;
    private String hash;

    public blokchain(int index, String data, String timestamp, String prevhash, String hash) {
        this.index = index;
        this.data = data;
        this.timestamp = timestamp;
        this.prevhash = prevhash;
        this.hash = hash;
    }

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
}
