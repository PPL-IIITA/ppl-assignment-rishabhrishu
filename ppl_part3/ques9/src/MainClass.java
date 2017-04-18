/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import com.relationship.*;

/**
 * Main Class of package ques9
 *
 * @author Rishabh Rishu(IIT2015068)
 */
public class MainClass {

    BestKvalued<Boy> boyList;
    BestKvalued<Girl> girlList;
    BestKvalued<Gift> giftList;
    BestKvalued<Couples> coupleList;
    _Logger logger;

    /**
     * @param args
     */
    public static void main(String[] args) {
        int k = new Random().nextInt(10) + 2;
        MainClass var = new MainClass();
        var.run(k);
        var.printCouples();
        var.printGiftExchange();

    }

    /**
     * Used to initialize everything
     *
     * @param k as given in question
     */
    public void run(int k) {
        ScanIpBestK sc = new ScanIpBestK();
        logger = new _Logger ("logfileq9.txt");
        try {
            System.out.println("****** Welcome to Match Finder ********");
            System.out.println("-------------------------------------");
            Thread.sleep(300);
            System.out.println("****** Obtaining details of Boys *****");
            boyList = sc.getBoyList(k);
            System.out.printf("<===========");
            Thread.sleep(800);
            System.out.printf("============");
            Thread.sleep(800);
            System.out.printf("=============>\n");
            System.out.println("------ Success ------");

            System.out.println("*****Obtaining details of Girls******");
            girlList = sc.getGirlList(k);
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
            giftList = sc.getGiftList(k);
            System.out.println("------ Success ------");

            System.out.println(" ********* Making Couples **********");
            System.out.printf("<===========");
            Thread.sleep(800);
            System.out.printf("============");
            Thread.sleep(800);
            CoupleAllocBestK ca = new CoupleAllocBestK(boyList, girlList, giftList, k, logger);
            coupleList = ca.makeCouple(k);
            System.out.printf("=============>\n");
            System.out.println("------ Success ------");

        } catch (InterruptedException ex) {
            System.out.println("Oops, Error occured, please try again");
        }

    }

    /**
     * Helper method to print couples formed
     */
    public void printCouples() {
        System.out.println("\nPrinting all the couples formed:");
        for (int i = 0; i < coupleList.getSize(); i++) {
            System.out.println(coupleList.get(i));
        }
    }

    /**
     * Helper method to print gift exchange between couples
     */
    public void printGiftExchange() {
        System.out.println("\n\nPrinting gift exchange between couples:");
        for (int i = 0; i < coupleList.getSize(); i++) {
            System.out.println("\nBoy: " + coupleList.get(i).getBoy().getName() + "  Girl :" + coupleList.get(i).getGirl().getName());
            coupleList.get(i).printGiftExchange();
            
        }
    }
}
