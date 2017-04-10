/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

import java.util.ArrayList;

/**
 * Class denoting "Geeks"
 *
 * @author Rishabh Rishu(IIT2015068)
 */
public class GeekyBoy extends Boy {

    /**
     * Creates an object of type geeky boy
     *
     * @param name name of the boy
     * @param attractiveness attractiveness level of the boy
     * @param intelligenceLevel intelligence level of the boy
     * @param girlfriendBudget girlfriend budget of the boy
     */
    public GeekyBoy(String name, int attractiveness, int intelligenceLevel, double girlfriendBudget) {
        super(name, attractiveness, intelligenceLevel, girlfriendBudget);
    }

    @Override
    public double getHappiness(Girl girl, ArrayList<Gift> giftBasket) {
        return girl.getIntelligenceLevel();
    }

}
