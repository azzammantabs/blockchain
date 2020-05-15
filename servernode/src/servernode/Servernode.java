/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servernode;

import java.sql.Timestamp;
import java.util.Date;
import static servernode.Block.getNounce;

/**
 *
 * @author Abdullah Azzam
 */
public class Servernode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Create date object
        Date date = new Date();
        //Create Data Pool API
        datapoolapi dp = new datapoolapi();
        //Create Node API
        nodeapi na = new nodeapi();
        //Create Block
        Block nBlock = new Block();
        Block lb = new Block(); //for last block before check node
        Block nlb = new Block();//for last block in check node loop
        //Looping Forever
        //Server is starting
        System.out.println("Server is starting...");
        while (true) {
            boolean status = dp.checkDataPool();
            
            if (status) {                
                //get last index node_block
                lb = na.getLastBlockN();
                int lid = lb.index; //last index node_block
                
                System.out.println("Data Pool Filled");
                //execute nounce function
                nBlock = dp.getDataPool(); //get data pool
                System.out.println("index: "+nBlock.index);
                
                //find nounce
                System.out.println("Mining...");
                String nounce = getNounce(nBlock.index+nBlock.data+nBlock.timestamp+nBlock.prevHash+nBlock.hash, lid);
                long time = date.getTime();
                Timestamp ts = new Timestamp(time);
                nBlock.nounce = nounce;
                //Create temp nounce API
                tempnounceapi tn = new tempnounceapi();            
                //insert to  temp_nounce
                tn.insertTempNounce(nounce, ts);
                
                //check node_block 
                System.out.println("Check Node Block");
                boolean st = false; //create status variable
                //looping until node_block increase
                while (st==false) {
                    //get last index node_block
                    nlb = na.getLastBlockN();
                    int nlid = nlb.index; //last index node_block
                    if (nlid == lid+1) {
                        st = true;
                    }
                }
                //Remove Temp Nounce
                System.out.println("Remove Temp Nounce");
                tn.deleteDatapool();
                //Remove Data Pool
                System.out.println("Remove Data Pool");
                dp.deleteDatapool(nBlock.index);
            }
        }
        
    }
    
}
