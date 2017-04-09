/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relationship;

/**
 * Class denoting essential gifts
 *
 * @author Rishabh Rishu (IIT2015068)
 */
public class EssentialGift extends Gift {

    /**
     *
     * @param price price of the gift
     * @param value value of the gift
     */
    public EssentialGift(double price, double value) {
        super(price, value);
    }

    @Override
    public String toString() {
        return String.format("Essential Gift:- Price: %.3f Value: %.3f\n", super.getPrice(), super.getValue());
    }

}
