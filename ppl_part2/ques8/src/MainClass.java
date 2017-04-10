/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rishabh Rishu
 */
import com.relationship.*;
import java.util.*;


/**
 * Main Class of package
 *
 * @author Rishabh Rishu(IIT2015068)
 */
public class MainClass {

    ArrayList<Boy> boyList;
    ArrayList<Girl> girlList;
    ArrayList<Gift> giftList;
    ArrayList<Couple> coupleList;

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        MainClass var = new MainClass();
        var.run();
        var.printGifting();
    }

    /**
     * Used to initialize everything
     *
     */
    public void run() {
        ScanInput sc = new ScanInput();
        String algorithm;
        try {
            System.out.println("****** Welcome to Match Finder ********");
            System.out.println("-------------------------------------");
            Thread.sleep(300);
            System.out.println("****** Obtaining details of Boys *****");
            boyList = sc.getBoyList();
            System.out.printf("<===========");
            Thread.sleep(800);
            System.out.printf("============");
            Thread.sleep(800);
            System.out.printf("=============>\n");
            System.out.println("------ Success ------");

            System.out.println("*****Obtaining details of Girls******");
            girlList = sc.getGirlList();
            System.out.printf("<===========");
            Thread.sleep(800);
            System.out.printf("============");
            Thread.sleep(800);
            System.out.printf("=============>\n");
            System.out.println("------ Success ------");

            System.out.println(" **** Obtaining details of Gifts ****");
            System.out.printf("<===========");
            Thread.sleep(800);
            System.out.printf("============");
            Thread.sleep(800);
            System.out.printf("=============>\n");
            giftList = sc.getGiftList();
            System.out.println("------ Success ------");

            System.out.println(" ********* Making Couples **********");
            System.out.printf("<===========");
            Thread.sleep(800);
            System.out.printf("============");
            Thread.sleep(800);
            
        /*algorithm is randomly generated here, however, to change algorithm here, remove the random code,
         and manually enter the algorithm, or dont enter anything, for a default value selection   */ 
        
        //random code start
            int rnd = new Random().nextInt(2)+1;
            if ( rnd == 1)
                algorithm = "Method 1";
            else
                algorithm = "Method 2";
        //random code ends    
            
            CoupleAllocator ca = new CoupleAllocatorMethod1(boyList, girlList, giftList,algorithm);
            ca.setLogger(new _Logger("logfileq8.txt"));
            coupleList = ca.makeCouple();
            System.out.printf("=============>\n");
            System.out.println("------ Success ------");

        } catch (InterruptedException ex) {
            System.out.println("Oops, Error occured, please try again");
        }

    }

    /**
     * Helper method to print gift exchanges between couples
     */
    public void printGifting() {
        System.out.println("\nPrinting gift exchanges between couples:");
        coupleList.stream().map((c) -> {
            System.out.println(c);
            return c;
        }).forEach((c) -> {
            c.printGiftExchange();
        });
    }
}
