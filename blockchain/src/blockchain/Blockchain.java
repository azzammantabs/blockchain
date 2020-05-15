/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

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
    public ArrayList listBlockchain = new ArrayList();

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
    
    

    public void clearBlokchain() {
        listBlockchain.clear();
    }

    public void createGenesis() {
        this.data = "Genesis";
        this.timestamp = "0";
        this.index = 0;
        this.hash = "0";
        this.prevhash = "0";
        this.nounce = "0";
    }


    private int getLastBlock() {
        return listBlockchain.size() - 1 ;
    }

    public void createBlock(Block nBlock) {
        Block temp_block = (Block) listBlockchain.get(getLastBlock());
        nBlock.prevHash = temp_block.hash;
        nBlock.hash = nBlock.getHash();
        listBlockchain.add(nBlock);
    }

    public void printData() {
        for (int i = 0; i < listBlockchain.size(); i++) {
            Block temp_block = (Block) listBlockchain.get(i);
            System.out.println("index : "+temp_block.index+
                    " data: "+temp_block.data+
                    " time : "+temp_block.timestamp+
                    " hash : " +temp_block.hash+
                    " prev hash : "+temp_block.prevHash);
        }
    }

    public Boolean isBlockValid() {
        for (int i = 0; i < listBlockchain.size(); i++) {
            Block tempBlock1 = (Block) listBlockchain.get(i - 1);
            Block tempBlock2 = (Block) listBlockchain.get(i);
            if (tempBlock2.hash != tempBlock2.getHash()) {
                return false;
            }else if (tempBlock2.prevHash != tempBlock1.hash) {
                return false;
            }
        }
        return true;
    }

}

