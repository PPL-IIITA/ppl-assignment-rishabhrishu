/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.relationship.*;

import java.util.*;
import java.io.*;

/**
 *
 * @author rishabh
 */
public class ScanIpRandK {

    RandomK<Boy> boyList;
    RandomK<Girl> girlList;
    RandomK<Gift> giftList;

    /**
     * Method for scanning list of boys from a file
     * @param k as given in question
     * @return list of boys
     */
    public RandomK<Boy> getBoyList(int k) {
        String name;
        int attractiveness;
        double girlfriendBudget;
        int intelligenceLevel;
        String type;
        boyList = new RandomK<Boy>(k);
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
                if (type.equals("miser")) {
                    boyList.add(new MiserBoy(name, attractiveness, intelligenceLevel, girlfriendBudget));

                } else if (type.equals("geeks")) {
                    boyList.add(new GeekyBoy(name, attractiveness, intelligenceLevel, girlfriendBudget));
                } else {
                    boyList.add(new GenerousBoy(name, attractiveness, intelligenceLevel, girlfriendBudget));
                }
            }
            bufferedReader.close();

        } catch (IOException ex) {
            System.out.println("---File not found---");
        }
        return boyList;
    }

    /**
     * Method for scanning list of girls from the file
     *
     * @param k as given in question
     * @return list of girls
     */
    public RandomK<Girl> getGirlList(int k) {
        String name;
        int attractiveness;
        double maintenanceBudget;
        int intelligenceLevel;
        String type;
        girlList = new RandomK<Girl>(k);
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
                if (type.equals("normal")) {
                    girlList.add(new NormalGirl(name, attractiveness, intelligenceLevel, maintenanceBudget));

                } else if (type.equals("desperate")) {
                    girlList.add(new DesperateGirl(name, attractiveness, intelligenceLevel, maintenanceBudget));
                } else {
                    girlList.add(new ChoosyGirl(name, attractiveness, intelligenceLevel, maintenanceBudget));
                }
            }
            bufferedReader.close();

        } catch (IOException ex) {
            System.out.println("---File not found---");
        }
        return girlList;
    }

    /**
     * Method for scanning the list of Gifts from file
     * @param k as given in question
     * @return list of gifts
     */
    public RandomK<Gift> getGiftList(int k) {
        String name;
        int rating;
        String difficulty;
        float price;
        float value;
        String utilityValue;
        String utilityClass;
        String type;
        giftList = new RandomK<Gift>(k);
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
                    giftList.add(new EssentialGift(price, value));
                } else if (type.equalsIgnoreCase("luxury")) {
                    rating = Integer.parseInt(st.nextToken());
                    difficulty = st.nextToken();
                    giftList.add(new LuxuryGift(price, value, rating, difficulty));
                } else {
                    utilityClass = st.nextToken();
                    utilityValue = st.nextToken();
                    giftList.add(new UtilityGift(price, value, utilityClass, utilityValue));
                }
            }
            bufferedReader.close();

        } catch (IOException ex) {
            System.out.println("---File not found---");
        }
        return giftList;
    }

}
