/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

import java.util.ArrayList;

/**
 * Class denoting "Generous" Boys
 * @author Rishabh Rishu(IIT2015068)
 */
public class GenerousBoy extends Boy{
/**
 * Creates an object of type generous boy
 * @param name name of the boy
 * @param attractiveness attractiveness level of the boy
 * @param intelligenceLevel intelligence level of the boy
 * @param girlfriendBudget girlfriend budget of the boy
 */
    public GenerousBoy(String name, int attractiveness, int intelligenceLevel, double girlfriendBudget) {
        super(name, attractiveness, intelligenceLevel, girlfriendBudget);
    }

    @Override
    public double getHappiness(Girl girl, ArrayList<Gift> giftBasket) {
        return girl.getHappiness(giftBasket);
    }
    
}
