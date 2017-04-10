/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

import java.util.ArrayList;

/**
 * Class denoting "Miser" Boys
 *
 * @author Rishabh Rishu(IIT2015068)
 */
public class MiserBoy extends Boy {

    /**
     * Creates an object of miser boy
     *
     * @param name name of the boy
     * @param attractiveness attractiveness level of the boy
     * @param intelligenceLevel intelligence level of the boy
     * @param girlfriendBudget girlfriend budget of the boy
     */
    public MiserBoy(String name, int attractiveness, int intelligenceLevel, double girlfriendBudget) {
        super(name, attractiveness, intelligenceLevel, girlfriendBudget);
    }

    @Override
    public double getHappiness(Girl girl, ArrayList<Gift> giftBasket) {
        double cost = 0.0;
        double happiness;
        for (Gift gift : giftBasket) {
            cost = cost + gift.getPrice();
        }
        happiness = super.getBudget() - cost;
        return happiness;
    }

}
