/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;
/**
 * This Class is used to randomly generate boys
 * Format - name,attractiveness,girlfriend_bugget,intelligence,type
 * @author Rishabh Rishu(IIT2015068)
 */


public class GenerateBoys {

    private int noOfBoys;
    Random random;
/**
 * 
 * @param n No. of boys we want to generate
 */
    public GenerateBoys(int n) {
        noOfBoys = n;
        this.write();
    }
/**
 * Method to write the boy attributes in a file
 */
    private void write() {
        String name;
        int attractiveness;
        double maintenanceBudget;
        int intelligenceLevel;
        String type;

        try {
            File file = new File("../../input/boys.csv");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);

            int i;
            for (i = 0; i < noOfBoys; i++) {
                random = new Random();
                name = this.getName(random.nextInt(15) + 5);
                attractiveness = this.getAttractiveness();
                maintenanceBudget = this.getBudget();
                intelligenceLevel = this.getIntelligence();
                type = this.getType();
                fileWriter.write(name + "," + attractiveness + "," + maintenanceBudget + "," + intelligenceLevel + "," + type + "\n");
                fileWriter.flush();
                System.gc();
            }
            fileWriter.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String getName(int no) {
        String s = "";
        random = new Random();
        for (int i = 0; i < no; i++) {
            s = s + (char) (random.nextInt(26) + 'a');
        }
        return s;
    }

    private int getAttractiveness() {
        random = new Random();
        return random.nextInt(100);
    }

    private double getBudget() {
        random = new Random();
        return (random.nextDouble() * 3000.0 + 500.0);
    }

    private int getIntelligence() {
        random = new Random();
        return random.nextInt(91) + 10;
    }

    private String getType() {
        random = new Random();
        int i = random.nextInt() % 3;
        if (i == 0) {
            return "miser";
        } else if (i == 1) {
            return "generous";
        } else {
            return "geeks";
        }
    }

}

