/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public static void main(String[] args) {
        // TODO code application logic here
        
        // write your code here
        //initiate object
        Scanner input = new Scanner(System.in);
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("EyyyyMMddhhmmssa");
        blokchains = new ArrayList<>();

        //Create Node 1
        Blockchain Block1 = new Blockchain();
        Block1.clearBlokchain();
        Block1.createGenesis();

        //Create Node 2
        Blockchain Block2 = new Blockchain();
        Block2.clearBlokchain();
        Block2.createGenesis();

        //Create Node 3
        Blockchain Block3 = new Blockchain();
        Block3.clearBlokchain();
        Block3.createGenesis();

        //Create Data Pool
        ArrayList dataPool = new ArrayList();

        //Data entered into Data Pool
        dataPool.add("Data 1");
        dataPool.add("Data 2");
        dataPool.add("Data 3");

        //Data entered from Data Pool into Block
        Block nBlock11 = new Block(); //entered into node 1
        nBlock11.data = (String) dataPool.get(0);
        Block1.createBlock(nBlock11);

        Block nBlock21 = new Block(); //entered into node 2
        nBlock21.data = (String) dataPool.get(0);
        Block2.createBlock(nBlock11);

        Block nBlock31 = new Block(); //entered into node 3
        nBlock31.data = (String) dataPool.get(0);
        Block3.createBlock(nBlock11);

        dataPool.remove(0);

        Block1.printData();
        Block2.printData();
        Block3.printData();
    }
    
}
