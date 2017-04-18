/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import com.relationship.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    List<String> queryList;
    CoupleList committedBoys;

    /**
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        MainClass var = new MainClass();
        var.run();
    }

    /**
     * Used to initialize everything
     *
     */
    public void run() {
        ScanInput sc = new ScanInput();
        int day = 1;
        try {
            System.out.println("****** Welcome to Match Finder ********");
            System.out.println("-------------------------------------");
            Thread.sleep(300);
            System.out.println("****** Obtaining details of Boys *****");
            try {
                boyList = sc.getBoyList();
            } catch (InvalidBoyTypeError ex) {
                System.out.println(ex.getMessage());
                System.out.println("Now exiting...");
                System.exit(0);
            }

            System.out.println("*****Obtaining details of Girls******");
            try {
                girlList = sc.getGirlList();
            } catch (InvalidGirlTypeError ex) {
                System.out.println(ex.getMessage());
                System.out.println("Now exiting...");
                System.exit(0);
            }

            System.out.println(" **** Obtaining details of Gifts ****");

            try {
                giftList = sc.getGiftList();
            } catch (InvalidGiftTypeError ex) {
                System.out.println(ex.getMessage());
                System.out.println("Now exiting...");
                System.exit(0);
            }
            System.out.println("------ Success ------");

            System.out.println(" ********* Making Couples **********");
            System.out.printf("<===========");
            Thread.sleep(800);
            System.out.printf("============");
            Thread.sleep(800);
            CoupleAllocator ca = new CoupleAllocatorMethod1(boyList, girlList, giftList);
            ca.setLogger(new _Logger("logfileq7.txt"));
            coupleList = ca.makeCouple();
            System.out.printf("=============>\n");
            System.out.println("------ Success ------");

            /* Here, use any of the three methods*/
            committedBoys = new CoupleListMethod3(coupleList);

            /* Here, use any of the three methods*/
            committedBoys = new CoupleListMethod3(coupleList);

            /*queryList is a container<? extends java.util.List<String>> containing list of boys*/
            queryList = new ArrayList<String>();

            /* to fill queryList, here i take out two random boys name from coupleList, and two randomly generated Strings
             * this can be changed as per need. But ensure that boy's name is picked from csv file, for true
             */
            queryList.add("jfasjfagsjsfd");
            queryList.add("vhjdvgvsbdhjvbkjsdb");
            queryList.add(coupleList.get(3).getBoy().getName());
            queryList.add(coupleList.get(0).getBoy().getName());
            this.findBoys(queryList);

        } catch (InterruptedException ex) {
            System.out.println("Oops, Error occured, please try again");
        }

    }

    /**
     * Helper method to find if a boy is in a relationship or not
     *
     * @param queryList query containing list of boys
     */
    public void findBoys(List<String> queryList) {
        for (String s : queryList) {
            System.out.print("For Boy-" + s + " : Girl-");
            System.out.println(committedBoys.hasGirlfriend(s));
        }
    }

}
