/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

import java.util.ArrayList;

/**
 * Objects of this class represent couples
 * @author Rishabh Rishu(IIT2015068)
 */
public class Couple {

    ArrayList<Gift> giftStore;
    ArrayList<Gift> giftBasket;
    private Girl girl;
    private Boy boy;
    private double happiness;
    private int compatibility;

    /**
     * Constructor , where algorithm for making gift basket need not be
     * specified
     *
     * @param girl Girl, in the couple
     * @param boy Boy, in the couple
     * @param giftList List of all the available gifts,i.e, gift store
     * @param logger logger object to be used for logging purpose
     */
    public Couple(Girl girl, Boy boy, ArrayList<Gift> giftList, _Logger logger) {
        logger.log("<COUPLE FORMED>" + "Boy's Name: " + boy.getName() + " Girl's Name: " + girl.getName());
        giftBasket = new ArrayList<Gift>();
        this.girl = girl;
        this.boy = boy;
        this.giftStore = giftList;
        boy.setStatus(true);
        girl.setStatus(true);
        girl.addBf(boy);
        this.setCompatibility();
        this.createGiftBasket(logger);
        this.setHappiness();
    }

    /**
     * Constructor, where algorithm for making gift basket needs to be specified
     *
     * @param girl Girl, in the couple
     * @param boy Boy, in the couple
     * @param giftList List of all the available gifts,i.e, gift store
     * @param logger logger object to be used for logging purpose
     * @param algorithm Algorithm to be used for gifting.<br>
     * "Method 1" - gifting as in q.1 <br>
     * "Method 2" - gifting as in q.8
     */
    Couple(Girl girl, Boy boy, ArrayList<Gift> giftList, _Logger logger, String algorithm) {
        giftBasket = new ArrayList<Gift>();
        this.girl = girl;
        this.boy = boy;
        this.giftStore = giftList;
        boy.setStatus(true);
        girl.setStatus(true);
        girl.addBf(boy);
        this.setCompatibility();
        this.createGiftBasket(logger, algorithm);
        this.setHappiness();
    }

    /**
     * Calculate Happiness of couple
     */
    private void setHappiness() {
        double girlHappiness = girl.getHappiness(giftBasket);
        double boyHappiness = boy.getHappiness(girl, giftBasket);
        happiness = girlHappiness + boyHappiness;
    }

    /**
     * Creates gift basket, which is gifted to girl, by the boy.
     *
     * @param logger object of logging utility 
     */
    public void createGiftBasket(_Logger logger) {
        GiftingAlgorithm ga = new GiftingAlgorithmMethod1(boy, girl, giftStore);
        ga.setLogger(logger);
        giftBasket = ga.makeGiftBasket();
    }

    /**
     * Creates gift basket, which is gifted to girl, by the boy.
     *
     * @param logger object of logging utility 
     * @param algorithm algorithm to be specified for gifting
     */
    public void createGiftBasket(_Logger logger, String algorithm) {
        if (algorithm.equalsIgnoreCase("method 1")) {
            GiftingAlgorithm ga = new GiftingAlgorithmMethod1(boy, girl, giftStore);
            ga.setLogger(logger);
            giftBasket = ga.makeGiftBasket();
        } else if (algorithm.equalsIgnoreCase("method 2")) {
            GiftingAlgorithm ga = new GiftingAlgorithmMethod2(boy, girl, giftStore);
            ga.setLogger(logger);
            giftBasket = ga.makeGiftBasket();
        }
    }

    /**
     * A helper method to print all the gift exchanges between couples
     */
    public void printGiftExchange() {
        for (Gift g : giftBasket) {
            System.out.print(g);
        }
    }

    /**
     * Calculate compatibility of couple
     */
    private void setCompatibility() {
        compatibility = (int) ((boy.getBudget() - girl.getBudget()) + Math.abs(boy.getAttractiveness() - girl.getAttractiveness()) + Math.abs(boy.getIntelligenceLevel() - girl.getIntelligenceLevel()));
    }

    /**
     * Get Happiness of couple
     *
     * @return Happiness of couple
     */
    public double getHappiness() {
        return happiness;
    }

    /**
     * Get compatibility of couple
     *
     * @return Compatibility of couple
     */
    public int getCompatibility() {
        return compatibility;
    }

    /**
     * Returns the boy in couple
     *
     * @return boy
     */
    public Boy getBoy() {
        return boy;
    }

    /**
     * Returns the girl in couple
     *
     * @return girl
     */
    public Girl getGirl() {
        return girl;
    }

    /**
     * Display details of couple, thus formed
     *
     * @return Formatted string displaying the attributes of a couple
     */
    @Override
    public String toString() {
        return String.format("Name of Boy: " + boy.getName() + "\n" + "Name of Girl: " + girl.getName() + "\nhappiness: " + happiness + "\nCompatibility: " + compatibility + "\n");
    }

}
