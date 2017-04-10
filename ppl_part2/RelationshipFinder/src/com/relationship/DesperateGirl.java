/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

import java.util.ArrayList;
import java.lang.Math;

/**
 * Class denoting "Desperate" Girls
 *
 * @author Rishabh Rishu(IIT2015068)
 */
public class DesperateGirl extends Girl {

    /**
     * Creates an object of type desperate girl
     *
     * @param name name of girl
     * @param attractiveness attractiveness level of girl
     * @param intelligenceLevel intelligence level of girl
     * @param maintenanceCost maintenance cost of girl
     */
    public DesperateGirl(String name, int attractiveness, int intelligenceLevel, double maintenanceCost) {
        super(name, attractiveness, intelligenceLevel, maintenanceCost);
    }

    @Override
    public double getHappiness(ArrayList<Gift> giftBasket) {
        double cost = 0.0;
        double value = 0.0;
        double happiness;
        for (Gift gift : giftBasket) {
            cost = cost + gift.getPrice();
        }
        happiness = Math.exp((cost - super.getBudget()) % 10);
        return happiness;
    }

}
