/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

import java.util.ArrayList;

/**
 * Abstract Class for girls
 *
 * @author Rishabh Rishu(IIT2015068)
 */
public abstract class Girl extends Person {

    private double maintenanceCost;
    private ArrayList<Boy> listofBf;

    /**
     * @param name name of girl
     * @param attractiveness attractiveness level of girl
     * @param intelligenceLevel intelligence level of girl
     * @param maintenanceCost maintenance cost of girl
     */
    public Girl(String name, int attractiveness, int intelligenceLevel, double maintenanceCost) {
        super(name, attractiveness, intelligenceLevel);
        this.setBudget(maintenanceCost);
        listofBf = new ArrayList<Boy>();
    }

    /**
     * Adds a boyfriend to the list the boys, she's been with
     *
     * @param boy new boyfriend
     */
    public void addBf(Boy boy) {
        listofBf.add(boy);
    }

    /**
     * Checks if a boy was ever in a relationship with her
     *
     * @param boy a boy
     * @return true, if given boy was her boyfriend in past, false otherwise
     */
    public boolean checkExBf(Boy boy) {
        return (listofBf.contains(boy));
    }

    /**
     * Calculates happiness of a girl
     *
     * @param giftBasket the list of gifts she has received from her boyfriend
     * @return happiness of the girl
     */
    public abstract double getHappiness(ArrayList<Gift> giftBasket);

    /**
     * Sets the maintenance cost for girl
     *
     * @param maintenanceCost maintenance cost
     */
    @Override
    public void setBudget(double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }

    /**
     * Returns the maintenance cost of the girl
     *
     * @return maintenance cost
     */
    @Override
    public double getBudget() {
        return maintenanceCost;
    }

    @Override
    public String toString() {
        return String.format("<Girl> " + super.toString() + "Maintenance Cost: " + maintenanceCost + "\n");
    }
}
