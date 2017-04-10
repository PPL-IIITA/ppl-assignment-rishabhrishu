/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

import java.util.ArrayList;

/**
 * Abstract Class for Boys
 *
 * @author Rishabh Rishu(IIT2015068)
 */
public abstract class Boy extends Person {

    private double girlfriendBudget;

    public Boy(String name, int attractiveness, int intelligenceLevel, double girlfriendBudget) {
        super(name, attractiveness, intelligenceLevel);
        this.setBudget(girlfriendBudget);
    }

    /**
     * Calculates the happiness of boy
     *
     * @param girl his girlfriend
     * @param giftBasket basket of all the gifts he sent to her
     * @return happiness of the boy
     */
    public abstract double getHappiness(Girl girl, ArrayList<Gift> giftBasket);

    /**
     * Sets the girlfriend budget for a boy
     *
     * @param girlfriendBudget the girlfriend budget of a boy
     */
    @Override
    public void setBudget(double girlfriendBudget) {
        this.girlfriendBudget = girlfriendBudget;
    }

    /**
     * Gets the girlfriend budget for a boy
     *
     * @return girlfriend budget of the boy
     */
    @Override
    public double getBudget() {
        return girlfriendBudget;
    }

    /**
     * Display the entities of a Boy object
     *
     * @return Formatted String for boy object
     */
    @Override
    public String toString() {
        return String.format("<Boy> " + super.toString() + "Girlfriend Budget: " + girlfriendBudget + "\n");
    }
}
