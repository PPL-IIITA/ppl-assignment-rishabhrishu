/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

import java.util.*;
import java.io.*;

/**
 * Helper class to scan the inputs from a csv file
 * @author rishabh(IIT2015068)
 */
public class ScanInput {

    ArrayList<Boy> boyList;
    ArrayList<Girl> girlList;
    ArrayList<Gift> giftList;

    /**
     * Method for scanning list of boys from a file
     * @throws InvalidBoyTypeError when file does not contain a valid boy type
     * @return list of boys
     */
    public ArrayList<Boy> getBoyList() throws InvalidBoyTypeError {
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
                if (type.equals("miser")) {
                    boyList.add(new MiserBoy(name, attractiveness, intelligenceLevel, girlfriendBudget));

                } else if (type.equals("geeks")) {
                    boyList.add(new GeekyBoy(name, attractiveness, intelligenceLevel, girlfriendBudget));
                } else if (type.equals("generous")){
                    boyList.add(new GenerousBoy(name, attractiveness, intelligenceLevel, girlfriendBudget));
                } else {
                    throw new InvalidBoyTypeError("Type of boy not as per given instructions");
                }
            }
            bufferedReader.close();

        } catch (IOException ex) {
            System.out.println("---File containing list of boys not found---");
        }
        return boyList;
    }

    /**
     * Method for scanning list of girls from the file
     * @throws InvalidGirlTypeError when file does not contain a valid girl type
     * @return list of girls
     */
    public ArrayList<Girl> getGirlList() throws InvalidGirlTypeError{
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
                if (type.equals("normal")) {
                    girlList.add(new NormalGirl(name, attractiveness, intelligenceLevel, maintenanceBudget));

                } else if (type.equals("desperate")) {
                    girlList.add(new DesperateGirl(name, attractiveness, intelligenceLevel, maintenanceBudget));
                } else if (type.equals("choosy")){
                    girlList.add(new ChoosyGirl(name, attractiveness, intelligenceLevel, maintenanceBudget));
                } else {
                    throw new InvalidGirlTypeError("Type of girl not as per given instructions");
                }
            }
            bufferedReader.close();

        } catch (IOException ex) {
            System.out.println("---File containing list of girls not found---");
        }
        return girlList;
    }

    /**
     * Method for scanning the list of Gifts from file
     * @throws InvalidGiftTypeError when file does not contain a valid gift type
     * @return list of gifts
     */
    public ArrayList<Gift> getGiftList() throws InvalidGiftTypeError {
        String name;
        int rating;
        String difficulty;
        float price;
        float value;
        String utilityValue;
        String utilityClass;
        String type;
        giftList = new ArrayList<Gift>();
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
                } else if (type.equals("utility")){
                    utilityClass = st.nextToken();
                    utilityValue = st.nextToken();
                    giftList.add(new UtilityGift(price, value, utilityClass, utilityValue));
                } else {
                    throw new InvalidGiftTypeError("Type of gift not as per given instructions");
                }
            }
            bufferedReader.close();

        } catch (IOException ex) {
            System.out.println("---File not found---");
        }
        Collections.sort(giftList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Gift v1 = (Gift) o1;
                Gift v2 = (Gift) o2;
                return Double.compare(v1.getPrice(), v2.getPrice());
            }

        });
        return giftList;
    }

}
