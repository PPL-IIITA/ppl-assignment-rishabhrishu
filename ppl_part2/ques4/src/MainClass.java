/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import com.relationship.*;
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
     * @param args k , as given in question
     */
    public static void main(String[] args) {
        int k = new Random().nextInt(10)+2;
        MainClass var = new MainClass();
        var.run(k);
    }

    /**
     * Used to initialize everything
     *
     * @param k for finding k best couples
     */
    public void run(int k) {
        ScanInput sc = new ScanInput();
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
            CoupleAllocator ca = new CoupleAllocatorMethod1(boyList, girlList, giftList);
            ca.setLogger(new _Logger("logfileq4.txt"));
            coupleList = ca.makeCouple();
            System.out.printf("=============>\n");
            System.out.println("------ Success ------");

            System.out.println("Performing breakup of k least happy couples:");
            this.getLeastK_happiest(k);
            for (int i =0; i <k;i++) {
                Girl g = coupleList.get(i).getGirl();
                System.out.println("\nPerforming breakup of " + g.getName());
                coupleList = ca.breakupCouple(coupleList.get(i));
                Couple cou = ca.findNewBf(g);
                if (cou != null) {
                    coupleList.add(cou);
                    System.out.print("Couple Created:\n" + cou);
                } else {
                    System.out.println("No suitable boy present for girl");
                }

            }

        } catch (InterruptedException ex) {
            System.out.println("Oops, Error occured, please try again");
        }

    }

    /**
     * Helper method to get k least happiest couples
     *
     * @param k k
     */
    public void getLeastK_happiest(int k) {
        Collections.sort(coupleList, (Object o1, Object o2) -> {
            Couple v1 = (Couple) o1;
            Couple v2 = (Couple) o2;
            return Double.compare(v1.getHappiness(), v2.getHappiness());
        });
       
    }

    /**
     * Helper method to print k most compatible couples
     *
     * @param k k
     */
    public void printK_compatible(int k) {
        System.out.println("\nPrinting " + k + " most compatible couples:");
        Collections.sort(coupleList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Couple v1 = (Couple) o1;
                Couple v2 = (Couple) o2;
                return Integer.compare(v2.getCompatibility(), v1.getCompatibility());
            }
        });
        for (int i = 0; i < k; i++) {
            System.out.println(coupleList.get(i));
        }
    }

    /**
     * Helper method to print gift exchanges between couples
     */
    public void printGifting() {
        System.out.println("\nPrinting gift exchanges between couples:");
        for (Couple c : coupleList) {
            System.out.println(c);
            c.printGiftExchange();
        }
    }
}
