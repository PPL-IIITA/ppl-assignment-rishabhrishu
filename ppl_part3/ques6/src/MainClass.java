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

    /**
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        int t = 30;
        MainClass var = new MainClass();
        var.run(t);
    }

    /**
     * Used to initialize everything
     *
     * @param t as given in question
     */
    public void run(int t) {
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
            _Logger logger = new _Logger("logfileq6.txt");
            ca.setLogger(logger);
            coupleList = ca.makeCouple();
            System.out.printf("=============>\n");
            System.out.println("------ Success ------");

            for (day = 1; day <= t; day++) {
                System.out.println("\n\nDay :" + day);
                System.out.println("Performing gifting::");
                for (Couple c : coupleList) {
                    c.createGiftBasket(logger);
                }

                System.out.println("Performing breakup of couples , whose happiness is less than " + t + ":");
                int flag = 0;
                for (int i = 0; i < coupleList.size(); i++) {
                    if (coupleList.get(i).getHappiness() < t) {
                        flag = 1;
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
                }
                if (flag == 0) {
                    System.out.println("No couple with happiness less than " + t + " was found.");
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
