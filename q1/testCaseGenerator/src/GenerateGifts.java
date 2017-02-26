/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;

/**
 * This class is used to randomly generate gifts
 * Format-
 * for essential-type,price,value
 * for luxury- type,price,value,rating,difficulty
 * for utility- type,price,value,utilityClass,utilityValue
 * @author Rishabh Rishu
 */

public class GenerateGifts {

    private int noOfGifts;
    Random random;
/**
 * 
 * @param n No. of gifts to be generated
 */
    public GenerateGifts(int n) {
        noOfGifts = n;
        this.write();
    }

    private void write() {
        String name;
        int rating;
        String difficulty;
        float price;
        float value;
        String utilityValue;
        String utilityClass;
        String type;

        try {
            File file = new File("../../input/gifts.csv");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);

            int i;
            for (i = 0; i < noOfGifts; i++) {
                type = this.getType();
                price = this.getPrice();
                value = this.getValue();
                switch (type) {
                    case "essential":
                        fileWriter.write(type + "," + price + "," + value + "\n");
                        fileWriter.flush();
                        break;
                    case "luxury":
                        price += 100.0;
                        value += 50.0;
                        rating = this.getRating();
                        difficulty = this.getDifficulty();
                        fileWriter.write(type + "," + price + "," + value + "," + rating + "," + difficulty + "\n");
                        fileWriter.flush();
                        break;
                    case "utility":
                        price += 50.0;
                        value += 25.5;
                        utilityClass = this.getUtilityClass();
                        utilityValue = this.getUtilityValue();
                        fileWriter.write(type + "," + price + "," + value + "," + utilityClass + "," + utilityValue + "\n");
                }
                System.gc();
            }
            fileWriter.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private String getType() {
        random = new Random();
        int i = random.nextInt() % 3;
        if (i == 0) {
            return "essential";
        } else if (i == 1) {
            return "luxury";
        } else {
            return "utility";
        }
    }

    private String getUtilityClass() {
        String s = "";
        random = new Random();
        for (int i = 0; i < 10; i++) {
            s = s + (char) (random.nextInt(26) + 'a');
        }
        return s;
    }

    private String getUtilityValue() {
        String s = "";
        random = new Random();
        for (int i = 0; i < 6; i++) {
            s = s + (char) (random.nextInt(10) + '0');
        }
        return s;
    }

    private String getDifficulty() {
        random = new Random();
        int i = random.nextInt()%5;
        switch (i){
            case 0:
                return "very easy";
            case 1:
                return "easy";
            case 2:
                return "medium";
            case 3:
                return "hard";
            case 4:
                return "very hard";
            default:
                return "almost impossible";
            
        }
    }

    private int getRating() {
        return new Random().nextInt(11)+1;
    }

    private float getValue() {
        random = new Random();
        return random.nextFloat()*1000 - random.nextFloat()*2000 ;
    }

    private float getPrice() {
        random = new Random();
        return random.nextFloat()*200.0f+150.0f;
    }
}
