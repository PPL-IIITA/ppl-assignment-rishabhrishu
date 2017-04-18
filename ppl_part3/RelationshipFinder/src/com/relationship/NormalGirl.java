/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

import java.util.ArrayList;

/**
 * Class denoting "Normal" Girl
 *
 * @author Rishabh Rishu(IIT2015068)
 */
public class NormalGirl extends Girl {

    /**
     * Creates an object of normal girl
     *
     * @param name name of the girl
     * @param attractiveness attractiveness level of the girl
     * @param intelligenceLevel intelligence level of the girl
     * @param maintenanceCost girlfriend budget of the girl
     */
    public NormalGirl(String name, int attractiveness, int intelligenceLevel, double maintenanceCost) {
        super(name, attractiveness, intelligenceLevel, maintenanceCost);
    }

    @Override
    public double getHappiness(ArrayList<Gift> giftBasket) {
        double cost = 0.0;
        double value = 0.0;
        double happiness;
        for (Gift gift : giftBasket) {
            cost = cost + gift.getPrice();
            value = value + gift.getValue();
        }
        happiness = cost + value - super.getBudget();
        return happiness;
    }

}
