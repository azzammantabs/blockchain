/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import static blockchain.Block.encrypt;
import static blockchain.Block.getNounce;
import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
/**
 *

 * @author Abdullah Azzam
 */
public class main {

    /**
     * @param args the command line arguments
     */
    private static List<Blockchain> blokchains;
    public static void main(String[] args) throws IOException, AWTException, SQLException {
        // TODO code application logic here
        // write your code here
        
        //Create Node API
         nodeapi na = new nodeapi();

        //Check Node Database is Null or Not
        boolean st_node = na.checkNode();
        boolean st_anisnode = na.checkAnisNode();
        boolean st_abinode = na.checkAbiNode();
        
        if (st_node) {
            //Create Node Azzam
            Blockchain Block1 = new Blockchain();
            Block1.clearBlokchain();
            Block1.createGenesis();
            //initiate genesis into node azzam
            na.insertNode(Block1.getIndex(), Block1.getData(), Block1.getTimestamp(), Block1.getPrevhash(), Block1.getHash(), Block1.getNounce());
        } 
        if (st_anisnode) {
            //Create Node Anis
            Blockchain Block2 = new Blockchain();
            Block2.clearBlokchain();
            Block2.createGenesis();
            //initiate genesis into node anis
            na.insertAnisNode(Block2.getIndex(), Block2.getData(), Block2.getTimestamp(), Block2.getPrevhash(), Block2.getHash(), Block2.getNounce());
        } 
        if (st_abinode) {
             //Create Node Abi
            Blockchain Block3 = new Blockchain();
            Block3.clearBlokchain();
            Block3.createGenesis();
            //initiate genesis into node abi
            na.insertAbiNode(Block3.getIndex(), Block3.getData(), Block3.getTimestamp(), Block3.getPrevhash(), Block3.getHash(), Block3.getNounce());
        }
        
        //home page
        Scanner input = new Scanner(System.in);
        Date date = new Date();
        int pil=0;
        while (pil!=3) {
            //Home Interface Program
            System.out.println("--Blockchain--");
            System.out.println("1. Insert Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Keluar");
            System.out.println("--------------");
            System.out.print("pilih : "); pil = input.nextInt();
            if (pil==1) {
                //insert data client
                Scanner insert = new Scanner(System.in);
                System.out.print("masukkan data: "); String dat = insert.nextLine();
                long time = date.getTime();
                Timestamp ts = new Timestamp(time);
                
                //get the last block 
                Block lastBlock = na.getLastBlockN();
                
                int idx = lastBlock.index+1;
                String prevhash = lastBlock.hash;
                String timestamp = String.valueOf(ts);
                String hs = String.valueOf(idx)+dat+timestamp+prevhash;
                String hash = encrypt(hs);
                
                //create data pool API
                datapoolapi dp = new datapoolapi();
                //data entered from client input to 3 data pool database
                dp.insertDatapool(idx, dat, timestamp, prevhash, hash); //data pool 1
                dp.insertDatapoolNode2(idx, dat, timestamp, prevhash, hash); //data pool 2
                dp.insertDatapoolNode3(idx, dat, timestamp, prevhash, hash); //data pool 3               
                
                //create Block 
                Block nBlock = new Block();
                nBlock.index = idx;
                nBlock.data = dat;
                nBlock.timestamp = timestamp;
                nBlock.prevHash = prevhash;
                nBlock.hash = hash;
                
                //find nounce
                System.out.println("Mining...");
                String nounce = getNounce(idx+dat+timestamp+prevhash+hash);
                long ntime = date.getTime();
                Timestamp nouncets = new Timestamp(ntime);
                
                //create temp nounce API
                tempnounceapi ta = new tempnounceapi();  
                //insert to temp_nouce
                ta.insertTempNounce(nounce, nouncets);
                
                //check temp_nounce in every node other computer
                boolean status1 = false;
                boolean status2 = false;
                boolean status3 = false;
                while (status1==false && status2==false && status3==false) {
                    status1 = ta.checkNounce1();
                    status2 = ta.checkNounce2();
                    status3 = ta.checkNounce3();
                }
                //create 3 Temp Nounce Object
                TempNounce tn1 = ta.getNounce1();
                TempNounce tn2 = ta.getNounce2();
                TempNounce tn3 = ta.getNounce3();
                
                //select the nounce is the fastest time
                String fixnounce = "";
                Timestamp ts1 = tn1.getTs();
                Timestamp ts2 = tn2.getTs();
                Timestamp ts3 = tn3.getTs();                
                
                if (status1 && status2==false && status3==false) {
                    fixnounce = tn1.getNounce();
                } else if (status1==false && status2 && status3==false) {
                    fixnounce = tn2.getNounce();
                } else if (status1==false && status2==false && status3) {
                    fixnounce = tn3.getNounce();
                } else if (status1 && status2 && status3==false) {
                    long lo = Math.min(ts1.getTime(), ts2.getTime()); //minimum value of ts1 & ts2
                    if (lo==ts1.getTime()) {
                        fixnounce = tn1.getNounce();
                    } else if (lo==ts2.getTime()) {
                        fixnounce = tn2.getNounce();
                    }
                } else if (status1 && status2==false && status3) {
                    long loo = Math.min(ts1.getTime(), ts3.getTime());//minimum value of ts1 & ts3
                    if (loo==ts1.getTime()) {
                        fixnounce = tn1.getNounce();
                    } else if (loo==ts3.getTime()) {
                        fixnounce = tn3.getNounce();
                    }
                } else if (status1==false && status2 && status3) {
                    long lnn = Math.min(ts2.getTime(), ts3.getTime());//minimum value of ts2 & ts3
                    if (lnn==ts2.getTime()) {
                        fixnounce = tn2.getNounce();
                    } else if (lnn==ts3.getTime()) {
                        fixnounce = tn3.getNounce();
                    }
                } else if (status1 && status2 && status3) {
                    long lo = Math.min(ts1.getTime(), ts2.getTime()); //minimum value of ts1 & ts2
                    long lon = Math.min(lo, ts3.getTime()); //minimun value of lo & ts3
                    if (lon==ts1.getTime()) {
                        fixnounce = tn1.getNounce();
                    } else if (lon==ts2.getTime()) {
                        fixnounce = tn2.getNounce();
                    } else if (lon==ts3.getTime()) {
                        fixnounce = tn3.getNounce();
                    }
                }
                
                nBlock.nounce = fixnounce;
                
                //data entered from data pool into Block 
                //into node_block computer 1
                na.insertNode(nBlock.index, nBlock.data, nBlock.timestamp, nBlock.prevHash, nBlock.hash, nBlock.nounce);
                
                //into node_block computer 2
                na.insertAnisNode(nBlock.index, nBlock.data, nBlock.timestamp, nBlock.prevHash, nBlock.hash, nBlock.nounce);

                //into node_block computer 3
                na.insertAbiNode(nBlock.index, nBlock.data, nBlock.timestamp, nBlock.prevHash, nBlock.hash, nBlock.nounce);
                
                //remove temp_nounce
                ta.deleteTempNounce();
                //remove data pool
                dp.deleteDatapool(nBlock.index);
                
            } else if (pil==2) {
                //print out data
                na.printNodeData();
                System.out.print("press enter to back..."); 
                Scanner back = new Scanner(System.in); back.nextLine();
            } else {
                if (pil!=3 ) {
                    System.out.println("the number not found, please choose again");
                    
                }
            }
        }
        

        
    }
    
    
}
