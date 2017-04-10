/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

/**
 * Class denoting Luxury Gifts
 *
 * @author Rishabh Rishu(IIT2015068)
 */
public class LuxuryGift extends Gift {

    private int rating;
    private String difficulty;

    /**
     *
     * @param price price of the gift
     * @param value value of the gift
     * @param rating luxury rating of the gift
     * @param difficulty difficulty in obtaining the gift
     */
    public LuxuryGift(double price, double value, int rating, String difficulty) {
        super(price, value);
        this.rating = rating;
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return String.format("Luxury Gift:- Price: %.3f Value: %.3f Luxury Rating: %d Difficulty in obtaining: %s\n", super.getPrice(), super.getValue(), rating, difficulty);
    }

}
