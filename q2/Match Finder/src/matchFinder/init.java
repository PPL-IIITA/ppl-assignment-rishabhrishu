/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchFinder;

import java.util.*;
import java.io.*;
import java.sql.Timestamp;

/**
 * <p>
 * This class takes input, the list of boys, girls and gifts from file and
 * stores it<br>
 * This class also makes the couples as per given logic.
 * </p>
 *
 * @author Rishabh (IIT2015068)
 */
public class init {

    ArrayList<Boy> boyList;
    ArrayList<Girl> girlList;
    ArrayList<Couple> coupleList;
    ArrayList<Gifts> giftsList;

    /**
     * <p>
     * Sets up the program,i.e., fetches list of boys, girls and gifts, and
     * tries to make couples</p>
     */
    public void run() {
        try {
            System.out.println("****** Welcome to Match Finder ********");
            System.out.println("-------------------------------------");
            Thread.sleep(300);
            System.out.println("****** Obtaining details of Boys *****");
            this.getBoyList();
            System.out.printf("<===========");
            Thread.sleep(800);
            System.out.printf("============");
            Thread.sleep(800);
            System.out.printf("=============>\n");
            System.out.println("------ Success ------");

            System.out.println("*****Obtaining details of Girls******");
            this.getGirlList();
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
            this.getGiftsList();
            System.out.println("------ Success ------");

            System.out.println(" ********* Making Couples **********");
            System.out.printf("<===========");
            Thread.sleep(800);
            System.out.printf("============");
            Thread.sleep(800);
            this.findSoulMates();
            System.out.printf("=============>\n");
            System.out.println("------ Success ------");

        } catch (InterruptedException ex) {

        }

    }

    /**
     * Helper function for scanning list of boys from a file
     */
    public void getBoyList() {
        String name;
        int attractiveness;
        double girlfriendBudget;
        int intelligenceLevel;
        String type;
        boyList = new ArrayList<Boy>();
        try {
            File file = new File("../../input/boys.csv");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                name = st.nextToken();
                attractiveness = Integer.parseInt(st.nextToken());
                girlfriendBudget = Double.parseDouble(st.nextToken());
                intelligenceLevel = Integer.parseInt(st.nextToken());
                type = st.nextToken();
                boyList.add(new Boy(name, attractiveness, girlfriendBudget, intelligenceLevel, type));
            }
            bufferedReader.close();

        } catch (IOException ex) {
            System.out.println("---File not found---");
        }
    }

    /**
     * Helper function for scanning list of girls from the file
     */
    public void getGirlList() {
        String name;
        int attractiveness;
        double maintenanceBudget;
        int intelligenceLevel;
        String type;
        girlList = new ArrayList<Girl>();
        try {
            File file = new File("../../input/girls.csv");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                name = st.nextToken();
                attractiveness = Integer.parseInt(st.nextToken());
                maintenanceBudget = Double.parseDouble(st.nextToken());
                intelligenceLevel = Integer.parseInt(st.nextToken());
                type = st.nextToken();
                girlList.add(new Girl(name, attractiveness, maintenanceBudget, intelligenceLevel, type));
            }
            bufferedReader.close();

        } catch (IOException ex) {
            System.out.println("---File not found---");
        }
    }

    /**
     * Helper function for scanning the list of Gifts from file
     */
    public void getGiftsList() {
        String name;
        int rating;
        String difficulty;
        float price;
        float value;
        String utilityValue;
        String utilityClass;
        String type;
        giftsList = new ArrayList<Gifts>();
        try {
            File file = new File("../../input/gifts.csv");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                type = st.nextToken();
                price = Float.parseFloat(st.nextToken());
                value = Float.parseFloat(st.nextToken());
                if (type.equalsIgnoreCase("essential")) {
                    giftsList.add(new Gifts(type, price, value));
                } else if (type.equalsIgnoreCase("luxury")) {
                    rating = Integer.parseInt(st.nextToken());
                    difficulty = st.nextToken();
                    giftsList.add(new Gifts(type, price, value, rating, difficulty));
                } else {
                    utilityClass = st.nextToken();
                    utilityValue = st.nextToken();
                    giftsList.add(new Gifts(type, price, value, utilityClass, utilityValue));
                }
            }
            bufferedReader.close();

        } catch (IOException ex) {
            System.out.println("---File not found---");
        }
        Collections.sort(giftsList, new giftComparator());
    }

    /**
     * Attempts to allocate a suitable boyfriend to all the girls
     */
    public void findSoulMates() {
        coupleList = new ArrayList<Couple>();
        File file = new File("../log.txt");
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.close();
            for (Girl girl : girlList) {
                if (!girl.getStatus()) {
                    for (Boy boy : boyList) {
                        if (!boy.getStatus()) {
                            if (boy.getGirlfriendBudget() >= girl.getMaintenanceBudget()) {
                                Couple c = new Couple(girl, boy, giftsList);
                                coupleList.add(c);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (IOException ex) {

        }
    }

    /**
     * Utility Function to print Couple List
     */
    public void display() {
        int i = 0;
        for (Couple couple : coupleList) {
            System.out.println("couple " + (++i));
            System.out.println(couple.toString());
        }
    }

    /**
     * Utility Function to print k happiest couples
     *
     * @param k k
     */
    public void printHappyCouples(int k) {
        Collections.sort(coupleList,Collections.reverseOrder(new happinessComparator()));
        int i;
        for (i = 0; i < k; i++) {
            System.out.print(coupleList.get(i).toString());
            System.out.println("Happiness :"+coupleList.get(i).getHappiness()+"\n");
        }

    }

    /**
     * Utility Method to print k most compatible couples
     *
     * @param k k
     */
    public void printCompatibleCouples(int k) {
        Collections.sort(coupleList,Collections.reverseOrder(new compatibilityComparator()));
        int i;
        for (i = 0; i < k; i++) {
            System.out.print(coupleList.get(i).toString());
            System.out.println("Compatibility :"+coupleList.get(i).getCompatibility()+"\n");
        
        }

    }

    /**
     * Inner Class used to sort Gifts List according to their cost
     */
    public class giftComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            Gifts v1 = (Gifts) o1;
            Gifts v2 = (Gifts) o2;
            return Float.compare(v1.getPrice(), v2.getPrice());
        }

    }

    /**
     * Inner Class to sort Couple List according to their Happiness
     */
    public class happinessComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            Couple v1 = (Couple) o1;
            Couple v2 = (Couple) o2;
            return Double.compare(v1.getHappiness(), v2.getHappiness());
        }

    }

    /**
     * Inner Class to sort Couple List according to their Compatibility
     */
    public class compatibilityComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            Couple v1 = (Couple) o1;
            Couple v2 = (Couple) o2;
            return Integer.compare(v1.getCompatibility(), v2.getCompatibility());
        }

    }
}
