/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

import java.util.ArrayList;
import java.lang.Math;

/**
 * Class denoting "Choosy" Girls
 *
 * @author Rishabh Rishu(IIT2015068)
 */
public class ChoosyGirl extends Girl {

    /**
     * Creates an object of type choosy girl
     *
     * @param name Name of Girl
     * @param attractiveness Attractiveness of girl
     * @param intelligenceLevel Intelligence level of girl
     * @param maintenanceCost Maintenance cost of girl
     */
    public ChoosyGirl(String name, int attractiveness, int intelligenceLevel, double maintenanceCost) {
        super(name, attractiveness, intelligenceLevel, maintenanceCost);
    }

    @Override
    public double getHappiness(ArrayList<Gift> giftBasket) {
        double cost = 0.0;
        double value = 0.0;
        double happiness;
        for (Gift gift : giftBasket) {
            cost = cost + gift.getPrice();
            if (gift instanceof LuxuryGift) {
                value = value + 2 * gift.getValue();
            }
        }
        happiness = Math.log(Math.abs(cost + value - super.getBudget()));
        return happiness;
    }

}
